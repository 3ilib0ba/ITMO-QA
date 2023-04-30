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
                RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Assertions.assertEquals(loginPageAfterRecover.getTitleText(), "Войти");
            }
            catch (TimeoutException e) {
                LogInPageMain logInPage = new LogInPageMain(webDriver);
                RecoverPasswordPage recoverPasswordPage = logInPage.goToRecoverPasswordPage();
                LogInPageMain loginPageAfterRecover = recoverPasswordPage.recoverEmail();
                Assertions.assertEquals(loginPageAfterRecover.getTitleText(), "Войти");
            }
        });
        drivers.forEach(WebDriver::quit);
    }
}
