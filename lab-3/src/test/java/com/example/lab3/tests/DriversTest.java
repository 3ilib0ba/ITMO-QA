package com.example.lab3.tests;

import com.example.lab3.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriversTest {
    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testDriver() {
        Utils.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(final WebDriver driver) {
        driver.get(Utils.BASE_URL);
        final String title = driver.getTitle();
        assertEquals("Ask and Answer - ASKfm", title);
        driver.quit();
    }
}
