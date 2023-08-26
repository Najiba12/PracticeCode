package StepDefinitions;

import Pages.LoginPage;
import Pages.commonFunctions;
import Pages.footerPage;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Pages.PDPPage;
import Pages.TopLinksPages;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalSearchSteps extends basePage {
	LoginPage loginPage = new LoginPage();
	public WebDriver driver;
	PDPPage pdp = new PDPPage();
	commonFunctions common_func = new commonFunctions();
	footerPage footer = new footerPage();
	TopLinksPages top = new TopLinksPages();
	public WebDriverWait wait;

	@Then("User is taken to no result found page")
	public void User_is_Taken_to_No_Result_Found_Page() throws Exception {
		softAssertH.assertEquals(common_func.getText(footer.noResultMsg), "No Result Found");
	}

	@When("User types on global search tab {string}")
	public void User_Types_on_Global_Search_Tab(String string) throws Exception {
		common_func.GetSearchTab(string);
	}

	@Then("User clicks on dropdown options of prices")
	public void User_Clicks_Drop_Down_Option_for_Prices() throws Exception {
		common_func.ClickOnLink(footer.LstvwId);
	}

	@Then("User clicks on dropdown options of sizes")
	public void User_Clicks_Drop_Down_Options_for_Sizes() throws Exception {
		common_func.ClickOnLink(footer.GridViewId);
		Assert.assertEquals(footer.getGridVwCount().size() > 0, true,
				"After clicking on Grid View Icon the products are not displaying as Grid");
	}

	@And("User checks drop down option for prices")
	public void User_Checks_Drop_Down_Option_for_Prices() throws Exception {
		footer.DropDownForPrizes();
	}

	@And("User checks drop down options for sizes")
	public void User_Checks_DropDown_Options_for_Sizes() throws Exception {
		footer.DropDownForSizes();
	}

	@When("User scrolls down")
	public void User_is_Taken_to_Product_Page() throws Exception {
		common_func.Scrolls();
	}

	@Then("User clicks on Get Refresh button and create Estimate")
	public void User_Clicks_on_Get_Refresh_Button() throws Exception {
		top.ScrollsBy300();
		pdp.createEstimates();
	}

	@Then("User clicks on aref Get it now button")
	public void User_Clicks_onGet_button() throws Exception {
		Thread.sleep(7000);
		footer.getitnow.click();
	}

}