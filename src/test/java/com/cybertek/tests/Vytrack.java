package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vytrack {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = BrowserFactory.getDriver("chrome");
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("https://qa3.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("#_submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-toggle")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dropdown-toggle")));
        WebElement name = driver.findElement(By.cssSelector(".dropdown-toggle"));
        String name1 = name.getText();
        name.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'My Confi')]")));
        driver.findElement(By.xpath("//a[contains(text(),'My Confi')]")).click();

        wait.until(ExpectedConditions.titleContains("Peyton"));
        String title = driver.getTitle();
        if(title.startsWith(name1)){
            System.out.println("title is "+title);
            System.out.println("name of logged in user is "+name1);
            System.out.println("title starts with the same name");
        }
        else {
            System.out.println("title is "+title);
            System.out.println("name of logged in user is "+name1);
            System.out.println("title does not start with the same name");

        }


        Thread.sleep(3000);


        driver.quit();

    }
}