package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Define locators for elements on the login page
    private By mobileNumberField = By.id("userName");
    private By loginButton = By.id("checkUser");
    private By otpField = By.id("userOtp");

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the login page
    public void navigateToLoginPage() {
        driver.get("https://www.snapdeal.com/login");
    }

    // Method to enter mobile number
    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    // Method to click on login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to check if OTP input field is displayed (indicating login step is successful)
    public boolean isOtpFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Wait for up to 20 seconds
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));  // Wait for OTP field to become visible
            return driver.findElement(otpField).isDisplayed();
        } catch (TimeoutException e) {
            return false;  // Return false if OTP field doesn't appear in the given time
        }
    }
}

