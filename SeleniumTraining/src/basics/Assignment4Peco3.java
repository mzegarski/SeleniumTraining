package basics;

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

public class Assignment4Peco3 {
	public static void main(String[] args) throws InterruptedException, IOException {
//Setup test		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.peco.com/");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);		
//Click on AC Cycling submenu
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='Ways to Save']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='AC Cycling']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AC Cycling']")));
		action.moveToElement(subMenu).click().perform();
//Expand and contract the menus on the left of the screen		
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Energy Assessments']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Energy Assessments']"))).click().perform();
		Thread.sleep(2000);
//		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Rebates & Discounts']"))).click().perform();
//		Thread.sleep(2000);
//		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Rebates & Discounts']"))).click().perform();
//		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Recycling']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Recycling']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Efficiency']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Efficiency']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Conversion']"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//i[@aria-label='Gas Conversion']"))).click().perform();
		
// Clean up
		driver.close();
	}
}
