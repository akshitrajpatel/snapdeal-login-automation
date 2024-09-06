package com.automation;

import com.snapdeal.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SnapdealLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
        // Uncomment for headless mode:
        // options.addArguments("--headless", "--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);  // Initialize LoginPage object
    }

    @Test
    public void testLogin() {
        // Navigate to Snapdeal login page
        loginPage.navigateToLoginPage();

        // Enter a mobile number
        loginPage.enterMobileNumber("8318162329");

        // Click login button
        loginPage.clickLoginButton();

        // Check if the OTP field is displayed, meaning login action was initiated
        Assert.assertTrue(loginPage.isOtpFieldDisplayed(), "Login flow did not trigger correctly.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
