package com.selenium;

import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class Dec24_JavaScriptExecutor extends BaseClass {


    public static void main(String[] args) throws IOException {

        launchBrowser("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        String title = (String) js.executeScript("return document.title;");

        System.out.println(title);

        String url = (String) js.executeScript("return document.URL;");

        System.out.println(url);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight;");


    }
}
