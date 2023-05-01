package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page {
    // HEADER
    private By homePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[1]");
    private By messagesPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[2]");
    private By notificationPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[3]");
    private By friendsPageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[4]");
    private By profilePageHrefBy = By.xpath("//*[@id=\"topMenu\"]/div[2]/section/nav/a[5]/p");

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
}
