import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WindowType;
public class ExtractFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/voko02/Desktop/Software 2025/chromedriver-mac-arm64/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		String fullNameSt [] = {"Alice Johnson", "Bob Smith", "","Sarah Henderson", "Karen Doherty"};
		String residencySt [] = {"In-State", "Out-of-State", "In-State", "Out-of-State", ""};
		String creditHrs [] = {"12", "15", "10", "abc", "8"};
		for (int index = 0; index < fullNameSt.length ; index++) {
		driver.get("https://cmpsprojectgroup1.com/isit356/tuitionestimator.html");
		
		WebElement Name = driver.findElement(By.id("name"));
		Name.sendKeys(fullNameSt[index]);
		
		WebElement Residency = driver.findElement(By.id("residency"));
		Residency.sendKeys(residencySt[index]);
		
		WebElement Credit = driver.findElement(By.id("credits"));
		Credit.sendKeys(creditHrs[index]);
		
		WebElement estimateTuitionButton = driver.findElement(By.xpath("//button[contains(.,'Estimate Tuition')]")); // type="button" >Estimate Tuition
		estimateTuitionButton.click();
		
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(2));
			Thread.sleep(3000);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			driver.switchTo().newWindow(WindowType.TAB);
			}
			catch(Exception e) {
				driver.switchTo().newWindow(WindowType.TAB);
			}
			
			}
		
		
	    // Using Java Extracting Information Based on my xml file (DataSet.xml)
		
		File file = new File("/Users/voko02/eclipse-workspace/TuitionAssignment/src/DataSet.xml");
		DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println(doc.getDocumentElement().getNodeName()); // To show the first line of XML file
		NodeList nodeList = doc.getElementsByTagName("case");
		System.out.println(nodeList.getLength());
		for(int n = 0; n < nodeList.getLength(); n++) { // retrieve cases from the XML
			Node node = nodeList.item(n);
			//System.out.println(node.toString());
			NodeList childNode = node.getChildNodes();
			for(int c = 0; c < childNode.getLength(); c++) { // retrieve columns inside each case
				Node tag = childNode.item(c);
				//System.out.println(tag.toString());
				String attr = tag.getNodeName();
				//System.out.println(attr);
				Element element = (Element) node;
				if(attr.equals("fullName")) {
					String value = element.getElementsByTagName(attr).item(0).getTextContent();
					System.out.println("\n"+ attr + ": " + value);
				}
					else if(attr.equals("residencyStatus")) {
					String value = element.getElementsByTagName(attr).item(0).getTextContent();	
					System.out.println(attr + ": " + value);
					}
						else if(attr.equals("creditHours")) {
						String value = element.getElementsByTagName(attr).item(0).getTextContent();	
						System.out.println(attr + ": " + value);
						}
						else if(attr.equals("tuition")) {
							String value = element.getElementsByTagName(attr).item(0).getTextContent();	
							System.out.println(attr + ": " + value);
							}
						
				}
			}
			
		}
	

}



