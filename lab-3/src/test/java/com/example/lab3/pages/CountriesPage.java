package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountriesPage extends Page {
    private final By homePageHrefBy = By.xpath("/html/body/main/main/nav/ol/li[1]/a");
    private final By unitedKingdomBy = By.xpath("/html/body/main/main/div/div[2]/a[9]/p");
    public CountriesPage(final WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, unitedKingdomBy).click();
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }
}
