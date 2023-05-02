package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page {
    private final By profileBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");
    private final By messagesBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private final By notificationsBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private final By friendsBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");

    private final By askAroundBy = By.xpath("//*[@id=\"question_question_text\"]");
    private final By sendQuestionBy = By.xpath("//*[@id=\"wallIndexForm\"]/div[2]/button");
    private final By amountOfCharactersBy = By.xpath("//*[@id=\"wallIndexForm\"]/div[2]/div[2]");

    private final By viewTopQuestionsBy = By.xpath("/html/body/main/main/aside[2]/section[1]/a");
    private final By viewRatingBy = By.xpath("/html/body/main/main/aside[2]/section[3]/p/a");

    private final By viewAnswersInTopBy = By.xpath("/html/body/main/main/aside[2]/section[1]/article[1]/a");
    private final By viewProfileInTopBy = By.xpath("/html/body/main/main/aside[2]/section[3]/a[1]/div[2]/span[1]");

    public HomePage(final WebDriver driver) {
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
        final WebElement questionInput = Utils.getElementBySelector(driver, askAroundBy);
        final WebElement sendQuestionButton = Utils.getElementBySelector(driver, sendQuestionBy);
        final WebElement amountOfCharactersElem = Utils.getElementBySelector(driver, amountOfCharactersBy);
        final String defaultText = amountOfCharactersElem.getText();

        questionInput.clear();
        questionInput.sendKeys(Utils.DEFAULT_QUESTION);
        sendQuestionButton.click();
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.textToBe(amountOfCharactersBy, defaultText));
    }
    public Integer getAmountOfCharacters() {
        return Integer.parseInt(Utils.getElementBySelector(driver, amountOfCharactersBy).getText());
    }
}
