package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends Page {
    private final By signInBy = By.xpath("//*[@id=\"homeWelcomeForm\"]/p/a");

    public StartPage(final WebDriver driver) {
        super(driver);
    }

    public LogInPageSlave goToLogInPage() {
        final WebElement signInHref = Utils.getElementBySelector(driver, signInBy);
        signInHref.click();
        Utils.waitUntilPageLoads(driver);
        return new LogInPageSlave(driver);
    }

}
