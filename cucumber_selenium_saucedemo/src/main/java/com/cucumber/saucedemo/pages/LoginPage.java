package com.cucumber.saucedemo.pages;

import com.cucumber.saucedemo.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class LoginPage extends PageBase {
    public void openLogPage() {
        webDriver.get("https://www.saucedemo.com/");
    }

    public String findAccount(){
        WebElement login_credentials = webDriver.findElement(By.id("login_credentials"));
        String[] links = login_credentials.getText().split("\n");
        String[] accounts = new String[links.length-1];
        // 从第一条开始复制，去掉第一条也就是去除：Accepted usernames are:
        System.arraycopy(links,1,accounts,0,accounts.length);
        for (int i = 0; i < accounts.length; i++) {
            System.err.println("可以登陆的账号为："+accounts[i]);
        }
        return accounts[new Random().nextInt(accounts.length)];
    }

    public String findPassword(){
        WebElement login_password = webDriver.findElement(By.className("login_password"));
        String[] links = login_password.getText().split("\n");
        String[] passwors = new String[links.length-1];
        // 从第一条开始复制，去掉第一条也就是去除：Password for all users:
        System.arraycopy(links,1,passwors,0,passwors.length);
        for (int i = 0; i < passwors.length; i++) {
            System.err.println("可以登陆的账号密码为："+passwors[i]);
        }
        return passwors[new Random().nextInt(passwors.length)];
    }

    public void login(String account, String password) {
        sleep(3*1000);
        WebElement userNameWebElement = webDriver.findElement(By.id("user-name"));
        WebElement passwordWebElement = webDriver.findElement(By.id("password"));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(userNameWebElement));
//        // 清空，以防其他的操作导致账号密码框不为空
        userNameWebElement.clear();
        userNameWebElement.sendKeys(account);
//        new Select(userNameWebElement).selectByVisibleText(account);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordWebElement));
        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);
//        new Select(passwordWebElement).selectByVisibleText(password);

        WebElement element = webDriver.findElement(By.id("login-button"));
//        element.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        // 上面的会报错
        new Actions(webDriver).click(element).perform();
    }

    public boolean loginResult(){
        sleep(3*1000);
        WebElement errorButton = null;
        try {
            errorButton = webDriver.findElement(By.className("error-button"));
            WebElement errorMessageContainerWebElement = webDriver.findElement(By.className("error-message-container"));
            System.err.println(errorMessageContainerWebElement.getText());
        } catch (Exception e) {
            System.err.println("登陆成功~~~，因为页面已经跳转了，获取不到元素了");
        }

        if (errorButton == null){
            System.err.println("登录成功！");
            return true;
        } else {
            System.err.println("登录失败！");
            webDriverWait.until(ExpectedConditions.elementToBeClickable(errorButton));
            // 上面的会报错
            new Actions(webDriver).click(errorButton).perform();
            System.err.println("关闭提示框！");
            return false;
        }
    }
}
