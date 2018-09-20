package basics;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeOptionsDemo {
	public static void main(String[] args) {
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings", 0);
	chromePrefs.put("download.default_directory", "C://temp");
	
	ChromeOptions co = new ChromeOptions();
	co.setBinary("Path to Chrome.exe");
	co.setProxy(new Proxy().setHttpProxy(""));
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.globalsqa.com/samplepagetest");
	
	
	
	}
}