package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;
/**
 * this class contains elements , locators and respective business libraries of creating module
 */
public class CreateNewContactPage {
	//Declaration
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name = "lastname")
	private WebElement ContactLastNameTF;
	
	@FindBy(xpath = "//input[contains(@title,'Save ')]")
	private WebElement SaveTN;
	
	@FindBy(xpath = "//img[contains(@onclick,'Accounts')]")
	private WebElement organizationPlusBTN;
	
	private String organizationPath = "//[text()='%s']";
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * this method fetches the page header
	 * @return String
	 */
	public String getpageFHeader() {
		return pageHeader.getText();
	}
	/**
	 * this method sets the orgamnisations name into the organization name text field
	 * @param name
	 */
	public void setContactLastName(String name) {
		
		ContactLastNameTF.sendKeys(name);
	}
	/**
	 * this method clicks on save button
	 */
		public void clickSaveBTN() {
			SaveTN.click();
		}
		/**
		 * this method selects the existing organization from the organizations window
		 * @param driverUtil
		 * @param orgName
		 */
		public void selectsExistingOrganization(WebDriverUtility driverUtil,String orgName) {
			 organizationPlusBTN.click();
	driverUtil.switchToWindow("Accounts");
	driverUtil.convertDynamicXpathToWebElement(organizationPath, orgName).click();
	driverUtil.switchToWindow("contacts");
	
		}

		}
