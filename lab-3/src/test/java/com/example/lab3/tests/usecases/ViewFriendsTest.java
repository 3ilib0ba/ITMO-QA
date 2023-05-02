package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ViewFriendsTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    public void viewFriendsFromMessagesPageTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            MessagesPage messagesPage = homePage.goToMessagesPage();
            messagesPage.rejectNotification();
            FriendsPage friendsPage = messagesPage.goToFriendsPage();
            Assertions.assertEquals(friendsPage.getTitleText(), "Ваши друзья");
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void viewFriendsFromFriendsPageTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            FriendsPage friendsPage = homePage.goToFriendsPage();
            Assertions.assertEquals(friendsPage.getTitleText(), "Ваши друзья");
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void viewFriendsViewInLoopFromFriendsPageTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            FriendsPage friendsPage = homePage.goToFriendsPage();
            friendsPage.changeBarStateToFriends();
            Assertions.assertEquals(friendsPage.getPressedNavigationText(), "Друзья");
        });
        drivers.forEach(WebDriver::quit);
    }
}
