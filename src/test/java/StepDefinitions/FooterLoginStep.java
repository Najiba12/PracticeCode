package StepDefinitions;

import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.Utility;
import Pages.commonFunctions;
import Pages.footerPage;

import java.util.List;

public class FooterLoginStep extends basePage {
	LoginPage loginPage = new LoginPage();
	FooterLoginPage foot = new FooterLoginPage();
	commonFunctions common_func = new commonFunctions();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	public WebDriverWait wait;

	@When("User clicks on contact us link")
	public void User_Clicks_ContactUs() throws Exception {
     common_func.getOnLinkText("Contact Us").click();
	}

	@Then("User reaches on page {string}")
	public void Verify_ContactPage(String title) throws Exception {
		foot.WindowHandler();
		softAssertH.assertEquals(common_func.getTitlePage(), title);
	}

	@When("User clicks on terms condition link")
	public void User_Clicks_TermOfUse_Footer() throws Exception {
	     common_func.getOnLinkText("Terms of Use").click();
	}
	
	@Then("User reaches on terms condition page {string}")
	public void Verify_TermOfUse_Page(String title) throws Exception {
		foot.WindowHandler();
		softAssertH.assertEquals(common_func.getTitlePage(), title);
	}

	@When("User clicks on privacy policy link on page")
	public void User_Clicks_Privacy_Policy_Footer() throws Exception {
	     common_func.getOnLinkText("Privacy Policy").click();
	}

	@Then("User reaches on privacy policy page {string}")
	public void Verify_Privacy_Policy_Page(String title) throws Exception {
		foot.WindowHandler();
		softAssertH.assertEquals(common_func.getTitlePage(), title);
	}

	@And("User navigate back to login page")
	public void Navigate_Backto_Login() throws Exception {
		foot.BackLoginPage(driver).click();
	}

	@And("User close other windows")
	public void Close_Windows() throws Exception {
		foot.ParentWindowHandler();
	}

	@Then("User enters the value and press cancel button")
	public void User_Clicks_OnCancel() throws Exception {
		foot.SendMsgContactUsCancel();
	}

	@Then("User enters the value and press submit button")
	public void User_Clicks_OnSubmit() throws Exception {
		foot.SendMsgContactUsSubmit();
	}

}
