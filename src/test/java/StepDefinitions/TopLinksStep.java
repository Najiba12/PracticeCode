package StepDefinitions;

import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.PDPPage;
import Pages.Utility;
import Pages.commonFunctions;
import Pages.footerPage;
import Pages.TopLinksPages;

public class TopLinksStep extends basePage {
	public WebDriver driver;
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
	public WebDriverWait wait;
	footerPage footer = new footerPage();
	PDPPage pdp = new PDPPage();

	@When("User clicks on Discover link")
	public void Click_Discover_link() throws Exception {
		common_func.ClickOnLink(top.Discover1);
	}

	@Then("User verifes the page elements")
	public void User_Verifies_Page_Element_is_Visible() {
		top.ExpectedUserLink.isDisplayed();
		top.DescribeYourBusiness.isDisplayed();
		top.ContinueBtn.isDisplayed();
		top.RightBoxleftMenu.isDisplayed();
		top.DescribeYourNeed.isDisplayed();
	}

	@Then("User passes {string} and press continue button")
	public void Verify_Setting_Page_Elements(String value) throws Exception {
		Thread.sleep(5000);
		common_func.getWebElement(top.ExpectedUserLink).sendKeys(value);
		common_func.Scrolls();
		common_func.ClickOnLink(top.ContinueBtn);
	}

	@And("User selects two checboxes and press continue")
	public void Selects_Options() throws Exception {
		common_func.ClickOnLink(top.Chkbox1);
		common_func.ClickOnLink(top.Chkbox2);
		Thread.sleep(5000);
		common_func.Scrolls();
		common_func.ClickOnLink(top.ContinueBtn1);
	}

	@And("User again selects two checkboxes and press continue")
	public void SelectsOptionsAgain() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.Chkbox11);
		common_func.ClickOnLink(top.Chkbox22);
		common_func.Scrolls();
		common_func.ClickOnLink(top.ContinueBtn1);
	}

	@And("User clicks on edit and clicks on continue")
	public void Clicks_On_Edit() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.edit);
		common_func.Scrolls();
		common_func.ClickOnLink(top.ContinueBtn1);
	}

	@And("User selects {string} and clicks on save button")
	public void Selects_Monthly_Option(String option) throws Exception {
		Select Se = new Select(common_func.getWebElement(top.btype));
		common_func.Scrolls();
		Se.selectByValue(option);
		common_func.ClickOnLink(top.savecont);
	}

	@Then("User clicks on request button")
	public void ClicksOn_Req_Button() throws Exception {
		common_func.Scrolls();
		common_func.ClickOnLink(top.reqpurpoe);
	}

	@And("User passes {string} & clicks on request pruposal")
	public void Pass_Values(String value1) throws Exception {
		common_func.ClickOnLink(top.reqpurpbtn);
		common_func.getWebElement(top.textarea).sendKeys(value1);
		common_func.ClickOnLink(top.btnprimaryreqpurposal);
		Thread.sleep(5000);
	}

//Discover2
	@And("User selects first two checboxes and press continue")
	public void Selects_Checkboxes() throws Exception {
		common_func.ClickOnLink(top.Chkbox111);
		common_func.ClickOnLink(top.Chkbox222);
		common_func.Scrolls();
		common_func.ClickOnLink(top.ContinueBtn1);
	}

	@Then("User passes {string} & {string} & {string}")
	public void Select_Values_From_Discover_Page(String value, String value2, String value3) throws Exception {
		Select Se1 = new Select(common_func.getWebElement(top.instance));
		Se1.selectByValue("Reserved Instance");
		Select Se3 = new Select(common_func.getWebElement(top.duration));
		Se3.selectByValue("2 Years");
		common_func.getWebElement(top.LoadBalance).sendKeys("2");
	}

	@Then("User clicks on Showers")
	public void ClicksOn_Get_Show_Result() throws Exception {
		common_func.Scrolls();
		Thread.sleep(20000);
		common_func.ClickOnLink(top.showres);
	}

	// application
	@When("User clicks on Application tab")
	public void Click_OnApp_link() throws Exception {
		common_func.ClickOnLink(top.Application_Link);
	}

	@Then("User verifies the page elements of app")
	public void User_Page_Element_App_Visible() throws InterruptedException {
		common_func.getWebElement(top.banner).isDisplayed();
		common_func.getWebElement(top.SortBy).isDisplayed();
		common_func.getWebElement(top.BarShadow).isDisplayed();
		common_func.getWebElement(top.Pagination).isDisplayed();
		common_func.getWebElement(top.Grid).isDisplayed();
		common_func.getWebElement(top.List).isDisplayed();
		common_func.getWebElement(top.ProductListMenu).isDisplayed();
		common_func.getWebElement(top.Selections).isDisplayed();
		common_func.getWebElement(top.RefineBy).isDisplayed();
		common_func.getWebElement(top.ProductListContent).isDisplayed();
		common_func.getWebElement(top.ProductListItem).isDisplayed();
		common_func.getWebElement(top.PaginationList).isDisplayed();
	}

	@Then("User counts the number of manage and getnow and print them")
	public void Counts() throws Exception {
		int getnow = top.getcountgetnow();
		int mange = top.getCountManage();
		System.out.println("mange" + mange);
		System.out.println("getnow" + getnow);
	}

