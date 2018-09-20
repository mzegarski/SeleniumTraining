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

public class Assignment2GmailXpath {

	public static void main(String[] args) {
//Setup for test.				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//a[@class='gb_P' and @data-pid='23']")).click();
		driver.findElement(By.xpath("//a[@data-g-label='Sign in']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mattzegarski@gmail.com");
		driver.findElement(By.xpath("//content/span")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Byteme32");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		
		
		
	}
}