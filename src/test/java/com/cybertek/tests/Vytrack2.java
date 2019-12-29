package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Vytrack2 {

    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS );


        driver.get("https://qa3.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("#_submit")).click();
        String title1 = driver.getTitle();
        System.out.println(title1);

        WebElement shortcut1=driver.findElement(By.cssSelector("[title='Shortcuts']"));
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Shortcuts']")));
        wait.until(ExpectedConditions.visibilityOf(shortcut1));
        wait.until(ExpectedConditions.elementToBeClickable(shortcut1));

        shortcut1.click();
        WebElement shortcut = driver.findElement(By.xpath("//a[contains(text(),'Show Users list')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Show Users list')]")));
        wait.until(ExpectedConditions.visibilityOf(shortcut));
        shortcut.click();

        WebElement sales = driver.findElement(By.xpath("//span[contains(text(),'Sales')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Sales')]")));
        wait.until(ExpectedConditions.visibilityOf(sales));
        String title = "Active Users - Users - User Management - System";
        wait.until(ExpectedConditions.titleIs(title));
        sales.click();


        WebElement opportunities = driver.findElement(By.xpath("//span[contains(text(),'Opportunities')]"));
        wait.until(ExpectedConditions.visibilityOf(opportunities));
        opportunities.click();

        wait.until(ExpectedConditions.titleIs("Open Opportunities - Opportunities - Sales"));
        wait.until(ExpectedConditions.elementToBeClickable(shortcut1));
        wait.until(ExpectedConditions.visibilityOf(shortcut1));

        shortcut1.click();

        driver.findElement(By.xpath("//a[text()='Show Users list']")).click();

        WebElement fleet = driver.findElement(By.xpath("//span[contains(text(),'Fleet')]"));

        title = "Active Users - Users - User Management - System";
        wait.until(ExpectedConditions.titleIs(title));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Fleet')]")));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        fleet.click();

        driver.findElement(By.xpath("//span[contains(text(),'Vehicle S')]")).click();
        wait.until(ExpectedConditions.urlToBe("https://qa3.vytrack.com/entity/Extend_Entity_VehicleServicesLogs"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message']")));
        WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String result = driver.findElement(By.xpath("//div[@class='message']")).getText();
        System.out.println(result);

        driver.quit();



    }
}