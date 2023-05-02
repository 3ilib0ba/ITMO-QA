package com.example.lab3.tests.usecases.friends_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class AskQuestionToFriendTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void askQuestionToFriendTest() {
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
            final String friendUsername = friendsPage.getFirstFriendUsername();
            final QuestionPage questionPage = friendsPage.goToQuestionToFriend();
            final ProfilePage profilePage = questionPage.askQuestion();
            Assertions.assertEquals(friendUsername, profilePage.getNickName());
        });
        drivers.forEach(WebDriver::quit);
    }
}
