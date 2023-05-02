package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private By askFriendButton = By.xpath("/html/body/main/main/div/div/section/form/div[2]/div[2]/div[1]/div/a[2]");

    private By inputFriendSearch = By.xpath("/html/body/main/main/div/div/section/form/div[1]/label/input");
    private By buttonForSearch = By.xpath("/html/body/main/main/div/div/section/form/div[1]/label");


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
        Utils.waitUntilPageLoads(driver);
    }

    public void changeBarStateToInterests() {
        Utils.getElementBySelector(driver, interestsBar).click();
        Utils.waitUntilPageLoads(driver);
    }

    public AnswerQuestionPage goToQuestionToFriend() {
        Utils.getElementBySelector(driver, askFriendButton).click();
        Utils.waitUntilPageLoads(driver);
        return new AnswerQuestionPage(driver);
    }

    public void searchFriend(String name) {
        WebElement searchInput = Utils.getElementBySelector(driver, inputFriendSearch);
        searchInput.clear();
        searchInput.sendKeys(name);

        Utils.getElementBySelector(driver, buttonForSearch).click();
        Utils.waitUntilPageLoads(driver);
    }

    public String getTitleText() {
        return Utils.getElementBySelector(driver, friendsTitle).getText();
    }
}
