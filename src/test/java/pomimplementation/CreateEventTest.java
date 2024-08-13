package pomimplementation;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import ObjectRepo.CreateToDoPage;
import ObjectRepo.EvenInformationPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.propertiesUtility;

public class CreateEventTest {

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
		HomePage home =  new HomePage(driver);
		CreateToDoPage createToDo = new CreateToDoPage(driver);
		EvenInformationPage evenInfo = new EvenInformationPage(driver);
		
		
		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else
			driverUtil.quitAllWindows();
		
		login.loginToVtiger(propertyUtil.readFromProperties("username"),propertyUtil.readFromProperties("password") );
		
		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();

		Map<String, String> map = excel.readFromExcel("EventsTestData", "Create New Event");
		home.selectFromQuickCreateDD(driverUtil,map.get("Quick Create"));

		jutil.waiting(3000);

		String subject = map.get("Subject") + jutil.generateRandomNum(100);
		
		createToDo.setSubject(subject);
		createToDo.clickStartDateWidget();
		
		createToDo.datePicker(jutil, driverUtil, map.get("Start Date"));
		jutil.waiting(2000);

		createToDo.clickDueDateWidget();
		createToDo.datePicker(jutil, driverUtil, map.get("Due Date"));
		
		
	
		if (evenInfo.getPageHeader().contains(subject)) {
			System.out.println("Event Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Pass");
		} else {
			System.out.println("Event Not Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Fail");
		}
		evenInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");
		excel.saveExcel(IConstantPath.EXCEL_PATH);

		home.signOutOfVtiger(driverUtil);

		excel.closeExcel();

		driverUtil.quitAllWindows();
	}

}
