package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Define locators for the login link or button on the homepage
    private By loginLink = By.xpath("//*[@id='loginIframe']"); // Update the XPath if needed

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
    }

    // Method to switch to iframe (if needed)
    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Assuming the iframe can be located by its tag name; update if necessary
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
    }

    // Method to click on the login link/button with explicit wait
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        loginElement.click();
    }

    // Method to switch back to the main content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
