package StepDefinitions;

import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.TopLinksPages;
import Pages.Utility;
import Pages.commonFunctions;
import Pages.footerPage;

public class OldRegressionStep extends basePage {
	LoginPage loginPage = new LoginPage();
	footerPage footer = new footerPage();
	commonFunctions common_func = new commonFunctions();
	TopLinksPages top = new TopLinksPages();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	public WebDriverWait wait;
	Random rm = new Random();
	int i = rm.nextInt(1000) + 1;

	@When("User clicks on market place link after reaching home page")
	public void User_Clicks_Marketplace() throws Exception {
		if (common_func.isElementPresent(footer.marketplace)) {
			common_func.ClickOnLink(footer.marketplace);
		}
	}

	@And("User verifies the presence of Discover link on home page")
	public void Verify_Discover() throws Exception {
		top.Discover1.isEnabled();
	}

	@And("User verifies the presence of Application link on home page")
	public void Verify_ApplicationLink() throws Exception {
		top.Application_Link.isEnabled();
	}

	@And("User verifies the presence of Infrastructure link on home page")
	public void Verify_Infrastructure() throws Exception {
		top.Infrastructure_Link.isEnabled();
	}

	@And("User verifies the presence of Platform link on home page")
	public void Verify_Platform() throws Exception {
		top.Platform_Link.isEnabled();
	}

	@And("User verifies the presence of DFD Banner on home page")
	public void Verify_DFD() throws Exception {
		top.DFP_Banner.isDisplayed();
	}

