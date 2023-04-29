package com.example.lab3.tests;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RecoverPasswordTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void recoverPasswordTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                StartPage startPage = new StartPage(webDriver);
                LogInPageSlave logInPage = startPage.goToLogInPage();
                Utils.waitUntilPageLoads(webDriver);
                RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                Utils.waitUntilPageLoads(webDriver);
                LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Utils.waitUntilPageLoads(webDriver);
                Assertions.assertEquals(loginPageAfterRecover.getURL(), "https://ask.fm/login/recover");
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                Utils.waitUntilPageLoads(webDriver);
                LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Utils.waitUntilPageLoads(webDriver);
                Assertions.assertEquals(loginPageAfterRecover.getURL(), "https://ask.fm/login/recover");
            }
        });
        drivers.forEach(WebDriver::quit);
    }
}
