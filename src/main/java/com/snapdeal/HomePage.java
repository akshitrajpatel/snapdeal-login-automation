package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Define locator for the login link on the homepage
    private By loginLink;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
        System.out.println("Page navigated successfully...");
    }

    // Method to click on the login link with explicit wait
    public void clickLoginLink() {
        System.out.println("Looking for login link...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Update XPath to use contains() for flexibility
        loginLink = By.xpath("//a[contains(text(),'login')]");

        try {
            WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
            System.out.println("Found login link, scrolling into view...");

            // Scroll into view if the element is off-screen
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", loginElement);

            System.out.println("Attempting to click login link...");

            // Try clicking the element
            loginElement.click();
        } catch (Exception e) {
            System.out.println("Click failed, trying JavaScriptExecutor...");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement loginElement = driver.findElement(loginLink);
            js.executeScript("arguments[0].click();", loginElement);
        }

        System.out.println("Login link clicked, proceeding...");
    }
}
