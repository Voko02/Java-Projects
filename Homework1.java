import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WindowType;

public class Homework1 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		
		String FirstNameId = "Arian";
		String LastNameId = "Vokopola";
		
		
		driver.get("https://cmpsprojectgroup1.com/isit356/subscription/");
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys(FirstNameId);
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys(LastNameId);
		
		WebElement yearClassification = driver.findElement(By.id("freshman"));
		yearClassification.click();
		
		WebElement club_1 = driver.findElement(By.id("soccer"));
		club_1.click();
		
		WebElement club_2 = driver.findElement(By.id("writing"));
		club_2.click();
		
		WebElement club_3 = driver.findElement(By.id("programming"));
		club_3.click();
		
		WebElement submit = driver.findElement(By.name("subscribe"));
		submit.click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		
	}

}
