package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {


        //write a method that takes a string parameter
        //based on the value of the parameter
        //the method must return either  chrome driver or firefox driver object
        //name: getDriver




        public static WebDriver getDriver (String browserType){
            WebDriver driver = null;
            switch (browserType.toLowerCase()){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                case "safari":

                    driver = new SafariDriver();

            }
            return driver;

        }

    }

