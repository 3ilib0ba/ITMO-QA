package com.example.lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnswerQuestionPage extends Page {
    private By answerBy = By.xpath("//*[@id=\"question_answer_text\"]");
    private By questionAuthorUsernameBy = By.xpath("/html/body/main/main/div/div/header/a/span");
    private By sendAnswerBy = By.xpath("//*[@id=\"answersNewForm\"]/div[2]/button");
    public AnswerQuestionPage(WebDriver driver) {
        super(driver);
    }
}
