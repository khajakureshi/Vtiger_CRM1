package hardcodedScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {

	public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	if(driver.getTitle().contains("vtiger CRM"))
		System.out.println("login page is displayed");
	else
		driver.quit();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	if(driver.getTitle().contains("vtiger CRM"))
		System.out.println("home page is displayed");
	else
		driver.quit();
	
	driver.findElement(By.xpath("//a[contains(@href,'Accounts&action=index')]")).click();
	if(driver.getTitle().contains("vtiger CRM"))
		System.out.println("organisations page is displayed");
	else
		driver.quit();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	WebElement pageHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	if(pageHeader.isDisplayed())
		System.out.println("creating new organisation page is displayed");
	else
		driver.quit();
	driver.findElement(By.name("accountname")).sendKeys("khajamynuddin");
		
	driver.findElement(By.id("phone")).sendKeys("8247620727");
	driver.findElement(By.name("website")).sendKeys("https/khajakureshi");
	driver.findElement(By.id("employees")).sendKeys("200");
	driver.findElement(By.name("button")).click();
	if(pageHeader.isDisplayed())
		System.out.println("organisation created successfully");
	else
		driver.quit();
	driver.findElement(By.xpath("//input[@name='Delete']")).click();
	driver.switchTo().alert().accept();
	if(driver.getTitle().contains("vtiger CRM"))
		System.out.println("organisation page is displayed");
	else
		driver.quit();
	WebElement adminwidget=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions actions=new Actions(driver);
	actions.moveToElement(adminwidget).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
	
	

	}

}
