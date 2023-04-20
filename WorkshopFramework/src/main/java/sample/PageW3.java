package sample;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PageW3 extends Initializer {
	String tutorial = "//*/a[@id='navbtn_tutorials']";
	String learnJava = "//*/a[@class='w3-bar-item w3-button'][contains(text(), 'Learn Java')][not (contains(text(), 'Learn JavaScript'))]";
	String javaTitle = "//*[@class='w3-col l10 m12']/h1";
	String javaMethod = "//div/a[@target='_top'][contains(text(), 'Java Math Methods')]";
	String tablaJavamethod = "//tbody/tr";
	
//	public PageW3() {
//		super();
//	}
	
	
	public void generateAutomatedFlow() {
		ArrayList<WebElement> ListadoDeCodigo = new ArrayList<WebElement>();
		driver.get("https://www.w3schools.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath(tutorial)).click();
		driver.findElement(By.xpath(learnJava)).click();

		WebElement checkElement = driver.findElement(By.xpath(javaTitle));
		
		if(checkElement.isDisplayed()) {
			driver.findElement(By.xpath(javaMethod)).click();
		}
		
		ListadoDeCodigo = (ArrayList<WebElement>) driver.findElements(By.xpath(tablaJavamethod));
		System.out.println("JAVA MATH METHODS: \n");
		for(WebElement el : ListadoDeCodigo) {
			System.out.println(el.getText() + "\n");
		}
		
		
		driver.close();
	}
}

	
