
package testNGimplementation.copy;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.ContactInformationPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.contactsPage;
import assertions.Soft_Assert;
import genericUtilities.BaseClass;
import genericUtilities.TabNames;

@Listeners(genericUtilities.ListenerImplementation.class)
public class CreateContactWithExistingOrgTest extends BaseClass{

	@Test(groups = "contacts")
	public void createContact() {
		contactsPage contact = pageObjectManager.getContactpage();
		CreateNewContactPage createContact = pageObjectManager.getCreatecontactpage();
		ContactInformationPage contactInfo = pageObjectManager.getContactinfo();
		
		home.clickRequiredTab(driverUtil, TabNames.CONTACTS);
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		
		contact.clickCreateContactBTN();

		soft.assertTrue(createContact.getpageFHeader().equalsIgnoreCase("Creating new contact"));
		
		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		
		createContact.setContactLastName(map.get("Last Name"));
		createContact.selectsExistingOrganization(driverUtil, map.get("Organization Name"));

		createContact.clickSaveBTN();

		soft.assertTrue(contactInfo.getpageHeader().contains(map.get("Last Name")));
		
		contactInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");
		
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		if(driver.getTitle().contains("Contacts")) 
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass");
		else 
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Fail");
		soft.assertAll();
	}

}
