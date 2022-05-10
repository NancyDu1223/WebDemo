package com.cucumber.saucedemo.pages;

import com.cucumber.saucedemo.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsPage extends PageBase {
    public void getProducts(){
        sleep(3*1000);
        List<WebElement> inventoryItemList = webDriver.findElements(By.className("inventory_item"));
        // 按照价格排序，比较器
        Collections.sort(inventoryItemList, new Comparator<WebElement>() {
            @Override
            public int compare(WebElement o1, WebElement o2) {
                double d1 = Double.parseDouble(o1.findElement(By.className("inventory_item_price")).getText().replace("$", ""));
                double d2 = Double.parseDouble(o2.findElement(By.className("inventory_item_price")).getText().replace("$", ""));
                return (int) -(d1-d2);
            }
        });
        for (int i = 0; i < inventoryItemList.size(); i++) {
            WebElement inventoryItem = inventoryItemList.get(i);
            WebElement inventory_item_price = inventoryItem.findElement(By.className("inventory_item_price"));
            String replace = inventory_item_price.getText().replace("&", "");
            System.err.println(replace);
        }

        WebElement product1 = inventoryItemList.get(0).findElement(By.tagName("button"));
        WebElement product2 = inventoryItemList.get(1).findElement(By.tagName("button"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(product1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(product2));
        sleep(3*1000);
        System.err.println("添加价格最贵的商品1");
        new Actions(webDriver).click(product1).perform();
        sleep(3*1000);
        System.err.println("添加价格最贵的商品2");
        new Actions(webDriver).click(product2).perform();
    }

    public void go_to_shopping_cart() {
        sleep(3*1000);
        WebElement shoppingCartLinkWebElement = webDriver.findElement(By.className("shopping_cart_link"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shoppingCartLinkWebElement));
        shoppingCartLinkWebElement.click();
    }
}
