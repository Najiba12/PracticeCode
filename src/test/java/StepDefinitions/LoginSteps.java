package StepDefinitions;

import Pages.LoginPage;
import Pages.commonFunctions;
import Pages.footerPage;
import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends basePage {
	LoginPage loginPage = new LoginPage();
	commonFunctions common_func = new commonFunctions();
	footerPage footer = new footerPage();

	@When("User inserts the Username {string}")
	public void Insert_UserName(String cred) throws Exception {
		loginPage.sendUsername(cred);
	}

	@And("User inserts the password {string}")
	public void Insert_Password(String cred) throws Exception {
		loginPage.insertPassword(cred);
	}

	@And("User clicks on login button")
	public void ClickOn_LoginPage() throws Exception {
		loginPage.clickOnLoginButton();
	}

	@When("User inserts validation code {string}")
	public void Insert_Code(String cred) throws Exception {
		loginPage.sendValidationCode(cred);
	}

	@And("User clicks on complete button")
	public void Complete_Authentication_Button() throws Exception {
		loginPage.clickOnCompleteButton();
	}

	@Then("Verify User is on home page")
	public void Verify_User_Is_On_HomePage() throws Exception {
		softAssertH.assertEquals(loginPage.getTitleText(), "Marketplace - CCM");
	}

	@Then("User logs out")
	public void User_Logsout_AccMenu_Suite6() throws Exception {
		loginPage.clickOnAccountMenuButton();
		if (common_func.isElementPresent(footer.logoutBtn)) {
			common_func.ClickOnLink(footer.logoutBtn);
		}
	}

}
