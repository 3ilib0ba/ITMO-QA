package com.example.lab3.tests.usecases.notifications_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class ViewAnswerTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void viewAnswerTest() {
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
            final String answererNickname = notificationsPage.getFirstAnswererNickName();
            final ProfilePage profilePage = notificationsPage.goToAnswer();
            Assertions.assertEquals(answererNickname, profilePage.getNickName());

        });
        drivers.forEach(WebDriver::quit);
    }
}
