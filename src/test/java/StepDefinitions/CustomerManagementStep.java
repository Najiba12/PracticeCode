package StepDefinitions;

import Utilities.basePage;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.commonFunctions;
import Pages.footerPage;
import java.util.Random;
import org.testng.Assert;
import Pages.LoginPage;
import Pages.Utility;
import Utilities.YmlUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.AccountCreationPage;
import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.TopLinksPages;
import Pages.Utility;
import Pages.commonFunctions;
import Pages.footerPage;
import Pages.ManagementPage;

public class CustomerManagementStep extends basePage {
	LoginPage loginPage = new LoginPage();
//	FooterLoginPage foot = new FooterLoginPage();
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
	footerPage footer = new footerPage();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	public WebDriverWait wait;
	String question = "Can we check the status of order from fulfillment tab?";
	String Answer = "Yes";
	AccountCreationPage acc = new AccountCreationPage();
	Random rm = new Random();
	int i = rm.nextInt(100) + 1;
	ManagementPage mgmnt = new ManagementPage();
	YmlUtil yamlData = new YmlUtil();
//	Utility utility = new Utility();
	Actions action = new Actions(driver);
   String FirstCol;
   String SecCol;
   String val;
	@Given("User visits the website {string}")
	public void User_Cisits_Management_Portal_Site(String url) throws IOException {
		String User_role_url = yamlData.getDataYML(urlFileName, url, url);
		driver.get(User_role_url);
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Login - CCM"));
	}
	@Given("User navigates to create account portal {string}")
	public void User_Cisits_Create_Portal_Site(String url) throws IOException {
		String User_role_url = yamlData.getDataYML(urlFileName, url, url);
		driver.get(User_role_url);
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Create Account - CCM"));
	}
//validate logo
	@When("User clicks on logo")
	public void User_Clicks_ContactUs() throws Exception {
		common_func.ClickOnLink(top.Logo);
	}

