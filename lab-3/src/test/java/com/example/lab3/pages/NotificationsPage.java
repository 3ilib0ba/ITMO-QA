package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationsPage extends Page {

    // HEADER
    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");

    // NAVIGATION ON PAGE(ALL, QUESTIONS, ANSWERS, LIKES)
    private By navigationToAllThemes = By.xpath("/html/body/main/main/div/div/section/header/div[2]/nav/a[1]");
    private By navigationToQuestionsTheme = By.xpath("/html/body/main/main/div/div/section/header/div[2]/nav/a[2]");
    private By navigationToAnswersTheme = By.xpath("/html/body/main/main/div/div/section/header/div[2]/nav/a[3]");
    private By navigationToLikesTheme = By.xpath("/html/body/main/main/div/div/section/header/div[2]/nav/a[4]");

    // QUESTION, ANSWER, LIKE
    private By questionHrefBy = By.xpath("/html/body/main/main/div/div/section/div/div/div[1]/a");
    private By answerHrefBy = By.xpath("/html/body/main/main/div/div/section/div/div/div[1]/a[2]");
    private By likeHrefBy = By.xpath("");

    public NotificationsPage(WebDriver driver) {
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

    public void changeWindowToAllThemes() {
        Utils.getElementBySelector(driver, navigationToAllThemes).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Все"));
    }
    public void changeWindowToQuestionsTheme() {
        Utils.getElementBySelector(driver, navigationToQuestionsTheme).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Вопросы"));
    }

    public void changeWindowToAnswerTheme() {
        Utils.getElementBySelector(driver, navigationToAnswersTheme).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Ответы"));
    }

    public void changeWindowToLikesTheme() {
        Utils.getElementBySelector(driver, navigationToLikesTheme).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Лайки"));
    }

    public AnswerQuestionPage goToQuestion() {
        Utils.getElementBySelector(driver, questionHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }

    public ProfilePage goToAnswer() {
        Utils.getElementBySelector(driver, answerHrefBy).click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }

    public String getPressedNavigationText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]")
        ).getText();
    }

    public String getFirstQuestionText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/div/div/div[1]/a")
        ).getText();
    }

    public String getFirstAnswererNickName() {
        return Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/div/div/section/div/div/div[1]/a[2]/strong[1]")
        ).getText();
    }
}
