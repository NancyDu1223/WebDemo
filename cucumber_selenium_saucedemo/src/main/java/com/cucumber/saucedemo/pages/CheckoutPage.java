package com.cucumber.saucedemo.pages;

import com.cucumber.saucedemo.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageBase {
    public void input_checkout_info(String firstName,String lastName,String postalCode){
        sleep(3*1000);
        WebElement firstNameWebElement = webDriver.findElement(By.id("first-name"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firstNameWebElement));
//        firstNameWebElement.clear();
        firstNameWebElement.sendKeys(firstName);

        sleep(3*1000);
        WebElement lastNameWebElement = webDriver.findElement(By.id("last-name"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastNameWebElement));
//        lastNameWebElement.clear();
        lastNameWebElement.sendKeys(lastName);

        sleep(3*1000);
        WebElement postalCodeWebElement = webDriver.findElement(By.id("postal-code"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(postalCodeWebElement));
//        postalCodeWebElement.clear();
        postalCodeWebElement.sendKeys(postalCode);
    }

    public void submit(){
        sleep(3*1000);
        WebElement continueWebElement = webDriver.findElement(By.id("continue"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueWebElement));
        new Actions(webDriver).click(continueWebElement).perform();
    }
}
