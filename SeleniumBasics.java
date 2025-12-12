package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {


        //API docs = https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html
        //Download page = https://www.selenium.dev/downloads/

        WebDriver driver  = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("=================");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        By b = By.xpath("//input[@id='user-name']");
        WebElement username = driver.findElement(b);

        username.sendKeys("standard_user");

      WebElement password =   driver.findElement(By.xpath("//input[@id='password']"));
      password.sendKeys("secret_sauce");

      driver.findElement(By.xpath("//input[@id='login-button']")).click();

      boolean result = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).isDisplayed();

      if (result)
          System.out.println("Login Test case passed");
      else
          System.out.println("Login Test case failed");

      driver.quit();

      //String expectedError = "Epic sadface: Sorry, this user has been locked out.";
      //String actualError = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
      //if (actualError.equals(expectedError))


      }

}
