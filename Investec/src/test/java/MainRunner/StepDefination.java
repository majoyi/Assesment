package MainRunner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {

	static WebDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;

	public StepDefination() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws InterruptedException {
		String sBrowser = "edge";
		String sUrl = "https://www.investec.com/";
		String Item = "cash investment rates";
		String sName = "";
		String sSurname = "";
		String sEmail = "";
		OpenBrowser(sBrowser, sUrl);
		js = (JavascriptExecutor) driver;

		// font[contains(text(),'Search')]
		By sSearchId = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]/div[1]");
		By sSearchTextID = By.id("searchBarInput");

		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.presenceOfElementLocated(sSearchId));
		driver.findElement(sSearchId).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(sSearchTextID));
		driver.findElement(sSearchTextID).sendKeys(Item);

		// navigate to url -
		// https://www.investec.com/en_za/focus/money/understanding-interest-rates.html
		driver.get(" https://www.investec.com/en_za/focus/money/understanding-interest-rates.html");

		By sSignUpID = By.xpath(
				"/html[1]/body[1]/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]");
		By sNameId = By.name("name");
		wait.until(ExpectedConditions.presenceOfElementLocated(sSignUpID));
		js.executeScript("window.scrollBy(0,500)", "");
		// driver.findElement(sSignUpID).click();
		Thread.sleep(5000);
		driver.findElement(sSignUpID).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(sNameId));
		// driver.findElement(sNameId).click();
		driver.findElement(sNameId).sendKeys("edwin");
		// driver.findElement(By.name("surname")).click();
		driver.findElement(By.name("surname")).sendKeys("test");
		// driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("edwin.ndlala@gmail.com");
		driver.findElement(By.cssSelector(".checkbox-input__trigger-button--first-child")).click();
		driver.findElement(By.cssSelector(".checkbox-input__buttons:nth-child(3) > .checkbox-input__trigger-button"))
				.click();
		WebElement submit = driver.findElement(By.cssSelector(".forms__submit"));
		js.executeScript("window.scrollBy(0,250)", "");
		submit.click();
		// js.executeAsyncScript("arguments[0].click();",submit);

		 By Thank_you = By.name("chform");
		 wait.until(ExpectedConditions.presenceOfElementLocated(Thank_you));
		 submit = driver.findElement(Thank_you);
		 String actual =(String) js.executeScript("return arguments[0].text;", submit);
		 
		 System.out.println("Htehhdjhdj "+actual);
		// String expected = "Thank you";
		// assertEquals(expected, actual);
		// (ThankyouMsg, Message);
	}

	public static void OpenBrowser(String sBrowser, String sUrl) {

		if (sBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// WebDriverManager.chromedriver().setup() ;

			driver = new ChromeDriver();
		} else if (sBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// WebDriverManager.chromedriver().setup() ;

			driver = new EdgeDriver();
		}
		else if (sBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// WebDriverManager.chromedriver().setup() ;

			driver = new FirefoxDriver();
		}

		// navigate to browser
		driver.get(sUrl);

		// Maximize the browser
		// driver.manage().window().maximize();
		// Use wait for let the brower to be ready
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void SearchItem(String Item) {

		js = (JavascriptExecutor) driver;

		// font[contains(text(),'Search')]
		By sSearchId = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]/div[1]");
		By sSearchTextID = By.id("searchBarInput");

		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.presenceOfElementLocated(sSearchId));
		driver.findElement(sSearchId).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(sSearchTextID));
		driver.findElement(sSearchTextID).sendKeys(Item);
	}

	public void AddPersonDetails(String sName, String sSurname, String sEmail) throws InterruptedException {

		// navigate to url -
		// https://www.investec.com/en_za/focus/money/understanding-interest-rates.html
		driver.get(" https://www.investec.com/en_za/focus/money/understanding-interest-rates.html");

		By sSignUpID = By.xpath(
				"/html[1]/body[1]/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]");
		By sNameId = By.name("name");
		wait.until(ExpectedConditions.presenceOfElementLocated(sSignUpID));
		js.executeScript("window.scrollBy(0,500)", "");
		// driver.findElement(sSignUpID).click();
		Thread.sleep(5000);
		driver.findElement(sSignUpID).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(sNameId));
		// driver.findElement(sNameId).click();
		driver.findElement(sNameId).sendKeys(sName);
		// driver.findElement(By.name("surname")).click();
		driver.findElement(By.name("surname")).sendKeys(sSurname);
		// driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys(sEmail);
		driver.findElement(By.cssSelector(".checkbox-input__trigger-button--first-child")).click();
		driver.findElement(By.cssSelector(".checkbox-input__buttons:nth-child(3) > .checkbox-input__trigger-button"))
				.click();
		WebElement submit = driver.findElement(By.cssSelector(".forms__submit"));
		js.executeScript("window.scrollBy(0,250)", "");
		submit.click();
		// js.executeScript("window.scrollBy(0,250)", "");
		// js.executeAsyncScript("arguments[0].click();",submit);
	}

	public void Close() {
		driver.quit();
	}

}
