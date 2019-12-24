package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsHomework1 {

    /**
     Locators homework 1
     Automate the test cases given in the pdf file. You can use existing projects or create new ones. Create classes and methods as you see fit. You can automate test cases in same class or different classes.  Push the code to GitHub at the end.


     Test case 1
     Go to ebay
     enter search term
     click on search button
     print number of results

     Test case 2
     go to amazon
     Go to ebay
     enter search term
     click on search button
     verify title contains search term

     Test case 3
     Go to wikipedia.org (Links to an external site.)
     enter search term `selenium webdriver`
     click on search button
     click on search result `Selenium (software)`
     verify url ends with `Selenium_(software)`
     */

    public static void main(String[] args) {

        //testcase1

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement searchBar = driver.findElement(By.cssSelector("#gh-ac"));
        searchBar.sendKeys("Ray-Ban");
        driver.findElement(By.cssSelector("#gh-btn")).click();
       WebElement element = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println(element.getText());

        driver.quit();

        //testcase2
        //testcase1

         driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
         searchBar = driver.findElement(By.cssSelector("#gh-ac"));
         String expected = "Ray-Ban";
        searchBar.sendKeys(expected);
        driver.findElement(By.cssSelector("#gh-btn")).click();
         element = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println(element.getText());
        String actual = driver.getTitle();

        if(actual.contains(expected)){
            System.out.println("title contains searched iteam");
        }
        else {
            System.out.println("fail");
        }

        driver.quit();


        //testcase3

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        String input = "Selenium (software)";
        driver.findElement(By.cssSelector("#searchInput")).sendKeys(input);
        driver.findElement(By.cssSelector("*[type='submit']")).click();
        String current = driver.getCurrentUrl();
        System.out.println(current);
        System.out.println(input);
        String comp = "Selenium_(software)";
        if (current.contains(comp)){
            System.out.println("url contains input");
        }
        else {
            System.out.println("fail");
        }
        driver.quit();



    }
}
