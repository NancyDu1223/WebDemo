package com.cucumber.saucedemo.pages;

import com.cucumber.saucedemo.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends PageBase {

    public void cart_item_label(){
        sleep(3*1000);
        List<WebElement> cartItemList = webDriver.findElements(By.className("cart_item"));
        System.err.println("购物车中的商品");
        for (int i = 0; i < cartItemList.size(); i++) {
            System.err.println(cartItemList.get(i).getText());
        }
    }

    public void checkout(){
        sleep(3*1000);
        WebElement checkoutWebElement = webDriver.findElement(By.id("checkout"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutWebElement));
        new Actions(webDriver).click(checkoutWebElement).perform();
    }
}
