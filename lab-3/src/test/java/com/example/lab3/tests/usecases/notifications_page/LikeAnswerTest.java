package com.example.lab3.tests.usecases.notifications_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class LikeAnswerTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void likeAnswerTest() {
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
            final NotificationsPage notificationsPage = homePage.goToNotificationsPage();
            notificationsPage.changeWindowToAnswerTheme();
            final ProfilePage profilePage = notificationsPage.goToAnswer();
            profilePage.likeAnswer();
            Assertions.assertEquals(profilePage.isAnswerLiked(), Boolean.TRUE);

        });
        drivers.forEach(WebDriver::quit);
    }
}
