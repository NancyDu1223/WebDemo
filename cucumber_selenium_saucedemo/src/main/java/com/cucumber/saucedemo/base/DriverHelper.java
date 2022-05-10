package com.cucumber.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * https://registry.npmmirror.com/binary.html?path=chromedriver/
 */
public class DriverHelper {
    private static volatile DriverHelper instance = null;

    public static DriverHelper getInstance() {
        if (instance == null){
            synchronized (DriverHelper.class){
                if (instance == null){
                    instance = new DriverHelper();
                }
            }
        }
        return instance;
    }

    private WebDriver driver;

    static {
        System.getProperties().setProperty("webdriver.chrome.driver", "src/main/resources/selenium/driver/windows/chromedriver.exe");
        DriverHelper.getInstance().getDriver();
    }

    private DriverHelper() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");

        chromeOptions.addArguments("--no-sandbox");//禁用沙箱
        chromeOptions.addArguments("--disable-dev-shm-usage");//禁用开发者shm
//        chromeOptions.addArguments("--headless"); //无头浏览器，这样不会打开浏览器窗口

        this.driver = new ChromeDriver(chromeOptions);
//        this.driver.manage().window().maximize();
        System.err.println("不全屏的话可能添加购物车失败！");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void main(String[] args) {
    }
}