	// NotificationManagement
	@When("User clicks on Notification Management option from account menu")
	public void Click_Account_Setting_Link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Notification Management").click();
	}

	// Request
	@When("User clicks on request tab from User page")
	public void User_ClicksOn_Req_Tab() throws Exception {
		common_func.ClickOnLink(top.RequestTab);
		Thread.sleep(5000);
	}

	@Then("User verifies whether req active is enabled or not")
	public void User_Verifies_Presence_Req_Active() throws Exception {
		common_func.getWebElement(top.RequestActive).isEnabled();
	}

	// Search
	@Then("User verifies the presence of record list")
	public void User_Verifies_the_Presence_of_Record_List() {
		common_func.getWebElement(top.RecordList).isDisplayed();
	}

	// forgot
	@And("User verifies the presence of alert message")
	public void User_Verifies_Presence_Alert() throws Exception {
		top.Validation_Message.isDisplayed();
	}

	// acclist
	@Then("User checks the presence of all the list and User prints the list on console")
	public void User_Checks_the_Presence_of_All_the_List() {
		footer.VerifyOptionAccountInfoFromAccMenu();
	}
	
	//Comparativebuttons

	@Then("User verifies the print button")
	public void user_verifies_the_print_button() {
	  common_func.getAreftext("Print").isDisplayed();
	}
	@Then("User clicks on comparative analysis")
	public void user_Clicks_Comparative() {
	  top.comparativeAnalysis.click();
	}
	@Then("User verifies the presence of details written on page")
	public void user_verifies_the_presence_of_details_written_on_page() {
	  top.comparativeAnalysisDetail.isDisplayed();
	}

	@Then("User verifies all the buttons present on comparative analysis page")
	public void user_verifies_all_the_buttons_present_on_comparative_analysis_page() {
	 common_func.getAreftext("Expand").isDisplayed();
	 top.ByTime.isDisplayed();
	 top.ByIndustry.isDisplayed();
	 top.Graph.isDisplayed();
	 top.button.isDisplayed();
	}
	//graph
	@Then("User verifies the presence of industry type")
	public void user_verifies_the_presence_of_industry_type() {
	   top.IndustryType.isDisplayed();
	}

	@Then("User verifies the presence of employee size")
	public void user_verifies_the_presence_of_employee_size() {
		top.EmployeeSize.isDisplayed();
	}

	// managementportal
	@And("User verifies the presence of all elements on login page")
	public void User_Checks_Presence_Login_Elements() {
		if(loginPage.Usernamefield.isDisplayed()){
			System.out.println("Username is present");
		}
		if(loginPage.Passwordfield.isDisplayed()){
			System.out.println("Password field is present");
		}
		if(loginPage.Forget_Pswd.isDisplayed()){
			System.out.println("Forgot password is present");
		}
		if(mgmnt.Moto.isDisplayed()){
			System.out.println("Moto field is present");
		}
		if(mgmnt.connectionLogo.isDisplayed()){
			System.out.println("Connection Logo is present");
		}
		if(loginPage.submitBtn.isDisplayed()){
			System.out.println("Login Button is present");
		}
	}
	@And("User verifies the presence of all elements on forgot password page")
	public void User_Checks_Presence_ForgotPass_Elements() {
		if(loginPage.Usernamefield.isDisplayed()){
			System.out.println("Username is present");
		}
		if(mgmnt.Moto.isDisplayed()){
			System.out.println("Moto field is present");
		}
		if(mgmnt.submitbtn.isDisplayed()){
			System.out.println("Submit button is present");
		}
	}
	@Then("User checks presence of customer tab")
	public void User_Checks_Presence_of_Customer_Tab() {
		mgmnt.CustomersTab.isDisplayed();
	}

	@Then("User checks presence of catalog tab")
	public void User_Checks_Presence_of_Catalog_Tab() {
		mgmnt.CatalogTab.isDisplayed();
	}

	@Then("User checks presence of fullfilment tab")
	public void User_checks_presence_of_fullfilment_tab() {
		mgmnt.FullfillmentTab.isDisplayed();
	}

	@Then("User checks presence of Reports tab")
	public void User_Checks_Presence_of_Reports_Tab() {
		mgmnt.ReportsTab.isDisplayed();
	}

	@Then("User checks presence of User tab")
	public void User_Checks_Presence_of_User_Tab() {
		mgmnt.UsersTab.isDisplayed();
	}

	@Then("User checks presence of Account Menu")
	public void User_Checks_Presence_of_Account_Menu() {
		common_func.ClickOnLink(mgmnt.AccountMenu);
	}

	@Then("User checks presence of Logout")
	public void User_Checks_Presence_of_Logout() {
		common_func.getWebElement(mgmnt.Logout).isDisplayed();
	}

	@When("User is taken to dashboard page")
	public void User_is_Taken_to_Dashboard_Page() throws Exception {
		softAssertH.assertEquals(common_func.getTitlePage(), "Dashboard - CCM");
	}
	// Userrole

	@When("User clicks on User tab")
	public void User_ClicksOn_User_Tab() {
		common_func.ClickOnLink(mgmnt.UsersTab);
	}

	@And("User checks presence of User, Setting and jobs")
	public void User_Checks_Presence_User_Sub_Options() {
		common_func.getWebElement(mgmnt.Users).isDisplayed();
		common_func.getWebElement(mgmnt.Settings).isDisplayed();
		common_func.getWebElement(mgmnt.Jobs).isDisplayed();
	}

	// UserRole
	@Then("User checks the option appeared User tab")
	public void User_Checks_Options_User() throws Exception {
		common_func.getWebElement(mgmnt.CreateUser).isDisplayed();
		common_func.getWebElement(mgmnt.Users).isDisplayed();
	}

	@And("User clicks on role link")
	public void User_ClicksOn_Role() throws Exception {
		common_func.ClickOnLink(mgmnt.Roles);
	}

	@When("User hovers on User tab")
	public void User_Hovers_On_User_Tab() {
		mgmnt.HoverGetUsersTab();
	}

	@When("User clicks on add new role button")
	public void User_Clicks_On_New_Role() {
		common_func.ClickOnLink(mgmnt.AddRoleBtn);
	}

	@When("User clicks on edit button of User page")
	public void User_ClicksOn_Edit() {
		common_func.ClickOnLink(mgmnt.EditBtn);
	}

	@Then("User navigates back to page")
	public void User_Navigates_to_Page() {
		mgmnt.getNaviagte();
	}
