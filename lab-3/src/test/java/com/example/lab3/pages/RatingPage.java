package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingPage extends Page {
    private final By titleBy = By.xpath("/html/body/main/main/div/div[1]");
    private final By ratingProfileBy = By.xpath("/html/body/main/main/div/div[2]/a[1]/div[2]/span[1]");
    public RatingPage(final WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return Utils.getElementBySelector(driver, titleBy).getText();
    }

    public ProfilePage goToProfilePage() {
        Utils.getElementBySelector(driver, ratingProfileBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
 }
