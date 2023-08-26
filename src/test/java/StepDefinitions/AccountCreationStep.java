package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.AccountCreationPage;
import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.ManagementPage;
import Pages.PDPPage;
import Pages.TopLinksPages;
import Pages.Utility;
import Pages.commonFunctions;
import Pages.footerPage;

public class AccountCreationStep extends basePage {
	AccountCreationPage acc = new AccountCreationPage();
	LoginPage loginPage = new LoginPage();
	FooterLoginPage foot = new FooterLoginPage();
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
	footerPage footer = new footerPage();
	public String email11;
	YmlUtil yamlData = new YmlUtil();
	ManagementPage mgmnt = new ManagementPage();
//	Utility utility = new Utility();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	WebDriverWait wait = new WebDriverWait(driver, 120);
	Random rm = new Random();	PDPPage pdp = new PDPPage();
	int i = rm.nextInt(10000) + 1;
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	Properties prop = new Properties();
	String Servicename;
//AccountCreation

	@Then("User provides {string} and {string}")
	public void User_Provides_Cred(String add, String zip) throws InterruptedException {
		Thread.sleep(9000);
		common_func.getWebElement(acc.BAadl).sendKeys(add);
		top.ScrollsBy300();
		// acc.getBAZip().sendKeys(zip);
		common_func.getWebElement(acc.BAzip).sendKeys(zip);
	}

	@Then("User passes values to BA {string} and clicks on save")
	public void User_Passes_Values(String string) throws IOException, InterruptedException {
		acc.CheckZipCode(string);
	}

	@And("User clicks on change payment button")
	public void User_Passes_onChangePayment() throws IOException, InterruptedException {
		Thread.sleep(7000);
		common_func.getAreftext("Change Payment Method").click();
		Thread.sleep(7000);
	}

//forgotpass
	@Then("User verifies alert message")
	public void User_Verifies_Alert_Message() throws InterruptedException {
		acc.getAlert();
	}

//footer
	@Then("User clicks on footer links")
	public void User_Clicks_on_Footer_Links() throws InterruptedException {
		Thread.sleep(7000);
		common_func.ClickOnLink(top.auditlog);
	}

	@Then("User clicks on footer link")
	public void User_Clicks_on_Footer_Links1() throws InterruptedException {
		Thread.sleep(7000);
		common_func.ClickOnLink(acc.FAQ);
	}

	@Then("User clicks on account menu and clicks on logo")
	public void User_Clicks_on_Account_Menu_and_Clicks_on_Logo() {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Budget").click();
		if (common_func.isElementPresent(footer.logo)) {
			common_func.ClickOnLink(footer.logo);
		}
	}

	@Then("User verifies presence of global search and gets account initials text after checking environment")
	public void User_Verifies_Presence_of_Global_Search_and_Gets_Account_Initials_Text() throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String env = prop.getProperty("env");
		common_func.SearchTab.isDisplayed();
		acc.CheckEnvironment(env);
	}

	@Then("User verifies the presence of account menu and bell icon")
	public void User_Verifies_the_Presence_of_Account_Menu_and_Bell_Icon() {
		acc.AccountmenuMgmt.isDisplayed();
		acc.bellicon.isDisplayed();
	}

	@Then("User verifies the presence of footer links")
	public void User_Verifies_the_Presence_of_Footer_Links() {
		//acc.AllFooterLinks();
		footer.isFooterLinkPresent();
		footer.isTopLinkPresent();
	}

