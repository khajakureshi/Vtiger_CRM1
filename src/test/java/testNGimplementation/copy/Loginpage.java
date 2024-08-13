package testNGimplementation.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	
		//DeClaration
		@FindBy(id="email") 
		private WebElement emailTF;
		@FindBy(id="password")
		private WebElement pwdTF;
		@FindBy(id="keepLoggedInCheckBox")
		private WebElement KeepMeLoggedInCB;
		@FindBy()
		private WebElement forgetPWDLink;
		@FindBy()
		private WebElement loginBTN;
		
		//Initialization
		public Loginpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		//Utilization
		public void SetEmailTF(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public void SetpwdTF(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public void SetKeepMeLoggedInCB(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public void SetforgetPWDLink(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
			public void SetloginBTN(WebDriver driver) {
				PageFactory.initElements(driver, this);
		}
			public void loginToVtiger(String fromProperties, String fromProperties2) {
				// TODO Auto-generated method stub
				
			}
	}


