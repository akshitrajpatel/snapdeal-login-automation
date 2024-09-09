package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Define locators for elements on the login page
    private By mobileNumberField = By.id("userName");  // The inspected field is correct with id = "userName"
    private By loginButton = By.id("checkUser");       // The login button's ID is assumed as "checkUser"
    private By otpField = By.id("userOtp");            // OTP field ID, if this is a two-factor flow

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the login page
    public void navigateToLoginPage() {
        driver.get("https://www.snapdeal.com/login");
    }

    // Method to enter mobile number or email
    public void enterMobileNumber(String mobileNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the mobile number field to become visible and interactable
        WebElement mobileNumberElement = wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField));

        // Enter the mobile number or email
        mobileNumberElement.sendKeys(mobileNumber);
    }

    // Method to click on the login button
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the login button is clickable
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    // Method to check if the OTP input field is displayed (indicating login step is successful)
    public boolean isOtpFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));
            return driver.findElement(otpField).isDisplayed();
        } catch (TimeoutException e) {
            return false;  // Return false if OTP field doesn't appear in time
        }
    }
}

