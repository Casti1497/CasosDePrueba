
package Metodos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Metodos {
	
	static WebDriver driver;
	
	public static WebDriver setup(){
		System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void sleep(int seconds) {
		int miliseconds=seconds*1000;
		try {Thread.sleep(miliseconds);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
}
