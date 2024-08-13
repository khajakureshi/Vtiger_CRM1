package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvenInformationPage {
	//Declaration 
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath =" //input[@name='Delete']")
	private WebElement deleteBTN;
	
	//Initilization 
	public EvenInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	//Utilization
	/**
	 * this method returns page header
	 * @return String
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * this method clicks on delete button
	 */
	public void clickDeleteBTN() {
		deleteBTN.click();
	}
}
