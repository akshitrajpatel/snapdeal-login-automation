package com.automation;

import com.snapdeal.HomePage;
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
    private HomePage homePage;
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
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Navigate to Snapdeal homepage
        homePage.navigateToHomePage();
        //System.out.println(driver.getPageSource());
        System.out.println("im here at testLogin() ....");
        // Click on the login link/button
        homePage.clickLoginLink();
        

        // Enter mobile number
        loginPage.enterMobileNumber("8318162329");

        // Click login button
        loginPage.clickLoginButton();

        // Check if the OTP field is displayed
        Assert.assertTrue(loginPage.isOtpFieldDisplayed(), "OTP field was not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
