package com.codecool.wuff.wuffproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WuffProjectApplication.class, args);
        System.setProperty("webdriver.chrome.driver" ,  "/Users/milanszakacs/Applications/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8888");
        webDriver.manage().window().maximize();
        Thread.sleep(5000);
        webDriver.findElement(By.id("inComment")).sendKeys("macska");
        Thread.sleep(5000);
        webDriver.findElement(By.className("commentbtn")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.className("spotlistbtn")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.className("adressbox2")).click();




    }
}
