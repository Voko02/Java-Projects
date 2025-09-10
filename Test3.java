import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class Test3 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://74.208.198.155/drupaltest/");
		
		WebElement element = driver.findElement(By.xpath("//a[@href='https://www.drupal.org']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
		element.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/drupaltest/user/login']"));
		Thread.sleep(1000);
		loginLink.click();  
		
		WebElement username = driver.findElement(By.id("edit-name"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.id("edit-pass"));
		password.sendKeys("test1234");
		
		WebElement loginButton = driver.findElement(By.name("op"));
		loginButton.click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/drupaltest/user']")).click();
		driver.findElement(By.xpath("//a[contains(@*, '/drupaltest/user/logout')]")).click();
		
	}

}
