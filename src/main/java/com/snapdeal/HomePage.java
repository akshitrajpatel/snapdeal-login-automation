package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Define locator for the login link or button on the homepage
    private By loginLink = By.xpath("//a[text()='Login']"); // Update the XPath if needed

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
    }

    // Method to click on the login link/button
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