	// invite
	@When("User clicks on User management from account menu")
	public void ClickOn_User_Management() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("User Management").click();
	}

	@And("User is taken to User {string}")
	public void verify_User_Managment_Page(String page) throws Exception {
		softAssertH.assertEquals(common_func.getTitlePage(), page);
	}

	@Then("User clicks on invite tab")
	public void ClicksOn_Invite() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.InvitesTab);;
	}

	@And("User generate random email and pass it to email textbox")
	public void Pass_Email() throws Exception {
		common_func.getWebElement(top.emailtextbox).sendKeys(i + "saima.tabassum" + i + "@arpatech.com");
		Thread.sleep(3000);
	}

	@And("User clicks on invite button")
	public void ClicksOn_Invite_Button() throws Exception {
		common_func.ClickOnLink(top.InviteBtn);
	}

	@Then("User clears email textbox")
	public void Clears_TextBox() throws Exception {
		common_func.getWebElement(top.emailtextbox).clear();
	}

	@And("User pass another randomly generated email and clicks on invite")
	public void Pass_Email2() throws Exception {
		common_func.getWebElement(top.emailtextbox).sendKeys("bilawal.alam" + i + "@arpatech" + i + ".com");
		Thread.sleep(3000);
		common_func.ClickOnLink(top.Invite2Btn);
	}

	@And("User pass another randomly generated email again and clicks on invite button")
	public void Pass_Email3() throws Exception {
		common_func.getWebElement(top.emailtextbox).sendKeys("s" + i + "@arpatech" + i + ".com");
		Thread.sleep(5000);
		common_func.ClickOnLink(top.Invite2Btn);
	}

	@Then("User prints alert message")
	public void Prints_Alert_Message() throws Exception {
		System.out.println(common_func.getText(top.alert));
	}

	@Then("User cancel invite and clicks on resend button")
	public void Cancel_Invite() throws Exception {
		common_func.ClickOnLink(top.CancelInvite);
		Thread.sleep(2000);
		common_func.ClickOnLink(top.resendinv);
	}

	// catalogRestriction
	@When("User checks Restricted button is displayed")
	public void Checks_Presence_Restricted() throws Exception {
		top.Restricted.isDisplayed();
	}

	@Then("User clicks on unrestricted button")
	public void User_Clicks_Unrestricted() throws Exception {
		common_func.ClickOnLink(top.Unrestricted);
	}

	@Then("User clicks on unrestrict button")
	public void User_Clicks_Unrestrict() throws Exception {
		common_func.ClickOnLink(top.Unrestrict);
	}

	@When("User clicks on restricted button")
	public void User_Clicks_On_Restricted() throws Exception {
		common_func.ClickOnLink(top.Restricted);
	}

	@When("User clicks on restrict button")
	public void User_Clicks_On_Restrict() throws Exception {
		top.ScrollsBy300();
		common_func.ClickOnLink(top.Restrict);
	}

	@Then("User sends {string} on search box")
	public void User_Pass_Value(String value) throws Exception {
		Thread.sleep(5000);
		common_func.getWebElement(top.ServiceSearch).sendKeys(value);
	}

	@And("User clicks on checkbox")
	public void User_Clicks_Checkbox() throws Exception {
		top.ScrollsBy300();
		Thread.sleep(9000);
		common_func.ClickOnLink(top.CheckBox);
	}

	@Then("User checks successful alert message")
	public void Successful_Alert() throws Exception {
		common_func.getWebElement(top.SucessMsg).isDisplayed();
	}

	@And("User checks if checkbox is displayed")
	public void Presence_Checkbox() throws Exception {
		top.CheckBox.isDisplayed();
	}

	@And("User selects all")
	public void User_Clicks_Select_All() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.SelectAll);
	}

	@Then("User verifies successful alert message is displayed")
	public void Successful_AlertMessage() throws Exception {
		common_func.getWebElement(top.UnRestrictSuccessMsg).isDisplayed();
	}

	// UserSearch
	@Then("User clicks on user tab")
	public void ClicksOn_User_Search() throws Exception {
		common_func.ClickOnLink(top.UserTab);
	}

	@And("User passes {string} to search bar")
	public void Pass_CCM_Value(String value) throws Exception {
		common_func.getWebElement(top.SearchBox).sendKeys("CCM" + Keys.ENTER);
	}

	// editProfile
	@Then("User verifies {string}")
	public void Verify_Edit_Page(String page) throws Exception {
		softAssertH.assertEquals(common_func.getTitlePage(), page);
	}

	@And("User clicks on Save button")
	public void ClicksOn_Save() throws Exception {
		common_func.ClickOnLink(top.SaveBtn);
	}

	// uploadlogo
	@Then("User clicks on browse button")
	public void ClicksOn_Browse_button() throws Exception {
		common_func.ClickOnLink(top.BrowseBtn);
		Thread.sleep(4000);
	}

	@When("User selects image from local files")
	public void Select_File() throws Exception {
		StringSelection ss = new StringSelection("C:\\Users\\Horizon\\Desktop\\a.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(4000);
	}

	@Then("User clicks on save")
	public void clicksOn_Save_Button() throws Exception {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		common_func.Scrolls();
		common_func.ClickOnLink(top.SaveChanges);
	}

	@And("User receives successful alert message on account setting page")
	public void verify_AlertMessage() throws Exception {
		// top.SuccessMsg.isDisplayed();
	}

	// addressofUse
	@Then("User clicks on req address button")
	public void Clicks_On_Req() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(top.RequestAddressBtn);
	}

	@And("User sends {string} to address textbox")
	public void Enter_Address(String value) throws Exception {
		common_func.getWebElement(top.address).sendKeys(value);
	}

	@And("User sends {string} to address field")
	public void Enter_Address_textbox(String value) throws Exception {
		common_func.getWebElement(top.AddressField).sendKeys(value);
	}

	@And("User sends {string} to zipcode field")
	public void Enter_Zip_Code(String value) throws Exception {
		common_func.getWebElement(top.Zip_Code).sendKeys(value);
	}

	@And("User sends {string} to phone textbox")
	public void Enter_Phone(String value) throws Exception {
		common_func.getWebElement(top.Phone).sendKeys(value);
	}

	@Then("User clicks on submit button on addofUse page")
	public void ClicksOn_Submit_Button() throws Exception {
		 common_func.ClickOnLink(top.SubmitBtn);
	}

	@And("User checks if validate message is displayed")
	public void Verify_Alert_Messages() throws Exception {
		//common_func.getWebElement(top.ValidationMsg).isDisplayed();
	}

	@When("User refreshes the page")
	public void User_Refreshes_the_Page() {
		driver.navigate().refresh();
	}

	// discover
	@And("User gets text from first and second textbox")
	public void Fetch_Texts() throws Exception {
		String Heading_Text = common_func.getText(top.Heading);
		common_func.getText(top.Step1Title);
		common_func.getText(top.Step2Title);
		System.out.println(Heading_Text);
	}

	// searchtab
	@Then("User gets product size")
	public void Product_Size() throws Exception {
		int a = top.getProducts().size();
	}

	// logout
	@When("User clicks on account menu link")
	public void User_Clicks_AccMenu() throws Exception {
		loginPage.clickOnAccountMenuButton();

	}

	@Then("User clicks on logout option from account menu")
	public void User_ClicksOn_LogOut() throws Exception {
		if (common_func.isElementPresent(footer.logoutBtn)) {
			common_func.ClickOnLink(footer.logoutBtn);
		}
	}

	// lockedUser
	@Then("User clears email text box")
	public void User_Clears_TextBox() throws Exception {
	common_func.getWebElement(	loginPage.Usernamefield).clear();
	}

	// forgotpass
	@When("User clicks on forgot password link from login page")
	public void ClicksOn_Forgot_Pass() throws Exception {
		common_func.getWebElement(loginPage.Forget_Pswd).click();

	}

	@And("User enters email address {string}")
	public void User_Enters_Email(String email) throws Exception {
		common_func.getWebElement(	loginPage.emailfield).sendKeys(email);
	}

	@Then("User clicks on submit button")
	public void Clicks_Submit() throws Exception {
		common_func.ClickOnLink(loginPage.Sbmt_Btn);
	}

}