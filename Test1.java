import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test1 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.cmpsprojectgroup1.com/rndsurvey/home.html");
		
		String ccodeValue = "SWEN 100";
		WebElement ccode = driver.findElement(By.name("ccode"));
		ccode.sendKeys(ccodeValue);
		
		String secValue = "1";
		WebElement sec = driver.findElement(By.name("sec"));
		sec.sendKeys(secValue);
		
		String FacultyId = "1234";
		WebElement facid = driver.findElement(By.name("facid"));
		facid.sendKeys(FacultyId);
		
		WebElement submit = driver.findElement(By.name("accesssurvey"));
		submit.click();
		
		WebElement option1 = driver.findElement(By.name("SWEN100-1000001-1"));
		option1.click();
		
		WebElement option2 = driver.findElement(By.name("SWEN100-1000001-2"));
		option2.click();
		
		WebElement option6 = driver.findElement(By.name("SWEN100-1000001-6"));
		option6.click();
		
		WebElement option3_s2 = driver.findElement(By.name("SWEN100-1000002-3"));
		option3_s2.click();
		
		//WebElement cancel = driver.findElement(By.name("cancel"));
		//cancel.click();
		
		WebElement submit1 = driver.findElement(By.name("submit"));
		submit1.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss(); // click cancel on the JavaScript's alert box
		//alert.accept(); //click OK on the JavaScript's alert box
	}

}
