package com.cucumber.saucedemo;

import com.cucumber.saucedemo.base.DriverHelper;
import com.cucumber.saucedemo.pages.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        String firstName = "zhang";
        String lastName = "san";
        String postalCode = "666";

        LoginPage loginPage = new LoginPage();
        loginPage.openLogPage();
        boolean flag;
        do {
            // 有些账号会被锁定的~~~
            String account = loginPage.findAccount();
            String password = loginPage.findPassword();
            System.err.println("当前登陆的账号为："+account);
            System.err.println("当前登陆的密码为："+account);
            loginPage.login(account,password);
            flag = loginPage.loginResult();
            System.err.println("登录状态："+flag);
            if (!flag){
                Thread.sleep(3*1000);
            }
        } while (!flag);
        ProductsPage productsPage = new ProductsPage();
        productsPage.getProducts();
        productsPage.go_to_shopping_cart();
        CartPage cartPage = new CartPage();
        cartPage.cart_item_label();
        cartPage.checkout();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.input_checkout_info(firstName,lastName,postalCode);
        checkoutPage.submit();

        FinishPage finishPage = new FinishPage();
        finishPage.checkout_summary_container();
        finishPage.checkout();

        DriverHelper.getInstance().getDriver().quit();
    }
}
