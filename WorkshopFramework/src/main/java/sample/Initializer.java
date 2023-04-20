package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializer {
	protected WebDriver driver;
	
	public Initializer() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		this.driver = new ChromeDriver();
	}
}
