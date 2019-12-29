package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestNg {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
    WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");

    }

@Test
    public void test1(){
    System.out.println(driver.getTitle());


}

@AfterMethod
    public void tearDown(){
    driver.quit();
}

//@Parameters
  //  @Optional





}
