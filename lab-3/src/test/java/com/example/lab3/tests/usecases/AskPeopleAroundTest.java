package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.HomePage;
import com.example.lab3.pages.LogInPageMain;
import com.example.lab3.pages.LogInPageSlave;
import com.example.lab3.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AskPeopleAroundTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void askPeopleAroundTest() {
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
            homePage.getAmountOfCharacters();
            homePage.askAround();
            Assertions.assertEquals(homePage.getAmountOfCharacters(), 300);
        });
        drivers.forEach(WebDriver::quit);
    }
}
