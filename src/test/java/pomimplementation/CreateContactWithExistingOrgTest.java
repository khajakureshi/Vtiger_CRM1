package pomimplementation;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ObjectRepo.ContactInformationPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.contactsPage;
import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.TabNames;
import genericUtilities.WebDriverUtility;
import genericUtilities.propertiesUtility;

public class CreateContactWithExistingOrgTest {

	public static void main(String[] args) {
		propertiesUtility propertyUtil = new propertiesUtility();

		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility driverUtil = new WebDriverUtility();

		propertyUtil.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);

		WebDriver driver = driverUtil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));

		long time = (Long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), DataType.LONG);
		driverUtil.waitTillElementFound(time);

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		contactsPage contact = new contactsPage(driver);
		CreateNewContactPage createContact = new CreateNewContactPage(driver);
		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else

			driverUtil.quitAllWindows();
		login.loginToVtiger(propertyUtil.readFromProperties("username"), propertyUtil.readFromProperties("password"));
//		
//		driver.findElement(By.name("user_name")).sendKeys(propertyUtil.readFromProperties("username"));
//		driver.findElement(By.name("user_password")).sendKeys(propertyUtil.readFromProperties("password"));
//		driver.findElement(By.id("submitButton")).submit();

		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();
		// driver.findElement(By.xpath("//a[contains(@href,'Contacts&action=index')]")).click();
		home.clickRequiredTab(driverUtil, TabNames.CONTACTS);
		if (driver.getTitle().contains("Contacts"))
			System.out.println("Contacts Page Displayed");
		else
//			driver.quit();

		driverUtil.quitAllWindows();
		contact.clickCreateContactBTN();
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

//		WebElement pageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
//		if (pageHeader.isDisplayed())
		if (createContact.getpageFHeader().equalsIgnoreCase("Creating new contact"))
			System.out.println("Creating New Contact Page is Displayed");
		else

			driverUtil.quitAllWindows();

		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");

//		driver.findElement(By.name("lastname")).sendKeys(map.get("Last Name"));
//		driver.findElement(By.xpath("//img[contains(@onclick,'Accounts')]")).click();
//
//		driverUtil.switchToWindow("Accounts");
		createContact.setContactLastName(map.get("Last Name"));
		createContact.selectsExistingOrganization(driverUtil, map.get("Organization Name"));

//		driver.findElement(By.xpath("//a[text()='" + map.get("Organization Name") + "']")).click();
//
//		driverUtil.switchToWindow("Contacts");
//
//		driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		createContact.clickSaveBTN();
//		String newContactPageHeader = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
//
//		if (newContactPageHeader.contains(map.get("Last Name")))
		if (contactInfo.getpageHeader().contains(map.get("Last Name")))
			System.out.println("Contact created successfully");
		else

			driverUtil.quitAllWindows();

		driver.findElement(By.xpath("//input[@name='Delete']")).click();

		driverUtil.handleAlert("ok");

		if (driver.getTitle().contains("Contacts")) {
			System.out.println("Contacts Page is Displayed");

			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass");
		} else {
			driverUtil.quitAllWindows();
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Fail");
		}

		excel.saveExcel(IConstantPath.EXCEL_PATH);
//		WebElement adminWidget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//		driverUtil.mouseHover(adminWidget);
//
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		home.signOutOfVtiger(driverUtil);
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}

}
