package ObjectRepo;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
//	LoginPage login;
//	HomePage home;
//	Organizationspage org;
//	contactsPage con;
//	CreatingNewOrganizationpage createorg;
//	CreateNewContactPage createcon;
//	CreateToDoPage createtodo;
//	organizationInFormationpage orginfo;
//	ContactInformationPage coninfo;
//	EvenInformationPage eventinfo;
	
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLogin() {
		return new LoginPage(driver);
	}

	public HomePage getHome() {
		return new HomePage(driver);
	}

	public Organizationspage getOrganizationpage() {
		return new Organizationspage(driver);
	}

	public contactsPage getContactpage() {
		return new contactsPage(driver);
	}

	public CreatingNewOrganizationpage getCreateorg() {
		return new CreatingNewOrganizationpage(driver);
	}

	public CreateNewContactPage getCreatecontactpage() {
		return new CreateNewContactPage(driver);
	}

	public CreateToDoPage getCreatetoDo() {
		return new CreateToDoPage(driver);
	}

	public organizationInFormationpage getOrganizationinfo() {
		return new organizationInFormationpage(driver);
	}

	public ContactInformationPage getContactinfo() {
		return new ContactInformationPage(driver);
	}

	public EvenInformationPage getEventinfo() {
		return new EvenInformationPage(driver);
	}

	public organizationInFormationpage getOrgInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
