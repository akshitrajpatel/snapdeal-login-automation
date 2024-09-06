package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    // Define locators
    private By iframeLocator = By.tagName("iframe");  // Locator for the iframe containing the login link
    private By loginLink = By.xpath(//*[@id="loginIframe"]); // Locator for the login link inside the iframe

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
    }

    // Method to switch to the iframe
    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, 20);  // Wait for up to 20 seconds
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframeElement);  // Switch to the iframe
    }

    // Method to switch back to the main content
    public void switchToMainContent() {
        driver.switchTo().defaultContent();  // Switch back to the main content
    }

    // Method to click on the login link/button
    public void clickLoginLink() {
        switchToIframe();  // Switch to the iframe first
        WebDriverWait wait = new WebDriverWait(driver, 20);  // Wait for up to 20 seconds
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        loginElement.click();
        switchToMainContent();  // Switch back to the main content if needed
    }
}
