package com.example.lab3.pages;

import com.example.lab3.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnswerQuestionPage extends Page {
    private By answerBy = By.xpath("//*[@id=\"question_answer_text\"]");
    private By sendAnswerBy = By.xpath("//*[@id=\"answersNewForm\"]/div[2]/button");
    public AnswerQuestionPage(WebDriver driver) {
        super(driver);
    }

    public MessagesPage answerTheQuestion() {
        WebElement inputAnswer = Utils.getElementBySelector(driver, answerBy);
        WebElement sendAnswerButton = Utils.getElementBySelector(driver, sendAnswerBy);

        inputAnswer.clear();
        inputAnswer.sendKeys(Utils.DEFAULT_ANSWER);
        sendAnswerButton.click();
        Utils.waitUntilPageLoads(driver);
        return new MessagesPage(driver);
    }
}