@Then("User changes role name")
	public void User_changesRoleName() {
		mgmnt.RoleName.clear();
		mgmnt.RoleName.sendKeys("Tester"+i);
	}
	@Then("User verifies the role being edited")
	public void User_Verifies_Changes() throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.RoleEdited.getText().contentEquals("Role updated successfully");
	}

	@When("User clicks on User setup")
	public void User_ClicksOn_User_Setup() {
		common_func.ClickOnLink(mgmnt.Users);
	}

	// customertab
	@When("User clicks on customer tab")
	public void User_ClicksOn_Customer() {
		common_func.ClickOnLink(mgmnt.CustomersTab);
	}

	@And("User checks the presence of fields")
	public void User_Verifies_Presence_Field() {
		common_func.ClickOnLink(mgmnt.AddRoleBtn);
	}

	@When("User clicks on select field button")
	public void User_ClicksOn_Select_Field() throws Exception {
		Thread.sleep(8000);
		common_func.ClickOnLink(mgmnt.SelectFieldBtn);
	}

	@When("User clicks on export button")
	public void User_ClicksOn_Export() throws InterruptedException {
		Thread.sleep(10000);
		common_func.ClickOnLink(mgmnt.ExportBtn);
	}

	@Then("User clicks on export cancel button")
	public void User_Clicks_On_Cancel_Button() throws Exception {
		Thread.sleep(10000);
		common_func.ClickOnLink(mgmnt.ExportCancel);
	}

	@And("User clicks on cancel button field")
	public void User_ClicksOn_Cancel_Button() {
		common_func.ClickOnLink(mgmnt.CancelBtn);
	}
//accountDrag
	@And("User fetches the names of first and second column")
	public void User_Fetches_ColumnsName() {
		FirstCol=mgmnt.FisrtColumn.getText();
		System.out.println("First Col: "+FirstCol);
		SecCol=mgmnt.SeconColumn.getText();
		System.out.println("Second Col: "+SecCol);
	}
	@When("User drags the first column and place it in second column")
	public void User_Drags_Columns() throws InterruptedException, AWTException {
		mgmnt.DragsCol();
		Thread.sleep(5000);
	}
	@Then("User Verifies the the columns are being dragged")
	public void User_Verifies_Dragged_Columns() {
		String FirstCol1=mgmnt.FisrtColumn.getText();
		String SecCol1=mgmnt.SeconColumn.getText();
		Assert.assertEquals(FirstCol1,SecCol);	
		Assert.assertEquals(FirstCol,SecCol1);	
	}
	//acountfilter
	@And("User clicks on {string} filter")
	public void User_Clicks_On_First_Filter(String value) {
		mgmnt.ColumnFilter(value);
	}
	@And("User clicks on clear or reset button")
	public void User_Clicks_On_Reset() throws InterruptedException {
		Thread.sleep(12000);
		common_func.getAreftext("Clear/Reset All").click();
		Thread.sleep(5000);
	}
	
	@Then("User clicks the option and apply {int}")
	public void User_Chooses_Filter(int i) throws InterruptedException {
		Thread.sleep(3000);
		val=common_func.getWebElement(mgmnt.SelectSecOption).getText();
		mgmnt.SelectSecOption.click();
		Thread.sleep(5000);
		top.ScrollsBy300();
		Thread.sleep(3000);
		//common_func.getAreftext("Apply").click();
		mgmnt.Apply(i);
		Thread.sleep(2000);
	}
	@Then("User verifies the information appeared on column {int}")
	public void User_Verifies_Information(int colnum) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.Verify(val, colnum);
	}
	//account sort
	@And("User clicks on column {string}")
	public void User_Clicks_On_Column(String value) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.ClickOnColumn(value);
		Thread.sleep(20000);
	}
	@And("User fetches the column data {int}")
	public void User_Fetches_Column_Data(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.fetchColumnData(i);
	}
	@And("User fetches the first column data {int}")
	public void User_Fetches_Column_Data2(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.fetchColumnData1(i);
	}
	@Then("User verifies whether column {int} is sorted or not")
	public void User_Verifies_Sorting(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.VerifyColumnData(i);
	}
	@Then("User verifies whether first column {int} is sorted or not")
	public void User_Verifies_Sorting_first(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.VerifyColumnDataBySimpleMethod2(i);
	}
	@And("User fetches the column data {int} by simple method")
	public void User_Fetches_Column_Data1(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.fetchColumnDataBySimpleMethod(i);
	}
	@Then("User verifies whether column {int} is sorted or not by simple method")
	public void User_Verifies_Sorting1(int i) throws InterruptedException {
		Thread.sleep(5000);
		mgmnt.VerifyColumnDataBySimpleMethod(i);
	}
	// SubManagement
	@When("User clicks on Subscription tab under customer tab")
	public void User_ClicksOn_Subs() {
		common_func.ClickOnLink(mgmnt.Subscription);
	}

	@When("User clicks on arrow {int} button and User clicks on edit subscription from drop down list")
	public void User_ClicksOn_Arrow(int i) {
		mgmnt.ApplyOnRow(i);
		common_func.ClickOnLink(mgmnt.EditSubs);
	}

	@And("User clicks on edit cancel button")
	public void User_ClicksOn_Edit_Cancel() {
		common_func.ClickOnLink(mgmnt.EditSubCancel);
	}

