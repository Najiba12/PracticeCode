package StepDefinitions;

import Utilities.basePage;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class ReportAndSetupTabSetp {
//	LoginPage loginPage = new LoginPage();
	// FooterLoginPage foot = new FooterLoginPage();
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
	footerPage footer = new footerPage();
	// String urlFileName = "src/test/resources/TestData/Urls.yaml";
	public WebDriverWait wait;
	String question = "Can we check the status of order from fulfillment tab?";
	String Answer = "Yes";
	Random rm = new Random();
	int i = rm.nextInt(1000) + 1;
	ManagementPage mgmnt = new ManagementPage();
	// YmlUtil yamlData = new YmlUtil();
	// Utility utility = new Utility();

	// BillingReport
	@When("User clicks on report tab")
	public void User_ClicksON_BillingReport() throws Exception {
		common_func.getAreftext("Reports").click();
	}

	@Then("User verifies the presence of buttons and links and billing report text")
	public void Report_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on Billing Report page")
	public void User_Choose_Fields_OnBillingReport_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		common_func.getLabelText("Provider Reference ID").click();
		mgmnt.TotalBill.click();
		mgmnt.BillingMonth.click();
		mgmnt.DueDate.click();
		mgmnt.Provider.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on Billing Report page")
	public void User_Verifies_Field_OnBillingReport_Page() throws Exception {
		if (common_func.getLabelText("Provider Referen...").isDisplayed()) {
			System.out.println("Provider Reference ID is displayed");
		}
		if (common_func.getLabelText("Total Bill").isDisplayed()) {
			System.out.println("Total Bill is displayed");
		}
		if (common_func.getLabelText("Due Date").isDisplayed()) {
			System.out.println("Due Date is displayed");
		}
		if (common_func.getLabelText("Provider").isDisplayed()) {
			System.out.println("Provider is displayed");
		}
		if (common_func.getLabelText("Billing Month").isDisplayed()) {
			System.out.println("Billing Month is displayed");
		}
		Thread.sleep(5000);
	}
/*
	@Then("User clicks on view accounts option")
	public void user_clicks_on_view_accounts_option1() {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Account").click();
	}
*/
	// Revenuebydivision
	@When("User clicks on revenue by division tab")
	public void User_ClicksON_Revenue() throws Exception {
		mgmnt.RevenueByDivision.click();
	}

	@Then("User verifies the presence of buttons and links and revenue by division text")
	public void Revenue_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on revenue by division page")
	public void User_Choose_Fields_OnRevenue_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.AccountName.click();
		mgmnt.Subtotal.click();
		mgmnt.BillingMonth.click();
		mgmnt.Division.click();
		mgmnt.STAB.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on revenue by division page")
	public void User_Verifies_Field_OnRevenue_Page() throws Exception {
		if (common_func.getLabelText("STAB").isDisplayed()) {
			System.out.println("STAB is displayed");
		}
		if (common_func.getLabelText("Subtotal").isDisplayed()) {
			System.out.println("Subtotal is displayed");
		}
		if (common_func.getLabelText("Division").isDisplayed()) {
			System.out.println("Division is displayed");
		}
		if (common_func.getLabelText("Account Name").isDisplayed()) {
			System.out.println("Account Name is displayed");
		}
		if (common_func.getLabelText("Billing Month").isDisplayed()) {
			System.out.println("Billing Month is displayed");
		}
		Thread.sleep(5000);
	}

	// Audit log
	@When("User clicks on audit log tab")
	public void User_ClicksON_AuditLog() throws Exception {
		mgmnt.Auditlog.click();
	}

	@Then("User verifies the presence of buttons and links and audit log text")
	public void AuditLog_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on audit log page")
	public void User_Choose_Fields_OnAuditLog_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.ID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on audit log page")
	public void User_Verifies_Field_OnAuditLog_Page() throws Exception {
		if (common_func.getLabelText("ID").isDisplayed()) {
			System.out.println("ID is displayed");
		}
		Thread.sleep(5000);
	}

	// MissingService
	@When("User clicks on missing service tab")
	public void User_ClicksON_MissingService() throws Exception {
		mgmnt.MissingService.click();
	}

	@Then("User verifies the presence of buttons and links and missing service text")
	public void MissingService_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on missing service page")
	public void User_Choose_Fields_OnService_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.ID.click();
		mgmnt.ServiceName.click();
		mgmnt.Provideid.click();
		mgmnt.Date.click();
		mgmnt.ProviderID.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on missing service page")
	public void User_Verifies_Field_OnMissingService_Page() throws Exception {
		if (common_func.getLabelText("ID").isDisplayed()) {
			System.out.println("ID is displayed");
		}
		if (common_func.getLabelText("Service Name").isDisplayed()) {
			System.out.println("Service Name is displayed");
		}
		if (common_func.getLabelText("Provider Product...").isDisplayed()) {
			System.out.println("Provider Product ID is displayed");
		}
		if (common_func.getLabelText("Date").isDisplayed()) {
			System.out.println("Date is displayed");
		}
		if (common_func.getLabelText("Provider ID").isDisplayed()) {
			System.out.println("Provider ID is displayed");
		}
		Thread.sleep(5000);
	}

	// ErrorslOG
	@When("User clicks on providers errors log tab")
	public void User_ClicksON_ErrorsLog() throws Exception {
		mgmnt.ErrorsLog.click();
	}

	@Then("User verifies the presence of buttons and links and providers errors log text")
	public void ErrorsLog_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on providers errors log page")
	public void User_Choose_Fields_OnErrorsLog_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.ErrorCode.click();
		mgmnt.Count.click();
		mgmnt.ErrorDescription.click();
		mgmnt.Date.click();
		mgmnt.CreatedAt.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on providers errors log page")
	public void User_Verifies_Field_OnErrorsLog_Page() throws Exception {
		if (common_func.getLabelText("Created At").isDisplayed()) {
			System.out.println("Created At is displayed");
		}
		if (common_func.getLabelText("Error Code").isDisplayed()) {
			System.out.println("Error Code is displayed");
		}
		if (common_func.getLabelText("Error Descriptio...").isDisplayed()) {
			System.out.println("Error Description is displayed");
		}
		if (common_func.getLabelText("Date").isDisplayed()) {
			System.out.println("Date is displayed");
		}
		if (common_func.getLabelText("Count").isDisplayed()) {
			System.out.println("Count is displayed");
		}
		Thread.sleep(9000);
	}

	@Then("User clicks on View latest providers errors log")
	public void user_clicks_on_latest_providerlogs() throws InterruptedException {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View latest providers errors log").click();
		Thread.sleep(5000);
	}

	@Then("User clicks on back to providers errors log")
	public void User_Clicks_Back() throws InterruptedException {
		common_func.getSpanText("Back to providers errors log").click();
		Thread.sleep(5000);
	}

	@Then("User clicks on View Count details")
	public void user_clicks_on_View_Count_Details() throws InterruptedException {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Count details").click();
		Thread.sleep(5000);
	}

	@Then("User verifies trace details elements on providers error logs page")
	public void user_clicks_on_view_TraceElements_option_OnProvidersErrorPage() throws InterruptedException {
		if (common_func.getSpanText("Params:").isDisplayed()) {
			System.out.println("Parameters are present");
		}
		if (common_func.getSpanText("Request:").isDisplayed()) {
			System.out.println("Request are present");
		}
		if (common_func.getSpanText("Response:").isDisplayed()) {
			System.out.println("Response are present");
		}
		if (common_func.getSpanText("Provider Response").isDisplayed()) {
			System.out.println("Provider Response are present");
		}
		common_func.getSpanText("Back to providers errors log").click();
	}

	// E1Errorlog
	@When("User clicks on E1 Error log tab")
	public void User_ClicksON_E1Error() throws Exception {
		mgmnt.E1ErrorsLog.click();
	}

	@Then("User verifies the presence of buttons and links and E1 Error log text")
	public void E1Errors_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
		Thread.sleep(5000);
	}

	@And("User unselects all the fields and choose fields to display on E1 Error log page")
	public void User_Choose_Fields_OnE1Errors_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.Date.click();
		mgmnt.CreatedAt.click();
		mgmnt.applyfield.click();
		Thread.sleep(9000);
	}

	@And("User verifies the presence of selected field on E1 Error log page")
	public void User_Verifies_Field_OnE1Error_Page() throws Exception {
		if (common_func.getLabelText("Created At").isDisplayed()) {
			System.out.println("Created At is displayed");
		}
		if (common_func.getLabelText("Date").isDisplayed()) {
			System.out.println("Date is displayed");
		}
		Thread.sleep(5000);
	}

	@Then("User clicks on re-execute option and re-execute the order")
	public void user_clicks_on_reexecute_option() throws InterruptedException {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("Re Execute").click();
		Thread.sleep(5000);
		if (!common_func.isElementPresentBy(mgmnt.NotReexecute)) {
			System.out.println("present");
			Thread.sleep(5000);
			common_func.clickOnButton("Yes");
			Thread.sleep(5000);
		}
		if (common_func.isElementPresentBy(mgmnt.NotReexecute)) {
			System.out.println("not");
			common_func.clickOnButton("Close");
		}
	}

	@Then("User verifies trace details elements on E1 error page")
	public void user_clicks_on_view_TraceElements_optionE1Error() throws InterruptedException {
		if (common_func.getSpanText("Params:").isDisplayed()) {
			System.out.println("Parameters are present");
		}
		if (common_func.getSpanText("E1 Response").isDisplayed()) {
			System.out.println("E1 Response are present");
		}
		common_func.getSpanText("Back to e1 errors/holds log").click();
	}

	// Eexecutionlog
	@When("User clicks on execution log tab")
	public void User_ClicksON_Execution() throws Exception {
		mgmnt.ExecutionLog.click();
	}

	@Then("User verifies the presence of buttons and links and execution log text")
	public void Execution_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on execution log page")
	public void User_Choose_Fields_OnExecution_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.ID.click();
		mgmnt.IP.click();
		mgmnt.User1.click();
		mgmnt.Date.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on execution log page")
	public void User_Verifies_Field_OnExecution_Page() throws Exception {
		if (common_func.getLabelText("IP").isDisplayed()) {
			System.out.println("IP is displayed");
		}
		if (common_func.getLabelText("ID").isDisplayed()) {
			System.out.println("ID is displayed");
		}
		if (common_func.getLabelText("User").isDisplayed()) {
			System.out.println("User is displayed");
		}
		if (common_func.getLabelText("Date").isDisplayed()) {
			System.out.println("Date is displayed");
		}
		Thread.sleep(5000);
	}

	@Then("User clicks on view trace details option")
	public void user_clicks_on_view_Trace_option() throws InterruptedException {
		mgmnt.FirstOrder.click();
		common_func.getAreftext("View Trace Details").click();
		Thread.sleep(5000);
	}

	@Then("User verifies trace details elements")
	public void user_clicks_on_view_TraceElements_option() throws InterruptedException {
		if (common_func.getSpanText("Params:").isDisplayed()) {
			System.out.println("Parameters are present");
		}
		if (common_func.getSpanText("Headers:").isDisplayed()) {
			System.out.println("Headers are present");
		}
		if (common_func.getSpanText("Response:").isDisplayed()) {
			System.out.println("Response are present");
		}
		common_func.getSpanText("Back to execution logs").click();
	}

	// FAQ
	@When("User clicks on FAQ tab")
	public void User_ClicksON_FAQ() throws Exception {
		mgmnt.FAQ.click();
	}

	@Then("User verifies all elements of FAQs Page")
	public void FAQ_Elements() throws Exception {
		if (mgmnt.SelectFieldBtn.isDisplayed()) {
			System.out.println("Select field is present");
		}
		if (top.export.isDisplayed()) {
			System.out.println("Export button is present");
		}
		if (common_func.getAreftext("Add Question").isDisplayed()) {
			System.out.println("Add Question is present");
		}
		String Detail = mgmnt.UserDetail.getText();
		System.out.println(Detail);
	}

	@And("User unselects all the fields and choose fields to display on FAQ page")
	public void User_Choose_Fields_OnFAQ_Page() throws Exception {
		Thread.sleep(5000);
		mgmnt.unselectall.click();
		mgmnt.Answer.click();
		mgmnt.Question.click();
		mgmnt.Status.click();
		mgmnt.CreatedAt.click();
		mgmnt.UpdatedAt.click();
		mgmnt.applyfield.click();
		Thread.sleep(5000);
	}

	@And("User verifies the presence of selected field on FAQ page")
	public void User_Verifies_Field_OnFAQ_Page() throws Exception {
		if (common_func.getLabelText("Answer").isDisplayed()) {
			System.out.println("Answer is displayed");
		}
		if (common_func.getLabelText("Question").isDisplayed()) {
			System.out.println("Question is displayed");
		}
		if (common_func.getLabelText("Created At").isDisplayed()) {
			System.out.println("Created At is displayed");
		}
		if (common_func.getLabelText("Updated At").isDisplayed()) {
			System.out.println("Updated At is displayed");
		}
		if (common_func.getLabelText("Status").isDisplayed()) {
			System.out.println("Status is displayed");
		}
		Thread.sleep(5000);
	}

	@And("User clicks on add question and type the question")
	public void User_add_Question() throws Exception {
		common_func.getAreftext("Add Question").click();
		common_func.getWebElement(mgmnt.TypeQuestion).sendKeys(question);
		common_func.getWebElement(mgmnt.TypeAnswer).sendKeys(Answer);
		mgmnt.Save.click();
		Thread.sleep(5000);
	}

	@Then("User verifies whether the question is displayed or not")
	public void User_Verifies_Question() throws Exception {
		String q = mgmnt.VerifyQuestion.getText();
		if (q.contentEquals(question)) {
			System.out.print(question);
		}
		String a = mgmnt.VerifyAnswer.getText();
		if (a.contentEquals(Answer)) {
			System.out.print(Answer);
		}
	}

	// settings
	@When("User clicks on Settings tab")
	public void User_ClicksON_Settings() throws Exception {
		mgmnt.Settings.click();
	}

	@Then("User verifies all elements of Settings Page")
	public void Settings_Elements() throws Exception {
		String CusGtm = mgmnt.CusGTMCode.getText();
		System.out.println(CusGtm);
		String ManGTM = mgmnt.ManGTMCode.getText();
		System.out.println(ManGTM);
		if (common_func.getAreftext("Edit").isDisplayed()) {
			System.out.println("Edit button is present");
		}
	}

	@Then("User fetches old details and clicks on edit")
	public void User_Clicks_On_Edit() throws Exception {
		String CusGtm = mgmnt.CusGTMCode.getText();
		System.out.println(CusGtm);
		String ManGTM = mgmnt.ManGTMCode.getText();
		System.out.println(ManGTM);
		common_func.getAreftext("Edit").click();
	}

	@And("User changes the expiry date {string} and customer GTM {string}")
	public void User_Edits_Settings(String value, String code) throws Exception {
		mgmnt.CusGTMInput.clear();
		mgmnt.CusGTMInput.sendKeys(value);
		mgmnt.ExpiryCode.clear();
		mgmnt.ExpiryCode.sendKeys(code);
		common_func.getAreftext("Save").click();
	}

	@Then("User verifies the alert message")
	public void User_Verifies_Changes() throws Exception {
		Assert.assertEquals(common_func.getText(mgmnt.SettingsAlert), "Settings saved successfully",
				"alert text not match");
	}

	// jobs
	@When("User clicks on Jobs tab")
	public void User_ClicksON_Jobs() throws Exception {
		mgmnt.Jobs.click();
	}

	@And("User verifies all elements of Jobs Page")
	public void Jobs_Elements() throws Exception {
		String Detail = mgmnt.JobDetail.getText();
		System.out.println(Detail);
		if (mgmnt.SearchJob.isDisplayed()) {
			System.out.println("Present");
		}
	}

	@And("User verifies types {string} and fetches its details")
	public void Jobs_Details(String jobsname) throws Exception {
		mgmnt.SearchJob.sendKeys(jobsname);
		System.out.println(mgmnt.Jobsname.getText());
		System.out.println(mgmnt.Schedule.getText());
		System.out.println(mgmnt.LastRun.getText());
		System.out.println(mgmnt.Status1.getText());
	}

	// change password
	@Then("User gets an alert message of successfully changing password")
	public void User_Verifies_AlertMsg() throws Exception {
		Assert.assertEquals(common_func.getText(mgmnt.AlertMsgPassword), "Your password is updated successfully",
				"alert text not match");
	}

	@Then("User verifies the presence of all elements")
	public void User_Verifies_Password_Elements() throws Exception {
		if (common_func.getById("current_password").isDisplayed() && common_func.getById("password").isDisplayed()
				&& common_func.getById("password_confirmation").isDisplayed()
				&& common_func.getAreftext("Save").isDisplayed() && common_func.getAreftext("Cancel").isDisplayed()) {
			System.out.println("All Elements are present");
		}
	}

	// Myprofile
	@Then("User verifies the elements of my profile page")
	public void User_Verifies_MyProfile_Elements() throws Exception {
		if (mgmnt.UserRole.isDisplayed() && mgmnt.Email.isDisplayed() && footer.firstname.isDisplayed()
				&& footer.lastname.isDisplayed() && footer.save_Myprofile.isDisplayed()
				&& footer.cancel_Myprofile.isDisplayed()) {
			System.out.println("All Elements are present");

		}
	}

	// createUser
	@When("User clicks on create user")
	public void User_ClicksON_CreateUser() throws Exception {
		common_func.getAreftext("Create User").click();
	}

	@Then("User fills out the form {string} {string} {string}")
	public void user_fills_out_the_form(String fname, String lname, String Role) {
		mgmnt.name.sendKeys(fname);
		mgmnt.lname.sendKeys(lname);
		mgmnt.role.sendKeys(Role);
		mgmnt.email.sendKeys("Muhammad" + i + "@arpatech.com");
		common_func.getAreftext("Create").click();
	}

	@Then("user gets the alert message of a new user has been created")
	public void User_Creates_New_User() throws Exception {
		Thread.sleep(5000);
		System.out.println(common_func.getSpanText("The user has been created").getText());
	}

	@Then("User verifies all elements of user Page")
	public void User_Elements() throws Exception {
		Thread.sleep(5000);
		if (mgmnt.SelectRole.isDisplayed()) {
			System.out.println("select role button is present");
		}
		if (mgmnt.SelectStatus.isDisplayed()) {
			System.out.println("select status button is present");
		}
		if (mgmnt.SearchJob.isDisplayed()) {
			System.out.println("Search job is present");
		}
		System.out.println(mgmnt.CreateUserDetail.getText());
	}
	//Roles
		@Then("User verifies all elements of role Page")
		public void role_Elements() throws Exception {
			Thread.sleep(5000);
			if (mgmnt.AddRoleBtn.isDisplayed()) {
				System.out.println("select role button is present");
			}
			if (mgmnt.RoleDesc.isDisplayed()) {
				System.out.println(mgmnt.RoleDesc.getText());
			}
		}
		//@Then("User clicks on save button of role page")
		//public void role_SaveBtn() throws Exception {
		//	common_func.getAreftext("Save").click();
		//}
		@Then("User enters role name")
		public void enterRoleName() throws Exception {
			mgmnt.RoleName.sendKeys("Tester"+i);
		}
		@Then("User gets alert message on creating new role")
		public void RoleAlertMessage() throws Exception {
			Thread.sleep(5000);
			mgmnt.RoleCreated.getText().contentEquals("Role created successfully");
		}

}
