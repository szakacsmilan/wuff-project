package com.codecool.wuff.wuffproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WuffProjectApplication.class, args);
        System.setProperty("webdriver.chrome.driver" ,  "/Users/milanszakacs/Applications/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8888");
        webDriver.manage().window().maximize();
        Thread.sleep(5000);
        webDriver.findElement(By.className("loginbtn")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.className("sign-up")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.id("email")).sendKeys("codecool@codecool.com");
        Thread.sleep(1000);
        webDriver.findElement(By.id("password1")).sendKeys("aaa");
        Thread.sleep(1000);
        webDriver.findElement(By.id("password2")).sendKeys("aaa");
        Thread.sleep(1000);
        webDriver.findElement(By.id("dogName")).sendKeys("Menta");
        Thread.sleep(1000);
        webDriver.findElement(By.id("ownerName")).sendKeys("Dani");
        Thread.sleep(5000);
        webDriver.findElement(By.id("submitbutt")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.className("loginbtn")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.className("loginForm")).sendKeys("codecool@codecool.com");
        Thread.sleep(1500);
        webDriver.findElement(By.className("passwordForm")).sendKeys("aaa");
        Thread.sleep(3000);
        webDriver.findElement(By.className("signIn")).click();
        Thread.sleep(7000);
        webDriver.findElement(By.id("inComment")).sendKeys("What is your favourite Dog breed?");
        Thread.sleep(3000);
        webDriver.findElement(By.className("commentbtn")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.className("spotlistbtn")).click();
        Thread.sleep(4000);
        webDriver.findElement(By.className("adressbox2")).click();
        Thread.sleep(4000);
        webDriver.findElement(By.className("profileButt")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.id("breed")).sendKeys("Greyhound");
        Thread.sleep(2000);
        webDriver.findElement(By.id("birthDate")).sendKeys("2013/t0228");
        Thread.sleep(4000);
        webDriver.findElement(By.className("updateBtn")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.className("saveChangesBtn")).click();
        Thread.sleep(4000);
        webDriver.findElement(By.className("homePageBtn")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.className("logoutBtn")).click();
        Thread.sleep(5000);
        webDriver.close();















    }
}
