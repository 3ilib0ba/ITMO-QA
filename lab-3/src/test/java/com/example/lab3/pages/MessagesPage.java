package com.example.lab3.pages;

import com.example.lab3.Utils;
import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage extends Page {

    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");

    private By privateMessagesBy = By.xpath("/html/body/main/main/div/div/section/div[1]/nav/a[2]");
    private By allMessagesBy = By.xpath("/html/body/main/main/div/div/section/div[1]/nav/a[1]");


    private By getMoreOptionsOfMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div[1]/article[1]/div[2]/div[2]/div/a");
    private By deleteMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div/article[1]/div[2]/div[2]/div/nav/a[1]");
    private By questionFromOneOfMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div/article[1]/div[2]/div[1]/a[2]");

    private By questionFromRightSideBy = By.xpath("/html/body/main/main/aside[2]/section[1]/article[1]/h4/a");
    private By firstFriendFromRightSideBy = By.xpath("/html/body/main/main/aside[2]/section[2]/div[1]/a[2]");

    public MessagesPage(WebDriver driver) {
        super(driver);
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

    public void showPrivateMessages() {
        Utils.getElementBySelector(driver, privateMessagesBy).click();
        Utils.waitUntilPageLoads(driver);
    }

    public void showAllMessages() {
        Utils.getElementBySelector(driver, allMessagesBy).click();
        Utils.waitUntilPageLoads(driver);
    }

    public void deleteMessage() {
        Utils.getElementBySelector(driver, getMoreOptionsOfMessageBy).click();
        Utils.waitUntilPageLoads(driver);
        Utils.getElementBySelector(driver, deleteMessageBy).click();
        Utils.waitUntilPageLoads(driver);
    }

    public AnswerQuestionPage goToQuestionFromMessages() {
        Utils.getElementBySelector(driver, questionFromOneOfMessageBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }

    public AnswerQuestionPage goToQuestionFromRightSide() {
        Utils.getElementBySelector(driver, questionFromRightSideBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }

    public ProfilePage goToFriendFromRightSide() {
        Utils.getElementBySelector(driver, firstFriendFromRightSideBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }

}
