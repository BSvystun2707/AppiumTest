package com.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SampleTest {

    private AndroidDriver driver;

    @Before
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setPlatformVersion("13")
                .setDeviceName("emulator-5554")
                .setApp("/Users/Bohdan/Downloads/duolingo.apk")
                .setNewCommandTimeout(Duration.ofSeconds(3600));

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test

    public void sampleTest() throws InterruptedException {
        // Пошук елемента за Accessibility ID
        WebElement el = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.uptodown:id/tv_accept_wizard_welcome']"));
        el.click();

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        WebElement el1 = driver.findElement(
                AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Profile\"]"));
        el1.click();

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        WebElement el2 = driver.findElement(
                AppiumBy.xpath(
                        "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Featured app\"]/android.widget.RelativeLayout[2]/android.view.View"));
        el2.click();

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        // WebElement el3 = driver.findElement(
        // AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gms:id/subtitle\"]"));
        // el3.click();

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        WebElement el4 = driver.findElement(
                AppiumBy.xpath(
                        "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/container\"])[1]/android.widget.LinearLayout"));
        el4.click();

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        // Затримка для UI оновлення
        Thread.sleep(1000); // 1 секунда

        // Знайти поле пошуку за допомогою XPath
        WebElement searchField = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.uptodown:id/tv_main_search_view']"));
        searchField.click(); // Клікаємо, щоб активувати поле пошуку
        Thread.sleep(1000);
        // Знайти поле введення тексту та ввести "duolingo"
        WebElement inputField = driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.AutoCompleteTextView[@resource-id=\"com.uptodown:id/actv_search_bar\"]"));
        inputField.sendKeys("duolingo"); // Вводимо "duolingo"
        Thread.sleep(1000);
        // Натискаємо на кнопку пошуку на клавіатурі
        driver.executeScript("mobile: performEditorAction", Map.of("action", "search"));
        Thread.sleep(1000);

        Thread.sleep(1000);

        WebElement duoPick = driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@resource-id=\"com.uptodown:id/tv_name_app_info_item\" and @text=\"Duolingo\"]"));
        duoPick.click();

        Thread.sleep(2000);

        // Знаходимо кнопку за допомогою ID
        WebElement downloadButton = driver.findElement(AppiumBy.id("com.uptodown:id/tv_status_download"));

        // Натискаємо на кнопку
        downloadButton.click();
        Thread.sleep(2000);

        WebElement acceptButton = driver.findElement(AppiumBy.id("com.uptodown:id/tv_ok"));

        // Натискаємо на кнопку
        acceptButton.click();
        Thread.sleep(5000);

        WebElement close = driver.findElement(
                AppiumBy.xpath(
                        "//android.view.View[@resource-id=\"video-container\"]/android.view.View[4]/android.widget.TextView"));

        // Натискаємо на кнопку
        close.click();
        Thread.sleep(15000);

        WebElement wishList = driver.findElement(AppiumBy.id("com.uptodown:id/iv_wishlist_button"));

        // Натискаємо на кнопку
        wishList.click();
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