//appsidelink
	@Then("User clicks on analytic check")
	public void User_ClicksOn_Analytic_Check() throws InterruptedException {
		top.ScrollsBy300();
		common_func.ClickOnLink(top.AnalyticsCheck);
		common_func.ClickOnLink(top.Apply);
		Thread.sleep(5000);
	}

	@Then("User checks application is found")
	public void User_Checks_App_Found() {
		top.getAppSelected();
	}

	// infrastructure
	@When("User clicks on infrastructure from home page")
	public void Click_On_Infra_Link() throws Exception {
		common_func.ClickOnLink(top.Infrastructure_Link);
	}

	@Then("User verifies the elements of page")
	public void User_Page_Element_Visible() throws InterruptedException {
		common_func.getWebElement(top.banner).isDisplayed();
		common_func.getWebElement(top.SortBy).isDisplayed();
		common_func.getWebElement(top.BarShadow).isDisplayed();
		common_func.getWebElement(top.Pagination).isDisplayed();
		common_func.getWebElement(top.Grid).isDisplayed();
		common_func.getWebElement(top.List).isDisplayed();
		common_func.getWebElement(top.ProductListMenu).isDisplayed();
		common_func.getWebElement(top.Selections).isDisplayed();
		common_func.getWebElement(top.ProductListContent).isDisplayed();
	}

	// infrasidelinks
	@Then("User clears icon")
	public void User_Clickson_Clear_Icon() {
		top.checksHeading();
		common_func.ClickOnLink(top.ClearIcon);
	}

	@Then("User clicks on IaaS")
	public void User_ClicksOn_Iaas() throws InterruptedException {
		common_func.Scrolls();
		Thread.sleep(5000);
		common_func.ClickOnLink(top.IaasText);
		common_func.ClickOnLink(top.accMenu4);
	}

//infraselected
	@Then("User clicks on industry type business")
	public void User_ClicksOn_Industry_Type_Business() throws InterruptedException {
		top.ScrollsBy300();
		Thread.sleep(10000);
		common_func.ClickOnLink(top.IndustryTypeBusiness);
		common_func.ClickOnLink(top.accMenu2);
		Thread.sleep(5000);
	}

//platform
	@When("User clicks on Platform from home page")
	public void Click_Platform_Link() throws Exception {
		common_func.ClickOnLink(top.Platform_Link);
	}

//platformselected
	@Then("User verifies category and clears icon")
	public void User_Verifies_Category() throws InterruptedException {
		top.getAppSelected();
		common_func.ClickOnLink(top.ClearIcon);
		Thread.sleep(5000);
	}

