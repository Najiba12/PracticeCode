package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utilities.basePage;

public class TopLinksPages extends basePage {
	// Utility utility = new Utility();
	public WebDriver driver;
	public WebDriverWait wait;
	footerPage footer = new footerPage();
	PDPPage pdp = new PDPPage();
	commonFunctions common_func = new commonFunctions();

	public TopLinksPages() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement Logo;
	@FindBy(xpath = "//section/section/ul/li[1]/a")
	public WebElement UserTab;
	@FindBy(xpath = "//section[@class='featured-ads container clearfix']")
	public WebElement DFP_Banner;
	@FindBy(xpath = "//a[@class='btn btn-primary left-btn']")
	public WebElement applysub;
	@FindBy(xpath = "//a[contains(@class,'reports')][contains(text(),'Subscriptions')]")
	public WebElement sub;
	@FindBy(xpath = "//div[@class='filter-search-drop-arrow'][1]")
	public WebElement col1stdropdown1;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'SKU ID')]")
	public WebElement sku;
	@FindBy(xpath = "//a[contains(@class,'reports')][contains(text(),'Signed Agreements')]")
	public WebElement sa;
	@FindBy(xpath = "//footer/section[1]/div[2]/ul[3]/li[7]/a")
	public WebElement FsignedAgreement;
	@FindBy(xpath = "//select[@id='date[created_at][timePeriod][input]']")
	public WebElement timeperiod;
	@FindBy(xpath = "//*[@id=\"date[created_at][fromUnit][input]\"]")
	public WebElement from;
	@FindBy(xpath = "//*[@id=\"date[created_at][toUnit][input]\"]")
	public WebElement to;
	@FindBy(xpath = "//select[@id='options']")
	public WebElement exportoptions;
	@FindBy(xpath = "//input[@name='email_addresses']")
	public WebElement emailbox;
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	public WebElement SendBtn;
	@FindBy(xpath = "//input[@id='current_page']")
	public WebElement currpage;
	@FindBy(xpath = "//div[2]/div/div/div[3]/button[2]")
	public WebElement exportcancel;
	@FindBy(xpath = "//button[contains(text(),'Export Report')]")
	public WebElement exportreport;
	@FindBy(xpath = "//a[@id='export']")
	public WebElement export;
	@FindBy(xpath = "//a[contains(text(),'Clear/Reset All')]")
	public WebElement clearresetall;
	@FindBy(xpath = "//a[contains(text(),'Unselect All')]")
	public WebElement unselectall;
	@FindBy(xpath = "//a[@class='btn left-btn' and text()='Select All']")
	public WebElement selectall;
	@FindBy(xpath = "//h1[@class='ccp-m-heading']")
	public WebElement Heading;
	@FindBy(xpath = "(//span[@class='step-title'])[1]")
	public WebElement Step1Title;
	@FindBy(xpath = "(//span[@class='step-title'])[2]")
	public WebElement Step2Title;
	@FindBy(id = "ExpectedUsers")
	public WebElement ExpectedUserLink;
	@FindBy(xpath = "//div[2]/div[5]/a[1]")
	public WebElement ContinueBtn;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	public WebElement ContinueBtn1;
	@FindBy(xpath = "//a[@class='btn btn-primary' and text()='Save & Continue']")
	public WebElement savecont;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	public WebElement showres;
	@FindBy(xpath = "//a[@class='top-link' and text()='Applications']")
	public WebElement Application_Link;
	@FindBy(xpath = "//a[@class='top-link' and text()='Infrastructure']")
	public WebElement Infrastructure_Link;
	@FindBy(xpath = "//a[@class='top-link' and text()='Platforms']")
	public WebElement Platform_Link;
	@FindBy(xpath = "//a[text()='Reports']")
	public WebElement ReportsTab;
	@FindBy(xpath = "//a[@class='users ' and text()='SETUP']")
	public WebElement UsersTab;
	@FindBy(xpath = "//a[@class='top-link' and text()='Discover']")
	public WebElement Discover1;
	@FindBy(id = "Load_Balancers")
	public WebElement LoadBalance;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/button")
	public WebElement close;
	@FindBy(xpath = "//label[contains(text(),'I need my solution delivered and managed from a ce')]")
	public WebElement Chkbox1;
	@FindBy(xpath = "//label[contains(text(),'I need the solution accessible to my users on the')]")
	public WebElement Chkbox2;
	@FindBy(xpath = "//label[contains(text(),'Provide users with tools to create, maintain,and collaborate documents data analysis and presentations')]")
	public WebElement Chkbox11;
	@FindBy(xpath = "//label[contains(text(),'Enable team collaboration and communication')]")
	public WebElement Chkbox22;
	@FindBy(xpath = "//label[contains(text(),'I need self-service, on-demand, automated deployme')]")
	public WebElement Chkbox111;
	@FindBy(xpath = "//label[contains(text(),'I need full control of my infrastructure while pur')]")
	public WebElement Chkbox222;
	@FindBy(xpath = "//select[@id='instance_type']")
	public WebElement instance;
	@FindBy(xpath = "//select[@id='contract_duration']")
	public WebElement duration;
	@FindBy(xpath = "//p[contains(text(),'Your preferences did not match any service, please')]")
	public WebElement pref;
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	public WebElement edit;
	@FindBy(xpath = "//select[@id='BillingType']")
	public WebElement btype;
	@FindBy(xpath = "//li[1]//label[1]//span[2]")
	public WebElement APCRow;
	@FindBy(xpath = "//tr[3]/td[1]/span/fieldset/legend/label")
	public WebElement reqpurpoe;
	@FindBy(xpath = "//a[@class='btn btn-primary pull-right request-proposal-btn']")
	public WebElement reqpurpbtn;
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	public WebElement btnprimaryreqpurposal;
	@FindBy(xpath = "//textarea[@id='ad_information']")
	public WebElement textarea;
	@FindBy(xpath = "//*[@class='tabsec-box ccp-form-step  clearfix']")
	public WebElement DescribeYourBusiness;
	@FindBy(xpath = "//*[@class='cont-steps sticky-rightbox-fixed left-menu']")
	public WebElement RightBoxleftMenu;
	@FindBy(xpath = "//*[@id='cart-step-1']")
	public WebElement DescribeYourNeed;
	@FindBy(xpath = "//li[@class='selection-category']//span")
	public WebElement str1;
	@FindBy(xpath = "//*[@id='_requestDetail']")
	public WebElement CustomeServiceRequest;
	@FindBy(xpath = "//*[@class='contactFormCont']//a[contains(text(),'Submit')]")
	public WebElement CustomeServiceRequestSubmitBtn;
	@FindBy(xpath = "//a[@class='top-link' and text()='Calendar']")
	public WebElement Calendar;
	@FindBy(xpath = "//a[@class='top-link' and text()='Subscriptions']")
	public WebElement Subscription;
	@FindBy(xpath = "//a[@class='top-link' and text()='Usage']")
	public WebElement Usage_Link;
	@FindBy(xpath = "//button[@id='subscribe-btn']")
	public WebElement subscribecal;
	@FindBy(xpath = "//div[@id='spendByMfg-wrapper']//a[@class='action-link expand'][contains(text(),'Expand')]")
	public WebElement expand;
	@FindBy(xpath = "//th[2]/div/div[3]")
	public WebElement Column1stDropdown;
	@FindBy(xpath = "//a[@class='action-link expand'][contains(text(),'Collapse')]")
	public WebElement collapse;
	@FindBy(xpath = "//div[@id='spendByMfg-wrapper']//select[@id='spendByMfg-range-select']")
	public WebElement dropdownprov;
	@FindBy(xpath = "//div[@id='savingsByMfg-wrapper']//select[@id='savingsByMfg-range-select']")
	public WebElement dropdownservice;
	@FindBy(id = "CalendarYear")
	public WebElement calyear;
	@FindBy(xpath = "//div[@id='yearOverYearSpend-wrapper']//select[@id='yearOverYearSpend-range-select']")
	public WebElement dropdowntype;
	@FindBy(xpath = "//div[@id='yearOverYearSpend2-wrapper']//select[@id='yearOverYearSpend2-range-select']")
	public WebElement dropdowncategory;
	@FindBy(xpath = "//li//label[contains(text(),'Provider Name')]//span")
	public WebElement proviname;
	@FindBy(xpath = "//li//label[contains(text(),'Service Name')]//span")
	public WebElement servename;
	@FindBy(xpath = "//li//label[contains(text(),'Provider ID')]//span")
	public WebElement provid;
	@FindBy(xpath = "//input[@id='SelectFieldsToDisplay']")
	public WebElement searchdisplay;
	@FindBy(xpath = "//div[3]/div/div/div/div[3]/button[1]")
	public WebElement apply;
	@FindBy(xpath = "//div/section[3]/a[2]")
	public WebElement apply3;
	@FindBy(xpath = "//a[@class='btn btn-primary left-btn']")
	public WebElement applysign;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	public WebElement applyauditlog;
	@FindBy(xpath = "//div[3]/div/div/div/div[3]/button[1]")
	public WebElement applyfield;
	@FindBy(xpath = "//label[@class='drag-handle sort-arrow descend']")
	public WebElement bill;
	@FindBy(xpath = "//label[@class='drag-handle sort-arrow descend']")
	public WebElement show0;
	@FindBy(xpath = "//label[contains(text(),'Provider ID')]")
	public WebElement show;
	@FindBy(xpath = "//label[contains(text(),'Provider Name')]")
	public WebElement show1;
	@FindBy(xpath = "//label[contains(text(),'Service Name')]")
	public WebElement show2;
	@FindBy(xpath = "//label[@class='drag-handle sort-arrow none'][contains(text(),'Provider ID')]")
	public WebElement billprovid;
	@FindBy(xpath = "//label[@class='drag-handle sort-arrow none'][contains(text(),'Provider Name')]")
	public WebElement billproviname;
	@FindBy(xpath = "//footer/section[1]/div[2]/ul[3]/li[5]/a")
	public WebElement auditlog;
	@FindBy(xpath = "//a[contains(@class,'reports')][contains(text(),'Invoice Details')]")
	public WebElement billline;
	@FindBy(xpath = "//footer/section[1]/div[2]/ul[3]/li[9]/a")
	public WebElement Fbillline;
	@FindBy(xpath = "//table[@class='mobile-table']/thead/tr/th[4]/div[1]/div[1]")
	public WebElement filtersearchicon;
	@FindBy(xpath = "//*[@id=\"selectFields\"]")
	public WebElement selectfields;
	@FindBy(xpath = "//th[4]//div[1]//div[3]//div[1]//div[1]//div[2]//a[2]")
	public WebElement apply1;
	@FindBy(xpath = "//input[@id='Provider Nameprovider_name']")
	public WebElement billprovidernamesearch;
	@FindBy(xpath = "//a[contains(@class,'reports')][contains(text(),'Invoices')]")
	public WebElement bills;
	@FindBy(xpath = "//footer/section[1]/div[2]/ul[3]/li[10]/a")
	public WebElement Fbills;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Billing Month')]")
	public WebElement skubill;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Subscription Name')]")
	public WebElement skubillLine;
	@FindBy(xpath = "//a[contains(@class,'reports')][contains(text(),'Orders')]")
	public WebElement Orders;
	@FindBy(xpath = "//*[@id=\"purchase_order\"]")
	public WebElement PurchaseOrder;
	@FindBy(xpath = "//th[4]//div[1]//div[3]//div[1]//div[1]//div[2]//a[2]")
	public WebElement applybill;
	@FindBy(xpath = "(//div[@class='filter-search-drop-arrow'])[3]")
	public WebElement Column1stDropdownOrder;
	@FindBy(id = "UserManagement")
	public WebElement SearchBox;
	By Dropdown = By.id("Users_Rights12");
	@FindBy(xpath = "//a[text()='Invites ']")
	public WebElement InvitesTab;
	@FindBy(id = "email_address")
	public WebElement emailtextbox;
	@FindBy(xpath = "//a[@class='btn btn-primary pull-left']")
	public WebElement InviteBtn;
	@FindBy(xpath = "//a[@class='btn btn-primary pull-left' and @tabindex='3']")
	public WebElement Invite2Btn;
	@FindBy(xpath = "//a[text()='Cancel Invite']")
	public WebElement CancelInvite;
	@FindBy(xpath = "//ul/li[1]/div/div[1]/div[3]/a")
	public WebElement resendinv;
	@FindBy(xpath = "//a[text()='Save']")
	public WebElement SaveBtn;
	@FindBy(name = "terms")
	public WebElement ServiceSearch;
	@FindBy(xpath = "//a[text()=' Restricted ']")
	public WebElement Restricted;
	@FindBy(xpath = "//a[text()='Unrestricted']")
	public WebElement Unrestricted;
	@FindBy(xpath = "//a[text()='Unrestrict']")
	public WebElement Unrestrict;
	@FindBy(xpath = "//span[text()='Catalog restrictions saved successfully']")
	public WebElement UnRestrictSuccessMsg;
	@FindBy(xpath = "(//span[@class='checkbox checkbox-primary sel-all'])[1]")
	public WebElement CheckBox;
	@FindBy(xpath = "//a[text()='Restrict']")
	public WebElement Restrict;
	@FindBy(xpath = "//div[@class='ccp-form-success']")
	public WebElement SucessMsg;
	@FindBy(xpath = "//label[text()='Select All']")
	public WebElement SelectAll;
	@FindBy(xpath = "//span[@class='btn btn-default btn-file']")
	public WebElement BrowseBtn;
	@FindBy(xpath = "//*[@id=\"AccountSettings\"]/div/div[3]/div[5]/div/a[1]")
	public WebElement SaveChanges;
	@FindBy(xpath = "//span[text()='Settings saved successfully']")
	public WebElement SuccessMsg;
	@FindBy(xpath = "//div/div/div[1]/a")
	public WebElement RequestAddressBtn;
	@FindBy(id = "address_line_1")
	public WebElement AddressField;
	@FindBy(id = "city")
	public WebElement City;
	@FindBy(id = "address_line_1")
	public WebElement address;
	@FindBy(id = "state")
	public WebElement State;
	@FindBy(id = "zip_code")
	public WebElement Zip_Code;
	@FindBy(id = "phone")
	public WebElement Phone;
	@FindBy(xpath = "//*[@id=\"billingApp\"]/div/div/div/div[4]/div/div[4]/div/fieldset/div/div/a[1]")
	public WebElement SubmitBtn;
	@FindBy(xpath = "//span[@class='alert-msg']")
	public WebElement ValidationMsg;
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement Validation_Message;
	@FindBy(xpath = "//div[@class='product-list-grid clearfix grid']")
	public WebElement RecordList;
	@FindBy(xpath = "//a[text()='Requests ']")
	public WebElement RequestTab;
	@FindBy(xpath = "//a[@href='#RequestUsers' and @class = 'active']")
	public WebElement RequestActive;
	@FindBy(xpath = "//span[@class='alert-msg']")
	public WebElement alert;
	@FindBy(xpath = "//*[@class='hero-banner']//img[@alt='hero-banner']")
	public WebElement banner;
	@FindBy(xpath = "//*[@id='ddSort-by-dropdown']")
	public WebElement SortBy;
	@FindBy(xpath = "//*[@class='bar-shadow']")
	public WebElement BarShadow;
	@FindBy(xpath = "//*[@id='ddSort-show']")
	public WebElement Pagination;
	@FindBy(xpath = "//*[@id='bt-products-grid']")
	public WebElement Grid;
	@FindBy(xpath = "//*[@id='bt-products-list']")
	public WebElement List;
	@FindBy(xpath = "//*[@id='product-list-menu']")
	public WebElement ProductListMenu;
	@FindBy(xpath = "//*[@class='product-menu-item selections active']")
	public WebElement Selections;
	@FindBy(xpath = "//*[@class='product-menu-item refine']")
	public WebElement RefineBy;
	@FindBy(xpath = "//*[@class='product-list-content']")
	public WebElement ProductListContent;
	@FindBy(xpath = "//*[@class='product-grid-item clearfix']")
	public WebElement ProductListItem;
	@FindBy(xpath = "//*[@class='className pagination light-theme simple-pagination pagination-list-report']")
	public WebElement PaginationList;
	@FindBy(xpath = "//*[@id='recently-viewed-listing']")
	public WebElement RecentlyViewedListing;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(xpath = "//*[@id='manage-content']/div[1]/section/div[2]/div/div[1]/ul/li[3]/div[1]/a[1]")
	public WebElement element2;
	@FindBy(xpath = "//*[@id='product-list-menu']//label[contains(text(),'Analytics')]/span")
	public WebElement AnalyticsCheck;
	@FindBy(xpath = "//*[@id='product-list-menu']/div[3]/div[1]/div/div/a")
	public WebElement Apply;
	@FindBy(xpath = "//*[@id='product-list-menu']/div[3]/div[2]/div/div/a")
	public WebElement accMenu2;
	@FindBy(xpath = "//li[@class='selection-category']//a")
	public WebElement ClearIcon;
	@FindBy(xpath = "//div[2]/div/ul/li/label")
	public WebElement IndustryTypeBusiness;
	@FindBy(xpath = "//div[4]/div/ul/li/label")
	public WebElement IaasText;
	@FindBy(xpath = "//section[2]/div[1]/div[3]/div[4]/div/div/a")
	public WebElement accMenu4;
	@FindBy(xpath = "(//*[@class='product-grid-item clearfix'])[1]//div[@class='cart-container clearfix']//a")
	public WebElement GetItNowPD;
	@FindBy(xpath = "//a[@class='btn disabled' and @id='estimates']")
	public WebElement estimate;
	@FindBy(xpath = "//th[6]//div[1]//div[3]//div[1]//div[1]//div[2]//a[2]")
	public WebElement applytenant;
	@FindBy(xpath = "//th[6]//div[1]//div[3]")
	public WebElement tenant;
	@FindBy(xpath = "//h2[@class='section-title' and text()='Subscription History']")
	public WebElement subhistory;
	@FindBy(xpath = "//nav[4]/div[2]/ul/li[2]/a")
	public WebElement comparativeAnalysis;
	@FindBy(xpath = "//body/div[1]/div[1]/div/div[2]/p")
	public WebElement comparativeAnalysisDetail;
	@FindBy(xpath = "//*[@class=\"form-control ccp-txtbox col-sm-3 col-md-2\"]")
	public WebElement ByTime;
	@FindBy(xpath = "//*[@class=\"form-control ccp-txtbox col-sm-3\"]")
	public WebElement ByIndustry;
	@FindBy(xpath = "//*[@id=\"caGraph\"]")
	public WebElement Graph;
	@FindBy(xpath = "//div/div[3]/div[1]/div/div[1]/span/span")
	public WebElement button;
	@FindBy(xpath = "//div/div[3]/div[2]/div/h2")
	public WebElement EmployeeSize;
	@FindBy(xpath = "//div[1]/div/div[3]/div[1]/div/h2")
	public WebElement IndustryType;
	@FindBy(xpath = "//div/div[2]/div[3]/div/span[2]")
	public WebElement addofuse;
	@FindBy(xpath = "//div[1]/div/div[2]/div[4]/div/span[2]")
	public WebElement payment;
	By createestimate = By.xpath("//a[@class='btn' and @id='estimates']");
	By Products = By.xpath("//a[@alt='product-detail']");
	public void GotoProviderPortal() throws InterruptedException {
			Thread.sleep(5000);
			common_func.getOnLinkText("Contact Us").click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='OrderApp']/div[3]//textarea")).sendKeys("Automation Testing");
			Thread.sleep(5000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='OrderApp']/div[3]//a[contains(text(),'Submit')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='OrderApp']/div[3]//a[contains(text(),'Cancel')]")).click();
		
	}

	public void getEstimate() throws InterruptedException {
		if (common_func.isElementPresentBy(createestimate)) {
			System.out.print("enabled");
			((WebElement) createestimate).click();
			Thread.sleep(7000);
			common_func.clickOnButton("Cancel");
		} else {
			System.out.println("not available");
		}
	}

	public void ContactUsCTA() throws InterruptedException {
		if (common_func.isElementPresent(common_func.getOnLinkText("Contact Us"))) {
			common_func.getOnLinkText("Contact Us").click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='OrderApp']/div[3]//textarea")).sendKeys("Automation Testing");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='OrderApp']/div[3]//a[contains(text(),'Submit')]")).click();
			Thread.sleep(5000);
		}
	}

	public void checksHeading() {
		String str = str1.getText();
		if (str.length() > 5)
			str = str.substring(0, 4);
		System.out.println(str);
		Assert.assertEquals(str, "IaaS");
	}

	public void checksHeadingPaas() {
		String str = driver.findElement(By.xpath("//li[@class='selection-category']//span")).getText();
		if (str.length() > 5)
			str = str.substring(0, 4);
		System.out.println(str);
		Assert.assertEquals(str, "PaaS");
	}

	public void checksCurrentUrl() throws InterruptedException {
		wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.titleContains("User Migration Bundle - CCM"));
		// Thread.sleep(10000);
		System.out.println("c");
		Thread.sleep(5000);
		String URL = driver.getCurrentUrl();
		if (URL.contains("product-detail")) {
			pdp.getitNow.click();
			System.out.println("d");
		} else {
			System.out.println("Invalid");
		}
		driver.navigate().back();
	}

	public void checksCurrentUrlRedirection(String page) throws InterruptedException {
		wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.titleContains("User Migration Bundle - CCM"));
		String URL = driver.getCurrentUrl();
		if (URL.contains("product-detail")) {
			Thread.sleep(5000);
			pdp.getitNow.click();
			String URLP = driver.getCurrentUrl();
			if (URL.contains("procurement")) {
				wait.until(ExpectedConditions.titleContains(page));
				Assert.assertEquals(driver.getTitle(), page);
			}
		} else {
			System.out.println("Invalid");
		}
		//Thread.sleep(5000);
		//driver.navigate().back();
	}

	public void checksGetitNow() {
		System.out.println("a");
		String str1 = GetItNowPD.getText();
		if (str1.length() > 10)
			str1 = str1.substring(0, 10);
		Assert.assertEquals(str1, "Get it Now");
	}

	public void CheckSubHistory() throws InterruptedException {
		Thread.sleep(5000);
		if (common_func.isElementPresent(subhistory)) {
			System.out.print("history table present");
		}
	}

	public void getAppSelected() {
		String[] stringArray = new String[] { "SKU ID #: 41319339", "SKU ID #: 41319336", "SKU ID #: 41319335",
				"SKU ID #: 41319334", "SKU ID #: 41319624", "SKU ID #: 41319623", "SKU ID #: 41319622",
				"SKU ID #: 41319621", "SKU ID #: 41319358", "SKU ID #: 41319357", "SKU ID #: 41319356",
				"SKU ID #: 41319355" };
		List<WebElement> myList = driver.findElements(By.xpath("//*[@class='part-number'][contains(text(),'SKU ID')]"));
		List<String> all_elements_text = new ArrayList();
		for (int i1 = 0; i1 < myList.size(); i1++) {
			boolean found = false;
			for (String x : stringArray) {
				if (x.equals(all_elements_text.add(myList.get(i1).getText()))) {
					found = true;
					break;
				}
			}
			System.out.println(found);
		}
	}

	public List<WebElement> getProducts() {
		return driver.findElements(Products);
	}

	public void purchaseOrder() throws InterruptedException {
		//common_func.ClickOnLink(unselectall);
		common_func.ClickOnLink(PurchaseOrder);
		Thread.sleep(2000);
		common_func.clickOnButton("Apply");
	}

	public void SelectSub() throws InterruptedException {
		if (common_func.getWebElement(skubillLine).isSelected()) // if Checked
		{
		}
		common_func.ClickOnLink(unselectall);
		if (!common_func.getWebElement(skubillLine).isSelected()) // if unChecked
		{
		}
		common_func.ClickOnLink(selectall);
		if (common_func.getWebElement(skubillLine).isSelected()) // if Checked
		{
		}
		common_func.ClickOnLink(unselectall);
		common_func.ClickOnLink(skubillLine);
		common_func.clickOnButton("Apply");
	}

	public void SelectBilling() throws InterruptedException {
		if (common_func.getWebElement(skubill).isSelected()) // if Checked
		{
		}
		common_func.ClickOnLink(unselectall);
		if (!common_func.getWebElement(skubill).isSelected()) // if unChecked
		{
		}
		Thread.sleep(5000);
		common_func.ClickOnLink(selectall);
		if (common_func.getWebElement(skubill).isSelected()) // if Checked
		{
		}
		common_func.ClickOnLink(unselectall);
		common_func.getWebElement(skubill).click();
		common_func.clickOnButton("Apply");
	}

	public boolean isElementPresentBy(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void matchHeaders(String[] strArray) throws IOException, InterruptedException {
		for (int i = 0; i < strArray.length; i++) {
			By show0 = By.xpath(strArray[i]);
			if (isElementPresentBy(show0)) {
			}
		}
	}

	public void ReportsOption() throws IOException, InterruptedException {
		String SizeDropdownExp[] = { "//label[@class='drag-handle sort-arrow none'][contains(text(),'Date')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'Time')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'User')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'Action')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'Action Type')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'IP')]",
				"//label[@class='drag-handle sort-arrow none'][contains(text(),'Browser')]" };
		matchHeaders(SizeDropdownExp);
	}

	public void checkPresenceSelected() {
		if (common_func.isElementPresent(show)) {
			System.out.print("Show prov id");
		}
		if (common_func.isElementPresent(show1)) {
			System.out.print("Show prov name");
		}
	}
	public void checkPresenceSelectedField() {
		if (common_func.isElementPresent(show2)) {
			System.out.print("Show service name");
		}
		if (common_func.isElementPresent(show1)) {
			System.out.print("Show prov name");
		}
	}

	public void ProviderSelected() {
		if (common_func.getWebElement(proviname).isSelected()) // if Checked
		{
			if (provid.isSelected()) // if Checked
			{
				System.out.print("checked");
			}
		}
	}

	public void ProviderUnSelected() {
		if (!common_func.getWebElement(proviname).isSelected()) // if unChecked
		{
			if (!common_func.getWebElement(provid).isSelected()) // if unChecked
			{
				System.out.print("unchecked1");

			}
		} else {
			System.out.print("checked");
		}
	}

	public void ProviderNameUnSelected() {
		if (!common_func.getWebElement(proviname).isSelected()) // if unChecked
		{
			System.out.print("checked");
		}

	}

	public void ProviderServiceUnSelected() {
		if (!common_func.getWebElement(proviname).isSelected()) // if unChecked
		{
			if (!common_func.getWebElement(servename).isSelected()) // if unChecked
			{
				System.out.print("unchecked1");

			}
		} else {
			System.out.print("checked");
		}
	}

	public int getcountexpand() {
		java.util.List<WebElement> getnow = driver.findElements(By.xpath(
				"//div[@id='CostPorjection-wrapper']//a[@class='action-link expand'][contains(text(),'Expand')]"));
		return getnow.size();
	}

	public void ScrollsBy300() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 300)");
	}

	public int getcountdrag() {
		java.util.List<WebElement> getnow = driver
				.findElements(By.xpath("//div[@id='CostPorjection-wrapper']//span[@class='action-link drag']"));
		return getnow.size();
	}

	public void SpendProvider() throws InterruptedException {
		Select search = new Select(common_func.getWebElement(dropdownprov));
		String SizeDropdownExp[] = { "Last 12 Months", "Last 3 Months", "Previous Quarter", "Current Year",
				"Previous Year", "All Time" };
		for (int p = 0; p < 6; p++) {
			search.selectByIndex(p);
			Thread.sleep(2000);
			Assert.assertEquals(search.getFirstSelectedOption().getText().trim(), SizeDropdownExp[p],
					"The Options appearing insight the  Dropdown are not same as expected");
		}
	}

	public void Type() throws InterruptedException {
		Select search = new Select(common_func.getWebElement(dropdowntype));
		String SizeDropdownExp[] = { "Last 12 Months", "Last 3 Months", "Previous Quarter", "Current Year",
				"Previous Year", "All Time" };
		for (int p = 0; p < 6; p++) {
			search.selectByIndex(p);
			Thread.sleep(2000);
			Assert.assertEquals(search.getFirstSelectedOption().getText().trim(), SizeDropdownExp[p],
					"The Options appearing insight the  Dropdown are not same as expected");
		}
	}

	public void Category() throws InterruptedException {
		Select search = new Select(common_func.getWebElement(dropdowncategory));
		String SizeDropdownExp[] = { "Last 12 Months", "Last 3 Months", "Previous Quarter", "Current Year",
				"Previous Year", "All Time" };
		for (int p = 0; p < 6; p++) {
			search.selectByIndex(p);
			Thread.sleep(3000);
			Assert.assertEquals(search.getFirstSelectedOption().getText().trim(), SizeDropdownExp[p],
					"The Options appearing insight the  Dropdown are not same as expected");
		}
	}

	public void Service() throws InterruptedException {
		Select search = new Select(common_func.getWebElement(dropdownservice));
		String SizeDropdownExp[] = { "Last 12 Months", "Last 3 Months", "Previous Quarter", "Current Year",
				"Previous Year", "All Time" };
		for (int p = 0; p < 6; p++) {
			search.selectByIndex(p);
			Thread.sleep(2000);
			Assert.assertEquals(search.getFirstSelectedOption().getText().trim(), SizeDropdownExp[p],
					"The Options appearing insight the  Dropdown are not same as expected");
		}
	}

	public void checksEnvSelectsMonth(String env) throws InterruptedException {
		if (env.contentEquals("qa")) {
		} else if (env.contentEquals("uat")) {
			Thread.sleep(6000);
			common_func.ClickOnLink(element2);
		}
	}

	public int getcountgetnow() {
		java.util.List<WebElement> getnow = driver
				.findElements(By.xpath("//a[@class='btn btn-primary' and text()='Get it Now']"));
		return getnow.size();
	}

	public int getCountManage() {
		List<WebElement> mange = driver
				.findElements(By.xpath("//a[@class='btn btn-primary btngreen' and text()='Manage']"));
		return mange.size();
	}

	public void HoverOnReports() {
		Actions action = new Actions(driver);
		action.moveToElement(ReportsTab).perform();
	}

	public void selectSKU() throws InterruptedException {
		if (common_func.getWebElement(sku).isSelected()) // if Checked
		{
		}
		Thread.sleep(5000);
		common_func.ClickOnLink(unselectall);
		if (!common_func.getWebElement(sku).isSelected()) // if unChecked
		{
		}
		Thread.sleep(5000);
		common_func.ClickOnLink(selectall);
		if (common_func.getWebElement(sku).isSelected()) // if Checked
		{
		}
		Thread.sleep(3000);
		common_func.ClickOnLink(unselectall);
		Thread.sleep(3000);
		common_func.getWebElement(sku).click();
		Thread.sleep(3000);
		common_func.ClickOnLink(applyfield);
		Thread.sleep(3000);
		By show = By.xpath("//label[@class='drag-handle sort-arrow none'][contains(text(),'SKU ID')]");
		Thread.sleep(3000);
		if (isElementPresentBy(show)) {

		}

	}

	public void Export() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		Actions ab = new Actions(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(export));
		common_func.ClickOnLink(export);
		Thread.sleep(3000);
		common_func.ClickOnLink(exportreport);
		Thread.sleep(3000);
		Select Se = new Select(exportoptions);
		Thread.sleep(2000);
		Se.selectByIndex(1);
		Thread.sleep(2000);
		common_func.ClickOnLink(currpage);
		Thread.sleep(2000);
		common_func.ClickOnLink(exportreport);
		Thread.sleep(2000);
		common_func.ClickOnLink(exportcancel);
		Thread.sleep(2000);
	}

	public void Email() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		Actions ab = new Actions(driver);
		Thread.sleep(5000);
		ab.click(driver.findElement(By.xpath("//a[@class='action-icon icon-mail']"))).release().perform();
		Thread.sleep(5000);
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOf(getemailbox()));
		common_func.getWebElement(emailbox).sendKeys("ayer.shuja@arpatech.com");
		// wait.until(ExpectedConditions.elementToBeClickable(getSendBtn()));
		common_func.ClickOnLink(SendBtn);

	}
}
