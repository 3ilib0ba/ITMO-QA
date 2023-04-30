package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnswersPage extends Page {
    private By viewByCountriesBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[2]/a");
    private By homePageHrefBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[1]/a");
    private By viewTopQuestionsBy = By.xpath("/html/body/main/main/section[1]/nav/ol/li[3]/a");
    private By answerTheQuestionBy = By.xpath("/html/body/main/main/section[1]/div/a");
    private By iconLikeDisabledBy = By.xpath("//a[@class=\"icon-like\"]");
    private By iconLikeEnabledBy = By.xpath("//a[@class=\"icon-like active\"]");

    public AnswersPage(WebDriver driver) {
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

    public AnswerQuestionPage goToAnswerQuestionPage() {
        Utils.getElementBySelector(driver, answerTheQuestionBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }
    public void likeTheAnswer() {
        Utils.getElementBySelector(driver, iconLikeDisabledBy).click();
    }

    public void dislikeTheAnswer() {
        Utils.getElementBySelector(driver, iconLikeEnabledBy).click();
    }
}
