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

public class iFrameHandling {
	public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
	driver.get("http://www.globalsqa.com/demo-site/datepicker/");
	WebElement ele = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(ele);//Frame 1
	Thread.sleep(3000l);//we can replace this with an explicit wait
	driver.findElement(By.id("datepicker")).click();
	
//	driver.switchTo().parentFrame();// will switch from frame3 to frame2
//	driver.switchTo().defaultContent();//gets out of iFrames alltogether
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Please enter the date");
	int i = scan.nextInt();
	driver.findElement(By.xpath("//td/a[text()='"+i+"']")).click();
	scan.close();
	
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	System.out.println(screenshotFile);// temp : random name : png format
	FileUtils.copyFile(screenshotFile, new File("./error.jpg"));
	
	}
}