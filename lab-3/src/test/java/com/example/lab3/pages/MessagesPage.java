package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagesPage extends Page {

    // HEADER
    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");


    private By privateMessagesBy = By.xpath("/html/body/main/main/div/div/section/div[1]/nav/a[2]");
    private By allMessagesBy = By.xpath("/html/body/main/main/div/div/section/div[1]/nav/a[1]");


    // MAIN PAGE
    private By getMoreOptionsOfMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div[1]/article[1]/div[2]/div[2]/div/a");
    private By deleteMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div/article[1]/div[2]/div[2]/div/nav/a[1]");
    private By questionFromOneOfMessageBy = By.xpath("/html/body/main/main/div/div/section/div[2]/div/article[1]/div[2]/div[1]/a[2]");
    private By notificationBy = By.xpath("/html/body/div[2]/div/section/div[2]/a[2]");

    // RIGHT SIDE BAR
    private By viewAnswersInTopBy = By.xpath("/html/body/main/main/aside[2]/section[1]/article[1]/h4/a");
    private By firstFriendFromRightSideBy = By.xpath("/html/body/main/main/aside[2]/section[2]/div[1]/a[2]");
    private By viewTopQuestionsBy = By.xpath("/html/body/main/main/aside[2]/section[1]/a");

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
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[@class=\"flex-1 bg-white text-gray-950\"]"), "Личные"));

    }

    public void showAllMessages() {
        Utils.getElementBySelector(driver, allMessagesBy).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[@class=\"flex-1 bg-white text-gray-950\"]"), "Все"));
    }

    public void deleteMessage() {
        Utils.getElementBySelector(driver, getMoreOptionsOfMessageBy).click();
        Utils.waitUntilPageLoads(driver);
        Utils.getElementBySelector(driver, deleteMessageBy).click();
        Utils.waitUntilPageLoads(driver);
    }

    public QuestionPage goToQuestionFromMessages() {
        Utils.getElementBySelector(driver, questionFromOneOfMessageBy).click();
        Utils.waitUntilPageLoads(driver);
        return new QuestionPage(driver);
    }

    public AnswersPage goToAnswersInTop() {
        Utils.getElementBySelector(driver, viewAnswersInTopBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswersPage(driver);
    }

    public ProfilePage goToFriendFromRightSide() {
        Utils.getElementBySelector(driver, firstFriendFromRightSideBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
    public TopQuestionsPage goToTopQuestionsPage() {
        Utils.getElementBySelector(driver, viewTopQuestionsBy).click();
        Utils.waitUntilPageLoads(driver);
        return new TopQuestionsPage(driver);
    }
    public void rejectNotification() {
        try {
            WebElement rejectNotificationButton = Utils.getElementBySelector(driver, notificationBy);
            rejectNotificationButton.click();
        }
        catch (TimeoutException ignored) {}
    }
    public String getPressedNavigationText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("//a[@class=\"flex-1 bg-white text-gray-950\"]")
        ).getText();
    }
    public String getFirstQuestionText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/div[2]/div/article[1]/div[2]/div[1]/a[1]")
        ).getText();
    }

    public String getTitle() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/header/h1")
        ).getText();
    }
}
