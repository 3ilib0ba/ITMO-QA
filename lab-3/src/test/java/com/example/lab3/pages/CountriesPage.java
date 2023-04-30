package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountriesPage extends Page {
    private By titleBy = By.xpath("/html/body/main/main/h1");
    private By homePageHrefBy = By.xpath("/html/body/main/main/nav/ol/li[1]/a");
    private By unitedKingdomBy = By.xpath("/html/body/main/main/div/div[2]/a[9]/p");
    public CountriesPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return Utils.getElementBySelector(driver, titleBy).getText();
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy);
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, unitedKingdomBy);
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }
}
