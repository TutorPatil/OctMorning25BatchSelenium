package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeniumBasics15Dec {
    static WebDriver driver = null;

    public static void findAltTextForBackPack()
    {
        launchAndLoginSauceDemoApp();

        WebElement backPack = driver.findElement(By.xpath("//div[@class='inventory_item_img']/a/img[@data-test='inventory-item-sauce-labs-backpack-img']"));
        String backPackALt = backPack.getAttribute("alt");
        String expectedAltText = "Sauce Labs Backpack";
        System.out.println(" The alt text value is "+backPackALt);

        if(backPackALt.equals(expectedAltText))
            System.out.println("Test case findAltTextForBackPack is Pass");
        else
            System.out.println("Test case findAltTextForBackPack is Fail!!");

        closeDriver();

    }


    public  static void verifyCartItems_001()
    {
        launchAndLoginSauceDemoApp();

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_img']/a/img"));

        int itemCount = items.size();

       // Using for each method
        items.forEach(item -> {
            System.out.println(item.getAttribute("alt"));
        });

        // using enhanced for loop
        for(WebElement m : items)
        {
            System.out.println(m.getAttribute("alt"));
        }

        // Using Regualr for loop
        for(int i=0; i<itemCount; i++)
        {
            String s = items.get(i).getAttribute("alt");
            System.out.println(s);
        }


        System.out.println("There are "+itemCount +" in the home page");


        closeDriver();
    }


    public static void login_001()
    {
        launchAndLoginSauceDemoApp();
        boolean result = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).isDisplayed();

        if(result)
            System.out.println("Test case Login_001 is Pass");
        else
            System.out.println("Test case Login_001 is Fail");

        closeDriver();

    }

    public static void launchAndLoginSauceDemoApp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        By b = By.xpath("//input[@id='user-name']");
        WebElement userName =  driver.findElement(b);
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }



    public static void captureToolTipOfImage()
    {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Sudhanva/Desktop/SaagTrainings/Selenium/DayWiseCode/FIrst2Sessions/Login.html");
        String title = driver.findElement(By.xpath("//img[@id='logo1']")).getAttribute("title");
        System.out.println(title);
    }

    public static void main(String[] args) {

        verifyCartItems_001();

    }

    public static  void closeDriver()
    {
        driver.quit();
    }
    

}
