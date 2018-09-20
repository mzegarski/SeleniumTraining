package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
//		driver.findElement(By.id("lst-ib")).sendKeys("selenium.org");
//		driver.findElement(By.className("gsfi")).sendKeys("selenium.org");
		driver.findElement(By.name("btnI")).click();
//		driver.findElement(By.partialLinkText("Advert")).click();
	}
}