//procurementprocess
	@Then("User clears icon of procurement")
	public void User_ClicksOn_Clear_Icon1() {
		common_func.ClickOnLink(top.ClearIcon);
	}

	@Then("User checks get it now string")
	public void User_Checks_GetItNow_String() {
		top.checksGetitNow();
	}

	@Then("User clicks on given button")
	public void User_Clickson_GetItNow_Button() throws InterruptedException {
		Thread.sleep(25000);
		common_func.ClickOnLink(top.GetItNowPD);
	}

	@Then("User checks the current url")
	public void User_Checks_Current_URL() throws InterruptedException {
		top.checksCurrentUrl();
	}

	@Then("User checks the current url and validate procuremt {string}")
	public void User_Checks_the_Current_URL_and_Validate_Procuremt(String page) throws InterruptedException {
		top.checksCurrentUrlRedirection(page);
	}
	@Then("User verifies the presence of all elements on procuremnt page")
	public void User_Validate_Procuremt_Page() throws InterruptedException {
		Thread.sleep(5000);
		if(common_func.getSpanText("Tenant Information").isDisplayed()) {
			System.out.println("Tenant Name Information");
		}
		if(top.addofuse.isDisplayed()) {
			System.out.println("Address of Use");
		}
		if(top.payment.isDisplayed()) {
			System.out.println("Payment and Billing");
		}
		if(common_func.getSpanText("Review Order").isDisplayed()) {
			System.out.println("Review Order");
		}
	}

	// manage
	@When("User clicks on Manage tab")
	public void Click_Manage_link() throws Exception {
		common_func.ClickOnLink(footer.Manage);
	}

	@Then("User verifies the presence of Subscription, Usage and Calender links")
	public void Verify_Presence_Of_Sub_Tabs_Page() throws Exception {
		top.Subscription.isDisplayed();
		top.Calendar.isDisplayed();
		top.Usage_Link.isDisplayed();
	}

	// calendar
	@Then("User clicks on calender link")
	public void Click_Calendar_Link() throws Exception {
		common_func.ClickOnLink(top.Calendar);
	}

	@Then("User clicks on subribecal")
	public void Click_On_Subcal() throws Exception {
		common_func.ClickOnLink(top.subscribecal);
		common_func.ClickOnLink(top.close);
		common_func.Scrolls();
	}

	@And("User checks environment {string} and clicks on April Month")
	public void Selects_Months(String env) throws Exception {
		top.checksEnvSelectsMonth(env);
	}

	// spend
	@When("User clicks on Insight link")
	public void Click_Insight_link() throws Exception {
		common_func.ClickOnLink(footer.Insight);

	}

	// insight
	@Then("User clicks on expand and collapse button")
	public void click_OnExpand_Collapse_Button() throws Exception {
		common_func.ClickOnLink(top.expand);
		common_func.ClickOnLink(top.collapse);
	}

	@And("User selects the option from dropdown of Spend category")
	public void Selects_Options_Spend_category() throws Exception {
		top.Category();
	}

	@And("User selects the option from dropdown of Spend provider")
	public void Selects_Options_Spend_Projection() throws Exception {
		top.SpendProvider();
	}

	@And("User selects the option from dropdown of Spend type")
	public void Selects_Options_Spend_Type() throws Exception {
		top.Type();
	}

	@And("User selects the option from dropdown of Spend services")
	public void Selects_Options_Spend_Services() throws Exception {
		top.Service();
	}

	// auditlog
	@Then("User clicks on audit log from report link")
	public void Signed_Agreement() throws Exception {
		common_func.ClickOnLink(top.ReportsTab);
		common_func.ClickOnLink(top.auditlog);
	}

	@Then("User checks reports options are verified")
	public void Report_Options() throws Exception {
		top.ReportsOption();
	}

	@Then("User clicks on export and email button")
	public void Export_Button() throws Exception {
		top.Export();
		top.Email();
		top.ScrollsBy300();
		Thread.sleep(5000);
	}

	@And("User clicks on first column on page")
	public void Selects_First_Col() throws Exception {
		top.ScrollsBy300();
		common_func.ClickOnLink(top.Column1stDropdown);
	}

	@Then("User selects today as time period")
	public void Selects_Time_Period() throws Exception {
		Select Se = new Select(common_func.getWebElement(top.timeperiod));
		Se.selectByIndex(2);
	}

	@And("User selects date from today to today")
	public void Selects_Date() throws Exception {
		Select Se1 = new Select(common_func.getWebElement(top.from));
		Se1.selectByIndex(2);
		Select Se2 = new Select(common_func.getWebElement(top.to));
		Se2.selectByIndex(2);
	}

	@And("User clicks on apply and reset all button")
	public void ClicksOn_Apply_Button() throws Exception {
		common_func.ClickOnLink(top.apply3);
		Thread.sleep(6000);
		common_func.ClickOnLink(top.clearresetall);
	}

	// signedAgreement
	@Then("User clicks on Signed Agreement from report link")
	public void ClicksOn_SignedAgreement() throws Exception {
		common_func.ClickOnLink(top.ReportsTab);
		common_func.ClickOnLink(top.sa);
	}

	@And("User clicks on first column to choose services")
	public void ClicksOn_First_Column() throws Exception {
		top.ScrollsBy300();
		Thread.sleep(5000);
		common_func.ClickOnLink(top.col1stdropdown1);
	}

	@Then("User selects cloud service agreement and clicks on save button")
	public void Selects_CCA() throws Exception {
		common_func.Scrolls();
		Thread.sleep(5000);
		common_func.ClickOnLink(top.APCRow);
		common_func.ClickOnLink(top.applysign);
	}

	@And("User clicks on select field and type {string}")
	public void Select_Field(String field) throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.selectfields);
		common_func.getWebElement(top.searchdisplay).sendKeys(field);
	}

	@Then("User clicks on unselect all and clicks on SKU & apply")
	public void ClicksOn_Unselect_All() throws Exception {
		top.selectSKU();
	}

	@Then("User clicks resetall")
	public void ClicksOn_reset_All() throws Exception {
		common_func.ClickOnLink(top.clearresetall);
	}

	// reportsubscription
	@Then("User clicks on Subscription from report link")
	public void ClicksOn_Subscription() throws Exception {
		common_func.ClickOnLink(top.ReportsTab);
		common_func.ClickOnLink(top.sub);
	}

	@Then("User clicks on apply button")
	public void ClicksOn_Appyly() throws Exception {
		common_func.ClickOnLink(top.applysub);

	}

	// InvoiceDetails
	@Then("User clicks on Invoice Details from report link")
	public void ClicksOn_Invoice_Details() throws Exception {
		common_func.ClickOnLink(top.ReportsTab);
		common_func.ClickOnLink(top.billline);
	}

	@And("User clicks on select field and type subscription {string}")
	public void Select_Field_Subscription(String field) throws Exception {
		Thread.sleep(8000);
		common_func.ClickOnLink(top.selectfields);
		common_func.getWebElement(top.searchdisplay).sendKeys("Subscription Name");
	}

	@Then("User clicks on unselect all and clicks on subscription name & apply")
	public void Select_SubField() throws Exception {
		top.SelectSub();
	}

	// invoices
	@Then("User clicks on Invoices from report link")
	public void Clicks_Invoices() throws Exception {
		common_func.ClickOnLink(top.ReportsTab);
		common_func.ClickOnLink(top.bills);
	}

	@Then("User clicks on unselect all and clicks on billing month & apply")
	public void Select_Billing_Month() throws Exception {
		top.SelectBilling();
	}

	// orders
	@Then("User clicks on Orders from report link")
	public void ClicksOn_Orders() throws Exception {
		top.HoverOnReports();
		common_func.ClickOnLink(top.Orders);
	}

	@Then("User clicks on unselect all and clicks purchase order & apply")
	public void Select_Purchase_Order() throws Exception {
		Thread.sleep(5000);
		top.purchaseOrder();
		Thread.sleep(5000);
	}

	@Then("User clicks on apply bill button")
	public void Click_Apply_Bill() throws Exception {
		common_func.ClickOnLink(top.applybill);
	}

	@And("User clicks on first column from order page")
	public void Select_First_Col_Order() throws Exception {
		top.ScrollsBy300();
		common_func.ClickOnLink(top.Column1stDropdownOrder);
	}

	// provider
	@Then("User clicks on first column")
	public void Click_First_Column() throws Exception {
		common_func.ClickOnLink(top.Column1stDropdown);
		common_func.Scrolls();
	}

	@And("User passes {string} and clicks on filter icon & reset all")
	public void Click_Filter_Icon(String value) throws Exception {
		Thread.sleep(4000);
		common_func.getWebElement(top.billprovidernamesearch).sendKeys(value);
		Thread.sleep(4000);
		common_func.ClickOnLink(top.filtersearchicon);
		Thread.sleep(4000);
	}

	@And("User clicks on selectfield and passes {string} and apply condition")
	public void Enter_Provider(String value) throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.selectfields);
		common_func.getWebElement(top.searchdisplay).sendKeys(value);
		top.ProviderSelected();
	}

	@Then("User clicks on unselect all select provider ID and provider name")
	public void Selects_ProviderId_Name() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.unselectall);
		top.ProviderUnSelected();
	}

	@And("User selects provider ID and Provider Name and save")
	public void Select_Provider() throws Exception {
		common_func.ClickOnLink(top.selectall);
		top.ProviderSelected();
		common_func.ClickOnLink(top.unselectall);
		common_func.ClickOnLink(top.provid);
		common_func.ClickOnLink(top.proviname);
		common_func.ClickOnLink(top.apply);
	}

	// service
	@Then("User clicks on unselect all select provider ID and service name")
	public void Selects_Provider_Id_Name_Service() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.unselectall);
		top.ProviderServiceUnSelected();
	}

	@Then("User clicks on tenent row")
	public void Select_Tenant_Row() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.tenant);
		common_func.ClickOnLink(top.applytenant);
	}

	@And("User selects service name and Provider Name and save")
	public void Select_Provider_Service() throws Exception {
		common_func.ClickOnLink(top.selectall);
		top.ProviderSelected();
		common_func.ClickOnLink(top.unselectall);
		common_func.ClickOnLink(top.proviname);
		common_func.ClickOnLink(top.servename);
		common_func.ClickOnLink(top.apply);
	}

	// spendType
	@Then("User clicks on unselect all select provider name")
	public void Selects_Provider_Name() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.unselectall);
		top.ProviderNameUnSelected();
	}

	@And("User selects Provider Name and save")
	public void Select_Provider_Name() throws Exception {
		common_func.ClickOnLink(top.selectall);
		common_func.ClickOnLink(top.unselectall);
		common_func.ClickOnLink(top.proviname);
		common_func.ClickOnLink(top.apply);
	}

	@Then("User verifies the presence of selected field")
	public void Verify_Field() throws Exception {
		top.checkPresenceSelected();
	}
	@Then("User verifies the presence of provider name and service name")
	public void Verify_Field1() throws Exception {
		top.checkPresenceSelectedField();
	}
	@Then("User verifies the presence provider name")
	public void Verify_Field2() throws Exception {
		Thread.sleep(4000);
		top.show1.isDisplayed();
	}
	@Then("User clicks on reset all")
	public void Reset_All() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(top.selectfields);
		common_func.ClickOnLink(top.selectall);
		common_func.ClickOnLink(top.apply);
		Thread.sleep(4000);
	}

	// subscription
	@Then("User clicks on subscription link")
	public void ClicksOn_Sub_Link() throws Exception {
		common_func.ClickOnLink(top.Subscription);
	}

	@And("User checks the presence of estimate")
	public void Checks_Estimates() throws Exception {
		if (top.estimate.isDisplayed()) {
			System.out.println("expected CTA not present  and expected to not present ");
		} else {
		}
	}

	@Then("User sends {string} to product quality")
	public void Sends_Product_Quantity(String value) throws Exception {
		pdp.prodQty1.clear();
		pdp.prodQty1.sendKeys(Keys.CONTROL);
		pdp.prodQty1.sendKeys(Keys.BACK_SPACE);
		pdp.prodQty1.sendKeys(value);
	}

	@Then("User clicks on Create Estimate and cancels")
	public void clicksOn_Estimates() throws Exception {
		top.getEstimate();
	}

	@Then("User visits provider portal page")
	public void Visits_Provider_Portal() throws Exception {
		common_func.Scrolls();
		top.GotoProviderPortal();
	}

	@Then("User checks if subscription history is present")
	public void Checks_Sub_History() throws Exception {
		top.CheckSubHistory();
	}
}
