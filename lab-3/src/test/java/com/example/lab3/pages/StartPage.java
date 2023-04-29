package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends Page {
    private By signInBy = By.xpath("//*[@id=\"homeWelcomeForm\"]/p/a");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public LogInPageSlave goToLogInPage() {
        WebElement signInHref = Utils.getElementBySelector(driver, signInBy);
        signInHref.click();
        return new LogInPageSlave(driver);
    }

}