//HOMEPAGE
	@When("User clicks on connect logo")
	public void User_Clicks_on_Connect_Logo() {
		common_func.ClickOnLink(acc.connLogo);
	}

	@Then("User checks the presence of get now and manage button and social icon")
	public void User_Checks_the_Presence_of_Get_Now_and_Manage_Button_and_Social_Icon() {
		acc.socialIcon.isDisplayed();
	}

	@Then("User clicks on usage")
	public void User_Clicks_on_Usage() {
		common_func.ClickOnLink(acc.Usage);
	}

	@Then("User clicks on calendar")
	public void User_Clicks_on_Calendar() {
		common_func.ClickOnLink(acc.Calendar);	}

	@Then("User clicks on insight")
	public void User_Clicks_on_Insight() {
		common_func.ClickOnLink(footer.Insight);
	}

	@Then("User clicks on spend analysis")
	public void User_Clicks_on_Spend_Analysis() {
		common_func.ClickOnLink(acc.spendAnalysis);
	}

	@Then("User clicks on orders link")
	public void User_Clicks_on_Orders_Link() throws InterruptedException {
		Thread.sleep(6000);
		common_func.ClickOnLink(acc.Order);
	}

	@Then("User clicks on signed Agreement link")
	public void User_Clicks_on_Signed_Agreement_link() {
		// acc.getSignedAgreement().click();
		common_func.ClickOnLink(top.FsignedAgreement);
	}

	@Then("User clicks on bill lines link")
	public void User_Clicks_on_Bill_Lines_Link() {
		// acc.getBillLines().click();
		common_func.ClickOnLink(top.Fbillline);
	}

	@Then("User clicks on bills link")
	public void User_Clicks_on_Bills_Link() {
		// acc.getBills().click();
		common_func.ClickOnLink(top.Fbills);
	}

	@Then("User clicks on FAQ link")
	public void User_Clicks_on_Faq_Link() {
		// acc.getFaq().click();
		common_func.ClickOnLink(acc.FAQ);
	}

	@When("User clicks on term of use link")
	public void user_clicks_on_term_of_use_link() {
		common_func.getAreftext("Terms of Use").click();
	}

	@When("User clicks on privacy policy link")
	public void user_clicks_on_privacy_policy_link() {
		common_func.getAreftext("Privacy Policy").click();
	}
	// validateProcurement

	@Then("User clicks on aref Get it now button on page")
	public void User_Clicks_on_Aref_Get_it_Now_Button_on_Page1() throws InterruptedException {
		acc.getitNow.click();
		Thread.sleep(5000);
		if(common_func.isElementPresentBy(acc.OrderConfirm)||common_func.isElementPresentBy(acc.OrderConfirm1)) {
			Thread.sleep(5000);
			common_func.getAreftext("Continue with Purchase").click();	}
	}

	@And("User verifies procurement page {string}")
	public void User_Verifies_Procurement_Page(String page) throws Exception {
			softAssertH.assertEquals(common_func.getTitlePage(), page);
	}
	@And("user fetches service name")
	public void User_Fetches_ServiceName() throws Exception {
		Thread.sleep(5000);
			Servicename=acc.ServiceName.getText();
	}
	@And("User verifies the status of order")
	public void User_Fetches_Status() throws Exception {
		Thread.sleep(10000);
		String status=acc.ServiceStatus.getText();
		System.out.println(status);
	}
	@Then("User checks environment and pass to search bar of subscription page")
	public void User_Pass_Value_To_Subscription_SearchBar1() throws Exception {
		   Thread.sleep(10000);
			pdp.SearchSub.sendKeys(Servicename);
			Thread.sleep(10000);
			pdp.SearchSub.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			//if(acc.ServiceNameVerify.getText().equals(Servicename)) {
			//	System.out.println("present");
			//}
		}
	@Then("User passes domain name and tenant name generated randomly")
	public void User_Passes_Domain_Name_and_Tenant_Name_Generated_Randomly() throws InterruptedException {
		Thread.sleep(5000);
		if (common_func.isElementPresentBy(acc.tenantLabel)) {
			common_func.ClickOnLink(acc.createtenant);
			Thread.sleep(5000);
			common_func.getWebElement(acc.createtenant).sendKeys("TestAutomationDomain41"+Keys.ENTER);
			Thread.sleep(5000);
			top.ScrollsBy300();
			common_func.getOnLinkText("Continue").click();
			Thread.sleep(15000);
			System.out.println("done1");
			//acc.TenentDetails();
			//Thread.sleep(8000);
		} 
		 if(common_func.isElementPresentBy(acc.SelectTenant)||common_func.isElementPresentBy(acc.SelectTenant2)) {
				//acc.SelectTenant1.click();
				Thread.sleep(5000);
				Select tenant = new Select(common_func.getWebElement(acc.SelectTenant1));
				tenant.selectByIndex(1);
				Thread.sleep(5000);
				acc.TenentDetails();
				//top.ScrollsBy300();
				//common_func.getOnLinkText("Continue").click();
			//	Thread.sleep(15000);
				System.out.println("pw");
			}
		//if(!common_func.isElementPresentBy(acc.SelectTenant)||!common_func.isElementPresentBy(acc.SelectTenant2)||!common_func.isElementPresentBy(acc.tenantLabel)){
		 else {
		 acc.TenentDetails();
		}
		System.out.println("done");
	}
	@Then("User passes domain name and tenant name generated")
	public void User_Passes_Domain_Name_and_Tenant_Name_Generated_Randomly1() throws InterruptedException {
		Thread.sleep(5000);
	 if(common_func.isElementPresentBy(acc.SelectTenant)||common_func.isElementPresentBy(acc.SelectTenant2)) {
			//acc.SelectTenant1.click();
			Thread.sleep(5000);
			Select tenant = new Select(common_func.getWebElement(acc.SelectTenant1));
			tenant.selectByIndex(1);
			Thread.sleep(5000);
			acc.TenentDetails();
		}
	}

	@Then("User checks the environment and provides all information")
	public void User_Checks_the_Environment_and_Provides_All_Information() throws InterruptedException, IOException {
		System.out.println("donhvj");
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String env = prop.getProperty("env");
		System.out.println(env);
		acc.ChecksEnvAndProvideAdd(env);
	}

	@Then("User clicks on continue")
	public void User_Clicks_on_Continue() throws InterruptedException {
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.Continue13);
		Thread.sleep(5000);
	}

	@Then("User passes {string} to purchase order")
	public void Passes_to_Purchase_Order(String string) throws InterruptedException {
		common_func.getWebElement(top.PurchaseOrder).sendKeys(string);
		Thread.sleep(10000);
	}

	@Then("User clicks on continue , agree and submit order")
	public void User_Clicks_on_Continue_Agree_and_Submit_Order() throws InterruptedException {
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.Continue2);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.Sbmt_Order);
		Thread.sleep(7000);
	}

	@Then("User clicks on related tenants")
	public void User_Clicks_on_Related_Tenants() throws InterruptedException {
		Thread.sleep(5000);
		common_func.getAreftext("Related Tenants").click();
	}
	@And("User receives thank you message")
	public void User_receives_Thankyou_Message() throws InterruptedException {
		Thread.sleep(10000);
		acc.ThankYou.isDisplayed();
		Thread.sleep(5000);
	}

	@Then("User clicks on cancel")
	public void Clicks_on_Cancel() {
		common_func.ClickOnLink(acc.cancelbtn);
	}

	@Then("User clicks on show related subscription")
	public void User_Clicks_on_Show_Related_Subscription() throws InterruptedException {
		acc.ShowRelatedSub();
	}

	@Then("User clicks on add of use")
	public void User_Clicks_on_Add_of_Use() throws InterruptedException {
		Thread.sleep(7000);
		acc.getAddOfUseEdit();
	}

	@Then("User passes {string} and clicks on save")
	public void User_Passes_and_Clicks_on_Save(String string) throws InterruptedException {
		acc.getValues(string);
	}

	@Then("User clicks on sales division access")
	public void User_Clicks_on_Sales_Division_Access() {
		// wait.until(ExpectedConditions.elementToBeClickable(acc.getSalesDivisionExpansion()));
		common_func.ClickOnLink(acc.SalesDivisionExpansion);
	}
	@And("User clicks on microsoft provider")
	public void User_Clicks_on_Microsoft() throws InterruptedException {
	common_func.Scrolls();
	common_func.Scrolls();
		Thread.sleep(5000);
	 common_func.getLabelText("Microsoft").click();
	 common_func.getAreftext("Apply").click();
	 Thread.sleep(5000);
	}
	@And("User clicks on adobe provider")
	public void User_Clicks_on_Adobe() throws InterruptedException {
	common_func.Scrolls();
	common_func.Scrolls();
		Thread.sleep(5000);
	 common_func.getLabelText("Acronis").click();
	 common_func.getAreftext("Apply").click();
	 Thread.sleep(5000);
	}
