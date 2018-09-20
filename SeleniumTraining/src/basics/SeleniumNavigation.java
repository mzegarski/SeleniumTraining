package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumNavigation {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		Dimension dimension = driver.manage().window().getSize();
		System.out.println(dimension.getHeight());
		System.out.println(dimension.getWidth());
		
		Point point = driver.manage().window().getPosition();
		System.out.println(point.getX());
		System.out.println(point.getY());
		
		driver.findElement(By.linkText("Advertising")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		driver.close();
		
	}
}