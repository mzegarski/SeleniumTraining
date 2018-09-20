package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment5Peco3 {

	WebDriver driver;
	Actions action;
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.peco.com/");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='Ways to Save']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='AC Cycling']"));
		action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AC Cycling']")));
		action.moveToElement(subMenu).click().perform();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testCase1() throws InterruptedException {
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Energy Assessments']"))).click().perform();
//put in some kind of assertion to verify that the menu expanded		
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Energy Assessments']"))).click().perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCase2() throws InterruptedException {
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Recycling']"))).click().perform();
//put in some kind of assertion to verify that the menu expanded		
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Recycling']"))).click().perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCase3() throws InterruptedException {
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Efficiency']"))).click().perform();
//put in some kind of assertion to verify that the menu expanded		
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Efficiency']"))).click().perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCase4() throws InterruptedException {
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Conversion']"))).click().perform();
//put in some kind of assertion to verify that the menu expanded		
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Conversion']"))).click().perform();
		Thread.sleep(2000);
	}
}
