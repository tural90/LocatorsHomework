package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

public class BrowserUtils {
    public static void verifyEquals(String expected, String actual) {


        if (expected.equals(actual)) {
            System.out.println("PASS");
            System.out.println("URL is the same");
        } else {
            System.out.println("FAIL");
            System.out.println("url is not the same");
        }
    }


    public static void verifyEquals(String expected, WebElement actual){

        if (expected.equals(actual)) {
            System.out.println("PASS");
            System.out.println("URL is the same");
        } else {
            System.out.println("FAIL");
            System.out.println("url is not the same");
        }
    }


    public static void verifyEquals(WebElement expected, String actual){

        if (expected.equals(actual)) {
            System.out.println("PASS");
            System.out.println("URL is the same");
        } else {
            System.out.println("FAIL");
            System.out.println("url is not the same");
        }
    }

    public static void verifyEquals(WebElement expected, WebElement actual){

        if (expected.equals(actual)) {
            System.out.println("PASS");
            System.out.println("URL is the same");
        } else {
            System.out.println("FAIL");
            System.out.println("url is not the same");
        }
    }

}

