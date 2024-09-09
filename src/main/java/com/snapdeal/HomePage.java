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
    private By loginLink; // Update XPath if necessary

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to Snapdeal homepage
    public void navigateToHomePage() {
        driver.get("https://www.snapdeal.com/");
        System.out.println("page navigate successfully.....");
        //By elem1= By.xpath("//*[@id='userName']");
        //WebElement element1 = driver.findElement(elem1);
        //String elementClass = element1.getAttribute("class");

        //System.out.println("Class of ele1 : "+ elementClass);
       // System.out.println(driver.getPageSource());
    }

    // Method to click on the login link with explicit wait
    public void clickLoginLink() {
        System.out.println("im here at Homepage() ....");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginLink = By.xpath("//a[text()='login']");
        System.out.println(driver.getPageSource());
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        System.out.println("Found login link, clicking...");
        try {
            loginElement.click();
        } catch (Exception e) {
            System.out.println("Click failed, trying JavaScriptExecutor...");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginElement);
        }
        System.out.println("Login link clicked, proceeding...");
    }
}
