package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class ViewQuestionsTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void viewQuestionsFromNotificationsPageTest() {
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
            notificationsPage.changeWindowToQuestionsTheme();
            Assertions.assertEquals(notificationsPage.getPressedNavigationText(), "Вопросы");
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void viewQuestionsFromProfilePageTest() {
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
            final ProfilePage profilePage = homePage.goToProfilePage();
            profilePage.changeBarToQuestions();
            Assertions.assertEquals(profilePage.getPressedNavigationText(), "Вопросы");
        });
        drivers.forEach(WebDriver::quit);
    }
}
