package com.example.lab3.tests.usecases.log_in_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class RecoverPasswordTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void recoverPasswordTest() {
        final List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            try {
                final StartPage startPage = new StartPage(webDriver);
                final LogInPageSlave logInPage = startPage.goToLogInPage();
                final RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                final LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Assertions.assertEquals(loginPageAfterRecover.getTitleText(), "Войти");
            }
            catch (TimeoutException e) {
                final LogInPageMain logInPage = new LogInPageMain(webDriver);
                final RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                final LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Assertions.assertEquals(loginPageAfterRecover.getTitleText(), "Войти");
            }
        });
        drivers.forEach(WebDriver::quit);
    }
}
