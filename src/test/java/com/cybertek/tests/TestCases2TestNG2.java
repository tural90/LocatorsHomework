package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases2TestNG2{

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    @BeforeMethod

    public void setDriver(){
        driver = BrowserFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDown(){
     driver.quit();
    }


    @Test
    public void testCase6(){
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();
        driver.findElement(By.name("full_name")).sendKeys("Tyler Taylor");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        Assert.assertTrue(driver.findElement(By.name("signup_message")).isDisplayed());
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();
        String text = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]")).getText();
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]")).isDisplayed());
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"schranka\\\"]/tr[3]/td[1]/span[2]\")")));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]")));
       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]"))));
        element= driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Assert.assertTrue(driver.findElement(By.id("odesilatel")).isDisplayed());
        System.out.println(driver.findElement(By.id("odesilatel")).getText());
        Assert.assertTrue(driver.findElement(By.id("predmet")).isDisplayed());
        System.out.println(driver.findElement(By.id("predmet")).getText());

    }

    @Test
    public void test2() throws InterruptedException{
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);

       // actions.dragAndDrop(source,target).perform(); //
        actions.clickAndHold(source).moveToElement(target).release().build().perform();

        Thread.sleep(2000);

    }
    }
