package com.example.lab3.tests.usecases.friends_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AskQuestionToFriendTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    public void askQuestionToFriendTest() {
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
            String friendUsername = friendsPage.getFirstFriendUsername();
            QuestionPage questionPage = friendsPage.goToQuestionToFriend();
            ProfilePage profilePage = questionPage.askQuestion();
            Assertions.assertEquals(friendUsername, profilePage.getNickName());
        });
        drivers.forEach(WebDriver::quit);
    }
}