//accCrea

	@Then("User clicks on add account button")
	public void User_Clicks_on_Add_Account_Button() {
		common_func.getAreftext("Add Account").click();
	}

	@Then("User is taken to add account {string}")
	public void User_is_Taken_to_Add_Account(String page) {
		wait.until(ExpectedConditions.titleContains(page));
		Assert.assertEquals(driver.getTitle(), page, "error");
	}

	@Then("User clicks on default admin")
	public void User_Clicks_on_Default_Admin() throws InterruptedException {
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.DeafultAdmin);
	}

	@Then("User provide new email generated randomly {string}")
	public void Provide_New_Email_Generated_Randomly(String name) throws InterruptedException {
		/*	email11 = "MohdJawad+" + i + "@arpatech.com";
			acc.enteremail.clear();
			acc.enteremail.sendKeys(email11);
			Thread.sleep(11000);
			acc.CreateNewAcc();
			Thread.sleep(5000);
			common_func.ClickOnLink(acc.Continue);
			Thread.sleep(15000);*/
		do {	
			i = rm.nextInt(10000) + 1;
			email11 = name + i + "@arpatech.com";
		acc.enteremail.clear();
		acc.enteremail.sendKeys(email11);
		Thread.sleep(20000);
		acc.CreateNewAcc();
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.Continue);
		Thread.sleep(20000);}
	while (common_func.isElementPresentBy(acc.alertEmail)||common_func.isElementPresentBy(acc.alertEmail1)) ;
	}
	@Then("User provide email generated randomly {string}")
	public void Provide_Email_Generated_Randomly(String name) throws InterruptedException {
		email11 = name + i + "@arpatech.com";
		acc.email.sendKeys(email11);
		common_func.getAreftext("Verify Email").click();
		Thread.sleep(5000);
		common_func.getWebElement(acc.code).sendKeys("111111");
		common_func.getAreftext("Verify").click();
		Thread.sleep(15000);}
	@Then("User clicks on save and contibue button")
	public void User_Clicks_on_Contibue1_Button() throws InterruptedException {
		Thread.sleep(5000);
		WebElement BEAccount = driver.findElement(By.className("multiselect"));
		BEAccount.click();
		BEAccount.sendKeys("Create New Account" + Keys.ENTER);
	}
	@Then("User clicks on contibue button")
	public void User_Clicks_on_Contibue_Button() throws InterruptedException {
	/*do {	email11 = "MohdJawad+" + i + "@arpatech.com";
		acc.enteremail.clear();
		acc.enteremail.sendKeys(email11);
		Thread.sleep(11000);
		acc.CreateNewAcc();
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.Continue);
		Thread.sleep(15000);}
	while (common_func.isElementPresentBy(acc.alertEmail)||common_func.isElementPresentBy(acc.alertEmail1)) ;*/
	}
	String AccName1;
	@Then("User provides {string} {string}")
	public void User_Provides(String string, String string2) throws InterruptedException {
		Thread.sleep(5000);
		common_func.getWebElement(acc.OrganizationName).sendKeys(string);
		AccName1=string2+i;
		common_func.getWebElement(acc.BusinessName).sendKeys(string2 + i);
		common_func.getWebElement(acc.industryType).sendKeys("Business" + Keys.ENTER);
		Select se1 = new Select(acc.NumberOfEmployees);
		Thread.sleep(3000);
		se1.selectByIndex(1);
		common_func.ClickOnLink(acc.ContInfo);
	}
	String AccName;
	@Then("User provides details of organization {string} {string}")
	public void User_Provides_Organizatation_Other_Details(String string, String string2) throws InterruptedException {
		common_func.getWebElement(acc.OrganizationNameR).sendKeys(string);
		AccName=string2+i;
		common_func.getWebElement(acc.BusinessNameR).sendKeys(string2 + i);
	//	common_func.getWebElement(acc.industryTypeR).click();
		Thread.sleep(3000);
		common_func.getWebElement(acc.industryTypeR).sendKeys("Business" + Keys.ENTER);
		Select se1 = new Select(acc.NumberOfEmployeesR);
		Thread.sleep(3000);
		se1.selectByIndex(1);
	}
	@And("User provides details {string} {string} {string}")
	public void User_Provides_Details(String add, String zip, String phone) throws InterruptedException {
		common_func.getWebElement(acc.AddressR).sendKeys(add);
		common_func.getWebElement(acc.ZipR).sendKeys(zip);
		common_func.getWebElement(acc.PhoneaddaccR).sendKeys(phone);
		Thread.sleep(3000);
		common_func.getAreftext("Save & Continue").click();
	}
	@And("User provides detail information {string} {string} {string}")
	public void User_Provides_DetailsInfo(String add, String zip, String phone) throws InterruptedException {
		common_func.getWebElement(acc.Address).sendKeys(add);
		common_func.getWebElement(acc.Zip).sendKeys(zip);
		common_func.getWebElement(acc.Phoneaddacc).sendKeys(phone);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.ContinueOrg);
	}

	@Then("User provides personal details {string}")
	public void User_Provides_Personal_Details(String email) throws InterruptedException {
	common_func.getWebElement(acc.TeamEmail).sendKeys(email);
	Thread.sleep(3000);
		common_func.ClickOnLink(acc.ContSalesRepManagement);
	}

	@Then("User clicks on billing address and sales division")
	public void User_Clicks_on_Billing_Address() throws InterruptedException {
		Thread.sleep(3000);
		// acc.BillingAddressExpansion().click();
		common_func.ClickOnLink(acc.BillingAddressExpansion);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.SalesDivisionExpansion);
	}

	@And("User provides details of billing {string} {string} {string}")
	public void User_Provides_DetailsBilling(String add, String zip, String phone) throws InterruptedException {
		common_func.getWebElement(	acc.BillingAddressLine1).sendKeys(add);
		common_func.getWebElement(acc.BillingAddressZip).sendKeys(zip);
		Thread.sleep(3000);
		common_func.getWebElement(	acc.BillingAddressPhone).sendKeys(phone);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.ContBillingAddress);
	}

	@Then("User clicks on sales division access and select division")
	public void User_Clicks_on_Sales_Division_Access_and_Select_Division() throws InterruptedException {
		Thread.sleep(3000);
		common_func.getWebElement(acc.SelectDivision).sendKeys("PSG");
		top.ScrollsBy300();
		common_func.ClickOnLink(acc.ContSalesDivision);
	}

	@Then("User clicks on add of use and add address button")
	public void User_Clicks_on_Add_of_Use_and_Add_Address_Button() throws InterruptedException {
		Thread.sleep(3000);
		common_func.getAreftext("Add Address").click();
	}

	@And("User provides details of add of use {string} {string} {string}")
	public void User_Provides_DetailsAdd(String add, String zip, String phone) {
		common_func.getWebElement(acc.addressLine1AddOfUse).sendKeys(add);
		common_func.getWebElement(acc.zipCodeAddOfUse).sendKeys(zip);
		common_func.getWebElement(acc.PhoneaddofUse).sendKeys(phone);
	}

	@Then("User clicks on save button of add of use")
	public void User_Clicks_on_Save_Button_of_Add_Of_Use() throws InterruptedException {
		Thread.sleep(5000);
		top.ScrollsBy300();
		common_func.ClickOnLink(acc.Save);
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.SaveAll);
		Thread.sleep(15000);
	}

	@Then("User clicks on resend email")
	public void User_Clicks_on_Resend_Email() {
		common_func.ClickOnLink(acc.ResendEmail);
	}

	@Then("User clicks on row and resend")
	public void User_Clicks_on_Row_and_Resend() throws InterruptedException {
		Thread.sleep(10000);
		common_func.getWebElement(acc.searchaccount).sendKeys(AccName1 + Keys.ENTER);
		Thread.sleep(5000);
		//common_func.ClickOnLink(acc.ColumnArrow);
		mgmnt.Arrow1.click();
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.resend);
		//common_func.getAreftext("Resend").click();
	}

	@And("User verifies resend page {string}")
	public void User_Verifies_Resend_Page(String page) {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains(page));
		Assert.assertEquals(driver.getTitle(), page, "error");
	}

	@And("User verifies account page {string}")
	public void User_Verifies_Acc_Page(String page) throws InterruptedException {
		foot.WindowHandler();
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains(page));
		Assert.assertEquals(driver.getTitle(), page, "error");
	}

	@Then("User clicks on click here")
	public void User_Clicks_on_Click_Here() {
		top.ScrollsBy300();
		driver.switchTo().frame(0);
		common_func.getWebElement(acc.Clickhere).click();
	}

	@And("User inserts the details {string} {string} {string} {string}")
	public void User_Verifies_Resend_Page(String Fname, String Lname, String job, String password)
			throws InterruptedException {
		common_func.getWebElement(acc.Firstname).sendKeys(Fname);
		common_func.getWebElement(acc.Lastname).sendKeys(Lname);
		common_func.getWebElement(acc.JobTitle).click();
		Thread.sleep(3000);
		common_func.getWebElement(acc.JobTitle).sendKeys(job + Keys.ENTER);
		common_func.getWebElement(acc.Password).sendKeys(password);
		common_func.getWebElement(acc.ConfirmPassword).sendKeys(password);
		Thread.sleep(5000);
		acc.ContSave.click();
		Thread.sleep(5000);
		acc.ContSave.click();
	}

	@Then("User clicks on agreement")
	public void User_ClicksOn_Agreement() throws InterruptedException {
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.agreement1);
		Thread.sleep(5000);
		common_func.ClickOnLink(acc.createAcc);
		Thread.sleep(15000);
	}

	// NetTerms
	@Then("User clicks on request net terms and save button")
	public void User_Clicks_on_Request_Net_Terms_and_Save_Button() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(acc.RequestNetTermBtn()));
		common_func.ClickOnLink(acc.RequestNetTermbtn);
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(acc.GetRequestNetTermSaveNContinueBtn()));
		common_func.ClickOnLink(acc.RequestNetTermSaveNContinueBtn);
		Thread.sleep(5000);
		Thread.sleep(15000);
	}

	@Then("User navigates to management portal {string}")
	public void User_Navigates_to_Management_Portal(String string) throws IOException {
		String User_role_url = yamlData.getDataYML(urlFileName, string, "management");
		driver.get(User_role_url);
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Login - CCM"));
	}	

	// Abcallscreditcard
	@Then("User verifies presence of billing method and pass {string}")
	public void User_Verifies_Presence_of_Billing_Method_and_Pass(String string) throws InterruptedException {
		common_func.ClickOnLink(acc.SalesDivisionExpansion);
		Thread.sleep(5000);
		acc.BillingMethod.isDisplayed();
		Select search = new Select(common_func.getWebElement(acc.BillingMethod));
		search.selectByValue(string);
	}

	@Then("User clicks on customer edit save button")
	public void User_Clicks_on_Customeredit_Save_Button() throws InterruptedException {
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(acc.GetMgtCustomersEditSave()));
		common_func.ClickOnLink(acc.MgtCustomersEditSave);
	}

	@Then("User pass {string} to get account")
	public void Pass_to_Get_Account(String string) {
		if (acc.getAccountAB.isEnabled()) {
			common_func.ClickOnLink(acc.getAccountAB);
			acc.getAccountAB.clear();
			acc.getAccountAB.sendKeys("12345");
		}
	}

	@Then("User refreshes the page and wait for account to be clickable")
	public void Refreshes_the_Page() {
		acc.getRefreshAccount();
	}

	@Then("User clicks on customer edit and get management edit customer")
	public void User_Clicks_on_Customer_Edit_and_Get_Management_Edit_Customer() throws InterruptedException {
		common_func.ClickOnLink(acc.CustomersEditPane);
		common_func.ClickOnLink(acc.MgtCustomersEdit);
		Thread.sleep(9000);
	}

	// withCreditCardsapproved
	@Then("User fetches account name")
	public void User_Fetches_Account_Name() {
		String a = acc.AccountName.getText();
		System.out.println(a);
	}

	@Then("User clicks on request tab")
	public void User_Clicks_on_Request_Tab() throws InterruptedException {
		Thread.sleep(7000);
		common_func.ClickOnLink(acc.RequestsNavigation);
	}

	@Then("User is taken to request page {string}")
	public void User_is_Taken_to_Request_Page(String page) {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains(page));
		Assert.assertEquals(driver.getTitle(), page, "error");
	}

	@Then("User filters out the pending accounts")
	public void User_Filters_Out_the_Pending_Accounts() throws InterruptedException {
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.Status);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.PendingStatus);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.ApplyStatus);
		Thread.sleep(3000);
	}
	@Then("User filters out the new account created")
	public void User_Filters_Out_the_new_Accounts() throws InterruptedException {
		acc.accName.sendKeys(AccName+Keys.ENTER);
		Thread.sleep(3000);
	}
	@Then("User verifies the new account on management portal")
	public void User_Filters_Out_the_new_Accounts1() throws InterruptedException {
		acc.accName1.sendKeys(AccName+Keys.ENTER);
		Thread.sleep(3000);
		if(acc.accNameVerify.getText().contentEquals(AccName))
		{
			System.out.println("verified");
		}}
	@Then("User filters out specific date and clicks on apply button")
	public void User_Filters_Out_Specific_Date_and_Clicks_on_Apply_Button() throws InterruptedException {
		common_func.ClickOnLink(acc.RequestedDate);
		acc.DateFilter.isDisplayed();
		Select se3 = new Select(acc.DateFilter);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterFrom.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(7);
		acc.DateFilterTo.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(7);
		// wait.until(ExpectedConditions.elementToBeClickable(acc.getDateFilterApply()));
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}

	@Then("User clicks on arrow and clicks on request approve")
	public void User_Clicks_on_Arrow_and_Clicks_on_Request_Approve() throws InterruptedException {
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.CustomersEditPane);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.NettermApproveRequest);
		Thread.sleep(6000);
		common_func.clickOnButton("Approve");
	}
	@Then("User clicks on arrow and clicks on request approve and enters {string} number")
	public void User_Clicks_on_Arrow_and_Clicks_on_Request_Approve1(String AB) throws InterruptedException {
		common_func.ClickOnLink(acc.CustomersEditPane);
		Thread.sleep(3000);
		common_func.ClickOnLink(acc.NettermApproveRequest);
		Thread.sleep(3000);
		acc.AbApproveRequest.sendKeys(AB);
		common_func.clickOnButton("Approve");
		Thread.sleep(3000);
	}
	@Then("User switches from current window to old window")
	public void User_SwitcheFrom_Currentwindow() throws InterruptedException {
		driver.switchTo().window(tabs.get(0));
	}

	@Then("User closes current window")
	public void User_Switches_to_Old_Tab() throws InterruptedException {
		driver.close();
	}

	// nettermsapproved
	@When("User clicks on fullfilment tab")
	public void User_Clicks_OnFullfilment() throws InterruptedException {
	//	driver.switchTo().window(tabs.get(0));
		//Thread.sleep(6000);
		common_func.ClickOnLink(acc.Fullfilment);
	}

	@Then("User clicks on aref first Get it now button")
	public void User_Clickson_First_GetitNow() throws InterruptedException {
		common_func.ClickOnLink(footer.Firstgetitnow);
		Thread.sleep(6000);
	}

	@Then("User clicks on account tab")
	public void User_Clicks_on_AccountTab() throws InterruptedException {
		common_func.Scrolls();
		common_func.ClickOnLink(acc.account);
	}
	//fullfilment

	@Then("User seacrhes the current order placed")
	public void user_seacrhes_the_current_order_placed() throws InterruptedException {
		acc.FullCompany.sendKeys("Muhammad"+Keys.ENTER);
		Thread.sleep(5000);
		//acc.FullProvider.sendKeys("Microsoft"+Keys.ENTER);
		//Thread.sleep(5000);
	}

	@Then("verifies the state and status of the order")
	public void verifies_the_state_and_status_of_the_order() throws InterruptedException {
		Thread.sleep(5000);
	//  String state=acc.fullState.getText();
	 String status= acc.fullStatus.getText();
	// System.out.println(state);
	 System.out.println(status);
	}

	//import
		@And("User clicks on import button")
		public void User_Clicks_on_Import() throws InterruptedException, IOException {
			common_func.getAreftext("Import").click();
		}String accountName;
		@And("User writes in excel sheet")
		public void User_WritesOnExcelSheet() throws InterruptedException, IOException {
			try {
	            String filePath = "C:\\\\\\\\Users\\\\\\\\Horizon\\\\\\\\Downloads\\\\\\\\QA Import File.csv";
	           // String lastId = acc.readLastId();
	           // String newId = acc.generateNextId(lastId);
	           accountName="import"+i;
	            String data = accountName +"@arpatech.com,"+accountName+","+" ,"+" ,"+"72413bf4-3056-4b6f-9a2d-e6be8cbd8fx1"+i+","+accountName+","+accountName+","+"9862659,43c4dfcb-f397-45d7-9d57-e00dbecaa605,1,2,9,BSG,Test,Manager,mark.detscher@connection.com,,,,Arpatech,1020 BRIGGS RD,STE 110,78054,MOUNT LAUREL,TX,,1234,1020 BRIGGS RD,STE 110,78054,MOUNT LAUREL,TX,,,13656316,1020 BRIGGS RD,STE 110,68054,MOUNT LAUREL,TX,,,9862659"; // Modify data format as needed
	           acc. writeCSVFile(filePath, data);
	           // acc.updateLastId(newId);
	            System.out.println("Data written to CSV file successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
		@Then("User selects vendors")
		public void User_Selects_Vendors() throws InterruptedException {
			Select se1 = new Select(acc.vendors);
			Thread.sleep(3000);
			se1.selectByIndex(2);
		}
		@Then("User selects file to import")
		public void User_Selects_File() throws InterruptedException, AWTException {
			acc.Browse.click();
			StringSelection ss = new StringSelection("C:\\Users\\Horizon\\Downloads\\QA Import File.csv");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Thread.sleep(4000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		}
		@And("User clicks on import file")
		public void User_Clicks_Import() throws InterruptedException {
			common_func.clickOnButton("Import Accounts");
			Thread.sleep(5000);
			acc.cancelImport.click();
		}
		@Then("User confirms the creation of new account")
		public void User_Confirms_accCreation() throws InterruptedException {
			Thread.sleep(2000);
			acc.AccCompanyName.sendKeys(accountName+Keys.ENTER);
			Thread.sleep(5000);
			System.out.println(accountName);
			acc.verifyAccCompanyName.getText().contentEquals("Arpatech - "+accountName);
		}
	
}