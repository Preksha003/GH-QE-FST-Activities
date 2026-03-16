package suiteExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {

        // Create Firefox driver
        driver = new FirefoxDriver();

        // Open the webpage
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test
    public void testCase1() {

        // Test Case 1: Get title and assert
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "Selenium: Target Practice");
    }

    @Test
    public void testCase2() {

        // Test Case 2: Find black button
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));

        // Correct check
        Assert.assertTrue(blackButton.isDisplayed());

        // WRONG assertion intentionally (to fail the test)
        Assert.assertEquals(blackButton.getText(), "Black Button");
    }

    @Test(enabled = false)
    public void testCase3() {

        // This test will NOT run
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {

        // This test will be skipped
        throw new SkipException("Skipping this test case intentionally");
    }

    @AfterTest
    public void afterMethod() {

        // Close browser
        driver.quit();
    }
}