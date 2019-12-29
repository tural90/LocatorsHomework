package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ebay {
    public static void main(String[] args) throws InterruptedException{


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver,5);

        WebElement inputBar = driver.findElement(By.cssSelector("#gh-ac"));
        inputBar.sendKeys("Wooden spoon");
        WebElement search = driver.findElement(By.cssSelector("#gh-btn"));
        search.click();
        WebElement result = driver.findElement(By.xpath("//div[@class='srp-controls__row-cells']//span[@class='BOLD']"));
        String n = result.getText().replace(",",".");
        WebElement all = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
        all.click();
        WebElement result2 = driver.findElement(By.xpath("//h1/span[@class='BOLD']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1/span[@class='BOLD']")));
        wait.until(ExpectedConditions.visibilityOf(result2));
        String n2 = result2.getText().replace(",",".");
        System.out.println(result);
        System.out.println(n+" "+n2);
        double i = Double.parseDouble(n);
        double y = Double.parseDouble(n2);

        if(i>y){
            System.out.println(i+" is greater than "+y);
        }
        else {
            System.out.println(y+" is greater than "+i);
        }

        driver.navigate().back();
        WebElement inputBar2 = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        WebDriverWait wait2 = new WebDriverWait(driver,5);

        wait2.until(ExpectedConditions.visibilityOf(inputBar2));
        Thread.sleep(5000);
        inputBar2.click();
        String input = inputBar2.getAttribute("value");
        System.out.println("input bar result is "+input);

        driver.navigate().back();

        WebElement inputBar3 = driver.findElement(By.cssSelector("#gh-ac"));
        wait.until(ExpectedConditions.visibilityOf(inputBar3));
        String input3 = inputBar3.getAttribute("value");
        System.out.println("input bar result is "+input3);

        driver.quit();
    }
}