package com.example.lab3.pages;

import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver driver;

    public Page(final WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final WebDriver driver) {
        this.driver = driver;
    }
}
