package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

import java.util.Iterator;
import java.util.Set;

public class Dec18_PopAndMultipleWindowFrame {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {



    }


    public static void multipleFrameHandling()
    {
        launchBrowser("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

        driver.switchTo().frame("iframeResult");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().defaultContent();   // This is to switch back to main html

        System.out.println(driver.getTitle());

        driver.quit();
    }

    public static void multipleWinTabHanlding() throws InterruptedException {
        launchBrowser("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

        driver.findElement(By.xpath("//button[text()='New Tab']")).click();

        // Now we have 2 windows, need to capture the  window IDs
        Set<String> winIds = driver.getWindowHandles();
        System.out.println(winIds);

        Iterator<String> itr = winIds.iterator();

        String firstWinId   = itr.next();
        String secondWinId  = itr.next();

        driver.switchTo().window(secondWinId);
        String secWinTitle = driver.getTitle();
        System.out.println(secWinTitle);
        boolean secWinElement =driver.findElement(By.xpath("//h1[text()='New Tab']")).isDisplayed();
        System.out.println(secWinElement);
        Thread.sleep(2000);
        driver.close(); // closes the current window ( focussed window )


        // switching back to first window
        driver.switchTo().window(firstWinId);
        String firstWinTitle = driver.getTitle();
        System.out.println(firstWinTitle);
        driver.quit(); // closes all the windows opened by selenium








//        while (itr.hasNext()) {
//            String winId = itr.next();
//            System.out.println(winId);
//            driver.switchTo().window(winId);
//            Thread.sleep(2000);

    }







    public static void popHandlingEx() throws InterruptedException {
    launchBrowser("https://artoftesting.com/samplesiteforselenium");
    driver.findElement(By.xpath("//button[text()='Generate Alert Box']")).click();
    Thread.sleep(3000);

//        WebDriver.TargetLocator wt = driver.switchTo();
//        Alert a = wt.alert();
//        a.accept();

    // to click on accept/Ok button from Popup
    driver.switchTo().alert().accept();

    // To click on cancel or dismiss buttons
    driver.findElement(By.xpath("//button[text()='Generate Confirm Box']")).click();
    Thread.sleep(3000);
    driver.switchTo().alert().dismiss();

    // To fetch the text from alert
    driver.findElement(By.xpath("//button[text()='Generate Alert Box']")).click();
    Thread.sleep(3000);
    String alertText = driver.switchTo().alert().getText();
    System.out.println(alertText);
    driver.close();
}

    public static void launchBrowser(String url)
    {
        driver = new ChromeDriver();
        driver.get(url);
    }



}
