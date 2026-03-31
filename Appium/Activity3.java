package Appium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.net.URI;

public class Activity3 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // 👉 MOST COMMON CALCULATOR (Google)
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.setNoReset(true);

        URL serverURL = new URI("http://localhost:4723").toURL();

        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void calculatorTest() throws Exception {

        // ===== 5 + 9 =====
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        String add = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final")
        ).getText();

        System.out.println("Addition: " + add);
        Assert.assertEquals(add, "14");

        Thread.sleep(2000);

        // Clear
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();

        // ===== 10 - 5 =====
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        String sub = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final")
        ).getText();

        System.out.println("Subtraction: " + sub);
        Assert.assertEquals(sub, "5");

        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();

        // ===== 5 * 100 =====
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        String mul = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final")
        ).getText();

        System.out.println("Multiplication: " + mul);
        Assert.assertEquals(mul, "500");

        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();

        // ===== 50 / 2 =====
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        String div = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final")
        ).getText();

        System.out.println("Division: " + div);
        Assert.assertEquals(div, "25");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}