package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnswersPage extends Page {
    private By viewByCountriesBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[2]/a");
    private By homePageHrefBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[1]/a");
    private By viewTopQuestionsBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[3]/a");
    private By answerTheQuestionBy = By.xpath("/html/body/main/main/section[1]/div/a");
    public AnswersPage(WebDriver driver) {
        super(driver);
    }

    public CountriesPage goToCountriesPage() {
        Utils.getElementBySelector(driver, viewByCountriesBy);
        Utils.waitUntilPageLoads(driver);
        return new CountriesPage(driver);
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy);
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, viewTopQuestionsBy);
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }

    public AnswerQuestionPage goToAnswerQuestionPage() {
        Utils.getElementBySelector(driver, answerTheQuestionBy);
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }
}
