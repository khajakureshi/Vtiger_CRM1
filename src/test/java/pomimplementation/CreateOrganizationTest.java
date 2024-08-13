package pomimplementation;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import ObjectRepo.CreatingNewOrganizationpage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.Organizationspage;
import ObjectRepo.organizationInFormationpage;
import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.TabNames;
import genericUtilities.WebDriverUtility;
import genericUtilities.propertiesUtility;


public class CreateOrganizationTest {

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
		Organizationspage organization = new Organizationspage(driver);
		CreatingNewOrganizationpage createOrg = new CreatingNewOrganizationpage(driver);
		organizationInFormationpage orgInfo = new organizationInFormationpage(driver);

		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else
			driverUtil.quitAllWindows();

		login.loginToVtiger(propertyUtil.readFromProperties("username"), propertyUtil.readFromProperties("password"));

		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();

		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);

		if (driver.getTitle().contains("Organizations")) {
			System.out.println("Organizations Page is Displayed");}
		else {
			driverUtil.quitAllWindows();}

		organization.ClickCreateOrgBTN();

		if (createOrg.getPageHeader().equalsIgnoreCase("Creating New Organization"))
			System.out.println("Creating New Organization Page is Displayed");
		else
			driverUtil.quitAllWindows();

		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization");

		createOrg.setOrganizationName(map.get("Organization Name"));
		createOrg.clickSaveBTN();

		if (orgInfo.getpageHeader().contains(map.get("Organization Name")))
			System.out.println("Organization created successfully");
		else
			driverUtil.quitAllWindows();

		orgInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");

		if (driver.getTitle().contains("Organizations")) {
			System.out.println("Organizations Page is Displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass");
		} else {
			driverUtil.quitAllWindows();
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Fail");
		}

		excel.saveExcel(IConstantPath.EXCEL_PATH);

		home.signOutOfVtiger(driverUtil);
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}

}