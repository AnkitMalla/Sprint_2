package com.vytrack.test;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));


    }




}
