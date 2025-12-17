package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dec17DifferentLocators {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {


        launchBrowser("file:///C:/Users/Sudhanva/Desktop/SaagTrainings/Selenium/DayWiseCode/FIrst2Sessions/Login.html");

        driver.findElement(By.cssSelector("input[id='username']")).clear();
        driver.findElement(By.cssSelector("input#username")).sendKeys("usernamedata");

        driver.findElement(By.cssSelector("#password")).sendKeys("passworddata");

        String data = driver.findElement(By.cssSelector("table tbody tr:nth-child(2) td:nth-child(3)")).getText();
        System.out.println(data);

        driver.findElement(By.cssSelector("input[class='textbox']")).clear();
        driver.findElement(By.cssSelector("input.textbox")).sendKeys("usernamedata");
        driver.findElement(By.cssSelector(".textbox")).clear();

        // ^ is used -- > startswith
        driver.findElement(By.cssSelector("input[id^='rem']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'remm')]")).click();

        //$ - for ends with
        driver.findElement(By.cssSelector("a[id$='link']")).click();  // ends with


        String text = driver.findElement(By.cssSelector("table>tbody tr:nth-child(2) td:last-child a:first-child")).getText();
        System.out.println(text);


        //input[id='user-name']

        //input[@id='user-name']


    }

    public static void locatorsEx2()
    {
        launchBrowser("file:///C:/Users/Sudhanva/Desktop/SaagTrainings/Selenium/DayWiseCode/FIrst2Sessions/Login.html");

        //driver.findElement(By.linkText("ForgotPassword")).click();
        // //a[text()='ForgotPassword']

        // using partial link Text
        //driver.findElement(By.partialLinkText("Password")).click();

        // using Tag Name
        //driver.findElement(By.tagName("img")).click();  //img
        driver.findElement(By.className("textbox")).clear();
        driver.findElement(By.className("textbox")).sendKeys("entering using class name");


        //************** DIFFERENT LOCATORS SUPPORTED BY SELENIUM *****************
        /*
            xpath
            css Selector
            id
            name
            classname
            tagname
            linkText
            partialLinkText

         */


    }

    public static void differentLocatorsEx1()
    {
        launchBrowser("https://www.saucedemo.com/");

        // Locating an element using its id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // //input[@id='user-name']

        // Using name
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // identifying using class
        driver.findElement(By.id("login-button")).click();
    }








    public static void launchAndLoginSauceDemoApp(String url,String userNameData, String passwordData)
    {
        launchBrowser(url);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userNameData);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passwordData);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

    }


    public static void launchBrowser(String url)
    {
        driver = new ChromeDriver();
        driver.get(url);
    }




}
