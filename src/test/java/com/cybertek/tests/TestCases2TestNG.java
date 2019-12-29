package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases2TestNG {

    WebDriver driver;
    WebDriverWait wait;
    Select select;

    @BeforeMethod
    public void setUp(){
        driver =  BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.partialLinkText("Registration F")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).isDisplayed());
    }

    @Test
    public void test2(){
        driver.findElement(By.partialLinkText("Registration F")).click();
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("inlineCheckbox3")).isDisplayed());

        //inlineCheckbox1
    }

    @Test
    public void test3(){
        driver.findElement(By.partialLinkText("Registration F")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//small[contains(text(),'first name must')]"))));
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'first name must')]")).isDisplayed());
    }


    @Test
    public void test5()throws InterruptedException{
        driver.findElement(By.partialLinkText("Registration F")).click();
        driver.findElement(By.name("firstname")).sendKeys("Tyler");
        driver.findElement(By.name("lastname")).sendKeys("Fataliyev");
        driver.findElement(By.name("username")).sendKeys("turalfetali");
        driver.findElement(By.name("email")).sendKeys("tural@mail.com");
        driver.findElement(By.name("password")).sendKeys("goodpassword");
        driver.findElement(By.name("phone")).sendKeys("808-808-8080");
        driver.findElement(By.cssSelector("[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/2019");
        select = new Select(driver.findElement(By.name("department")));
        select.selectByValue("MO");
        select = new Select(driver.findElement(By.name("job_title")));
        select.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
//        wait.until(ExpectedConditions.urlToBe("https://practice-cybertekschool.herokuapp.com/registration_confirmation"));
            WebElement element  = driver.findElement(By.xpath("//p[contains(text(),'successfully')]"));
//        wait.until(ExpectedConditions.visibilityOf(element));
           System.out.println(element.getText());
       Assert.assertTrue(element.isDisplayed());

        Thread.sleep(3000);

    }
}
