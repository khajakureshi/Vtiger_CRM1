package genericUtilities;
/**
 * This enum stores all the names of Vtiger application
 * @author sncsr
 */

public enum TabNames {
	ORGANIZATIONS("Accounts"),CONTACTS("contacts"),LEADS("Leads");
	
	private String tabName;
	
	private TabNames(String tabName) {
		this.tabName = tabName;
		
	}
	public String getTabName() {
		return tabName;
	}

}
