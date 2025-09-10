import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class WordPress {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://cmpsprojectgroup1.com/wpdemo/");
		
		driver.findElement(By.xpath("//a[@href= 'https://cmpsprojectgroup1.com/wpdemo/wp-login.php']")).click();
		
		driver.findElement(By.xpath("//a[@href= 'https://cmpsprojectgroup1.com/wpdemo/wp-login.php?action=register']")).click();
		
		String username = "Voko02A";
		String email = "avokopola7@gmail.com";
		String psw = "#30012002Av@";
		
		WebElement usrnam = driver.findElement(By.id("user_login"));
		usrnam.sendKeys(username);
		
		WebElement mail = driver.findElement(By.id("user_email"));
		mail.sendKeys(email);
		
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.xpath("//a[@href= 'https://cmpsprojectgroup1.com/wpdemo/wp-login.php']")).click();
		
		WebElement mail_1 = driver.findElement(By.id("user_login"));
		mail_1.sendKeys(email);
		
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys(psw);
		
		driver.findElement(By.id("wp-submit")).click();
	}

}
