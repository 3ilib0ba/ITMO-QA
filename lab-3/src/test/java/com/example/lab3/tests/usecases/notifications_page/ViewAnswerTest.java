package com.example.lab3.tests.usecases.notifications_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ViewAnswerTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    public void viewAnswerTest() {
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
            NotificationsPage notificationsPage = homePage.goToNotificationsPage();
            notificationsPage.changeWindowToAnswerTheme();
            String answererNickname = notificationsPage.getFirstAnswererNickName();
            ProfilePage profilePage = notificationsPage.goToAnswer();
            Assertions.assertEquals(answererNickname, profilePage.getNickName());

        });
        drivers.forEach(WebDriver::quit);
    }
}
