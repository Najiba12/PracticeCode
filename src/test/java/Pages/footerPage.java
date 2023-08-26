package Pages;

import Utilities.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class footerPage {
	public WebDriver driver;
	Utility utility = new Utility();
	FooterLoginPage foot = new FooterLoginPage();
	public WebDriverWait wait;
	commonFunctions common_func = new commonFunctions();
	@FindBy(xpath = "/html/body/nav[3]/div/div/a[1]")
	public WebElement marketplace;
	@FindBy(xpath = "/html/body/nav[3]/div/div/a[3]")
	public WebElement Insight;
	@FindBy(xpath = "/html/body/nav[3]/div/div/a[2]")
	public WebElement Manage;
	@FindBy(xpath = "//div[4]//a[1]")
	public WebElement learnMore;
	@FindBy(xpath = "//section/div/div/div[2]/p")
	public WebElement textPage;
	@FindBy(xpath = "//*[@id=\"billingApp\"]/div/div/div[2]/p/a")
	public WebElement Invite;
	@FindBy(xpath = "//p[contains(text(),'Organization and Account Information is displayed below. Please update and save as needed. Please note: Some Organization information cannot be changed on this portal. Please ')]")
	public WebElement textpageinfo;
	@FindBy(id = "bt-products-list")
	public WebElement LstvwId;
	@FindBy(id = "bt-products-grid")
	public WebElement GridViewId;
	@FindBy(xpath = "//strong[contains(text(),'No Result Found')]")
	public WebElement noResultMsg;
	@FindBy(xpath = "//input[@id='main-search']")
	public WebElement SearchTab;
	@FindBy(linkText = "Logout")
	public WebElement logoutBtn;
	@FindBy(xpath = "/html/body/header/section/div/div/a")
	public WebElement noAccessBack;
	@FindBy(xpath = "//a[contains(text(),'Refresh Price')]")
	public WebElement Refresh;
	@FindBy(xpath = "//div[@class='shopping-cart']//a")
	public WebElement Notification;
	@FindBy(xpath = "//input[@id='settings_default_admin']")
	public WebElement show1;
	@FindBy(xpath = "//label[contains(text(),'Allow Request for Access and New Accounts')]")
	public WebElement show2;
	@FindBy(xpath = "//label[contains(text(),'Allow New Accounts, Do Not Allow Requests for Acce')]")
	public WebElement show3;
	@FindBy(xpath = "//label[contains(text(),'Allow Access Requests, Do Not Allow New Accounts')]")
	public WebElement show4;
	@FindBy(xpath = "//*[@class='col-md-4 col-sm-6 col-xs-12 grid-before-m']//div/p")
	public WebElement show5;
	@FindBy(xpath = "//input[@id='account_settings_1_1']")
	public WebElement banner1;
	@FindBy(xpath = "//select[@id='select_filter']")
	public WebElement selectFilter;
	@FindBy(xpath = "//select[@id='view_all']")
	public WebElement view_all;
	@FindBy(xpath = "//input[@id='CatalogRestrictions']")
	public WebElement catalogRestrictionInput;
	@FindBy(xpath = "//a[contains(text(),'Unrestricted')]")
	public WebElement unrestricted;
	@FindBy(xpath = "//a[contains(text(),'Restricted')]")
	public WebElement Restricted;
	@FindBy(xpath = "//fieldset/span/label")
	public WebElement Selectall_Catalog;
	@FindBy(xpath = "//div[3]/div/div[1]/span")
	public WebElement CSP;
	@FindBy(xpath = "//div[contains(@class,'pagination-total')]//span[contains(text(),'12')]")
	public WebElement Banner55;
	@FindBy(xpath = "//div[1]//span[1]//label[1]")
	public WebElement Checkbox;
	@FindBy(xpath = "//a[contains(@class,'btn btn-primary')]' and text()='Restrict']")
	public WebElement Restrict;
	@FindBy(xpath = "//a[contains(@class,'btn btn-primary')]' and text()='Cancel']")
	public WebElement Cancel_Catalog;
	@FindBy(xpath = "//input[@id='FirstName']")
	public WebElement firstname;
	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement lastname;
	@FindBy(xpath = "//input[@id='Phone']")
	public WebElement Phone;
	@FindBy(xpath = "//a[@class='btn edit xs-btn-auto']")
	public WebElement EditProfile_btn;
	@FindBy(xpath = "//form/div[3]/a[2]")
	public WebElement cancel_Myprofile;
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement save_Myprofile;
	@FindBy(xpath = "//fieldset[1]//label[1]//span[1]")
	public WebElement element1;
	@FindBy(xpath = "//fieldset[1]//label[1]")
	public WebElement element;
	@FindBy(xpath = "//option[contains(@value, '26')]")
	public WebElement options1pay;
	@FindBy(xpath = "//option[contains(@value, '02')]")
	public WebElement optionspay;
	@FindBy(xpath = "//img[@class='logo']")
	public WebElement logo;
	@FindBy(xpath = "//div[@class='user-container clearfix']//div[@class='right']//ul")
	public WebElement resultSet;
	@FindBy(xpath = "//div[@class='info-section profile-det']//ul")
	public WebElement resultSet1;
	@FindBy(xpath = "//h1[contains(text(),'Notifications')]")
	public WebElement Notification_heading;
	@FindBy(xpath = "//span[text()='All Notifications']")
	public WebElement All_Notification;
	@FindBy(xpath = "//span[contains(text(),'Flagged')]")
	public WebElement Flagged;
	@FindBy(xpath = "//span[contains(text(),'404')]")
	public WebElement NotAccessible1;
	@FindBy(xpath = "//select[@id='ddSort-by-dropdown']")
	WebElement SortDropDown;
	@FindBy(xpath = "//select[@id='ddSort-show']")
	WebElement SizeDd;
	@FindBy(xpath = "//div[5]/div/div/div/div/div/p/span")
	public WebElement alertmsg;
	@FindBy(xpath = "//div[@class='alert alert-danger ccp-alert-customer']")
	public WebElement alertdan;
	@FindBy(xpath = "//a[@class='btn pull-left form-save-cancel-btn' and text()='Cancel ']")
	public WebElement cancelchangepwd;
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	public WebElement notifcancel;
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement notifsave;
	@FindBy(xpath = "//*[@id=\"PaymentApp\"]/div[1]/div/div/div[2]/a")
	public WebElement ChangeBtn;
	@FindBy(id = "show-credit-card-iframe")
	public WebElement AddCreditBtn;
	@FindBy(xpath = "//a[contains(text(),'Save Card')]")
	public WebElement savecard;
	@FindBy(xpath = "//*[@class='edit-btn']/a[contains(text(),'Edit')]")
	public WebElement EditButtonAOU;
	@FindBy(xpath = "//div[@class=\"alert alert-danger ccp-alert-danger\"]")
	public WebElement alertdanger;
	@FindBy(xpath = "//*[@class='col-sm-12 formbtns-custom']/a[contains(text(),'Save')]")
	public WebElement UpdateButtonAOU;
	@FindBy(xpath = "//a[@class='btn' and text()='Cancel']")
	public WebElement cancel;
	@FindBy(id = "CCName")
	public WebElement ccid;
	@FindBy(xpath = "//*[@id=\"accountNumber\"]")
	public WebElement cardno;
	@FindBy(name = "expMonth")
	public WebElement cardexpiry1;
	@FindBy(id = "expYear")
	public WebElement cardexpiry2;
	@FindBy(id = "cvv")
	public WebElement cvv;
	@FindBy(xpath = "//span[@class='alert-msg']")
	public WebElement AlertmsgContact;
	@FindBy(xpath = "//a[@id='contact-submit']")
	public WebElement Contact_submit;
	@FindBy(xpath = "(//a[@class='btn btn-primary get-now-btn' and text()='Get it Now'])[2]")
	public WebElement getitnow;
	@FindBy(xpath = "(//a[ text()='Get it Now'])")
	public WebElement Firstgetitnow;
	@FindBy(xpath = "//a[contains(text(),'1-800-795-4444')]")
	WebElement show220;
	@FindBy(xpath = "//span[contains(text(),'Contact us for help with billing, sales orders, subscriptions or technical issues')]")
	WebElement show330;
	@FindBy(xpath = "//span[contains(text(),'Customer and Tech Support Team')]")
	WebElement show440;
	@FindBy(xpath = "//form/div[1]/div[3]/div[2]/span[3]")
	WebElement show11;
	@FindBy(xpath = "//form/div[1]/div[3]/div[2]/span[1]")
	WebElement show33;
	@FindBy(xpath = "//form/div[1]/div[3]/div[2]/span[2]")
	WebElement show44;
	@FindBy(xpath = "//form/div[1]/div[3]/div[2]/span[4]")
	WebElement show55;
	@FindBy(xpath = "//input[@id='fname']")
	WebElement show77;
	@FindBy(xpath = "//input[@id='lname']")
	WebElement show88;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement show99;
	@FindBy(xpath = "//input[@id='email']")
	WebElement show111;
	@FindBy(xpath = "//select[@id='standard_catalog']")
	WebElement show222;
	By GridVwCount = By.xpath("//a[@class='grid-control-icon icon-grid active']");
	By dropdown = By.xpath("//select[@id='ddSort-show']");
	public footerPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	public void ImagesDisplayed() {
		int counter = 0;
		if (common_func.isElementPresent(learnMore)) {
			List<WebElement> listImages = driver.findElements(By.tagName("img"));
			for (WebElement image : listImages) {
				if (image.isDisplayed()) {
					counter++;
				}
			}
			System.out.println("No. of total displace able images: " + counter);
		}
	}

	public void getSearchTab(String value) {
		utility.setText(SearchTab, value + Keys.ENTER);
	}

	public List<WebElement> getGridVwCount() {
		return driver.findElements(GridVwCount);
	}

	public void getContactUsDetails() throws Exception {

		if (common_func.isElementPresent(show55)) {
			if (show11.isDisplayed()) {
			}
			if (show33.isDisplayed()) {
			}
			if (show44.isDisplayed()) {
			}
		}

		if (show77.isDisplayed()) {
			if (show88.isDisplayed()) {
			}
			if (show99.isDisplayed()) {
			}
			if (show111.isDisplayed()) {
			}
			if (show222.isDisplayed()) {
			}
			common_func.Scrolls();
			if (show330.isDisplayed()) {
			}
			if (show440.isDisplayed()) {
			}
			if (show220.isDisplayed()) {
			}
		}
	}

	public WebElement dropdown() {
		return driver.findElement(dropdown);
	}

	public void ProvidePaymentCred() throws InterruptedException {
		common_func.getWebElement(ccid).sendKeys("Ayer Shuja");
		Thread.sleep(2000);
		driver.switchTo().frame("eProtect-iframe");
		common_func.getWebElement(cardno).sendKeys("4111 1111 1111 1111");
		Thread.sleep(2000);
		common_func.ClickOnLink(cardexpiry1);
		optionspay.click();
		Thread.sleep(4000);
		common_func.ClickOnLink(cardexpiry2);
		Thread.sleep(2000);
		options1pay.click();
		Thread.sleep(2000);
		common_func.getWebElement(cvv).sendKeys("1234");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

	public String getemailAlertmsg() throws InterruptedException {
		Actions toolAct = new Actions(driver);
		Thread.sleep(5000);
		toolAct.moveToElement(element).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath(
				"//span[@id='1']//div[@class='tooltip tt-text'][contains(text(),'You are not allowed to opt out of the email.')]"));
		String toolTipText = toolTipElement.getText();
		return (toolTipText);
	}

	public void ElementsAccountSetting() {
		if (common_func.isElementPresent(banner1)) {
			if (banner1.isSelected())
				System.out.print("selected");
		}
		if (!banner1.isSelected())
			banner1.click();
		if (common_func.isElementPresent(show2)) {
		}
		if (common_func.isElementPresent(show3)) {
		}
		if (common_func.isElementPresent(show4)) {
		}

	}


	public void CatalogRestrictions() {
		if (common_func.isElementPresent(Selectall_Catalog)) {
			if (common_func.isElementPresent(CSP)) {
				if (common_func.isElementPresent(Banner55)) {
					if (common_func.isElementPresent(Checkbox)) {
						common_func.ClickOnLink(Checkbox);
					}
				}
			}
			System.out.print("pass 54");
		}
		if (common_func.isElementPresent(catalogRestrictionInput)) {
			System.out.print("pass 543");
		}
		if (common_func.isElementPresent(unrestricted)) {
			System.out.print("pass 544");
			if (common_func.isElementPresent(Restricted)) {
				System.out.print("pass 545");
			}
		}
	}

	public void fetchDetail() {
		List<WebElement> options = resultSet.findElements(By.tagName("li"));
		for (WebElement li : options) {
			System.out.println(li.getText());
		}
		List<WebElement> options1 = resultSet1.findElements(By.tagName("li"));
		for (WebElement li1 : options1) {
			System.out.println(li1.getText());
		}
	}

	public void PassPhone(String value) {

		utility.setText(Phone, value);
	}

	public void PassFName(String value) {

		utility.setText(firstname, value);
	}

	public void PassLName(String value) {

		utility.setText(lastname, value);
	}

	public void DropDownForPrizes() throws InterruptedException {
		Select search = new Select(SortDropDown);
		String defact = search.getFirstSelectedOption().getText();
		Assert.assertEquals(defact, "Best match", "Best Match Option is not Selected as Default");
		String DropdownOptionsExp[] = { "Best match", "Price: Low to High", "Price: High to Low" };

		for (int i = 0; i < 1; i++) {
			search.selectByValue("name");
			Thread.sleep(5000);
			Assert.assertEquals(search.getFirstSelectedOption().getText().trim(), DropdownOptionsExp[i],
					"The Options appearing insight the sorting Dropdown are not same as expected");
			System.out.println(DropdownOptionsExp[i]);
		}
	}

	public void DropDownForSizes() throws InterruptedException {
		Select se1 = new Select(SizeDd);
		String defsize = se1.getFirstSelectedOption().getText();
		Assert.assertEquals(defsize, "12", "12 Option is not appearing selected as default on the size dropdown");
		String SizeDropdownExp[] = { "12", "24", "36", "48" };
		List<WebElement> options = dropdown().findElements(By.tagName("option"));
		System.out.println("size" + options.size());
		for (int i = 0; i < options.size(); i++) {
			se1.selectByValue(SizeDropdownExp[i]);
			Assert.assertEquals(options.get(i).getText(), SizeDropdownExp[i],
					"The Options appearing insight the size Dropdown are not same as expected");
		}
	}

	public void VerifyOptionAccountInfo() {
		if (common_func.isElementPresent(common_func.getOnLinkText("My Profile"))) {
			if (common_func.isElementPresent(common_func.getOnLinkText("Notification Management"))) {
				if (common_func.isElementPresent(common_func.getOnLinkText("Payment Method"))) {
					if (common_func.isElementPresent(common_func.getOnLinkText("User Management"))) {
						if (common_func.isElementPresent(textpageinfo)) {
						}
					}
				}
			}
		}
		if (common_func.isElementPresent(common_func.getOnLinkText("Account Domains"))) {
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Information"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Settings"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Address of Use"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Catalog Restrictions"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Change Password"))) {
			}
		}
	}

	public void VerifyOptionAccountInfoFromAccMenu() {
		if (common_func.isElementPresent(common_func.getOnLinkText("My Profile"))) {
			System.out.println(common_func.getOnLinkText("My Profile").getText());
			if (common_func.isElementPresent(common_func.getOnLinkText("Notification Management"))) {
				System.out.println(common_func.getOnLinkText("Notification Managmenet").getText());
				if (common_func.isElementPresent(common_func.getOnLinkText("Payment Method"))) {
					System.out.println(common_func.getOnLinkText("Payment Method").getText());
					if (common_func.isElementPresent(common_func.getOnLinkText("User Management"))) {
						System.out.println(common_func.getOnLinkText("User Managmenet").getText());
					}
				}
			}
		}
		if (common_func.isElementPresent(common_func.getOnLinkText("My Profile"))) {
			System.out.println(common_func.getOnLinkText("My Profile").getText());
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Information"))) {
				System.out.println(common_func.getOnLinkText("Account Information").getText());
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Settings"))) {
				System.out.println(common_func.getOnLinkText("Account Settings").getText());
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Address of Use"))) {
				System.out.println(common_func.getOnLinkText("Address of Use").getText());
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Catalog Restrictions"))) {
				System.out.println(common_func.getOnLinkText("Catalog Restrictions").getText());
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Change Password"))) {
				System.out.println(common_func.getOnLinkText("Change Password").getText());
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Budget"))) {
				System.out.println(common_func.getOnLinkText("Budget").getText());
			}
		}
	}

	public void VerifyOptionsAccountDomain() {
		if (common_func.isElementPresent(common_func.getOnLinkText("My Profile"))) {
			if (common_func.isElementPresent(common_func.getOnLinkText("Notification Management"))) {
				if (common_func.isElementPresent(common_func.getOnLinkText("Payment Method"))) {
					if (common_func.isElementPresent(common_func.getOnLinkText("User Management"))) {
						if (common_func.isElementPresent(textPage)) {
							common_func.ClickOnLink(Invite);
							Assert.assertEquals(driver.getTitle(), "User Management - CCM",
									"User not able to land to the UM invite page");
						}
					}
				}
			}
		}
		if (common_func.isElementPresent(common_func.getOnLinkText("Account Domains"))) {
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Information"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Account Settings"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Address of Use"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Catalog Restrictions"))) {
			}
			if (common_func.isElementPresent(common_func.getOnLinkText("Change Password"))) {
			}
		}
	}

	public boolean isFooterLinkPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOf(common_func.getAreftext("Help")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getAreftext("Accessibility")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getOnLinkText("Contact Us")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getOnLinkText("Privacy Policy")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getAreftext("About Connection")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getAreftext("About CCM")));
			wait.until(ExpectedConditions.visibilityOf(common_func.getOnLinkText("Terms of Use")));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isTopLinkPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOf(marketplace));
			wait.until(ExpectedConditions.visibilityOf(Insight));
			wait.until(ExpectedConditions.visibilityOf(Manage));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
