package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnswersPage extends Page {
    private final By viewByCountriesBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[2]/a");
    private final By homePageHrefBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[1]/a");
    private final By viewTopQuestionsBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[3]/a");
    private final By answerTheQuestionBy = By.xpath("/html/body/main/main/section[1]/div/a");

    public AnswersPage(final WebDriver driver) {
        super(driver);
    }

    public CountriesPage goToCountriesPage() {
        Utils.getElementBySelector(driver, viewByCountriesBy).click();
        Utils.waitUntilPageLoads(driver);
        return new CountriesPage(driver);
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, viewTopQuestionsBy).click();
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }

    public QuestionPage goToAnswerQuestionPage() {
        Utils.getElementBySelector(driver, answerTheQuestionBy).click();
        Utils.waitUntilPageLoads(driver);
        return new QuestionPage(driver);
    }
}
