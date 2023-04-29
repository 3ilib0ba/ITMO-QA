package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page {
    private By usernameBy = By.xpath("/html/body/main/main/section[1]/header/div/div[1]/span");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return Utils.getElementBySelector(driver, usernameBy).getText().substring(1);
    }
}
