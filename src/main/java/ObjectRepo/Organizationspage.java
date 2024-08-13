package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains elements, locators and respective business libraries of organizations
 * @author sncsr
 */
public class Organizationspage {
	
//Declaration
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgBTN;
	
	//Initialization
	
	public Organizationspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * this method clicks on the create organization button
	 */
	public void ClickCreateOrgBTN() {
		createOrgBTN.click();
}
}
