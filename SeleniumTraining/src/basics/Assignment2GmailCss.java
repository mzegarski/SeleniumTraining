package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2GmailCss {

	public static void main(String[] args) throws InterruptedException {
//Setup for test.				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
//Main test
		driver.findElement(By.cssSelector("a[class='gb_P'][data-pid='23']")).click();
		driver.findElement(By.cssSelector("a[data-g-label='Sign in']")).click();
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("mattzegarski@gmail.com");
		driver.findElement(By.cssSelector("span[class='RveJvd snByac'")).click();
		Thread.sleep(3000);
		
//		WebDriverWait wait = new WebDriverWait(driver, 60l);
//		wait.until(ExpectedConditions.presenceviOfElementLocated(By.cssSelector("input[type='password']")));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Byteme32");
		driver.findElement(By.cssSelector("span[class='CwaK9']"));
		
		
		
		
		
	}
}