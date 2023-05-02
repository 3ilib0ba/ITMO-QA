package com.example.lab3.tests.usecases;

import com.example.lab3.Utils;
import com.example.lab3.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

class AnswerQuestionTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void answerQuestionFromMessagesPageTest() {
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
            final MessagesPage messagesPage = homePage.goToMessagesPage();
            messagesPage.rejectNotification();
            final String firstQuestionTextBefore = messagesPage.getFirstQuestionText();
            final QuestionPage questionPage = messagesPage.goToQuestionFromMessages();
            questionPage.answerTheQuestion();
            final String firstQuestionTextAfter = messagesPage.getFirstQuestionText();
            Assertions.assertNotEquals(firstQuestionTextBefore, firstQuestionTextAfter);
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    void answerQuestionFromNotificationsPageTest() {
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
            final String firstQuestionTextBefore = notificationsPage.getFirstQuestionText();
            final QuestionPage questionPage = notificationsPage.goToQuestion();
            final MessagesPage messagesPage = questionPage.answerTheQuestion();
            messagesPage.rejectNotification();
            final String firstQuestionTextAfter = messagesPage.getFirstQuestionText();
            Assertions.assertNotEquals(firstQuestionTextBefore, firstQuestionTextAfter);
        });
        drivers.forEach(WebDriver::quit);
    }
}
