package selenium;
 
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class AmazonIphonePrice {
 
    public static void main(String[] args) {
 
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        // Open Amazon
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
 
        // Search iphone 17 pro
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
 
        searchBox.sendKeys("iphone 17 pro");
        driver.findElement(By.id("nav-search-submit-button")).click();
 
        // Wait for results
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-component-type='s-search-result']")
        ));
 
        // Get all product containers
        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );
 
        int count = 0;
 
        // Loop to find the 3rd phone
        for (WebElement product : products) {
 
            WebElement title = product.findElement(By.tagName("h2"));
 
            if (title.isDisplayed()) {
                count++;
 
                if (count == 3) {
                    title.click();
                    break;
                }
            }
        }
 
        // Switch to new tab
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
 
        // Get price
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='a-price-whole']")
                )
        );
 
        System.out.println("Price: " + price.getText());
 
        // Get delivery date
        WebElement delivery = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("delivery-message")
                )
        );
 
        System.out.println("Delivery Date: " + delivery.getText());
 
        //driver.quit();
    }
}