package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Define locator for the login link on the homepage
    private By loginLink = By.xpath("//*[@id='stack_yuda']"); // Update XPath if necessary

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
        System.out.println(driver.getPageSource());
    }

    // Method to click on the login link with explicit wait
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        loginElement.click();
        System.out.println(driver.getPageSource());
    }
}
