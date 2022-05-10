package com.cucumber.saucedemo.pages;

import com.cucumber.saucedemo.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends PageBase {

    public void checkout_summary_container(){
        System.err.println("最终的结算页面清单");
        sleep(3*1000);
        WebElement checkout_summary_container = webDriver.findElement(By.id("checkout_summary_container"));
        System.err.println(checkout_summary_container.getText());
    }

    public void checkout(){
        sleep(3*1000);
        WebElement finishWebElement = webDriver.findElement(By.id("finish"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(finishWebElement));
        new Actions(webDriver).click(finishWebElement).perform();
    }
}
