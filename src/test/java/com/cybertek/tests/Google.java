package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class Google extends BrowserUtils {
    public static void main(String[] args)  {

        List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium" );

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input[role='combobox']")).sendKeys(searchStrs.get(0));
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement ok =  driver.findElement(By.xpath("//center/input[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(ok));
        ok.click();

        WebElement current = driver.findElement(By.xpath("//cite[contains(text(), 'java.com')]"));
        System.out.println(current.getText());
        WebElement open = driver.findElement(By.cssSelector(".LC20lb"));
        open.click();

        String open1 = driver.getCurrentUrl();
        System.out.println(open1);

        verifyEquals(current,open1);

        driver.navigate().back();

        WebElement current2 = driver.findElement(By.xpath("//cite[contains(text(),'https://www.oracle')]"));
        System.out.println(current2.getText());
        WebElement open2 = driver.findElement(By.xpath("//h3[contains(text(), 'Java SE')]"));
        wait.until(ExpectedConditions.elementToBeClickable(open2));

        open2.click();
        String open3 = driver.getCurrentUrl();
        System.out.println(open3);

        verifyEquals(current2,open3);


        driver.quit();
    }
}
