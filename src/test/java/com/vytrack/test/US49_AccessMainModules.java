package com.vytrack.test;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class US49_AccessMainModules {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    //log in as manager
    @Test
    public void login_manager_credentials(){
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("storemanager205");
        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);

        //Login successfully. Verify user see 8 modules

        //1.Verify Dashboards
        WebElement dashBoards1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']"));
        String expectedDash1 = "Dashboards";
        String actualDash1 = dashBoards1.getText();
        Assert.assertEquals(actualDash1, expectedDash1);

        //2.Verify Fleet
        WebElement fleet1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        String expectedFleet = "Fleet";
        String actualFleet = fleet1.getText();
        Assert.assertEquals(actualFleet, expectedFleet);

        //3. Verify Customers
        WebElement customers1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]"));
        String expectedCustom1 = "Customers";
        String actualCustom1 = customers1.getText();
        Assert.assertEquals(actualCustom1, expectedCustom1);

        //4. Verify Sales
        WebElement sales1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]"));
        String expectedSales1 = "Sales";
        String actualSales1 = sales1.getText();
        Assert.assertEquals(actualSales1, expectedSales1);

        //5. Verify Activities
        WebElement activities1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][4]"));
        String expectedActive1 = "Activities";
        String actualActive1 = activities1.getText();
        Assert.assertEquals(actualActive1, expectedActive1);

        //6. Verify Marketing
        WebElement marketing1  = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][5]"));
        String expectedMarket1 = "Marketing";
        String actualMarket1 = marketing1.getText();
        Assert.assertEquals(actualMarket1, expectedMarket1);

        //7. Verify Reports & Segments
        WebElement repSeg1 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][6]"));
        String expectedRepSeg = "Reports & Segments";
        String actualRepSeg = repSeg1.getText();
        Assert.assertEquals(actualRepSeg, expectedRepSeg);

        //8. Verify System
        WebElement systTest = driver.findElement(By.xpath("//li[@class='mobile-hide dropdown dropdown-level-1 last']"));
        String expectedSyst = "System";
        String actualSyst = systTest.getText();
        Assert.assertEquals(actualSyst, expectedSyst);
    }



    //log in as driver

    @Test
    public void login_driver_credentials() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("user172");

        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);

        //Login successfully. Verify user see 4 modules

        //1. Verify Fleet
        WebElement fleet2 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        String expectedFleet2 = "Fleet";
        String actualFleet2 = fleet2.getText();
        Assert.assertEquals(actualFleet2, expectedFleet2);

        //2. Verify Customers
        WebElement custer2 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]"));
        String expectedCuster2 = "Customers";
        String actualCusters2 = custer2.getText();
        Assert.assertEquals(actualCusters2,expectedCuster2);

        //3. Verify Activities
        WebElement active2 = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]"));
        String expectedActive2 = "Activities";
        String actualActive2 = active2.getText();
        Assert.assertEquals(actualActive2, expectedActive2);

        //4. Verify System
        WebElement syst2 = driver.findElement(By.xpath("//li[@class='mobile-hide dropdown dropdown-level-1 last']"));
        String expectedSyst2 = "System";
        String actualSyst2 = syst2.getText();
        Assert.assertEquals(actualSyst2,expectedSyst2);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }







}
