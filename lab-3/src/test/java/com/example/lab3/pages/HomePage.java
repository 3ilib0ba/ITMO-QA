package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    private By profileBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage goToProfilePage() {
        Utils.getElementBySelector(driver, profileBy).click();
        return new ProfilePage(driver);
    }
}
