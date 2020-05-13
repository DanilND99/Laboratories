package mx.tec.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestHtml2ApplicationTests {
	private static WebDriver driver;
	@BeforeEach
	public void setUp() {
		String basePath = new File("").getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception {
		//When
		driver.get("http://automationpractice.com/index.php");
		String title = driver.getTitle();
		//Then
		assertEquals("My Store", title);
	}
	@Test
	public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception {
		//When
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("pokket@a.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("pokket");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		String title = driver.getTitle();
		//Then
		assertEquals("My account - My Store", title);
	}
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed() throws Exception{
		//When
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("pokket@b.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("pokketa");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		String title = driver.getTitle();
		//Then
		assertEquals("Login - My Store", title);
	}
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed() throws Exception{
		//When
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("pokket@b.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("pokketa");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		WebElement errorField = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		//Then
		assertEquals("Authentication failed.", errorField.getText());
	}
	@Test
	public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsIsDisplayed() throws Exception{
		//When
		driver.get("http://automationpractice.com/index.php");
		WebElement searchField = driver.findElement(By.id("search_query_top"));
		searchField.sendKeys("Konosuba");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
		WebElement spanField = driver.findElement(By.xpath("//span[@class='heading-counter']"));
		//Then
		assertEquals("0 results have been found.",spanField.getText().trim());
	}
	@Test
	public void givenAClient_whenSearchingEmptyString_thenPleaseEnterIsDisplayed() throws Exception{
		//When
		driver.get("http://automationpractice.com/index.php");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
		WebElement pField = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		//Then
		assertEquals("Please enter a search keyword",pField.getText());
	}
	@Test
	public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed() throws Exception{
		//When
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("pokket@a.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("pokket");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		WebElement anchor = driver.findElement(By.xpath("//a[@class='logout']"));
		anchor.click();
		String title = driver.getTitle();
		//Then
		assertEquals("Login - My Store", title);
	}
}
