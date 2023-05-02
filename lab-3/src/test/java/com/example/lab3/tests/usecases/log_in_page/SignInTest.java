package com.example.lab3.tests.usecases.log_in_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class SignInTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void testValidSignIn() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                final HomePage homePage = logInPage.validSignIn();
                final ProfilePage profilePage = homePage.goToProfilePage();
                Assertions.assertEquals(profilePage.getUsername(), Utils.CORRECT_USERNAME);
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                final HomePage homePage = logInPage.validSignIn();
                final ProfilePage profilePage = homePage.goToProfilePage();
                Assertions.assertEquals(profilePage.getUsername(), Utils.CORRECT_USERNAME);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void testInvalidSignIn() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                final HomePage homePage = logInPage.invalidSignIn();
                Assertions.assertThrows(TimeoutException.class, homePage::goToProfilePage);
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                final HomePage homePage = logInPage.invalidSignIn();
                Assertions.assertThrows(TimeoutException.class, homePage::goToProfilePage);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

}