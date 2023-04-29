package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoverPasswordPage extends Page {
    private By emailBy = By.xpath("//*[@id=\"recovery_email\"]");
    private By continueButtonBy = By.xpath("//*[@id=\"passwordRecoveryNewForm\"]/div[3]/input");
    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
    }
    public LogInPageMain recoverEmail() {
        WebElement emailInput = Utils.getElementBySelector(driver, emailBy);
        WebElement continueButton = Utils.getElementBySelector(driver, continueButtonBy);

        emailInput.clear();
        emailInput.sendKeys(Utils.EMAIL);
        continueButton.click();
        Utils.waitUntilPageLoads(driver);
        return new LogInPageMain(driver);
    }
}
