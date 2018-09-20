package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchTagNames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for(int i=0;i<ele.size();i++)
		{
			String link = ele.get(i).getAttribute("href");
			System.out.println(link);
		}
	}
}