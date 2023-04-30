package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ViewTopQuestionsTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void viewTopQuestionsTest() {
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
            TopQuestionsPage topQuestionsPage = homePage.goToTopQuestionsPage();
            Assertions.assertEquals(topQuestionsPage.getTitleText(),
                    "\uD83C\uDDF7\uD83C\uDDFA\n" + "Россия\n" + "- О чем спрашивают люди");
        });
        drivers.forEach(WebDriver::quit);
    }
}
