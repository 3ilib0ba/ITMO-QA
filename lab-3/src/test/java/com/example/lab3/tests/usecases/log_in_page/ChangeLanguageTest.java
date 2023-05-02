package com.example.lab3.tests.usecases.log_in_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.LogInPageMain;
import com.example.lab3.pages.LogInPageSlave;
import com.example.lab3.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class ChangeLanguageTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void changeLanguageTest() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                logInPage.changeLanguage();
                Assertions.assertEquals(logInPage.getSignInButtonText(), "Log in");
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                logInPage.changeLanguage();
                Assertions.assertEquals(logInPage.getSignInButtonText(), "Log in");
            }
        });
        drivers.forEach(WebDriver::quit);
    }
}
