import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Main {
    public static void main(String[] args) {
        try {
            // Setup Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");  // REQUIRED in Codespaces
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");

            options.setBinary("/usr/bin/google-chrome");
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

            // Launch browser
            WebDriver driver = new ChromeDriver(options);

            // Open website
            driver.get("https://www.google.com");

            // Wait a bit (important)
            Thread.sleep(2000);

            // Type in search box
            driver.findElement(By.name("q")).sendKeys("Selenium automation");

            // Submit search
            driver.findElement(By.name("q")).submit();

            // Wait for results
            Thread.sleep(3000);

            // Print output
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("result.png"));

            System.out.println("Screenshot saved as result.png ✅");

            // Close browser
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}