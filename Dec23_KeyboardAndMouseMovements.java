package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Dec23_KeyboardAndMouseMovements extends BaseClass{


    public static void main(String[] args) throws IOException, InterruptedException {

    }



    public static void keyPressOperations() throws IOException, InterruptedException {
        // key press using actions class

        launchBrowser("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        // Creating Object of Actions class and passing driver as constructor argument
        Actions action = new Actions(driver);

        WebElement textBox = driver.findElement(By.xpath("//input[@id='name']"));

        action.click(textBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("selenium")
                .keyUp(Keys.SHIFT)
                .perform();

        Thread.sleep(3000);

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='state']"));
        action.click(dropDown)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN)
                .perform();
    }

    public static void contextClick() throws IOException {
        // Context menu / right click of mouse
        launchBrowser("https://artoftesting.com/samplesiteforselenium");

        WebElement textBoxContextClick = driver.findElement(By.xpath("//input[@id='fname']"));

        // Creating Object of Actions class and passing driver as constructor argument
        Actions action = new Actions(driver);

        // performing context click on the textbox
        action.contextClick(textBoxContextClick).perform();
    }

    public static void doubleClickOperation() throws IOException, InterruptedException {
        // double click operation

        launchBrowser("https://artoftesting.com/samplesiteforselenium");
        WebElement dClickBtn = driver.findElement(By.xpath(" //button[@id='dblClkBtn']"));

        // Creating Object of Actions class and passing driver as constructor argument
        Actions action = new Actions(driver);


        action.doubleClick(dClickBtn).perform();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();

    }

    public static void dragAndDropExample() throws IOException {

        // Drag and drop using actions class

        launchBrowser("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        WebElement toDrag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement toDrop = driver.findElement(By.xpath("//div[@id='droppable']"));

        // Creating Object of Actions class and passing driver as constructor argument
        Actions action = new Actions(driver);

        // using the Drag and drop method of actions class to perform the operation...
        action.dragAndDrop(toDrag, toDrop).perform();

        /*

        // in case drag and drop does not work use the below

        action.clickAndHold(toDrag)
                .moveToElement(toDrop)
                .release()
                .perform();

         */

    }

    public static void mouseMovement() throws IOException, InterruptedException {

        // mouse movement
        launchBrowser("https://www.flipkart.com/");
        WebElement menu = driver.findElement(By.xpath("//span[text()='Fashion']"));

        // Creating Object of Actions class and passing driver as constructor argument
        Actions action = new Actions(driver);
        // using moveToElement method of Actions class and then calling perform method
        action.moveToElement(menu).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Men Footwear']")).click();
    }
}
