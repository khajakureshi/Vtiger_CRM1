package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepo.LoginPage;

public class LoginScript {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Loginpage login = new Loginpage(driver);
		
		login.SetEmailTF("admin");
		login.SetpwdTF("admin");
		login.SetKeepMeLoggedInCB();
		login.SetforgetPWDLink();
		login.SetloginBTN();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
