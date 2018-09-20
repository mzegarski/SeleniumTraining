package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://google.com");
//		String actualTitle = driver.getTitle();
//		System.out.println(actualTitle);
//		String expected = "google";
//		if(actualTitle.equalsIgnoreCase(expected))
//		{
//			System.out.println ("Test Case Passed");
//		}
		
		String actualURL = driver.getCurrentUrl();
		String expected = "google";
		if (actualURL.contains(expected))
		{
			System.out.println("Test Case Passed");
		}
	}
	
}
