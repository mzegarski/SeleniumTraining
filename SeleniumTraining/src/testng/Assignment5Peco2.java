package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment5Peco2 {
	
	WebDriver driver;
	Actions action;
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.get("http://www.peco.com/");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testCase1() throws InterruptedException {
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='Outages']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='View Outage Map']"));
		action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Outage Map']")));
		action.moveToElement(subMenu).click().perform();
		String expectedTitle = "Outage Map | PECO - An Exelon Company";
		String actualTitle = driver.getTitle();
//		System.out.println(expectedTitle);
//		System.out.println(actualTitle);
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}
}
