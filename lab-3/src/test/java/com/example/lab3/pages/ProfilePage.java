package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends Page {
    // HEADER
    private final By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private final By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private final By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private final By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private final By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");
    private final By askYourselfArea = By.xpath("//*[@id=\"question_question_text\"]");
    private final By askYourselfButton = By.xpath("//*[@id=\"profileAnswersForm\"]/div[2]/button");

    // NAVIGATION (ANSWERS, QUESTIONS, VERSUSES)
    private final By answersBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[1]");
    private final By questionsBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[2]");
    private final By versusesBar = By.xpath("/html/body/main/main/div/section[2]/header/nav/a[3]");

    private final By editProfileHref = By.xpath("/html/body/main/main/aside[1]/section/h2[1]/a");

    private final By usernameBy = By.xpath("/html/body/main/main/section[1]/header/div/div[1]/span");
    public ProfilePage(final WebDriver driver) {
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
        final WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Ответы"));
    }

    public void changeBarToQuestions() {
        Utils.getElementBySelector(driver, questionsBar).click();
        final WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Вопросы"));
    }

    public void changeBarToVersuses() {
        Utils.getElementBySelector(driver, versusesBar).click();
        final WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Версус"));
    }

    public void askYourself(final String question) {
        final WebElement askingTextArea = Utils.getElementBySelector(driver, askYourselfArea);
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
        final WebElement like = Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/div/article/div[3]/div[1]/a[1]"));
        if ("icon-like".equals(like.getAttribute("class"))) {
            like.click();
        }
    }

    public String getNickName() {
        return Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/section[1]/header/div/h1/span")).getText();
    }

    public List<String> getInterests() {
        final ArrayList<String> interests = new ArrayList<>();
        final WebElement list = Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/aside[1]/section/div/div/ul")
        );
        final List<WebElement> links = list.findElements(By.tagName("li"));
        for (WebElement link: links) {
            interests.add(link.getText().substring(1));
        }
        return interests;
    }

    public Boolean isAnswerLiked() {
        final WebElement like = Utils.getElementBySelector(
                driver, By.xpath("/html/body/main/main/div/article/div[3]/div[1]/a[1]")
        );
        if ("icon-like active".equals(like.getAttribute("class"))) {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    public String getPressedNavigationText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]")
        ).getText();
    }
}
