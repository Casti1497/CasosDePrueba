package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Prueba {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FZ515SJ\\eclipse-workspace\\Login\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		String pathToExtension = "C:\\\\Users\\\\FZ515SJ\\\\AppData\\\\Local\\\\Google\\\\Chrome\\\\User Data\\\\Default\\\\Extensions\\\\gighmmpiobklfepjocnamgkkbiglidom\\\\5.1.1_0";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=" + pathToExtension);
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);

		String url = "https://letterboxd.com/";

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
				"//html[@id='html']//header[@id='header']//nav[@class='main-nav']/ul[@class='navitems']//a[@href='/sign-in/']/span[@class='label']"))
				.click();

		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		WebElement email = driver.findElement(By.xpath("//html[@id='html']//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//html[@id='html']//input[@id='password']"));
		WebElement loginButton = driver.findElement(By
				.xpath("//html[@id='html']//form[@id='signin']/fieldset[@class='fieldset']//input[@value='Sign in']"));
		

		email.clear();
		System.out.println("Ingresando Mail");
		email.sendKeys("LaPrueba");

		password.clear();
		System.out.println("Ingresando Contraseña");
		password.sendKeys("castillo100");

		System.out.println("Clickeando el botón de Ingreso");
		loginButton.click();
		
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// String title = "LaPrueba";
		// boolean actualTitle = driver.getTitle().contains(title);
		// System.out.println("Verificando que la pagina arranque");
		// Assert.assertEquals(actualTitle, title, "Titulo de la pagina no cuadra");

		String actualTitle = driver.getTitle();
		System.out.println("The title of the web page is " + actualTitle);

		String expectedTitle = "Letterboxd • Social film discovery.";

		Assert.assertEquals(actualTitle, expectedTitle,"The actual and expected title don’t match");
		
		System.out.println("La pagina fue verificada");
		System.out.println("Usuario logueado correctamente");

		//driver.quit();

	}

}
