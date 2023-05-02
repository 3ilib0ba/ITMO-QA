package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends Page {
    // HEADER
    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");
    private By askYourselfArea = By.xpath("//*[@id=\"question_question_text\"]");
    private By askYourselfButton = By.xpath("//*[@id=\"profileAnswersForm\"]/div[2]/button");

    // NAVIGATION (ANSWERS, QUESTIONS, VERSUSES)
    private By answersBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[1]");
    private By questionsBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[2]");
    private By versusesBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[3]");

    private By editProfileHref = By.xpath("/html/body/main/main/aside[1]/section/h2[1]/a");

    private By usernameBy = By.xpath("/html/body/main/main/section[1]/header/div/div[1]/span");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return Utils.getElementBySelector(driver, usernameBy).getText().substring(1);
    }

    public HomePage goToHomePage() {
        Utils.getElementBySelector(driver, homePageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new HomePage(driver);
    }

    public ProfilePage goToProfilePage() {
        Utils.getElementBySelector(driver, profilePageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
    public MessagesPage goToMessagesPage() {
        Utils.getElementBySelector(driver, messagesPageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new MessagesPage(driver);
    }
    public NotificationsPage goToNotificationsPage() {
        Utils.getElementBySelector(driver, notificationPageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new NotificationsPage(driver);
    }
    public FriendsPage goToFriendsPage() {
        Utils.getElementBySelector(driver, friendsPageHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new FriendsPage(driver);
    }

    public void changeBarToAnswers() {
        Utils.getElementBySelector(driver, answersBar).click();
        Utils.waitUntilPageLoads(driver);
    }

    public void changeBarToQuestions() {
        Utils.getElementBySelector(driver, questionsBar).click();
        Utils.waitUntilPageLoads(driver);
    }

    public void changeBarToVersuses() {
        Utils.getElementBySelector(driver, versusesBar).click();
        Utils.waitUntilPageLoads(driver);
    }

    public void askYourself(String question) {
        WebElement askingTextArea = Utils.getElementBySelector(driver, askYourselfArea);
        askingTextArea.clear();
        askingTextArea.sendKeys(question);

        Utils.getElementBySelector(driver, askYourselfButton).click();
        Utils.waitUntilPageLoads(driver);
    }

    public Page goToEditingProfilePage() {
        Utils.getElementBySelector(driver, editProfileHref).click();
        Utils.waitUntilPageLoads(driver);
        return new Page(driver);
    }

    public void likeAnswer() {
        WebElement like = Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/div/article/div[3]/div[1]/a[1]"));
        if (like.getAttribute("class").equals("icon-like")) {
            like.click();
        }
    }

    public String getNickName() {
        return Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/section[1]/header/div/h1/span")).getText();
    }

    public Boolean isAnswerLiked() {
        WebElement like = Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/div/article/div[3]/div[1]/a[1]")
        );
        if (like.getAttribute("class").equals("icon-like active")) return Boolean.TRUE;
        else return Boolean.FALSE;
    }
}
