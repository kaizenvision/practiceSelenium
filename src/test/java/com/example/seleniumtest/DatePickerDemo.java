package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DatePickerDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//span[text()='Leave']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions act = new Actions(driver);

        act.click(driver.findElement(By.xpath("(//div[contains(@class,'oxd-date-wrapper')])[1]")))
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();

        act.click(driver.findElement(By.xpath("//div[text()='31']"))).build().perform();


    }
}
