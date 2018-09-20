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

public class Assignment4Peco1 {
	public static void main(String[] args) throws InterruptedException, IOException {
//Setup test		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.peco.com/");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);		
//Click on Customer Support submenu		
		WebElement menu = driver.findElement(By.cssSelector("a[aria-label='My Account']"));
		WebElement subMenu = driver.findElement(By.xpath("//a[text()='Customer Support']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30l);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Customer Support']")));
		action.moveToElement(subMenu).click().perform();
//Click on FAQs		
		driver.findElement(By.xpath("//span[text()='FAQs']")).click();
//Take screenshot		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fName = new SimpleDateFormat("'FAQ'yyyyMMddHHmmss'.jpg'").format(new Date());
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.home") + "\\Desktop\\" + fName));
//Navigate back to Customer Service		
		driver.navigate().back();
//Click Contact us, take screenshot and navigate back		
		driver.findElement(By.xpath("//span[text()='Contact Us']")).click();
		screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		fName = new SimpleDateFormat("'Contact'yyyyMMddHHmmss'.jpg'").format(new Date());
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.home") + "\\Desktop\\" + fName));
		driver.navigate().back();
//Click Assistance Programs, take screenshot and navigate back		
		driver.findElement(By.xpath("//span[text()='Assistance Programs']")).click();
		screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		fName = new SimpleDateFormat("'Assistance'yyyyMMddHHmmss'.jpg'").format(new Date());
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.home") + "\\Desktop\\" + fName));
		driver.navigate().back();
//Click Equipment Responsibility, take screenshot and navigate back	
//		action.sendKeys(Keys.CONTROL, Keys.END).perform();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Equipment Responsibility']")).click();
		screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		fName = new SimpleDateFormat("'Equipment'yyyyMMddHHmmss'.jpg'").format(new Date());
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.home") + "\\Desktop\\" + fName));
		driver.navigate().back();
//Test Cleanup
//		driver.close();
		
	}
}
