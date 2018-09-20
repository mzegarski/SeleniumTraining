package basics;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3Date {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
	driver.get("http://www.globalsqa.com/demo-site/datepicker/");
	WebElement ele = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(ele);
	WebDriverWait wait = new WebDriverWait(driver, 30l);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("datepicker")));
	driver.findElement(By.id("datepicker")).click();
	driver.findElement(By.cssSelector("handler[title='Prev']")).click();
	
	}
}