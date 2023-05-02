package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FriendsPage extends Page {

    // HEADER
    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");

    // NAVIGATION BAR(FRIENDS, INTERESTS)
    private By friendsBar = By.xpath("/html/body/main/main/div/div/section/header/nav/a[1]");
    private By interestsBar = By.xpath("/html/body/main/main/div/div/section/header/nav/a[2]");
    private By socialMediasBar = By.xpath("/html/body/main/main/div/div/section/header/nav/a[3]");

    private By askFriendButton = By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[2]/div[1]/div/a[2]");

    private By inputFriendSearch = By.xpath("/html/body/main/main/div/div/section/form/div[1]/label/input");

    private By friendsTitle = By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[1]/h2");

    public FriendsPage(WebDriver driver) {
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

    public void changeBarStateToFriends() {
        Utils.getElementBySelector(driver, friendsBar).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Друзья"));
    }

    public void changeBarStateToInterests() {
        Utils.getElementBySelector(driver, interestsBar).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Интересы"));
    }

    public void changeBarStateToSocialMedias() {
        Utils.getElementBySelector(driver, socialMediasBar).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]"), "Социальные сети"));
    }

    public QuestionPage goToQuestionToFriend() {
        Utils.getElementBySelector(driver, askFriendButton).click();
        Utils.waitUntilPageLoads(driver);
        return new QuestionPage(driver);
    }

    public void searchFriend(String name) {
        WebElement searchInput = Utils.getElementBySelector(driver, inputFriendSearch);
        searchInput.clear();
        searchInput.sendKeys(name);

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[1]/h2"), "Результат поиска"));
    }

    public void searchByInterests(String interest) {
        WebElement searchInput = Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/form/div[1]/label/input[1]"));
        searchInput.clear();
        searchInput.sendKeys(interest);
        searchInput.sendKeys(Keys.RETURN);

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driverWait.until(ExpectedConditions.textToBe(
                By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[1]/h2"), "Результат поиска"));
    }

    public ProfilePage goToFirstSearchedFriendProfile() {
        Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[2]/div[1]/a[2]/span[1]")
        ).click();
        return new ProfilePage(driver);
    }

    public String getTitleText() {
        return Utils.getElementBySelector(driver, friendsTitle).getText();
    }
    public String getPressedNavigationText() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("//a[contains(@class, \"bg-white text-gray-950\")]")
        ).getText();
    }

    public String getFirstFriendUsername() {
        return Utils.getElementBySelector(
                driver,
                By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[2]/div[1]/a[2]/span[1]")
        ).getText();
    }
}
