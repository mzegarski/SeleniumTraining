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

public class Assignment4Peco2 {
	public static void main(String[] args) throws InterruptedException, IOException {
//Setup test		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.peco.com/");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);		
//Navigate to the Outage Map
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='Outages']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='View Outage Map']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Outage Map']")));
		action.moveToElement(subMenu).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='summary-icon]")));
		driver.findElement(By.xpath("//span[@id='summary-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='icon-cross']")).click();
		
		driver.close();
		
	}
}
