package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class ViewFriendsTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void viewFriendsFromMessagesPageTest() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            final MessagesPage messagesPage = homePage.goToMessagesPage();
            messagesPage.rejectNotification();
            final FriendsPage friendsPage = messagesPage.goToFriendsPage();
            Assertions.assertEquals(friendsPage.getTitleText(), "Ваши друзья");
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void viewFriendsFromFriendsPageTest() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            final FriendsPage friendsPage = homePage.goToFriendsPage();
            Assertions.assertEquals(friendsPage.getTitleText(), "Ваши друзья");
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void viewFriendsViewInLoopFromFriendsPageTest() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            HomePage homePage;
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                homePage = logInPage.validSignIn();
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                homePage = logInPage.validSignIn();
            }
            final FriendsPage friendsPage = homePage.goToFriendsPage();
            friendsPage.changeBarStateToFriends();
            Assertions.assertEquals(friendsPage.getPressedNavigationText(), "Друзья");
        });
        drivers.forEach(WebDriver::quit);
    }
}
