package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
    private By profileBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");
    private By messagesBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationsBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");

    private By askAroundBy = By.xpath("//*[@id=\"question_question_text\"]");
    private By sendQuestionBy = By.xpath("//*[@id=\"wallIndexForm\"]/div[2]/button");

    private By viewTopQuestionsBy = By.xpath("/html/body/main/main/aside[2]/section[1]/a");
    private By viewRatingBy = By.xpath("/html/body/main/main/aside[2]/section[3]/p/a");

    private By viewAnswersInTopBy = By.xpath("/html/body/main/main/aside[2]/section[1]/article[1]/a");
    private By viewProfileInTopBy = By.xpath("/html/body/main/main/aside[2]/section[3]/a[1]/div[2]/span[1]");

    private By iconLikeDisabledBy = By.xpath("//a[@class=\"icon-like\"]");
    private By iconLikeEnabledBy = By.xpath("//a[@class=\"icon-like active\"]");
    private By viewFiendProfileBy = By.xpath("/html/body/main/main/div/section[2]/div[2]/div/article[1]/div[1]/div[2]/div/a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage goToProfilePage() {
        Utils.getElementBySelector(driver, profileBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
    public MessagesPage goToMessagesPage() {
        Utils.getElementBySelector(driver, messagesBy).click();
        Utils.waitUntilPageLoads(driver);
        return new MessagesPage(driver);
    }
    public NotificationsPage goToNotificationsPage() {
        Utils.getElementBySelector(driver, notificationsBy).click();
        Utils.waitUntilPageLoads(driver);
        return new NotificationsPage(driver);
    }
    public FriendsPage goToFriendsPage() {
        Utils.getElementBySelector(driver, friendsBy).click();
        Utils.waitUntilPageLoads(driver);
        return new FriendsPage(driver);
    }

    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, viewTopQuestionsBy).click();
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }
    public RatingPage goToRatingPage() {
        Utils.getElementBySelector(driver, viewRatingBy).click();
        Utils.waitUntilPageLoads(driver);
        return new RatingPage(driver);
    }

    public AnswersPage goToAnswersInTopPage() {
        Utils.getElementBySelector(driver, viewAnswersInTopBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswersPage(driver);
    }
    public ProfilePage goToProfileInTop() {
        Utils.getElementBySelector(driver, viewProfileInTopBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }

    public void askAround() {
        WebElement questionInput = Utils.getElementBySelector(driver, askAroundBy);
        WebElement sendQuestionButton = Utils.getElementBySelector(driver, sendQuestionBy);

        questionInput.clear();
        questionInput.sendKeys(Utils.DEFAULT_QUESTION);
        sendQuestionButton.click();
    }
    public void likeTheAnswer() {
        Utils.getElementBySelector(driver, iconLikeDisabledBy).click();
    }
    public void dislikeTheAnswer() {
        Utils.getElementBySelector(driver, iconLikeEnabledBy).click();
    }
    public ProfilePage goToFriendProfile() {
        Utils.getElementBySelector(driver, viewFiendProfileBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
}
