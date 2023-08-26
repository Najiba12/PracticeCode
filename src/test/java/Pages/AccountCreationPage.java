package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.FileReader;
import java.io.FileWriter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.FooterLoginPage;
import Pages.LoginPage;
import Pages.Utility;
import Pages.commonFunctions;
import StepDefinitions.AccountCreationStep;

public class AccountCreationPage {
	public WebDriver driver;
	public static Logger logger;
	String fileName = "src/test/resources/TestData/signInData.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	WebDriverWait wait;
	ManagementPage page = new ManagementPage();
	commonFunctions common_func = new commonFunctions();
	LoginPage loginPage = new LoginPage();
	FooterLoginPage foot = new FooterLoginPage();
	TopLinksPages top = new TopLinksPages();
	PDPPage pdp = new PDPPage();
	footerPage footer = new footerPage();

	public AccountCreationPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	Random rm1 = new Random();
	public int i1 = rm1.nextInt(10000) + 1;
	By verifycode = By.id("code");
	@FindBy(xpath = "//img[@id='ccm_logo_id']")
	public WebElement connLogo;
	@FindBy(xpath = "//div[2]/ul[4]/li[4]/a")
	public WebElement FAQ;
	@FindBy(xpath = "//div[@class='menu-account']//span[@class='acount-intials']")
	public WebElement acctinitials;
	@FindBy(xpath = "//a[@class='clearfix']//span[@class='account-title'][contains(text(),'My Account')]")
	public WebElement AccountmenuMgmt;
	@FindBy(xpath = "//div[@class='shopping-cart']//a")
	public WebElement bellicon;
	@FindBy(xpath = "//img[@class='footer-logo']")
	public WebElement FootLogo;
	@FindBy(xpath = "//p[contains(text(),'© 2023 Connection Cloud MarkITplace')]")
	public WebElement socialIcon;
	@FindBy(xpath = "//ul[@class='col-sm-3 col-xs-3']//a[contains(text(),'Spend Analysis')]")
	public WebElement spendAnalysis;
	@FindBy(xpath = "(//a[@tabindex='0' and text()='Get it Now'])[1]")
	public WebElement GetBtn;
	@FindBy(xpath = "(//a[@tabindex='0' and text()='Manage'])[1]")
	public WebElement GetBtn1;
	@FindBy(id = "customField0")
	public WebElement VerifyDomain1;
	@FindBy(id = "tenant_name1")
	public WebElement tenantname1;
	@FindBy(xpath = "//div[@id='step3-form']//a[text()='Save and Continue']")
	public WebElement Continue13;
	@FindBy(xpath = "//form/div[3]/div[4]/div/div/div/div")
	public WebElement alertAccExist;
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement Continue2;
	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg-txt']")
	public WebElement agree;
	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg-txt mb-app-btn']")
	public WebElement agree1;
	@FindBy(xpath = "//a[@class='btn btn-primary' and text()='Submit Order']")
	public WebElement Submit_Order;
	@FindBy(xpath = "//*[@id='sticky-menu-right-procurement']//button")
	public WebElement Sbmt_Order;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelbtn;
	@FindBy(xpath = "//div[1]/div/div/div[3]/div[1]/div/h3")
	public WebElement ThankYou;
	@FindBy(xpath = "//*[@id='selectedAddressOfUse']")
	public WebElement getaddress;
	@FindBy(id = "zipCode")
	public WebElement Zip_Code1;
	@FindBy(id = "addressLine1")
	public WebElement AddressField1;
	@FindBy(xpath = "//a[text()='Save & Continue']")
	public WebElement Savecont;
	@FindBy(xpath = "//*[@id='billingApp']/div/div/div/div[3]/div/div/div[1]/a")
	public WebElement editaddressofuse1;
	@FindBy(xpath = "//*[@id='FirstName']")
	public WebElement fn;
	@FindBy(id = "LastName")
	public WebElement ln;
	@FindBy(id = "Phone")
	public WebElement ph;
	@FindBy(id = "JobTitle")
	public WebElement jobtitle;
	@FindBy(id = "Password")
	public WebElement pwd;
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmpwd;
	@FindBy(xpath = "//div[@class='alert alert-success ccp-alert-success']")
	public WebElement alertmsg2;
	@FindBy(xpath = "//input[@id='addressLine1']")
	public WebElement BAadl;
	@FindBy(xpath = "//input[@id='zipCode']")
	public WebElement BAzip;
	@FindBy(xpath = "//input[@id='phone']")
	public WebElement BAph;
	@FindBy(xpath = "//input[@id='city']")
	public WebElement city;
	@FindBy(xpath = "//*[@id='billingApp']/div/div/div/div[6]/div/div/div/div/div[2]/div/div[2]/div/ul/li/span")
	public WebElement agree5;
	@FindBy(xpath = "//button[contains(text(),'Show Related Subscriptions')]")
	public WebElement agree4;
	@FindBy(xpath = "//*[@class='formbtns-custom']/a[2]")
	public WebElement RequestNetTermbtn;
	@FindBy(xpath = "//*[@tabindex='10']")
	public WebElement RequestNetTermSaveNContinueBtn;
	@FindBy(xpath = "//*[@class='td_option_drop reports-show-more']/div[2]/a")
	public WebElement MgtCustomersEdit;
	@FindBy(xpath = "//*[@id='billing_method']")
	public WebElement BillingMethod;
	@FindBy(xpath = "//*[@class='col-sm-10 col-sm-offset-1']//*[@class='ccpmng-form-sec openForm']//a[contains(text(),'Save')]")
	public WebElement MgtCustomersEditSave;
	@FindBy(xpath = "//*[@id='ParentABNumber']")
	public WebElement getAccountAB;
	@FindBy(xpath = "//span[contains(text(),'Sales Division')]")
	public WebElement SalesDivisionExpansion;
	public String a;
	@FindBy(id = "phone")
	public WebElement Phone1;
	@FindBy(xpath = "//*[@class='ccpmng-form-sec-heading accordion-sec-heading'][contains(text(),'Default Admin')]")
	public WebElement DeafultAdmin;
	@FindBy(xpath = "//form/div[7]/div/a")
	public WebElement ContOrg;
	@FindBy(xpath = "//div[4]/div/form/div[7]/div/a")
	public WebElement ContSalesRepManagement;
	@FindBy(xpath = "//div[5]/div/div/form/div[3]/div/a")
	public WebElement ContBillingAddress;
	@FindBy(xpath = "//div/form/div[11]/div/a")
	public WebElement ContSalesDivision;
	@FindBy(xpath = "//div[2]/div[1]/div/form/div[3]/div/a")
	public WebElement Continue;
	@FindBy(xpath = "//form/div[9]/div/a")
	public WebElement ContInfo;
	@FindBy(xpath = "//div[2]/div[3]/div/a[1]")
	public WebElement SaveAll;
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	public WebElement Save;
	@FindBy(id = "OrganizationName")
	public WebElement OrganizationName;
	@FindBy(id = "BusinessName")
	public WebElement BusinessName;
	@FindBy(xpath = "//form/div[5]/div/div/div[1]/input")
	public WebElement OrganizationNameR;
	@FindBy(id = "companyName")
	public WebElement BusinessNameR;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[6]/a")
	public WebElement ResendEmail;
	@FindBy(xpath = "//div[2]/div[2]/div/form/div[3]/div/div/div")
	public WebElement industryType;
	@FindBy(xpath = "//*[@id=\"NumberOfEmployees\"]")
	public WebElement NumberOfEmployees;
	@FindBy(xpath = "/html/body/div/div/div/div/div/div[1]/div[3]/div/div[2]/form/div[7]/div/div")
	public WebElement industryTypeR;
	@FindBy(xpath = "//*[@id=\"newCompanySizes\"]")
	public WebElement NumberOfEmployeesR;
	@FindBy(id = "Address")
	public WebElement Address;
	@FindBy(id = "Zip")
	public WebElement Zip;
	@FindBy(id = "Phone")
	public WebElement Phoneaddacc;
	@FindBy(id = "ba_address_line_1")
	public WebElement AddressR;
	@FindBy(id = "ba_zip_code")
	public WebElement ZipR;
	@FindBy(id = "ba_phone")
	public WebElement PhoneaddaccR;
	@FindBy(id = "BillingAddressLine1")
	public WebElement BillingAddressLine1;
	@FindBy(id = "BillingAddressZip")
	public WebElement BillingAddressZip;
	@FindBy(id = "BillingAddressPhone")
	public WebElement BillingAddressPhone;
	@FindBy(id = "PhoneNumber")
	public WebElement PhoneNumber;
	@FindBy(id = "FirstName")
	public WebElement Firstname;
	@FindBy(id = "LastName")
	public WebElement Lastname;
	@FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	public WebElement ConfirmPassword;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	public WebElement Password;
	@FindBy(xpath = "//*[@id=\"JobTitle\"]")
	public WebElement JobTitle;
	@FindBy(id = "TeamEmail")
	public WebElement TeamEmail;
	@FindBy(id = "addressLine1")
	public WebElement addressLine1AddOfUse;
	@FindBy(id = "zipCode")
	public WebElement zipCodeAddOfUse;
	@FindBy(id = "phone")
	public WebElement PhoneaddofUse;
	@FindBy(xpath = "//*[@id=\"Division\"]")
	public WebElement SelectDivision;
	@FindBy(id = "BusinessEmail")
	public WebElement enteremail;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "code")
	public WebElement code;
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	public WebElement ColumnArrow;
	@FindBy(xpath = "//tr[1]/td[1]/div/div/div/a")
	public WebElement resend;
	@FindBy(xpath = "/html/body/table/tbody/tr/td/center/table[2]/tbody/tr/td/table/tbody/tr/th[1]/table/tbody/tr/th/p/a")
	public WebElement Clickhere;
	@FindBy(id = "getNowBtn")
	public WebElement getitNow;
	@FindBy(xpath = "//*[@class='btn btn-primary'][contains(text(),'Save & Continue')]")
	public WebElement ContSave;
	@FindBy(xpath = "//div[2]/div[2]/div/div/div/label")
	public WebElement agreement1;
	@FindBy(xpath = "//div[7]/div/div/div[2]/div[3]/a")
	public WebElement createAcc;
	@FindBy(xpath = "//*[@class='mobile-table']/tbody/tr[1]/td[@columnname='Arrow']")
	public WebElement CustomersEditPane;
	@FindBy(xpath = "//table/tbody/tr[1]/div[1]/td/div")
	public WebElement AccountName;
	@FindBy(xpath = "//*[@class='td_option_drop reports-show-more']//div[2]/a")
	public WebElement NettermApproveRequest;
	@FindBy(xpath = "//*[@id=\"parent-ab-number\"]")
	public WebElement AbApproveRequest;
	By NettermApproveRequestApprovebtn = By.xpath("//button[contains(text(),'Approve')]");
	@FindBy(xpath = "//*[@class='section-navigation user-middle']//a[contains(text(),'Requests')]")
	public WebElement RequestsNavigation;
	@FindBy(xpath = "//*[@id='date[created_at][timePeriod][input]']")
	public WebElement DateFilter;
	@FindBy(xpath = "//*[@id=\"date[updated_at][timePeriod][input]\"]")
	public WebElement DateFilterDomain;
	@FindBy(xpath = "//*[@id='date[created_at][fromUnit][input]']")
	public WebElement DateFilterFrom;
	@FindBy(xpath = "//*[@id='date[created_at][toUnit][input]']")
	public WebElement DateFilterTo;
	@FindBy(xpath = "//*[@id='date[updated_at][fromUnit][input]']")
	public WebElement DateFilterFromDomain;
	@FindBy(xpath = "//*[@id='date[updated_at][toUnit][input]']")
	public WebElement DateFilterToDomain;
	@FindBy(xpath = "//*[@id=\"date[date][timePeriod][input]\"]")
	public WebElement DateFilterResend;
	@FindBy(xpath = "//*[@id='date[date][fromUnit][input]']")
	public WebElement DateFilterFromResend;
	@FindBy(xpath = "//*[@id='date[date][toUnit][input]']")
	public WebElement DateFilterToResend;
	@FindBy(xpath = "//div[11]/div/div/div/div/div/div[3]/button[1]")
	public WebElement DateFilterApply;
	@FindBy(xpath = "//*[@id=\"date[sent_date][timePeriod][input]\"]")
	public WebElement DateFilterNoti;
	@FindBy(xpath = "//*[@id='date[sent_date][fromUnit][input]']")
	public WebElement DateFilterFromNoti;
	@FindBy(xpath = "//*[@id='date[sent_date][toUnit][input]']")
	public WebElement DateFilterToNoti;
	@FindBy(xpath = "//*[@id=\"date[start_date][timePeriod][input]\"]")
	public WebElement DateFilterInvoice;
	@FindBy(xpath = "//*[@id='date[start_date][fromUnit][input]']")
	public WebElement DateFilterInvoiceFrom;
	@FindBy(xpath = "//*[@id='date[start_date][toUnit][input]']")
	public WebElement DateFilterInvoiceTo;
	@FindBy(xpath = "//th[5]//div[@class='filter-search-drop-arrow']")
	public WebElement Status;
	@FindBy(xpath = "//*[@id=\"Account Namecompany_name\"]")
	public WebElement accName;
	@FindBy(xpath = "//*[@id=\"CCM Account Namecompany_name\"]")
	public WebElement accName1;
	@FindBy(xpath = "//table/tbody/tr/div[3]/td/div")
	public WebElement accNameVerify;
	@FindBy(xpath = "//th[5]//div[@class='filter-search-drop-arrow']//a[contains(text(),'Apply')]")
	public WebElement ApplyStatus;
	@FindBy(xpath = "//div[@class='filter-search-drop-arrow']//li[1]//span[1]")
	public WebElement PendingStatus;
	@FindBy(xpath = "//th[3]//div[@class='filter-search-drop-arrow']")
	public WebElement RequestedDate;
	@FindBy(xpath = "//*[@class='mobile-table']/tbody/tr[last()]/td[@columnname='Arrow']")
	public WebElement CustomersEditPanel;
	@FindBy(xpath = "//*[@class='insights '][contains(text(),'FULFILLMENT')]")
	public WebElement Fullfilment;
	@FindBy(xpath = "//*[@id=\"tenant\"]")
	public WebElement createtenant;
	@FindBy(xpath = "//*[@id=\"Recipient Email Addressto\"]")
	public WebElement searchaccount;
	@FindBy(xpath = "//*[@class='col-sm-12 form-cont clearfix']//span[contains(text(),'Billing Address')]")
	public WebElement BillingAddressExpansion;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[1]/a")
	public WebElement account;
	@FindBy(xpath="//footer/section[1]/div[2]/ul[2]/li[4]/a")
	public WebElement Calendar;
	@FindBy(xpath="//footer/section[1]/div[2]/ul[2]/li[3]/a")
	public WebElement Order;
	@FindBy(xpath="//footer/section[1]/div[2]/ul[3]/li[6]/a")
	public WebElement Usage;
	@FindBy(xpath="//section[2]/div[2]/div[1]/div[1]/div/h1")
	public WebElement ServiceName;
	@FindBy(xpath="//div[1]/ul/li/div[1]/div/div[1]/span")
	public WebElement ServiceNameVerify;
	@FindBy(xpath="//div[1]/div[1]/ul/li/div[1]/div/div[6]/p")
	public WebElement ServiceStatus;
	@FindBy(xpath="//*[@id=\"Account Namecompany_name\"]")
	public WebElement FullCompany;
	@FindBy(xpath="//*[@id=\"CCM Account Namecompany_name\"]")
	public WebElement AccCompanyName;
	@FindBy(xpath="//section[2]/table/tbody/tr[1]/div[3]/td")
	public WebElement verifyAccCompanyName;
	@FindBy(xpath="//div/div/div/div/div/div[3]/div/div[1]/button[2]")
	public WebElement cancelImport;
	@FindBy(xpath="//*[@id=\"Provider Nameprovider_name\"]")
	public WebElement FullProvider;
	@FindBy(xpath="//section[2]/table/tbody/tr[1]/div[3]/td")
	public WebElement fullStatus;
	@FindBy(xpath="//section[2]/table/tbody/tr[1]/div[3]/td")
	public WebElement fullState;
	@FindBy(xpath="//div[2]/div[2]/section/div[2]/div[2]/a[3]")
	public WebElement suspenSub;
	@FindBy(xpath="//div[2]/div[3]/div/form/div[7]/div/a")
	public WebElement ContinueOrg;
	@FindBy(xpath="//*[@id=\"SelectProvider\"]")
	public WebElement vendors;
	@FindBy(xpath="//div/div/div[3]/div/div/div/div[3]/div/div/div")
	public WebElement Browse;
	@FindBy(xpath="//*[@id=\"tenant\"]")
	public WebElement SelectTenant1;
	public By OrderConfirm=By.xpath("//div[6]/div/div/div/div/div[1]/div/h2");
	public By OrderConfirm1=By.xpath("//*[@id=\"pdp-main-wrapper\"]/div[4]/div/div/div/div/div[1]/div/h2");
	public By tenantLabel = By.xpath("//label[contains(text(),'Select a Tenant or create a new one:')]");
	By notlisted = By.xpath("//*[@class='multiselect'][@data-vv-as='Account Type']/div[1]");
	By BEAccount = By.xpath("//form/div[2]/div/div/div/div[1]");
	By agreement = By.xpath("//*[@class='checkbox checkbox-primary']//input[@id='agreement']");
	By Subsription = By.xpath("//*[@class='row col-sm-12 custom-btns']/a");
	By VerifyDomain = By.id("customField0");
	By tenantname = By.id("tenant_name1");
	public By SelectTenant = By.xpath("//label[contains(text(),'Select a Tenant or create a new one:')]");
	public By SelectTenant2 = By.xpath("//label[contains(text(),'Create, Select or Migrate tenant:')]");
	public By alertEmail= By.xpath("//*[@class=\"alert-msg\"][contains(text(),'An account already exists for this business email address')]");
	public By alertEmail1= By.xpath("//span[contains(text(),'Select an existing account or create a new account')]");
	public By addOf= By.xpath("//p[contains(text(),'Houston, TX, 77084')]");
	public By continueInfo= By.xpath("//div[2]/div/div[2]/form/div[6]/a");
	public By continueInfo1= By.xpath("//div[1]/div/div[2]/div[2]/div/div[2]/form/div[5]/a");
	public void CreateNewAcc() throws InterruptedException {
		WebElement BEAccount = driver.findElement(By.className("multiselect"));
		BEAccount.click();
		System.out.println("helllo");
		Thread.sleep(15000);
		BEAccount.sendKeys("Create New Account" + Keys.ENTER);
	}

	public WebElement getagreement() {
		return driver.findElement(agreement);
	}

	public WebElement getsubsribeToBasic() {
		return driver.findElement(Subsription);
	}

	public WebElement getBEAccount() {
		return driver.findElement(BEAccount);
	}

	public WebElement getnotlistedlabel() {
		return driver.findElement(notlisted);
	}

	public WebElement getVerificationCode() {
		return driver.findElement(verifycode);
	}

	 public static void writeCSVFile(String filePath, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        }
    }
	public void ShowRelatedSub() throws InterruptedException {
		agree5.click();
		Thread.sleep(3000);
		agree4.click();
	}

	public void getAddOfUseEdit() throws InterruptedException {
		// WebElement editaddressofuse = driver.findElement(By.linkText("Edit"));
		common_func.getAreftext("Edit").click();
		// editaddressofuse.click();
		Thread.sleep(3000);
		// WebElement cancel =
		// driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
		// cancel.click();
		common_func.getAreftext("Cancel").click();
		Thread.sleep(3000);
		editaddressofuse1.click();
		Thread.sleep(3000);
	}

	public void getValues(String value) throws InterruptedException {
		// WebElement ext = driver.findElement(By.xpath("//input[@id='ext']"));
		// ext.sendKeys(value);
		common_func.getById("ext").sendKeys(value);
		// WebElement save =
		// driver.findElement(By.xpath("//a[contains(text(),'Save')]"));
		Thread.sleep(3000);
		common_func.getAreftext("Save").click();
		// save.click();
	}

	public void getitNow() throws InterruptedException {
		String now = "//a[@class='btn btn-primary' and text()='Get it Now']";
		Thread.sleep(10000);
		WebElement av = driver.findElement(By.xpath("//a[contains(text(),'Refresh Price')]"));
		String bbb = av.getText();
		System.out.println("PREVIOUSPAGE" + bbb);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", av);
		av.click();
		By getnow1 = By.xpath(now);
		Thread.sleep(5000);
		WebElement av1 = driver.findElement(getnow1);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("arguments[0].scrollIntoView()", av1);
		av1.click();
	}

	public void getitNowOnCSP() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement avf = driver.findElement(By.xpath("//a[@class='retry-btn sidebox btn btn-primary']"));
		Thread.sleep(8000);
		jse.executeScript("arguments[0].scrollIntoView()", avf);
		avf.click();
		Thread.sleep(8000);
		WebElement avf1 = driver.findElement(
				By.xpath("//a[@class='btn btn-primary btn-to-cart show-for-tablet modal-btn hide-for-print']"));
		jse.executeScript("arguments[0].scrollIntoView()", avf1);
		avf1.click();
		Thread.sleep(8000);
		String abc = driver.getTitle();
		System.out.println("SAIMAAA " + abc);
	}

	public void TenentDetails() throws InterruptedException {
		Thread.sleep(5000);
		if (common_func.isElementPresentBy(VerifyDomain)) {
			Thread.sleep(3000);
			VerifyDomain1.sendKeys("TestAutomationDomain" + i1);
		}
		if (common_func.isElementPresentBy(tenantname)) {
			Thread.sleep(3000);
			tenantname1.sendKeys("TestAutomationDomain" + i1);
		}
		if (common_func.isElementPresentBy(continueInfo)||common_func.isElementPresentBy(continueInfo1)) {
		top.ScrollsBy300();
		common_func.getOnLinkText("Continue").click();
		Thread.sleep(15000);}
	}

	public void ChecksEnvAndProvideAdd(String env) throws InterruptedException {
		if(!common_func.isElementPresentBy(addOf)) {
			System.out.println("hi");
		wait = new WebDriverWait(driver, 120);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		if (env.contentEquals("uat")) {
			Thread.sleep(5000);
			Select search = new Select(common_func.getWebElement(getaddress));
			search.selectByIndex(2);
			Thread.sleep(3000);
			// wait.until(ExpectedConditions.elementToBeClickable(getAddressField1()));
			common_func.getWebElement(AddressField1).sendKeys("756 Concho Ln Houston, TX, 77084");
			// wait.until(ExpectedConditions.elementToBeClickable(getZip_Code1()));
			Thread.sleep(4000);
			common_func.getWebElement(Zip_Code1).sendKeys("77084");
			Thread.sleep(7000);
			// wait.until(ExpectedConditions.elementToBeClickable(getPhone1()));
			Thread.sleep(5000);
			common_func.getWebElement(Phone1).sendKeys("232.423.5345");
			Thread.sleep(3000);
			WebElement exist = driver.findElement(By.xpath("//a[contains(text(),'Use an existing address')]"));
			exist.click();
			Select se1 = new Select(common_func.getWebElement(getaddress));
			Thread.sleep(3000);
			se1.selectByIndex(1);
			WebElement edit = driver.findElement(By.xpath("//div[@id='step3-form']//span/a[contains(text(),'Edit')]"));
			edit.click();
			Thread.sleep(7000);
			// wait.until(ExpectedConditions.elementToBeClickable(getPhone1()));
			Thread.sleep(5000);
			common_func.getWebElement(Phone1).sendKeys("232.423.5346");
			Thread.sleep(4000);
		}
		}
	}

	public void getRefreshAccount() {
		wait = new WebDriverWait(driver, 10000);
		do {
			for (int a = 0; a < 10; a++) {
				driver.navigate().refresh();
				common_func.ClickOnLink(SalesDivisionExpansion);
				wait.until(ExpectedConditions.elementToBeClickable(getAccountAB));
			}
		} while (getAccountAB.getText() == "201");
		System.out.println("Sales REP AB :" + getAccountAB.getText());

	}

	public void CheckEnvironment(String env) {
		if (env.contentEquals("qa")) {
			String a = acctinitials.getText();
			System.out.println(a);
			Assert.assertEquals(a, "AA");
		}
		if (env.contentEquals("uat")) {
			String a = acctinitials.getText();
			System.out.println(a);
			Assert.assertEquals(a, "TT");
		}
	}

	public void getAlert() throws InterruptedException {
		// By alertforgot = By.xpath("//div[@class='alert alert-success
		// ccp-alert-success']");
		Thread.sleep(20000);
		String count = driver.findElement(By.xpath("//div[@class='alert alert-success ccp-alert-success']")).getText();
		String expected = "A password reset link has been emailed to your email account on file. Please check your email"
				.replaceAll("\\n|\\r\\\n", System.getProperty("line.separator"));
		Thread.sleep(3000);
		Assert.assertEquals(count.contains("A password reset link has been emailed"),
				expected.contains("A password reset link has been emailed"), "alert text not match");
	}

	public void enteremailInfo(String email) throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		FluentWait wait2;
		wait2 = new FluentWait(driver);
		wait2.withTimeout(20000, TimeUnit.MILLISECONDS);
		wait2.pollingEvery(500, TimeUnit.MILLISECONDS);
		wait2.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.titleContains("Create Account - CCM"));
		wait2.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(foot.emailfield));
		wait2.ignoring(NoSuchElementException.class);
		Thread.sleep(10000);
		foot.emailfield.sendKeys(email);
		Thread.sleep(10000);
		System.out.println("1");
		wait2.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(foot.verifyemail));
		System.out.println("2");
		foot.verifyemail.click();
		System.out.println("3");
		Thread.sleep(5000);
	}

	public void click_resendcodeLinkInAlert() throws IOException, InterruptedException {
		By alertmsgresendcode = By.xpath("//a[contains(text(),'Resend verification code')]");
		wait = new WebDriverWait(driver, 120);
		FluentWait wait2;
		wait2 = new FluentWait(driver);
		wait2.withTimeout(10000, TimeUnit.MILLISECONDS);
		wait2.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait2.ignoring(NoSuchElementException.class);
		driver.findElement(alertmsgresendcode).isEnabled();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(alertmsgresendcode)));
		wait2.ignoring(NoSuchElementException.class);
		driver.findElement(alertmsgresendcode).click();
		wait2.ignoring(NoSuchElementException.class);

	}

	public void FetchesCode(String env, String dburl, String dbun, String dbpswd)
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		String email11 = null;
		String query = "select verification_code from signup_verification_token where email='" + email11 + "';";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dburl, dbun, dbpswd);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			a = rs.getString(1);

			System.out.println("code =" + a);
		}
		con.close();
	}

	public void entercode(String code) throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		FluentWait wait2;
		wait2 = new FluentWait(driver);
		wait2.withTimeout(10000, TimeUnit.MILLISECONDS);
		wait2.pollingEvery(250, TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(getVerificationCode()));
		getVerificationCode().sendKeys(code);
		// wait.until(ExpectedConditions.elementToBeClickable(getVerifyCodeBtn()));
		// getVerifyCodeBtn().click();
		common_func.getOnLinkText("Verify").click();
	}

	public void savecontinueclick() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.elementToBeClickable(getsavecontinue()));
		Thread.sleep(5000);
		common_func.ClickOnLink(Savecont);
		Thread.sleep(5000);
	}

	public void enterUserInfo(String fn1, String ln1, String phone1, String jobtitle1, String pwd1, String confirmpwd1)
			throws IOException, InterruptedException {
		FluentWait wait2;
		wait2 = new FluentWait(driver);
		wait2.withTimeout(10000, TimeUnit.MILLISECONDS);
		wait2.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait2.ignoring(NoSuchElementException.class);
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(fn));
		fn.sendKeys(fn1);
		wait.until(ExpectedConditions.elementToBeClickable(ln));
		ln.sendKeys(ln1);
		wait.until(ExpectedConditions.elementToBeClickable(ph));
		ph.sendKeys(phone1);
		// wait.until(ExpectedConditions.elementToBeClickable(JobTitle()));
		Select search = new Select(common_func.getWebElement(jobtitle));
		wait2.ignoring(NoSuchElementException.class);
		search.selectByVisibleText(jobtitle1);
		// wait.until(ExpectedConditions.elementToBeClickable(common_func.getWebElement(pwd)));
		pwd.sendKeys(pwd1);
		wait.until(ExpectedConditions.elementToBeClickable(confirmpwd));
		common_func.getWebElement(confirmpwd).sendKeys(confirmpwd1);
		savecontinueclick();
		// wait2.ignoring(NoSuchElementException.class);
	}

	public void AgreeCSA() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		getagreement().click();
		Thread.sleep(5000);
	}

	public void CheckZipCode(String value) throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		while (!(common_func.isElementPresent(city))) {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			BAzip.sendKeys(Keys.CONTROL, "a");
			Thread.sleep(3000);
			BAzip.sendKeys(Keys.DELETE);
			Thread.sleep(3000);
			BAzip.sendKeys("77084");
			Thread.sleep(5000);
		}
		// wait.until(ExpectedConditions.visibilityOfElementLocated(city));
		Thread.sleep(6000);
		common_func.getWebElement(BAph).sendKeys(value);
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.elementToBeClickable(getBASave()));
		common_func.getAreftext("Save").click();
	}

}