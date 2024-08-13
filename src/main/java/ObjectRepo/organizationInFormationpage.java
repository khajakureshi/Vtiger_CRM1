package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInFormationpage {
	//Declaration 
	@FindBy (css="span.dvHeaderText")
	private WebElement pageHeader;
	@FindBy(xpath =" //input[@name='Delete']")
	private WebElement deleteBTN;
	//Initilization
	public organizationInFormationpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * this method fetches the page header
	 * @return String
	 */
	public String getpageHeader() {
		return pageHeader.getText();
	}
	/**
	 * this method is used to click on delete button
	 */
	public void clickDeleteBTN() {
		deleteBTN.click();
	}
}
	


