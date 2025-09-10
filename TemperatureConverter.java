import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TemperatureConverter {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		String cases [] = {"100", "230", "a1", "230a", "bb1"};
		String converterTemp []= {"Celsius","Kelvin", "Celsius", "Kelvin", "Celsius"};
		for(int index = 0; index < cases.length; index++) {
			
			if (index == 2 || index == 4) {
				continue;
			}
			
				
		driver.get("https://cmpsprojectgroup1.com/wpdemo/");
			
		WebElement element = driver.findElement(By.xpath("//a[@href='https://cmpsprojectgroup1.com/wpdemo/18-2/']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		
		
		WebElement option1 = driver.findElement(By.name("Fahrenheit"));
		option1.sendKeys(cases[index]);
		
		WebElement firstCaseClick = driver.findElement(By.id(converterTemp[index]));
		firstCaseClick.click();
		
		
		WebElement submitButton = driver.findElement(By.name("Convert"));
		submitButton.click();
		
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		WebElement clearButton = driver.findElement(By.name("Clear"));
		clearButton.click();	
			
		
		}	
	}
}

