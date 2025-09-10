import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Test {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String URL = "jdbc:mysql://localhost/drupaltest?user=root&password=";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connect to JDBC successfully");
		Connection connection = DriverManager.getConnection(URL);
		System.out.println("Connect to JDBC successfully");
		String dbCommand = "select username, password from user";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(dbCommand);
		result.next();
		String user_name = result.getString(1);
		String passw = result.getString(2);
		System.out.println("Log in to MySQL successfully!");
		System.setProperty("webdriver.chrome.driver","/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://74.208.198.155/drupaltest/user/login");
		
		// username is admin, password is test1234
		WebElement username = driver.findElement(By.id("edit-name"));
		username.sendKeys("user_name");
		
		WebElement password = driver.findElement(By.id("edit-pass"));
		password.sendKeys("passw");
		
		WebElement loginButton = driver.findElement(By.name("op"));
		loginButton.click();
		
	}
}