package com.cucumber.saucedemo;

import com.cucumber.saucedemo.base.DriverHelper;
import com.cucumber.saucedemo.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;

public class TestStep {

    /**
     * Before scenario.
     */
    @Before
    public void before() {
        System.err.println("before");
    }

    /**
     * After scenario.
     */
    @After
    public void after() {
        System.err.println("after");
    }


    @Given("launch sauce application")
    public void run(){
        System.err.println("run");
    }

    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();;
    private CheckoutPage checkoutPage = new CheckoutPage();
    private FinishPage finishPage = new FinishPage();;

    @Given("openLogPage")
    public void openLogPage(){
        loginPage.openLogPage();
    }

    @Given("login")
    public void login(){
        String account = loginPage.findAccount();
        String password = loginPage.findPassword();
        loginPage.login(account,password);
    }

    @When("loginByAccountAndPassword {string} {string}")
    public void loginByAccountAndPassword(String account, String password ){
//        String account = loginPage.findAccount();
//        String password = loginPage.findPassword();
        loginPage.login(account,password);
    }

    @When("loginResult")
    public boolean loginResult(){
        return loginPage.loginResult();
    }

    @Then("checkLoginResult")
    public void checkLoginResult(){
        boolean result = loginPage.loginResult();
        if (result){
            System.err.println("登录成功~~~");
        } else {
            System.err.println("登录失败，退出虚拟机");
            System.exit(666666);
        }
    }


    @Given("getProducts")
    public void getProducts(){
        productsPage.getProducts();
    }

    @Given("productsPageGoToShoppingCart")
    public void productsPageGoToShoppingCart(){
        productsPage.go_to_shopping_cart();
    }

    @Given("cartPageCartItemLabel")
    public void cartPageCartItemLabel(){
        cartPage.cart_item_label();
    }

    @Given("checkout")
    public void cartPageCheckout(){
        cartPage.checkout();
    }

    @Given("checkoutPageInputCheckoutInfo")
    public void checkoutPageInputCheckoutInfo(){
        String firstName = "zhang";
        String lastName = "san";
        String postalCode = "666";
        checkoutPage.input_checkout_info(firstName,lastName,postalCode);
    }

    @When("checkoutPageInputCheckoutInfo {string} {string} {string}")
    public void checkoutPageInputCheckoutInfo(String firstName,String lastName,String postalCode){
        checkoutPage.input_checkout_info(firstName,lastName,postalCode);
    }

    @When("checkoutPageSubmit")
    public void checkoutPageSubmit(){
        checkoutPage.submit();
    }

    @Given("finishPageCheckoutSummaryContainer")
    public void finishPageCheckoutSummaryContainer(){
        finishPage.checkout_summary_container();
    }

    @When("finishPageCheckout")
    public void finishPageCheckout(){
        finishPage.checkout();
    }

    @Given("exit")
    public void exit(){
        System.err.println("关闭自动关闭代码，得手动退出浏览器以及驱动");
//        DriverHelper.getInstance().getDriver().quit();
    }
}
