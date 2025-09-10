
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

public class Test2 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		
		String ccodeValue []= { "SWEN 100", "SWEN100", "SWEN 100"};
		String secValue []= {"1", "1", "2"};
		String FacultyId [] = {"1234", "1234", "1234"};
		
		for(int index = 0; index < ccodeValue.length; index++) {
		driver.get("https://www.cmpsprojectgroup1.com/rndsurvey/home.html");
		WebElement ccode = driver.findElement(By.name("ccode"));
		ccode.sendKeys(ccodeValue[index]);
		
		WebElement sec = driver.findElement(By.name("sec"));
		sec.sendKeys(secValue[index]);
		
		WebElement facid = driver.findElement(By.name("facid"));
		facid.sendKeys(FacultyId[index]);
		
		WebElement submit = driver.findElement(By.name("accesssurvey"));
		submit.click();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		}
	}

}
