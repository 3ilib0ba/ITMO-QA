package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionPage extends Page {
    private By inputAnswerBy = By.xpath("//*[@id=\"question_answer_text\"]");
    private By inputQuestionBy = By.xpath("//*[@id=\"question_question_text\"]");

    private By sendAnswerBy = By.xpath("//*[@id=\"answersNewForm\"]/div[2]/button");
    private By sendQuestionBy = By.xpath("//*[@id=\"questionsNewForm\"]/div[2]/button");
    public QuestionPage(WebDriver driver) {
        super(driver);
    }

    public MessagesPage answerTheQuestion() {
        WebElement inputAnswer = Utils.getElementBySelector(driver, inputAnswerBy);
        WebElement sendAnswerButton = Utils.getElementBySelector(driver, sendAnswerBy);

        inputAnswer.clear();
        inputAnswer.sendKeys(Utils.DEFAULT_ANSWER);
        sendAnswerButton.click();
        Utils.waitUntilPageLoads(driver);
        return new MessagesPage(driver);
    }

    public ProfilePage askQuestion() {
        WebElement inputAnswer = Utils.getElementBySelector(driver, inputQuestionBy);
        WebElement sendAnswerButton = Utils.getElementBySelector(driver, sendQuestionBy);

        inputAnswer.clear();
        inputAnswer.sendKeys(Utils.DEFAULT_QUESTION);
        sendAnswerButton.click();
        Utils.waitUntilPageLoads(driver);
        return new ProfilePage(driver);
    }
}
