package com.vytrack.test;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US50_Users_access_to_the_Oroinc_Documentation_page {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test (priority = 1)
    public void truck_drivers_access_the_oroinc_doc_page() throws InterruptedException { //

        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("user179");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();

        // Locate on Question Icon and click on it
       WebElement clickQuestionIcon = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
        clickQuestionIcon.click();
        Thread.sleep(2000);

        // Truck Drivers on the Oroinc Documentation page
        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());

            if (driver.getTitle().equals("Welcome to Oro Documentation")) {
                break;
            }

          Thread.sleep(2000);
        }
        Assert.assertEquals(driver.getTitle(), "Welcome to Oro Documentation");

    }

        @Test (priority = 2)
        public void store_manager_access_the_oroinc_doc_page() throws InterruptedException { //

            WebElement usernameInput2 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            usernameInput2.sendKeys("storemanager205");

            WebElement passwordInput2 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            passwordInput2.sendKeys("UserUser123");

            WebElement loginButton2 = driver.findElement(By.xpath("//button[@id='_submit']"));
            loginButton2.click();
            Thread.sleep(2000);


            // Locate on Question Icon and click on it

            WebElement clickQuestionIcon2 = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
            clickQuestionIcon2.click();
            Thread.sleep(2000);

            // Store Managers on the Oroinc Documentation page

            Set<String> allWindows = driver.getWindowHandles();

            for (String eachWindow : allWindows) {
                driver.switchTo().window(eachWindow);
                System.out.println("driver.getTitle() = " + driver.getTitle());

                if (driver.getTitle().equals("Welcome to Oro Documentation")) {
                    break;
                }

                Thread.sleep(2000);
            }
            Assert.assertEquals(driver.getTitle(), "Welcome to Oro Documentation");
        }

    @Test (priority = 3)
    public void sales_manager_access_the_oroinc_doc_page() throws InterruptedException { //

        WebElement usernameInput3 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput3.sendKeys("salesmanager144");

        WebElement passwordInput3 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput3.sendKeys("UserUser123");

        WebElement loginButton3 = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton3.click();

        // Locate on Question Icon and click on it

        WebElement clickQuestionIcon3 = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
        clickQuestionIcon3.click();
        Thread.sleep(2000);

        // Sales Managers on the Oroinc Documentation page

        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());

            if (driver.getTitle().equals("Welcome to Oro Documentation")) {
                break;
            }

            Thread.sleep(2000);
        }
        Assert.assertEquals(driver.getTitle(), "Welcome to Oro Documentation");
    }

    @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

