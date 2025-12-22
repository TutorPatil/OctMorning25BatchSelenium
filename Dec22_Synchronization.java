package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Dec22_Synchronization extends BaseClass{


    public static void main(String[] args) throws InterruptedException, IOException {

        launchBrowser("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // waiting / sleeping for 3 seconds using thread.sleep
        //Thread.sleep(3000);

        //Max implicit wait is for 20 seconds  and the default polling time is 500 ms( Milli Secs)
        // Once the impplicit wait is applied it will be there until driver is closed/quit
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // Create the Object of WebDriver wait class to explicitly wait for a condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='shopping_cart_container']")));

        boolean result = driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).isDisplayed();
        if(result == true)
            System.out.println("Logged in successfully");
        else
            System.out.println("Could not Log  in!!!");

        driver.quit();
    }


}
