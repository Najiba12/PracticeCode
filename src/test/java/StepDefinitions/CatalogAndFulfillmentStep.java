package StepDefinitions;

import Utilities.basePage;

import java.util.Random;

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

import org.testng.Assert;

import Pages.AccountCreationPage;
import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.ManagementPage;
import Pages.PDPPage;
import Pages.TopLinksPages;
import Pages.Utility;
import Utilities.YmlUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogAndFulfillmentStep {
	//LoginPage loginPage = new LoginPage();
	//FooterLoginPage foot = new FooterLoginPage();
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
//	footerPage footer = new footerPage();
//	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	public WebDriverWait wait;
	String question = "Can we check the status of order from fulfillment tab?";
	String Answer = "Yes";
	Random rm = new Random();
	int i = rm.nextInt(100) + 1;
	ManagementPage mgmnt = new ManagementPage();
	AccountCreationPage acc = new AccountCreationPage();

	// ResenDemail
	@And("User verifies the list of notifications are present")
	public void User_checks_Presence_Notifications() {
		mgmnt.TypeNotificaton.isDisplayed();
		mgmnt.Recepient.isDisplayed();
	}

	@Then("User downloads the file")
	public void User_Downloads_File() throws Exception {
		common_func.clickOnButton("Export Report");
		Thread.sleep(5000);
	}

	// sendemails
	
	@Then("User clicks on send email")
	public void User_Clicks_SendEmails() throws Exception {
		mgmnt.SendEmails.click();
		Thread.sleep(5000);
	}
	@Then("User filters out current date and presses on apply button")
	public void User_Filters_Out_CurrentDate() throws InterruptedException {
		acc.DateFilterResend.isDisplayed();
		Select se3 = new Select(acc.DateFilterResend);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterFromResend.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		acc.DateFilterToResend.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}
	@And("User verifies all the elements")
	public void User_checks_Presence_Element() {
		mgmnt.Organisation.isDisplayed();
		mgmnt.Account.isDisplayed();
		mgmnt.Subject.isDisplayed();
		mgmnt.mailTo.isDisplayed();
		mgmnt.EditContent.isDisplayed();
		common_func.Scrolls();
		mgmnt.Send.isDisplayed();
		System.out.println("All Elements are present");
	}

	@Then("User successfully sends email")
	public void User_SendEmails_Successfully() throws Exception {
		Thread.sleep(5000);
		String email = mgmnt.EmailSuccessful.getText();
		System.out.println(email);
	}

	// send bulk emails (Steps are also present in customerManagementstep)
	@And("User Verifies the presence of elements on send bulk emails")
	public void User_Verifies_Presence_Element() {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (common_func.getAreftext("Select All").isDisplayed()) {
			System.out.println("Select All button is present");
		}
	}

	// addons
	@When("User clicks on addons tab")
	public void User_ClicksOn_AddonsTab() throws Exception {
		mgmnt.Addons.click();
	}

	@And("User verifies the presence of addons elements")
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

	@And("User unselects all the fields and choose fields to display")
	public void User_Choose_Fields() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.AddonType.click();
		mgmnt.LastSync.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on addons page")
	public void User_Verifies_Addon_Field() throws Exception {
		if (common_func.getLabelText("Last Sync").isDisplayed()) {
			System.out.println(" Last Sync is displayed");
		}
		if (common_func.getLabelText("Addon Type").isDisplayed()) {
			System.out.println("Addons type is displayed");
		}
		Thread.sleep(8000);
	}

	@Then("User resets all")
	public void User_ResetsAll() throws Exception {
		Thread.sleep(5000);
		mgmnt.selectall.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	// services
	@When("User clicks on sync button on service page")
	public void User_ClicksOn_Sync_ButtonService() throws InterruptedException {
		common_func.ClickOnLink(mgmnt.SyncBtn);
		Thread.sleep(10000);
		common_func.ClickOnLink(mgmnt.SyncCloseService);
		Thread.sleep(5000);
	}

	// failToSyn
	@And("User unselects all the fields and choose fields to display on fail to sync page")
	public void User_Choose_Fields1() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.ProductStatus.click();
		mgmnt.Provideid.click();
		mgmnt.LastSync.click();
		mgmnt.EULA.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on fail to sync page")
	public void User_Verifies_Field1() throws Exception {
		if (common_func.getLabelText("Last Sync").isDisplayed()) {
			System.out.println(" Last Sync is displayed");
		}
		if (common_func.getLabelText("Product Status").isDisplayed()) {
			System.out.println("product status is displayed");
		}
		if (common_func.getLabelText("EULA Required").isDisplayed()) {
			System.out.println("EULA Required is displayed");
		}
		if (common_func.getLabelText("Provider Product...").isDisplayed()) {
			System.out.println("Provider Product ID is displayed");
		}
		Thread.sleep(15000);
	}

	@When("User clicks on fail to sync tab")
	public void User_ClicksOn_ServiceTab() throws Exception {
		Thread.sleep(5000);
		mgmnt.FailToSyn.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of buttons")
	public void User_Verifies_Elements() throws Exception {
		mgmnt.SelectFieldBtn.isDisplayed();
		top.export.isDisplayed();
		String Detail = mgmnt.failtoSyncDetail.getText();
		System.out.println(Detail);
	}

	// order
	@Then("User verifies the presence of buttons and links")
	public void Order_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		if (mgmnt.SyncBtn.isDisplayed()) {
			System.out.println("Sync button is present");
		}
		if (common_func.getLabelText("Order ID").isDisplayed()) {
			System.out.println("Order ID is available");
		}
		String Detail = mgmnt.OrderDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on order page")
	public void User_Choose_Fields_OnOrder_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.Orderedby.click();
		mgmnt.OrderNum.click();
		mgmnt.OrderType.click();
		mgmnt.Tax.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on order page")
	public void User_Verifies_Field_OnOrder_Page() throws Exception {
		if (common_func.getLabelText("Ordered By").isDisplayed()) {
			System.out.println(" Ordered By is displayed");
		}
		if (common_func.getLabelText("Tax").isDisplayed()) {
			System.out.println("Tax is displayed");
		}
		if (common_func.getLabelText("Order Type").isDisplayed()) {
			System.out.println("Order Type is displayed");
		}
		if (common_func.getLabelText("Order Number").isDisplayed()) {
			System.out.println("Order Number is displayed");
		}
		Thread.sleep(10000);
	}

	@Then("User passes {string} to status column and clicks on first option")
	public void Order_Filters(String value) throws Exception {
		Thread.sleep(8000);
		//mgmnt.status.sendKeys(value + Keys.ENTER);
		//Thread.sleep(8000);
		mgmnt.FirstOrder.click();
		//mgmnt.EditOrderStatus.click();
		common_func.getAreftext("Edit Order Status").click();
		Thread.sleep(5000);
	}

	@Then("User clicks on first order and selects manage order and view order details")
	public void ManageOrder() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("Manage Notes").click();
		Thread.sleep(5000);
		mgmnt.CancelManageNotes.click();
		Thread.sleep(5000);
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Order Details").click();
		Thread.sleep(5000);
	}

	@And("User changes the status of order from pending to cancelled")
	public void User_Chnacges_Status() throws Exception {
		Thread.sleep(8000);
		Select drpCountry = new Select(mgmnt.ChangeStatus);
		drpCountry.selectByVisibleText("Cancelled");
		mgmnt.OrderSave.click();
		Thread.sleep(5000);
		if (mgmnt.OrderAlert.isDisplayed()) {
			mgmnt.OrderSave.click();
			Thread.sleep(9000);
		}
		// tenant
	}

	@Then("User verifies the presence of buttons and links and tenant detail")
	public void Tenant_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.TenantDetail.getText();
		System.out.println(Detail);
	}

	@Then("User clicks on manage notes")
	public void User_Clicks_On_ManageNotes() throws Exception {
		mgmnt.FirstOrder.click();
		// mgmnt.ManageNotes.click();
		common_func.getAreftext("Manage Notes").click();
		Thread.sleep(5000);
		mgmnt.CancelManageNotes.click();
	}

	@And("User clicks on add of use on tenant page")
	public void User_Clicks_On_AddOfUse_Tenant_Page() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("Address Of Use").click();
		common_func.getWebElement(mgmnt.CloseAdd).click();
	}

	@Then("User clicks on update tenant")
	public void User_Clicks_On_UpdateTenant() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("Update Tenant").click();
	}

	@When("User clicks on tenant tab")
	public void User_ClicksON_Tenant() throws Exception {
		mgmnt.Tenant.click();
	}

	@And("User unselects all the fields and choose fields to display on tenant page")
	public void User_Choose_Fields_OnTenant_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.TenantID.click();
		mgmnt.TenantName.click();
		mgmnt.UpdatedBy.click();
		mgmnt.AccountName.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on tenant page")
	public void User_Verifies_Field_Ontenant_Page() throws Exception {
		if (common_func.getLabelText("Tenant ID").isDisplayed()) {
			System.out.println(" Tenant ID is displayed");
		}
		if (common_func.getLabelText("Tenant Name").isDisplayed()) {
			System.out.println("Tenant Name is displayed");
		}
		if (common_func.getLabelText("Updated By").isDisplayed()) {
			System.out.println("Updated By is displayed");
		}
		if (common_func.getLabelText("Account Name").isDisplayed()) {
			System.out.println("Account Name is displayed");
		}
		Thread.sleep(10000);
	}

	@Then("User clicks on view latest providers errors log on tenant page")
	public void user_clicks_on_Viewlatest_providerlogs() throws InterruptedException {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Latest Providers Errors Log").click();
	}

	// orderDetail
	@When("User clicks on order detail tab")
	public void User_ClicksON_Orders() throws Exception {
		mgmnt.OrdersDetail.click();
	}

	@Then("User verifies the presence of buttons and links and order detail text")
	public void OrderDetails_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.OrdersDetailtext.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on order detail page")
	public void User_Choose_Fields_OnOrderDetail_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.Seat.click();
		mgmnt.ServiceName.click();
		mgmnt.ServiceID.click();
		mgmnt.AccountID.click();
		mgmnt.Provider.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on order detail page")
	public void User_Verifies_Field_OnOrderDetail_Page() throws Exception {
		if (common_func.getLabelText("Service ID").isDisplayed()) {
			System.out.println(" Service ID is displayed");
		}
		if (common_func.getLabelText("Service Name").isDisplayed()) {
			System.out.println("Service Name is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("Seats").isDisplayed()) {
			System.out.println("Seats is displayed");
		}
		if (common_func.getLabelText("Provider").isDisplayed()) {
			System.out.println("Provider is displayed");
		}
		Thread.sleep(10000);
	}

	@Then("User clicks on view order")
	public void View_Order() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Order").click();
	}
	@Then("User selects {string} of seats and price and apply {int}")
	public void Selects_Seats_Price(String num,int i) throws Exception {
		Thread.sleep(4000);
		mgmnt.SeatsFrom.sendKeys(num);
		mgmnt.SeatsTo.sendKeys(num);
		mgmnt.Apply(i);
	}
	@Then("User verifies the information {string} appeared on column {int}")
	public void User_Verifies_Information(String num,int colnum) throws InterruptedException {
		Thread.sleep(4000);
		mgmnt.Verify(num, colnum);
	}
	// user
	@When("User clicks on fulfillment user tab")
	public void User_ClicksON_User() throws Exception {
		mgmnt.User.click();
	}

	@Then("User clicks on View Tenant option")
	public void User_Clicks_on_View_Tenant_Menu() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Tenant").click();
	}

	@Then("User verifies the presence of buttons and links and user text")
	public void Users_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on user page")
	public void User_Choose_Fields_OnUser_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.FirstName.click();
		mgmnt.LastName.click();
		mgmnt.CreatedAt.click();
		mgmnt.UpdatedAt.click();
		mgmnt.AccountID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on user page")
	public void User_Verifies_Field_OnUser_Page() throws Exception {
		if (common_func.getLabelText("Created At").isDisplayed()) {
			System.out.println(" Created At is displayed");
		}
		if (common_func.getLabelText("Updated At").isDisplayed()) {
			System.out.println("Updated At is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("First Name").isDisplayed()) {
			System.out.println("First Name is displayed");
		}
		if (common_func.getLabelText("Last Name").isDisplayed()) {
			System.out.println("Last Name is displayed");
		}
		Thread.sleep(8000);
	}

	// Usage
	@When("User clicks on fulfillment usage tab")
	public void User_ClicksON_Usage() throws Exception {
		mgmnt.Usage.click();
	}

	@Then("User verifies the presence of buttons and links and usage text")
	public void Usage_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UsageDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on usage page")
	public void User_Choose_Fields_OnUsage_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.Metering.click();
		mgmnt.SubscriptionID.click();
		mgmnt.LastUpdated.click();
		mgmnt.TenantID.click();
		mgmnt.AccountID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on usage page")
	public void User_Verifies_Field_OnUsage_Page() throws Exception {
		if (common_func.getLabelText("Metering").isDisplayed()) {
			System.out.println(" Metering is displayed");
		}
		if (common_func.getLabelText("Last Updated").isDisplayed()) {
			System.out.println("Last Updated is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("Subscription ID").isDisplayed()) {
			System.out.println("Subscription ID is displayed");
		}
		if (common_func.getLabelText("Tenant ID").isDisplayed()) {
			System.out.println("Tenant ID is displayed");
		}
		Thread.sleep(8000);
	}

	// Invoice
	@When("User clicks on fulfillment invoice tab")
	public void User_ClicksON_Invoice() throws Exception {
		mgmnt.Invoices.click();
	}

	@Then("User clicks on view invoices details")
	public void User_Clicks_on_InvoiceDetails_Menu() throws Exception {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Invoice Details").click();
	}

	@Then("User verifies the presence of buttons and links and invoice text")
	public void Invoice_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.InvoicesDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on invoice page")
	public void User_Choose_Fields_OnInvoice_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.DueDate.click();
		mgmnt.ShippingAddress.click();
		mgmnt.BillingMonth.click();
		mgmnt.InvoiceNumber.click();
		mgmnt.AccountID.click();
		mgmnt.AccountName.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on invoice page")
	public void User_Verifies_Field_OnInvoice_Page() throws Exception {
		if (common_func.getLabelText("Due Date").isDisplayed()) {
			System.out.println("Due Date is displayed");
		}
		if (common_func.getLabelText("Shipping Address").isDisplayed()) {
			System.out.println("Shipping Address is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("Billing Month").isDisplayed()) {
			System.out.println("BillingMonth is displayed");
		}
		if (common_func.getLabelText("Invoice Number").isDisplayed()) {
			System.out.println("Invoice Number is displayed");
		}
		if (common_func.getLabelText("Account Name").isDisplayed()) {
			System.out.println("Account Name is displayed");
		}
		Thread.sleep(10000);
	}

	// InvoiceDetails
	@When("User clicks on fulfillment invoice details tab")
	public void User_ClicksON_InvoiceDetail() throws Exception {
		mgmnt.InvoiceDetails.click();
	}

	@Then("User clicks on view invoices")
	public void InvoiceDetails_Invoices() throws Exception {
		mgmnt.FirstOrder.click();
		mgmnt.ViewInvoice.click();
	}

	@Then("User clicks on view usages")
	public void InvoiceDetails_Usage() throws Exception {
		mgmnt.FirstOrder.click();
		mgmnt.ViewUsage.click();
	}

	@Then("User verifies the presence of buttons and links and invoice details text")
	public void InvoiceDetails_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on invoice details page")
	public void User_Choose_Fields_OnInvoiceDetail_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.StartDate.click();
		mgmnt.EndDate.click();
		mgmnt.BillingCycle.click();
		mgmnt.AccountName.click();
		mgmnt.AccountID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on invoice details page")
	public void User_Verifies_Field_OnInvoiceDetails_Page() throws Exception {
		if (common_func.getLabelText("Start Date").isDisplayed()) {
			System.out.println("Start Date is displayed");
		}
		if (common_func.getLabelText("End Date").isDisplayed()) {
			System.out.println("End Date is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("Account Name").isDisplayed()) {
			System.out.println("Account Name is displayed");
		}
		if (common_func.getLabelText("Billing Cycle").isDisplayed()) {
			System.out.println("Billing Cycle is displayed");
		}
		Thread.sleep(10000);
	}
	@Then("User selects today from filter and apply")
	public void User_Filters_Out_today() throws InterruptedException {
		acc.DateFilterInvoice.isDisplayed();
		Select se3 = new Select(acc.DateFilterInvoice);
		Thread.sleep(3000);
		se3.selectByVisibleText("Today");
		acc.DateFilterInvoiceFrom.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		acc.DateFilterInvoiceTo.isDisplayed();
		Thread.sleep(3000);
		se3.selectByIndex(1);
		common_func.ClickOnLink(acc.DateFilterApply);
		Thread.sleep(7000);
	}

	// AccountOnHold
	@When("User clicks on fulfillment account on hold tab")
	public void User_ClicksON_AccountsOnHold() throws Exception {
		mgmnt.AccountOnHold.click();
	}

	@Then("User verifies the presence of buttons and links and account on hold text")
	public void AccountsOnHold_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on account on hold page")
	public void User_Choose_Fields_OnAccountOnHold_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		Thread.sleep(5000);
		mgmnt.Tax.click();
		mgmnt.PaymentMethod.click();
		mgmnt.Orderedby.click();
		mgmnt.AccountID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on account on hold page")
	public void User_Verifies_Field_OnAccountOnHold_Page() throws Exception {
		if (common_func.getLabelText("Tax").isDisplayed()) {
			System.out.println("Tax is displayed");
		}
		if (common_func.getLabelText("Payment Method").isDisplayed()) {
			System.out.println("Payment Method is displayed");
		}
		if (common_func.getLabelText("Account ID").isDisplayed()) {
			System.out.println("Account ID is displayed");
		}
		if (common_func.getLabelText("Ordered By").isDisplayed()) {
			System.out.println("Ordered By is displayed");
		}
		Thread.sleep(8000);
	}

}
