package StepDefinitions;

import Utilities.basePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.commonFunctions;
import Pages.footerPage;

import org.testng.Assert;
import Pages.LoginPage;
import Pages.Utility;
import Utilities.YmlUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Account_MenuStep extends basePage {
	LoginPage loginPage = new LoginPage();
	commonFunctions common_func = new commonFunctions();
	footerPage footer = new footerPage();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	public WebDriverWait wait;
	public String OldTab;

	@When("User clicks on account setting from account menu")
	public void Click_Account_Setting_link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Account Settings").click();
	}

	@And("User verifies other elements on account setting page")
	public void Verify_Setting_Page_elements() throws Exception {
		footer.ElementsAccountSetting();
	}

	// addressofuse
	@When("User clicks on address of use from account menu")
	public void Click_AddressOfUse_link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Address of Use").click();
	}

	@And("User clicks on edit and update button")
	public void click_OnSave_suite6() throws Exception {
		if (common_func.isElementPresent(footer.show5)) {
			common_func.ClickOnLink(footer.EditButtonAOU);
			common_func.ClickOnLink(footer.UpdateButtonAOU);
		}
	}

	// catalogRestriction
	@When("User clicks on catalog restriction from account menu")
	public void Click_Catalog_link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Catalog Restrictions").click();
	}

	@Then("User verifies presence of other elements from catalog restriction page")
	public void Verify_Catalog_Page_elements() throws Exception {
		footer.CatalogRestrictions();
	}

