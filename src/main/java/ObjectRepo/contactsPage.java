package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains elements ,locators and respective business libraries of contacts page
 * @author Sncsr
 */
public class contactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactBTN;
	
	//Initialization
	public contactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		//Utlization
		/**
		 * this method clicks on the create contact button
		 */
		public void clickCreateContactBTN() {
			createContactBTN.click();
		}
	}


