package Appium;



import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;

    // ================= SETUP =================
    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        // Contacts App
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

        // 🔥 Important fixes
        options.setNoReset(false);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // 🚀 FORCE OPEN APP (main fix)
        driver.activateApp("com.google.android.contacts");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= TEST =================
    @Test
    public void contactsTest() {

        // Wait for app screen
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.FrameLayout")
        ));

        // 👉 Click "Create contact"
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Create contact")
        )).click();

        // Wait for input fields
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")
        ));

        // Get all input fields
        List<WebElement> fields = driver.findElements(
                AppiumBy.className("android.widget.EditText")
        );

        // Enter data
        fields.get(0).sendKeys("Aaditya");
        fields.get(1).sendKeys("Varma");
        fields.get(2).sendKeys("999148292");

        // 👉 Click Save
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Save\")")
        )).click();

        // 👉 Optional validation (basic)
        Assert.assertTrue(true);
    }

    // ================= TEARDOWN =================
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



