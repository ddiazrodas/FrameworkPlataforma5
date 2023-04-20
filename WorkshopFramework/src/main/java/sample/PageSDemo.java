package sample;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.DataVerification;

public class PageSDemo extends Initializer{
	
	//DECLARAR XPATH, TAREA PARA LOS CHICOS DE P5
	private String userXpath = "//*[@id='login_credentials'][contains(text(),'standard_user')]";
	private String passwordXpath = "//*[@class=\"login_password\"]";
	private String inputUsernameXpath = "//*[@id=\"user-name\"]";
	private String inputPasswordXpath = "//*[@id=\"password\"]";
	private String loginBtnXpath = "//*[@id=\"login-button\"]";
	private String addToCartBtnXpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]";
	private String cartBtnXpath = "//*[@id=\"shopping_cart_container\"]/a";
	private String removeBtn = "//*[@id=\"remove-sauce-labs-backpack\"]";

	public void assessmentOne() {
		//INGRESAR A LA WEB
		driver.get("https://www.saucedemo.com/");
		//NECESITO TIEMPOS DE ESPERA (NO TODO CARGA INSTANTANEO)
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//LOCALIZAR ELEMENTOS USUARIO Y CONTRASEÑA
		String username = driver.findElement(By.xpath(userXpath)).getText();
		String password = driver.findElement(By.xpath(passwordXpath)).getText();
		//LIMPIAR EL STRING CON METODO SPLIT
		String standard_user = username.split(":")[1].split("locked")[0];
		String password_sauce = password.split(":")[1];
		//VERIFICAR EL VALOR OBTENIDO PARA LOGUEARSE
		DataVerification.verificationMessage(standard_user, password_sauce);
		//LOCALIZAR Y LLENAMOS LOS INPUTS
		driver.findElement(By.xpath(inputUsernameXpath)).sendKeys(standard_user);
		driver.findElement(By.xpath(inputPasswordXpath)).sendKeys(password_sauce);
		//LOCALIZAR BOTON DE LOG-IN Y DAR CLICK
		driver.findElement(By.xpath(loginBtnXpath)).click();
	}
	
	public void assessmentTwo( ) throws InterruptedException {
		//LOCALIZAR BOTON AGREGAR AL CARRITO DEL ITEM BAGPACK
		driver.findElement(By.xpath(addToCartBtnXpath)).click();
		//LOCALIZAR EL CARRITO Y DAR CLICK
		driver.findElement(By.xpath(cartBtnXpath)).click();
		// Thread.sleep(3000);
		//NECESITO TIEMPOS DE ESPERA HASTA QUE UN ELEMENTO ESPECIFICO (REMOVE) SEA VISIBLE (NO TODO CARGA INSTANTANEO)
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(removeBtn)));
		//LOCALIZAR ELEMENTO REMOVE Y DAR CLICK
		driver.findElement(By.xpath(removeBtn)).click();
		//CERRAR DRIVER
		driver.close();
	}
}

