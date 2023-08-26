package StepDefinitions;

import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.Utility;
import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Pages.commonFunctions;
import Pages.footerPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class footerSteps extends basePage {
	LoginPage loginPage = new LoginPage();
	commonFunctions common_func = new commonFunctions();
	FooterLoginPage foot = new FooterLoginPage();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	footerPage footer = new footerPage();
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	public WebDriverWait wait;
	public String OldTab;

	@When("User checks if MarketPlace link is available")
	public void Verify_Marketplace() throws Exception {
		if (common_func.isElementPresent(footer.marketplace)) {
			System.out.println("marketplace");
		}
	}

	@Then("User checks if Manage link is available")
	public void Verify_Manage() throws Exception {
		if (common_func.isElementPresent(footer.Manage)) {
			System.out.println("manage");
		}
	}

	@Then("User checks if Insight link is available")
	public void Verify_Insight() throws Exception {
		if (common_func.isElementPresent(footer.Insight)) {
			System.out.println("insight");
		}
	}

	@Then("User checks if About CCM link is available")
	public void Verify_About_CCM() throws Exception {
		if (common_func.isElementPresent(common_func.getAreftext("About CCM"))) {
			System.out.println("About CCM");
		}
	}

	@Then("User checks if About Connection link is available")
	public void Verify_About_Connection() throws Exception {
		if (common_func.isElementPresent(common_func.getAreftext("About Connection"))) {
			System.out.println("About Connection");
		}
	}

	@Then("User checks if Contact us link is available")
	public void Verify_Contact_US() throws Exception {
		if (common_func.isElementPresent(common_func.getOnLinkText("Contact Us"))) {
			System.out.println("Contact us");
		}
	}

	@Then("User checks if Term of use link is available")
	public void Verify_TermOfUse() throws Exception {
		if (common_func.isElementPresent(common_func.getOnLinkText("Terms of Use"))) {
			System.out.println("Term of use");
		}
	}

	@Then("User checks if Privacy policy link is available")
	public void Verify_Privacy_Policy() throws Exception {
		if (common_func.isElementPresent(common_func.getOnLinkText("Privacy Policy"))) {
			System.out.println("Privacy policy");
		}
	}

	@Then("User checks if Accessibility link is available")
	public void Verify_Accessibility() throws Exception {
		if (common_func.isElementPresent(common_func.getAreftext("Accessibility"))) {
			System.out.println("Accessibility");
		}
	}

	@Then("User checks if Help link is available")
	public void Verify_Help() throws Exception {
		if (common_func.isElementPresent(common_func.getAreftext("Help"))) {
			System.out.println("Help");
		}
	}
	@Then("User clicks on about CCM")
	public void ClickOn_About() throws Exception {
		common_func.Scrolls();
		common_func.ClickOnLink(common_func.getAreftext("About CCM"));
	}
	// Clicking on Connection link
	@When("User scrolls down to footer in home page")
	public void ScrollsDown() throws Exception {
		common_func.Scrolls();
	}

	@Then("User clicks on about connection link")
	public void ClickOn_Connection() throws Exception {
		common_func.ClickOnLink(common_func.getAreftext("About Connection"));
	}

	@And("User verifies the presence of learn more button & total number of images that are displayed are fetched")
	public void Total_Images_Displayed() throws Exception {
		footer.ImagesDisplayed();
	}

	@Then("User checks if footer links are available")
	public void Verify_Footer_Links_From_ConnectionPage() throws Exception {
		if (footer.isFooterLinkPresent()) {
			System.out.println("Available");
		}
	}

//contactus
	
	@Then("User checks if contact us details are present")
	public void Verify_Contactus_Details_Page() throws Exception {
		footer.getContactUsDetails();
	}

	@Then("User clicks on submit button on contact page")
	public void ClickOn_Submit_Button_Contact() throws Exception {
		common_func.ClickOnLink(footer.Contact_submit);
	}

	@Then("User gets an alert message")
	public void User_Gets_Alert_Message() throws Exception {
		Assert.assertEquals(common_func.getText(footer.AlertmsgContact), "The Subject field is required",
				"msg not diplayed");
	}

	@Then("User checks if footer links are available on page")
	public void Verify_FooterLinks_From_Privacy_Policy_Page() throws Exception {
		if (footer.isFooterLinkPresent()) {
			System.out.println("Available");
		}
	}

	// Accessibility
	@When("User clicks on Accessibility link")
	public void ClickOn_Accessibility_link() throws Exception {
		common_func.Scrolls();
		OldTab = driver.getWindowHandle();
		common_func.ClickOnLink(common_func.getAreftext("Accessibility"));
	}

	@Then("User navigates back to old window")
	public void BackTo_Old_Tab() throws Exception {
		driver.switchTo().window(OldTab);
	}

	// help
	@When("User clicks on help link")
	public void ClickOn_Help_Link() throws Exception {
		common_func.ClickOnLink(common_func.getAreftext("Help"));
	}

	@Then("User clicks on marketplace present on help page if it exists")
	public void Click_Marketplace_Link() throws Exception {
		if (common_func.isElementPresent(footer.marketplace)) {
			common_func.ClickOnLink(footer.marketplace);
		}
	}

	@Then("User clicks on Spend Analysis if it exists")
	public void Click_Insight_Link() throws Exception {
		if (common_func.isElementPresent(footer.Insight)) {
			common_func.ClickOnLink(footer.Insight);
		}
	}

	@Then("User clicks on Subscription if it exists")
	public void Click_Aubscription_Link() throws Exception {
		if (common_func.isElementPresent(footer.Manage)) {
			common_func.ClickOnLink(footer.Manage);
		}
	}

	@Then("User clicks on My Profile if it exists")
	public void Click_MyProfile_Link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("My Profile").click();
	}

	@Then("User clicks on Account Settings if it exists")
	public void Click_Setting_Link() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Account Settings").click();
	}

	// notification
	@When("User clicks on notification link")
	public void Click_Notification_Link() throws Exception {
		if (common_func.isElementPresent(footer.Notification)) {
			common_func.ClickOnLink(footer.Notification);
		}
	}

	@Then("User gets all notifications, headings and flag")
	public void Verify_link() throws Exception {
		common_func.isElementPresent(footer.Notification_heading);
		common_func.isElementPresent(footer.All_Notification);
		common_func.isElementPresent(footer.Flagged);
	}

	// UserRole
	@Then("User navigates to {string}")
	public void Verify_User_Role(String url) throws Exception {
		String User_role_url = yamlData.getDataYML(urlFileName, url, "accountDomainUrl");
		driver.get(User_role_url);
	}

	// 404page
	@Given("User navigates to 404 page {string}")
	public void Verify_404page(String url) throws Exception {
		String User_role_url = yamlData.getDataYML(urlFileName, url, "marketPlaceUrl");
		driver.get(User_role_url);
		softAssertH.assertEquals(common_func.getTitlePage(), "404 Not Found - CCM");
	}

	@And("User clicks on no access button")
	public void User_Clicks_NoAccesback_to_Home() throws Exception {
		if (common_func.isElementPresent(footer.noAccessBack)) {
			common_func.ClickOnLink(footer.noAccessBack);
		}
	}

	@Then("User reaches to home page")
	public void User_Navigatesback_to_Home() throws Exception {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Marketplace - CCM"));
	}

	// acountdomains
	@Then("User clicks on account domains from account menu")
	public void User_AccDomain_AccMenu() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Account Domains").click();
	}

	@And("User verifies the presence of options of account menu from account domain page")
	public void User_Verifies_OptionOf_AccMenu() throws Exception {
		footer.VerifyOptionsAccountDomain();
		Thread.sleep(5000);
	}

	// acountInformation
	@Then("User clicks on account information from account menu")
	public void User_AccInfo_AccMenu() throws Exception {
		loginPage.clickOnAccountMenuButton();
		common_func.getOnLinkText("Account Information").click();
	}

	@And("User verifies the presence of options of account menu")
	public void User_Verifies_OptionOf_AccMenu_Options() throws Exception {
		footer.VerifyOptionAccountInfo();
		Thread.sleep(5000);
	}
}
