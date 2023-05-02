package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopQuestionsPage extends Page {
    private final By viewAnswersBy = By.xpath("/html/body/main/main/div/div/div/article[1]/a[2]");
    private final By viewByCountriesBy = By.xpath("/html/body/main/main/div/div/div/article[1]/a[2]");
    private final By homePageHrefBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[1]/a");
    private final By titleBy = By.xpath("/html/body/main/main/section[1]/h1");

    public TopQuestionsPage(final WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public CountriesPage goToCountiesPage() {
        Utils.getElementBySelector(driver, viewByCountriesBy).click();
        Utils.waitUntilPageLoads(driver);
        return new CountriesPage(driver);
    }

    public AnswersPage goToAnswers() {
        Utils.getElementBySelector(driver, viewAnswersBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswersPage(driver);
    }

    public String getTitleText() {
        return Utils.getElementBySelector(driver, titleBy).getText();
    }
}
