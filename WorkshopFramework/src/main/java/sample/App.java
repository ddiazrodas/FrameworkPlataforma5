package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	public static void main(String[] args) {	
//		PageW3 w3school = new PageW3();
//		w3school.generateAutomatedFlow();
		
		PageSDemo demo = new PageSDemo();
		demo.assessmentOne();
	}
}
