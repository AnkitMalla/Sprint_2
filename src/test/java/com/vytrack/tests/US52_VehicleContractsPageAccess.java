package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US52_VehicleContractsPageAccess {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void managerAccess() throws InterruptedException {
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        Thread.sleep(2000);
        loginBox.sendKeys("storemanager205");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        Thread.sleep(2000);
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(2000);
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Actions builder = new Actions(driver);
        Thread.sleep(2000);
        builder.moveToElement(fleetModule).perform();
        Thread.sleep(2000);
        WebElement vehicleContractLink = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        vehicleContractLink.click();
        Thread.sleep(2000);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("expectedURL = " + expectedURL);
        System.out.println("actualURL = " + actualURL);

        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

    }

    @Test
    public void driverAccess() throws InterruptedException {
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        Thread.sleep(2000);
        loginBox.sendKeys("user178");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        Thread.sleep(2000);
        passwordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        Thread.sleep(2000);
        loginButton.click();
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        Actions builder = new Actions(driver);
        Thread.sleep(2000);
        builder.moveToElement(fleetModule).perform();
        WebElement vehicleContractOption = driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        Thread.sleep(2000);
        vehicleContractOption.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        String expectedMsg = "You do not have permission to perform this action.";
        String actualMsg = errorMessage.getText();
        Assert.assertEquals(actualMsg, expectedMsg);
        System.out.println("expectedMsg = " + expectedMsg);
        System.out.println("actualMsg = " + actualMsg);

    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