//	}
	// Change_password
	@When("User clicks on change password from account menu")
	public void Click_ChangePassword_link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Change Password").click();
	}

	@Then("User reaches on change password page")
	public void Verify_ChangePassword_Page_suite6() throws Exception {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Change Password - CCM"));
		Assert.assertEquals(driver.getTitle(), "Change Password - CCM", "error");
	}

	@And("User clicks on save button")
	public void User_clicks_onSaveButton_suite6() throws Exception {
		Thread.sleep(4000);
		common_func.getAreftext("Save").click();

	}

	@Then("User gets an alert message for password field is required")
	public void User_ReceievesAlert_PasswordRequired_suite6() throws Exception {
		Thread.sleep(4000);
		Assert.assertEquals(common_func.getText(footer.alertmsg), "The Current Password field is required",
				"alert text not match");
	}

	@Then("User gets an alert message for providing incorrect password")
	public void User_ReceievesAlert_IncorrectPassword_suite6() throws Exception {
		Assert.assertEquals(common_func.getText(footer.alertmsg),
				"The provided current password is incorrect, please try again", "alert text not match");
	}

	@When("User provides incorrect current password {string}")
	public void Enter_IncorrectCurrentPassword_suite6(String current) throws Exception {
		common_func.getById("current_password").sendKeys(current);
	}

	@When("User provides new password {string}")
	public void Enter_NewPassword_suite6(String newpass) throws Exception {
		common_func.getById("password").sendKeys(newpass);
	}

	@When("User confirms password {string}")
	public void Enter_ConfirmPassword_suite6(String confirm) throws Exception {
		common_func.getById("password_confirmation").sendKeys(confirm);
	}

	@When("User provide correct current password {string}")
	public void Enter_CurrentPassword2_suite6(String current) throws Exception {
		common_func.getById("current_password").sendKeys(current);
	}

	@When("User provide incorrect new password {string}")
	public void Enter_IncorrectNewPassword_suite6(String newpass) throws Exception {
		common_func.getById("password").sendKeys(newpass);
	}

	@When("User confirm incorrect confirm password {string}")
	public void Enter_IncorrectConfirmPassword_suite6(String confirm) throws Exception {
		common_func.getById("password_confirmation").sendKeys(confirm);
	}

	@When("User provides correct current password {string}")
	public void Enter_CurrentPassword1_suite6(String current) throws Exception {
		common_func.getById("current_password").sendKeys(current);
	}

	@When("User provide less than 8 digit new password {string}")
	public void Enter_less8DigitNewpassword_suite6(String newpass) throws Exception {
		common_func.getById("password").sendKeys(newpass);
	}

	@When("User confirm less than 8 digit password {string}")
	public void Enter_less8DigitConfirmpassword_suite6(String confirm) throws Exception {
		common_func.getById("password_confirmation").sendKeys(confirm);
	}

	@Then("User gets an alert message for not matching new password with confirm password")
	public void User_ReceivesAlertMessage_IncorrectNewPassword_suite6() throws Exception {
		Assert.assertEquals(common_func.getText(footer.alertmsg), "Password and Confirm Password does not match",
				"alert text not match");
	}

	@Then("User gets an alert message for not providing 8 digits password")
	public void User_ReceivesAlertMessageg_8DigitPassword_suite6() throws Exception {
		Assert.assertEquals(common_func.getText(footer.alertmsg),
				"Password must have at least 8 characters and a combination of uppercase, lowercase letter, number, and special characters ~`!@#$%^&*()_-=+[{]};:'\",.<>/?|",
				"alert text not match");
	}

	@And("User clicks on cancel button")
	public void User_clicks_OnCancelButton_suite6() throws Exception {
		Thread.sleep(4000);
		common_func.ClickOnLink(footer.cancelchangepwd);
	}
	@Then("User gets an alert message for successfully changing password")
	public void User_ReceievesAlert_successful_suite6() throws Exception {
		Assert.assertEquals(common_func.getText(footer.alertmsg),
				"Your password is updated successfully", "alert text not match");
	}

   @And("User verifies the presence of all elements on change password page")
	public void User_Verifies_Presence_Elements() throws Exception {
		if(footer.cancelchangepwd.isDisplayed()) {
			System.out.println("Cancel button is displayed");
		}
		if(common_func.getAreftext("Save").isDisplayed()) {
			System.out.println("Save button is displayed");
		}
		if(common_func.getById("password").isDisplayed()) {
			System.out.println("password field is displayed");
		}
		if(common_func.getById("password_confirmation").isDisplayed()) {
			System.out.println("confirm password field  is displayed");
		}
		if(common_func.getById("current_password").isDisplayed()) {
			System.out.println("current password field is displayed");
		}
	}

	// My Profile
	@When("User clicks on My Profile from account menu")
	public void Click_My_Profile_link_suite6() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("My Profile").click();
	}

	@And("User fetches details")
	public void Fetch_Details() throws Exception {
		footer.fetchDetail();
	}

	@When("User clicks on edit button")
	public void clicks_On_EditButton() throws Exception {
		if (common_func.isElementPresent(footer.EditProfile_btn)) {
			common_func.ClickOnLink(footer.EditProfile_btn);
		}
	}

	@Then("User passes phone {string} and scrolls down")
	public void Enter_Phone_Number_suite6(String phone) throws Exception {
		footer.Phone.clear();
		footer.PassPhone(phone);
		common_func.Scrolls();
	}

	@And("User clicks on save button my profile")
	public void User_clicks_onSaveButton_MyProfile_suite6() throws Exception {
		Thread.sleep(4000);
		if (common_func.isElementPresent(footer.save_Myprofile)) {
			common_func.ClickOnLink(footer.save_Myprofile);
		}
	}

	@And("User passes new values for name {string}")
	public void Enter_FirstName__suite6(String name) throws Exception {
		footer.firstname.clear();
		footer.PassFName(name);
	}

	@And("User passes new values for lastname {string}")
	public void Enter_LastName_Number_suite6(String lname) throws Exception {
		footer.lastname.clear();
		footer.PassLName(lname);
		common_func.Scrolls();
	}

	@And("User press cancel button")
	public void User_clicks_onCancelButton_MyProfile_suite6() throws Exception {
		if (common_func.isElementPresent(footer.cancel_Myprofile)) {
			common_func.ClickOnLink(footer.cancel_Myprofile);
		}
	}

	// Notification Management
	@When("User clicks on Notifications Management from account menu")
	public void Click_Notification_Management_link_suite6() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Notification Management").click();
	}

	@And("User verifies edit check box by getting alert message")
	public void Get_Alert_Message_suite6() throws Exception {
		String alert = footer.getemailAlertmsg();
		Assert.assertEquals(alert, "You are not allowed to opt out of the email.", "alert text not match");
	}

	@And("User click on element")
	public void Click_Element_Button_suite6() throws Exception {
		common_func.ClickOnLink(footer.element1);
	}

	@Then("User clicks cancel button on notification page")
	public void Click_Cancel_Button_suite6() throws Exception {
		common_func.ClickOnLink(footer.notifcancel);
	}

	@And("User clicks on save button of notification management")
	public void Click_Save_Button_suite6() throws Exception {
		common_func.ClickOnLink(footer.notifsave);
		Thread.sleep(5000);
	}

	@Then("User scrolls up")
	public void User_ScrollsUp_suite6() throws Exception {
		common_func.ScrollsUp();
	}

	// paymentMethod
	@When("User clicks on payment method from account menu")
	public void Click_Payment_Link_suite6() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Payment Method").click();
	}

	@And("User clicks on add payment button")
	public void Click_AddPayment_button_suite6() throws Exception {
		Thread.sleep(8000);
		common_func.ClickOnLink(footer.ChangeBtn);
	}

	@And("User clicks on add a credit card button")
	public void Click_AddCard_suite6() throws Exception {
		Thread.sleep(8000);
		common_func.ClickOnLink(footer.AddCreditBtn);
	}

	@Then("User provide all the credentials")
	public void Enter_Creddentials_suite6() throws Exception {
		footer.ProvidePaymentCred();
	}

	@And("User clicks on save button on payment page")
	public void Click_SavePay_Button_suite6() throws Exception {
		common_func.ClickOnLink(footer.savecard);
	}

	@Then("User clicks on cancel button on payment page")
	public void Click_CancelPay_Button_suite6() throws Exception {
		common_func.ClickOnLink(footer.cancel);
	}

	// UserloginwithInvalidCredentials
	
	@When("User provides Username {string}")
	public void InsertUserName_invalidCred(String value) throws Exception {
		loginPage.sendUsername(value);
	}

	@When("User provides password {string}")
	public void InsertPassword_InvalidCred(String value) throws Exception {
		loginPage.insertPassword(value);
	}

	@And("User clicks on the login button to visit home page")
	public void Click_OnLoginButton_InvalidCred() throws Exception {
		loginPage.clickOnLoginButton();
	}

	@Then("User gets alert message of invalid credentials")
	public void User_ReceivesAlertMessage_SessionExpired_suite6() throws Exception {
		Assert.assertEquals(common_func.getText(footer.alertdanger), "The provided email does not exist",
				"alert text not match");
	}
}