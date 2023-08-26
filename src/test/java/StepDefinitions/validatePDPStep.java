package StepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.AccountCreationPage;
import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.PDPPage;
import Pages.TopLinksPages;
import Pages.commonFunctions;
import Pages.footerPage;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validatePDPStep extends basePage {
	LoginPage loginPage = new LoginPage();
	PDPPage pdp = new PDPPage();
	FooterLoginPage foot = new FooterLoginPage();
	TopLinksPages top = new TopLinksPages();
	commonFunctions common_func = new commonFunctions();
	AccountCreationPage acc = new AccountCreationPage();
	footerPage footer = new footerPage();
	public WebDriverWait wait;
	Properties prop = new Properties();
	
	@Given("User checks environment and fetches id from database and visit estimate page")
	public void User_fetches_ID() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String env=prop.getProperty("env");
		String UserName = prop.getProperty("Dbun");
		String Password= prop.getProperty("dbpswd");
		String url = prop.getProperty("Database_URL");
		pdp.envFetchID(env, url, UserName, Password);
	}

	@Then("User verifies the page contains 404")
	public void User_is_Taken_to_404_Page() throws Exception {
		Assert.assertEquals(common_func.getText(footer.NotAccessible1), "404", "User able to access this page");
		Thread.sleep(5000);
	}

	@And("User clicks on no access")
	public void User_ClicksOn_NoAccess_Button() throws Exception {
		common_func.ClickOnLink(pdp.noaccessback);	}

	@Then("User checks environment and pass {string} to search bar of subscription page")
	public void User_Pass_Value_To_Subscription_SearchBar(String value) throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String env=prop.getProperty("env");
		if (env.contentEquals("uat")) {
			pdp.SearchSub.sendKeys(value);
			Thread.sleep(5000);
			pdp.SearchSub.sendKeys(Keys.ENTER);
		}
	}

	@And("User clicks on manage subscription button")
	public void User_ClicksOn_Manage_Subs() throws Exception {
		Thread.sleep(5000);
		common_func.ClickOnLink(pdp.add);
		top.ScrollsBy300();
	    common_func.ClickOnLink(pdp.mangesubscCTA);
	}

	@And("User clicks on view estimate")
	public void User_ClicksOn_View_Estimate() throws Exception {
		common_func.ClickOnLink(pdp.viewestimate);
	}

	@And("User verifies the presence of the other elements on the page")
	public void User_Verifies_Presence_Elemet() throws Exception {
		pdp.presenceElement();
	}

	@Then("User clicks on tool tip image and fetches the text")
	public void User_ClicksOn_Tooltip() throws Exception {
		pdp.Tooltip();
	}

	@Then("User checks the presence of elements")
	public void User_Checks_Other_Elemets() throws Exception {
		//pdp.otherElemets();
	}

	@Then("User navigates back")
	public void User_Navigates_Back() throws Exception {
		driver.navigate().back();
	}

	@And("User verifies presence of contact us")
	public void User_Verifies_ContactUs() throws Exception {
		common_func.getOnLinkText("Contact Us").isDisplayed();
	}

	@Then("User clears the textbox of CTA product")
	public void User_ClearsCTA_Product_QTY() throws Exception {
		pdp.prodQty1.sendKeys(Keys.CONTROL);
		pdp.prodQty1.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		pdp.prodQty1.clear();
	}

	@And("User fetches id from database and fetches seats from database and send it to CTA product")
	public void User_Fetches_Seats() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String UserName = prop.getProperty("Dbun");
		String Password= prop.getProperty("dbpswd");
		String url = prop.getProperty("Database_URL");
		pdp.fetchesSeats(url, UserName, Password);
	}

	@And("User press continue")
	public void User_Press_Continue() throws Exception {
		common_func.ClickOnLink(pdp.cont);
	}

	// partC
	@Then("User checks environment and fetches current seats and pass it to CTA product quantity")
	public void User_Fetches_Current_Seats() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/config/data.properties");
		prop.load(fis);
		String env=prop.getProperty("env");
		String UserName = prop.getProperty("Dbun");
		String Password= prop.getProperty("dbpswd");
		String url = prop.getProperty("Database_URL");
		top.ScrollsBy300();
		pdp.fetchCurrentSeats(env, url, UserName, Password);
	}

	@Then("User clicks on update")
	public void User_ClicksOn_Update_Button() throws Exception {
		common_func.ClickOnLink(pdp.User);
		Thread.sleep(5000);

	}

	@Then("User clicks on continue update")
	public void User_Continue_Update() throws Exception {
		common_func.ClickOnLink(pdp.contUp);
		Thread.sleep(5000);
	}

	@Then("User passes {string} to search bar of subscription page and User clicks on active and verifies the presence of element")
	public void User_Pass_Value_To_Subscription(String value) throws Exception {
		pdp.passValueClickOnActive(value);
	}
	//suspend
	@Then("User clicks on suspend button")
	public void user_ClicksOnSuspend() throws InterruptedException {
		Thread.sleep(5000);
		acc.suspenSub.click();
		Thread.sleep(5000);
		common_func.clickOnButton("Continue");
	}
	@Then("User clicks on cancel subscriptiohn button")
	public void user_ClicksOnCancel() throws InterruptedException {
		Thread.sleep(5000);
		common_func.getAreftext("Cancel Subscription").click();
		Thread.sleep(5000);
		common_func.clickOnButton("Continue");
		Thread.sleep(8000);
	}
	@And("User verifies if service is suspended")
	public void user_verifies_SuspendedService() throws InterruptedException {
		Thread.sleep(5000);
		if(acc.suspenSub.isEnabled()) {
			System.out.println("Enabled");
		}else {
			System.out.println("Disabaled");
		}
	}
	@And("User verifies if service is cancelled")
	public void user_verifies_CancelService() throws InterruptedException {
		Thread.sleep(10000);
		if(common_func.getAreftext("Cancel Subscription").isEnabled()) {
			System.out.println("Enabled");
		}else {
			System.out.println("Disabaled");
		}
	}
	@And("User clicks on manage subscription of an active service")
	public void User_Clicks_On_Active_Service() throws InterruptedException {
		common_func.Scrolls();
		pdp.Active.click();
		common_func.ClickOnLink(pdp.mangesubscCTA);
	}
	@And("User clicks on cancelled subscription")
	public void User_Clicks_On_Cancelled() throws InterruptedException {
		common_func.Scrolls();
		pdp.Cancelled.click();
		common_func.ClickOnLink(pdp.BuyItAgain);
		Thread.sleep(8000);
	}
	@And("User clicks on get it now")
	public void User_Clicks_On_GetItNow() throws InterruptedException {
		common_func.Scrolls();
		common_func.getAreftext("Get it Now").click();
		common_func.clickOnButton("Continue");
	}
}