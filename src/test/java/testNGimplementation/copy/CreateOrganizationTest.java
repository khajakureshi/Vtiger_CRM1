
package testNGimplementation.copy;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreatingNewOrganizationpage;
import ObjectRepo.Organizationspage;
import ObjectRepo.organizationInFormationpage;
import genericUtilities.BaseClass;
import genericUtilities.TabNames;

@Listeners(genericUtilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "organizations")
	public void createOrgTest() {
		Organizationspage organization = pageObjectManager.getOrganizationpage();
		CreatingNewOrganizationpage createOrg = pageObjectManager.getCreateorg();
		organizationInFormationpage orgInfo = pageObjectManager.getOrgInfo();
		
		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);

		soft.assertTrue(driver.getTitle().contains("Organizations"));
		
		organization.ClickCreateOrgBTN();

		soft.assertTrue(createOrg.getPageHeader().equalsIgnoreCase("creating new organization"));
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization");

		createOrg.setOrganizationName(map.get("Organization Name"));
		createOrg.clickSaveBTN();

		soft.assertTrue(orgInfo.getpageHeader().contains(map.get("Organization Name")));
		
		orgInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");

		soft.assertTrue(driver.getTitle().contains("Organizations"));
		if (driver.getTitle().contains("Organizations")) 
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass");
		else 
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Fail");
		soft.assertAll();
	}

}
