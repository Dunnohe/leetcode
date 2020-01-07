package org.leetcode.headless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxHeadless {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("Email")).sendKeys("Enter user name");
        driver.findElement(By.id("next")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("Passwd")).sendKeys("Enter Password");
        driver.findElement(By.id("signIn")).click();
        Thread.sleep(2000);
        String titleOfPage = driver.getTitle();

        System.out.println(titleOfPage);
    }
}
