package com.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dec19_NavigationsAndMaxMin {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {









    }

    public static  void windowMaxMinSizePointExample() throws InterruptedException {
        launchBrowser("https://artoftesting.com/samplesiteforselenium");


//        WebDriver.Options wo = driver.manage();
//        WebDriver.Window ww = wo.window();
//        ww.maximize();

        //To Maximize the window
        driver.manage().window().maximize();

        Thread.sleep(2000);
        // To minimize
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // To set the window to full screen mode  ( F11)
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // To set the size of the window to a particular size of height and width

        Dimension d = new Dimension(300,300);
        driver.manage().window().setSize(d);
        Thread.sleep(2000);

        // To move the window to a particular point

        Point p = new Point(500,500);
        driver.manage().window().setPosition(p);

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://google.com");

        driver1.manage().window().setSize(new Dimension(300,300));
        driver1.manage().window().setPosition(new Point(100,100));

        // To get the size of a webemenet
        WebElement link = driver.findElement(By.xpath("//a[text()='ArtOfTesting']"));
        Dimension d1 = link.getSize();

        System.out.println(d1.getHeight());
        System.out.println(d1.getWidth());

        // To get the position of a webelement on the screen
        Point p1 = link.getLocation();
        System.out.println(p1.getX());
        System.out.println(p1.getY());


        driver.get();


    }

    public static void browserNavigations() throws InterruptedException {

        launchBrowser("https://artoftesting.com/samplesiteforselenium");
        Thread.sleep(3000);
        driver.get("https://google.com");

        // WebDriver.Navigation wn = driver.navigate();
        //wn.back();

        driver.navigate().back();
        WebDriver.Navigation wn = driver.navigate();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    public static void launchBrowser(String url)
    {
        driver = new ChromeDriver();
        driver.get(url);
    }

}
