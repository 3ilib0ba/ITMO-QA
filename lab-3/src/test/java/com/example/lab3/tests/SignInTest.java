package com.example.lab3.tests;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SignInTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    public void testValidSignIn() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                HomePage homePage = logInPage.validSignIn();
                ProfilePage profilePage = homePage.goToProfilePage();
                Assertions.assertEquals(profilePage.getUsername(), Utils.CORRECT_USERNAME);
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                HomePage homePage = logInPage.validSignIn();
                ProfilePage profilePage = homePage.goToProfilePage();
                Assertions.assertEquals(profilePage.getUsername(), Utils.CORRECT_USERNAME);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void testInvalidSignIn() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                HomePage homePage = logInPage.invalidSignIn();
                Assertions.assertThrows(TimeoutException.class, homePage::goToProfilePage);
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                HomePage homePage = logInPage.invalidSignIn();
                Assertions.assertThrows(TimeoutException.class, homePage::goToProfilePage);
            }
        });
        drivers.forEach(WebDriver::quit);
    }

}