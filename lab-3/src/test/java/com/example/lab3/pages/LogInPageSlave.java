package com.example.lab3.pages;

import com.example.lab3.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPageSlave extends Page {

    private By usernameBy = By.xpath("//*[@id=\"user_name\"]");
    private By passwordBy = By.xpath("//*[@id=\"user_password\"]");
    private By signInBy = By.xpath("//*[@id=\"sessionNewForm\"]/div[5]/input");
    private By reCapchaFlag = By.xpath("//span[@aria-checked=\"true\"]");
    private By forgotPasswordBy = By.xpath("//*[@id=\"sessionNewForm\"]/div[4]/a");

    private By languageBy = By.xpath("/html/body/main/footer/div/p/a");
    private By englishLanguageBy = By.xpath("/html/body/div/div/section/div[2]/div/div[1]/a[8]");

    public LogInPageSlave(WebDriver driver) {
        super(driver);
    }
    public HomePage validSignIn() {
        return trySignIn(Utils.CORRECT_USERNAME, Utils.CORRECT_PASSWORD);
    }

    public HomePage invalidSignIn() {
        return trySignIn(Utils.CORRECT_USERNAME, Utils.INCORRECT_PASSWORD);
    }

    public RecoverPasswordPage goToRecoverPasswordPage() {
        Utils.getElementBySelector(driver, forgotPasswordBy).click();
        Utils.waitUntilPageLoads(driver);
        return new RecoverPasswordPage(driver);
    }

    public void changeLanguage() {
        WebElement languageSelect = Utils.getElementBySelector(driver, languageBy);
        languageSelect.click();

        Utils.getElementBySelector(driver, By.xpath("/html/body/div/div/section"));

        WebElement englishLanguageButton = Utils.getElementBySelector(driver, englishLanguageBy);
        englishLanguageButton.click();
        Utils.waitUntilPageLoads(driver);
    }

    public String getSignInButtonText() {
        return Utils.getElementBySelector(driver, signInBy).getAttribute("value");
    }

    private HomePage trySignIn(String username, String password) {
        WebElement loginInput = Utils.getElementBySelector(driver, usernameBy);
        WebElement passwordInput = Utils.getElementBySelector(driver, passwordBy);
        WebElement signInButton = Utils.getElementBySelector(driver, signInBy);

        loginInput.clear();
        passwordInput.clear();

        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
        ));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recaptcha-checkbox-border']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reCapchaFlag));

        driver.switchTo().defaultContent();
        signInButton.click();

        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }
}
