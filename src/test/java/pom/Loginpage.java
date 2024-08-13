package pom;

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
		
		@FindBy(id="toPasswordRecoveryPageLink")
		private WebElement forgetPWDLink;
		
		@FindBy(id="last")
		private WebElement loginBTN;
		
		//Initialization
		public Loginpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		//Utilization
		public void SetEmailTF(String email) {
			emailTF.sendKeys(email);
		}
		public void  SetpwdTF(String  pwd) {
			pwdTF.sendKeys(pwd);
		}
		public void SetKeepMeLoggedInCB() {
			KeepMeLoggedInCB.click();
			
		}
		public void SetforgetPWDLink() {
			forgetPWDLink.click();
		}
			public void SetloginBTN() {
				loginBTN.click();
		}
			
				
			}
				
			
	


