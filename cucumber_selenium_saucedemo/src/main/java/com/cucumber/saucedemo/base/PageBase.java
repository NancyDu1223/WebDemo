package com.cucumber.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected WebDriver webDriver =  DriverHelper.getInstance().getDriver();
    protected WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
