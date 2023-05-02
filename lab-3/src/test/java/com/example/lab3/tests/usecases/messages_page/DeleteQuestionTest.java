package com.example.lab3.tests.usecases.messages_page;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DeleteQuestionTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    public void deleteQuestionTest() {
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
            MessagesPage messagesPage = homePage.goToMessagesPage();
            messagesPage.rejectNotification();
            String firstQuestionTextBefore = messagesPage.getFirstQuestionText();
            messagesPage.deleteMessage();
            String firstQuestionTextAfter = messagesPage.getFirstQuestionText();
            Assertions.assertNotEquals(firstQuestionTextBefore, firstQuestionTextAfter);
        });
        drivers.forEach(WebDriver::quit);
    }
}