//assume role
	@When("User clicks on arrow {int} button")
	public void User_ClicksOn_Arrow1(int i) {
		//common_func.ClickOnLink(mgmnt.Arrow1);
		mgmnt.ApplyOnRow(i);
		top.ScrollsBy300();
	}

	@Then("User clicks on Assume Role from drop down list")
	public void User_clicksOn_Assume_Role() throws Exception {
		common_func.ClickOnLink(mgmnt.AssumeRole);
		Thread.sleep(5000);
		common_func.ClickOnLink(mgmnt.AssumeRadio);
		Thread.sleep(2000);
		common_func.ClickOnLink(mgmnt.AssumeRoleBtn);
	}

	@Then("User iterates to next window and come back")
	public void User_naviagtesTo_NextWindow() throws Exception {
		mgmnt.getNextWindow();
	}

	@Then("User clicks on subscription link from footer")
	public void User_ClicksOn_Sub_Footer() throws Exception {
		common_func.ClickOnLink(mgmnt.FSubs);
	}

	// editacc
	@Then("User clicks on edit account")
	public void User_Clickson_Edit_Acc() throws Exception {
		common_func.ClickOnLink(mgmnt.EditAccount);
	}

	@When("User clicks on footer logo")
	public void User_Clickson_Footer_Logo() throws Exception {
		common_func.Scrolls();
		common_func.ClickOnLink(mgmnt.FooterLogo);
	}

	// catalog
	@When("User clicks on catalog tab")
	public void User_ClicksOn_Catalog() {
		common_func.ClickOnLink(mgmnt.CatalogTab);
	}

	@Then("User clicks on categories appeared under catalog tab")
	public void User_Clickson_Categories() throws Exception {
		common_func.ClickOnLink(mgmnt.Categories);
	}

	@When("User clicks on sync button")
	public void User_ClicksOn_Sync_Button() throws InterruptedException {
		Thread.sleep(12000);
		common_func.ClickOnLink(mgmnt.SyncBtn);
		Thread.sleep(10000);
		if(common_func.getWebElement(mgmnt.SyncSuccessful).isDisplayed()) {
			System.out.println("Sync is successful");
		}
	//	common_func.ClickOnLink(mgmnt.SyncClose)
	}

	@And("User clicks on apply button of page")
	public void User_ClicksOn_Apply_Category() throws InterruptedException {
		common_func.ClickOnLink(mgmnt.ApplyBtn);
		Thread.sleep(16000);
	}

	@Then("User clicks on edit category from drop down list")
	public void User_Clickson_Edit_Category() throws Exception {
		common_func.ClickOnLink(mgmnt.EditCategory);
		common_func.getWebElement(mgmnt.Catheading).isDisplayed();
	}

	// domainPage
	@Then("User clicks on domain link under customer tab")
	public void User_ClicksOn_Domain() throws Exception {
		common_func.ClickOnLink(mgmnt.Domain);
	}

	@Then("User clicks on Request link under customer tab")
	public void User_ClicksOn_Request_link() throws Exception {
		common_func.ClickOnLink(mgmnt.RequestTab1);
	}

	@Then("User clicks on net terms")
	public void User_ClicksOn_Net_Terms() throws Exception {
		mgmnt.NetTermHeading.isDisplayed();
	}
	@Then("User selects current date and apply")
	public void User_Chooses_CurrentDate() throws Exception {
		Select se3 = new Select(acc.DateFilterDomain);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterFromDomain.isDisplayed();
		se3.selectByIndex(1);
		acc.DateFilterToDomain.isDisplayed();
		se3.selectByIndex(1);
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}
	@Then("User verifies the current date appeared on column {int}")
	public void User_Verifies_Date(int i) throws Exception {
		mgmnt.VerifyDate(i);
	}
	@Then("User filters out current date and clicks on apply button")
	public void User_Filters_Out_CurrentDate() throws InterruptedException {
		acc.DateFilter.isDisplayed();
		Select se3 = new Select(acc.DateFilter);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterFrom.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		acc.DateFilterTo.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}
	@Then("User filters out current date and clicks on apply")
	public void User_Filters_Out_Current_Date() throws InterruptedException {
		acc.DateFilterNoti.isDisplayed();
		Select se3 = new Select(acc.DateFilterNoti);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterFromNoti.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		acc.DateFilterToNoti.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}
	// notificationManagement
	@Then("User clicks on Notification link under customer tab")
	public void User_ClicksOn_Noti() throws Exception {
		common_func.ClickOnLink(mgmnt.CustNotification);
	}

	@Then("User clicks on send notification link")
	public void User_ClicksOn_Send_Noti() throws Exception {
		common_func.ClickOnLink(mgmnt.SendNotificationBtn);
	}

	@Then("User clicks on edit provider from drop down list")
	public void User_ClicksOn_Edit_Provider() throws Exception {
		common_func.ClickOnLink(mgmnt.EditProvider);
	}

	@And("User clicks on cancel button of provider page")
	public void User_ClicksOn_Cancel_Provider() throws Exception {
		top.ScrollsBy300();
		top.ScrollsBy300();
		common_func.ClickOnLink(mgmnt.cancelBtn);
		driver.navigate().back();
	}

	@When("User clicks on add provider button")
	public void User_ClicksOn_Add_Provider() throws Exception {
		common_func.ClickOnLink(mgmnt.AddProvider_Btn);
	}

	// servicetab //sendmail
	@When("User clicks on service under catalog tab")
	public void User_ClicksOn_Service_Tab() {
		common_func.ClickOnLink(mgmnt.ServicesTab);
	}

	@When("User clicks on edit service from drop down list")
	public void User_ClicksOn_Edit_Service() {
		common_func.ClickOnLink(mgmnt.EditService);
	}
	@And("User fills out all the requisites")
	public void User_Mails_Email() throws InterruptedException {
		mgmnt.Organisation.sendKeys("Arpatech");
		Thread.sleep(5000);
		mgmnt.Account.click();
		Thread.sleep(5000);
		Select drpCountry = new Select(driver.findElement(By.id("selectAccount")));
		Thread.sleep(5000);
		drpCountry.selectByVisibleText("Muhammad Jawad6");
		mgmnt.Subject.sendKeys("Automation Testing");
		mgmnt.mailTo.sendKeys("Muhammad.jawad+1@arpatech.com");
		mgmnt.EditContent.sendKeys("I am testing this web page");
		common_func.Scrolls();
		Thread.sleep(5000);
		mgmnt.Send.click();
		Thread.sleep(5000);
	}
	@Then("User hovers on send emails and clicks on send bulk emails")
	public void User_Clicks_SendBulkEmails() throws Exception {
		action.moveToElement(mgmnt.SendEmails).perform();
		mgmnt.SendBulkEmails.click();
	}
	//request
	@And("User verifies the presence of request elements")
	public void User_Verifies_Addons_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		if (mgmnt.SyncBtn.isDisplayed()) {
			System.out.println("Sync button is present");
		}
		String Detail = mgmnt.AddonsDetail.getText();
		System.out.println(Detail);
	}
	@Then("User clicks the first option and apply {int}")
	public void User_Chooses_Second_Filter(int i) throws InterruptedException {
		Thread.sleep(3000);
		val=common_func.getWebElement(mgmnt.SelectFirstOption).getText();
		mgmnt.SelectFirstOption.click();
		top.ScrollsBy300();
		Thread.sleep(2000);
		mgmnt.Apply(i);
		Thread.sleep(5000);
	}
	@And("User clicks on {string}")
	public void User_Clicks_On_Menu(String val) throws Exception {
		mgmnt.clickOnMenu(val);
	}
	@And("User cancels the reject option")
	public void User_Clicks_On_Cancel() throws Exception {
		Thread.sleep(2000);
		mgmnt.Cancelbtn1.click();
	}
	@Then("User clicks on view accounts option")
	public void user_clicks_on_view_accounts_option() {
		common_func.getAreftext("View Account").click();
	}
	//filter
	String filterValue;
	@And("User fetches the content on column {int}")
	public void User_fetches_filter_content1(int i) throws Exception {
		Thread.sleep(2000);
		filterValue=mgmnt.Filter(i);
	}
	@Then("User verifies the content appeared on column {int}")
	public void User_Verifies_filter_content1(int i) throws Exception {
		Thread.sleep(2000);
		String value;
		value=mgmnt.Filter(i);
		Assert.assertTrue(value.equals(filterValue));
	}
}