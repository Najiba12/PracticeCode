package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.apache.logging.log4j.core.appender.rolling.action.Action;
import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.client.model.geojson.Point;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Utilities.basePage;

public class ManagementPage {
	public WebDriver driver;
	Utility utility = new Utility();
	public WebDriverWait wait;
	commonFunctions common_func = new commonFunctions();
	PDPPage pdp = new PDPPage();

	public ManagementPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='shop ' and text()='Customers']")
	public WebElement CustomersTab;
	@FindBy(xpath = "//a[@class='track ' and text()='Catalog']")
	public WebElement CatalogTab;
	@FindBy(xpath = "//a[@class='insights ' and text()='FULFILLMENT']")
	public WebElement FullfillmentTab;
	@FindBy(xpath = "//a[@class='reports ' and text()='Reports']")
	public WebElement ReportsTab;
	@FindBy(xpath = "//a[@class='users ' and text()='SETUP']")
	public WebElement UsersTab;
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	public WebElement Logout;
	@FindBy(xpath = "(//span[@class='account-title'])[1]")
	public WebElement AccountMenu;
	@FindBy(xpath = "//a[@class='top-link' and text()='Settings']")
	public WebElement Settings;
	@FindBy(xpath = "//a[@class='top-link' and text()='Jobs']")
	public WebElement Jobs;
	@FindBy(xpath = "(//a[text()='Roles'])[2]")
	public WebElement Roles;
	@FindBy(xpath = "//a[@class='top-link' and text()='Users']")
	public WebElement Users;
	@FindBy(xpath = "//a[@class='btn auto-width btn btn-primary mr-0']")
	public WebElement CreateUser;
	@FindBy(xpath = "//*[@id=\"first_name\"]")
	public WebElement name;
	@FindBy(xpath = "//*[@id=\"last_name\"]")
	public WebElement lname;
	@FindBy(xpath = "//*[@id=\"email_address\"]")
	public WebElement email;
	@FindBy(xpath = "//*[@id=\"Role\"]")
	public WebElement role;
	@FindBy(xpath = "//div/div[2]/div/div/div/p/span")
	public WebElement alertCreateUser;
	@FindBy(xpath = "//div[@class='pull-right invite-userbtn']")
	public WebElement AddRoleBtn;
	@FindBy(xpath = "//a[@class='btn edit pull-right' and text()='Edit']")
	public WebElement EditBtn;
	@FindBy(xpath = "(//button[@class='btn btn-secondary' and text()='Cancel'])[6]")
	public WebElement CancelBtn;
	@FindBy(id = "selectFields")
	public WebElement SelectFieldBtn;
	@FindBy(id = "export")
	public WebElement ExportBtn;
	@FindBy(xpath = "//form/button[2]")
	public WebElement ExportCancel;
	@FindBy(xpath = "//a[@class='top-link' and text()='Subscriptions']")
	public WebElement Subscription;
	@FindBy(xpath = "(//td[@columnname='Arrow'])[1]")
	public WebElement Arrow1;
	@FindBy(xpath = "//a[text()='Edit Subscription']")
	public WebElement EditSubs;
	@FindBy(xpath = "//div[9]/button[2]")
	public WebElement EditSubCancel;
	@FindBy(xpath = "//div/div/div[4]/a")
	public WebElement AssumeRole;
	@FindBy(xpath = "//*[@id=\"Users\"]")
	public WebElement AssumeRadio;
	@FindBy(xpath = "(//a[text()='Subscriptions'])[3]")
	public WebElement FSubs;
	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Assume Role']")
	public WebElement AssumeRoleBtn;
	@FindBy(xpath = "//div[4]/div/div/div/div/div[3]/div/div/div/button[2]")
	public WebElement button;
	@FindBy(xpath = "//a[text()='Edit Account']")
	public WebElement EditAccount;
	@FindBy(xpath = "//a[@class='btn' and text()='Cancel']")
	public WebElement AccountCancel;
	@FindBy(xpath = "//section[1]/div[1]/a/img")
	public WebElement FooterLogo;
	@FindBy(xpath = "//a[@class='top-link' and text()='Categories']")
	public WebElement Categories;
	@FindBy(xpath = "//div[10]/div/div/div/div/div/div[3]/button")
	public WebElement SyncClose;
	@FindBy(xpath = "/html/body/div[10]/div/div/div/div/button")
	public WebElement SyncCloseService;
	@FindBy(xpath = "//*[@id=\"sync\"]")
	public WebElement SyncBtn;
	@FindBy(id = "loadingMask")
	public WebElement loadingMask;
	@FindBy(xpath = "//a[text()='Edit Category']")
	public WebElement EditCategory;
	@FindBy(id = "updateCategoryBtn")
	public WebElement ApplyBtn;
	@FindBy(xpath = "//h2[text()='Edit Category']")
	public WebElement Catheading;
	@FindBy(xpath = "(//a[@class='top-link' and text()='Domains'])[1]")
	public WebElement Domain;
	@FindBy(xpath = "//a[text()='Net Terms']")
	public WebElement NetTerms;
	@FindBy(xpath = "(//a[@class='top-link' and text()='Requests'])[1]")
	public WebElement RequestTab1;
	@FindBy(xpath = "//label[text()='Change Request ID']")
	public WebElement CRID;
	@FindBy(xpath = "//td[@class='blue-medium']")
	public WebElement RequestId;
	@FindBy(xpath = "//label[text()='Net Terms ID']")
	public WebElement NetTermHeading;
	@FindBy(xpath = "(//a[@class='top-link' and text()='Notifications'])[1]")
	public WebElement CustNotification;
	@FindBy(xpath = "//a[@class='btn auto-width' and text()='Send Notification']")
	public WebElement SendNotificationBtn;
	@FindBy(xpath = "//a[text()='Edit Provider']")
	public WebElement EditProvider;
	@FindBy(xpath = "//div[6]/div/div/a[2]")
	public WebElement cancelBtn;
	@FindBy(xpath = "//a[text()='Add Provider']")
	public WebElement AddProvider_Btn;
	@FindBy(xpath = "//a[text()='Edit Service']")
	public WebElement EditService;
	@FindBy(xpath = "//a[@class='top-link' and text()='Services']")
	public WebElement ServicesTab;
	@FindBy(xpath = "//table/thead/tr/th[4]/label")
	public WebElement TypeNotificaton;
	@FindBy(xpath = "//table/thead/tr/th[5]/label")
	public WebElement Recepient;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[7]/a")
	public WebElement SendEmails;
	@FindBy(xpath = "//*[@id=\"selectOrganization\"]")
	public WebElement Organisation;
	@FindBy(xpath = "//*[@id=\"selectAccount\"]")
	public WebElement Account;
	@FindBy(xpath = "//*[@id=\"Mailto\"]")
	public WebElement mailTo;
	@FindBy(xpath = "//*[@id=\"subject\"]")
	public WebElement Subject;
	@FindBy(xpath = "//div[7]/div/div/div/div[3]/div/p")
	public WebElement EditContent;
	@FindBy(xpath = "//div[2]/div[9]/div/div/a")
	public WebElement Send;
	@FindBy(xpath = "//div[2]/div[9]/div/div/div/div/div/div/p/span")
	public WebElement EmailSuccessful;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[3]/a")
	public WebElement Addons;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[5]/a")
	public WebElement FailToSyn;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Addon Type')]")
	public WebElement AddonType;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Provider Product ID')]")
	public WebElement Provideid;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Product Status')]")
	public WebElement ProductStatus;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'EULA Required')]")
	public WebElement EULA;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Last Sync')]")
	public WebElement LastSync;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Order Number')]")
	public WebElement OrderNum;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Order Type')]")
	public WebElement OrderType;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Ordered By')]")
	public WebElement Orderedby;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Tax')]")
	public WebElement Tax;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Tenant ID')]")
	public WebElement TenantID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Tenant Name')]")
	public WebElement TenantName;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Updated By')]")
	public WebElement UpdatedBy;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Account Name')]")
	public WebElement AccountName;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Account ID')]")
	public WebElement AccountID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Service ID')]")
	public WebElement ServiceID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Service Name')]")
	public WebElement ServiceName;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Provider')]")
	public WebElement Provider;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Seats')]")
	public WebElement Seat;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Updated At')]")
	public WebElement UpdatedAt;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Created At')]")
	public WebElement CreatedAt;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'First Name')]")
	public WebElement FirstName;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Last Name')]")
	public WebElement LastName;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Billing Month')]")
	public WebElement BillingMonth;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Invoice Number')]")
	public WebElement InvoiceNumber;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Due Date')]")
	public WebElement DueDate;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Shipping Address')]")
	public WebElement ShippingAddress;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Metering')]")
	public WebElement Metering;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Subscription ID')]")
	public WebElement SubscriptionID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Last Updated')]")
	public WebElement LastUpdated;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Start Date')]")
	public WebElement StartDate;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'End Date')]")
	public WebElement EndDate;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Billing Cycle')]")
	public WebElement BillingCycle;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Payment Method')]")
	public WebElement PaymentMethod;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Total Bill')]")
	public WebElement TotalBill;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'STAB')]")
	public WebElement STAB;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Parent AB')]")
	public WebElement ParentAB;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Division')]")
	public WebElement Division;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Subtotal')]")
	public WebElement Subtotal;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Payment Method')]")
	public WebElement Browser;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'User')]")
	public WebElement User1;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Action Type')]")
	public WebElement ActionType;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Message')]")
	public WebElement Message;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Assumed Role')]")
	public WebElement AssumedRole;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'IP')]")
	public WebElement IP;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Date')]")
	public WebElement Date;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'ID')]")
	public WebElement ID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Provider ID')]")
	public WebElement ProviderID;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Error Code')]")
	public WebElement ErrorCode;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Error Description')]")
	public WebElement ErrorDescription;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Count')]")
	public WebElement Count;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Answer')]")
	public WebElement Answer;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Question')]")
	public WebElement Question;
	@FindBy(xpath = "//label[@class='control control--checkbox'][contains(text(),'Status')]")
	public WebElement Status;
	@FindBy(xpath = "//tr[1]/td/i")
	public WebElement FirstOrder;
	@FindBy(xpath = "//*[@id=\"Statusstatus\"]")
	public WebElement status;
	@FindBy(xpath = "//tr[1]/td/div/div/div[4]/a")
	public WebElement EditOrderStatus;
	@FindBy(xpath = "//*[@id=\"Status\"]")
	public WebElement ChangeStatus;
	@FindBy(xpath = "//div[11]/div/div/div/div/div/div[3]/div[1]/div/div[1]/div/div/div/p/span")
	public WebElement OrderAlert;
	@FindBy(xpath = "//div[11]/div/div/div/div/div/div[3]/div[3]/button[1]")
	public WebElement OrderSave;
	@FindBy(xpath = "//div[3]/div/div/div/div[2]/div[1]/a[1]")
	public WebElement unselectall;
	@FindBy(xpath = "//div[3]/div/div/div/div[2]/div[1]/a[2]")
	public WebElement selectall;
	@FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div[3]/button[1]")
	public WebElement applyfield;
	@FindBy(xpath = "//section[1]/section[2]/section[1]/div/p")
	public WebElement failtoSyncDetail;
	@FindBy(xpath = "//div[1]/section[1]/section[2]/section[1]/div/p")
	public WebElement AddonsDetail;
	@FindBy(xpath = "//section[1]/section[2]/section[1]/div/p")
	public WebElement OrderDetail;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[3]/a")
	public WebElement Tenant;
	@FindBy(xpath = "//section[2]/section[1]/div/p")
	public WebElement TenantDetail;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[2]/a")
	public WebElement OrdersDetail;
	@FindBy(xpath = "//section[2]/section[1]/div/p")
	public WebElement OrdersDetailtext;
	@FindBy(xpath = "//tr[1]/td/div/div/div[2]/a")
	public WebElement ViewDetailOrder;
	@FindBy(xpath = "//td/div/div/div[1]/a")
	public WebElement ManageNotes;
	@FindBy(xpath = "//div[13]/div/div/div/div/button")
	public WebElement CancelManageNotes;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[4]/a")
	public WebElement User;
	@FindBy(xpath = "//section[2]/section[1]/div/p")
	public WebElement UserDetail;
	@FindBy(xpath = "//section/div/div/div/p")
	public WebElement JobDetail;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[5]/a")
	public WebElement Usage;
	@FindBy(xpath = "//section[2]/section[1]/div/p")
	public WebElement UsageDetail;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[6]/a")
	public WebElement Invoices;
	@FindBy(xpath = "//section[2]/section[1]/div/p")
	public WebElement InvoicesDetail;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[7]/a")
	public WebElement InvoiceDetails;
	@FindBy(xpath = "//nav[3]/div[2]/ul/ul/li[8]/a")
	public WebElement AccountOnHold;
	@FindBy(xpath = "//tr[1]/td[1]/div/div/div[1]/a")
	public WebElement ViewInvoice;
	@FindBy(xpath = "//tr[1]/td[1]/div/div/div[2]/a")
	public WebElement ViewUsage;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[2]/a")
	public WebElement RevenueByDivision;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[3]/a")
	public WebElement Auditlog;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[4]/a")
	public WebElement MissingService;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[5]/a")
	public WebElement ErrorsLog;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[6]/a")
	public WebElement E1ErrorsLog;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[7]/a")
	public WebElement ExecutionLog;
	@FindBy(xpath = "//nav[3]/div[2]/ul/li[4]/a")
	public WebElement FAQ;
	@FindBy(xpath = "//*[@id=\"question\"]")
	public WebElement TypeQuestion;
	@FindBy(xpath = "//*[@id=\"answer\"]")
	public WebElement TypeAnswer;
	@FindBy(xpath = "//tr[1]/div[2]/td/div")
	public WebElement VerifyQuestion;
	@FindBy(xpath = "//tr[1]/div[3]/td/div")
	public WebElement VerifyAnswer;
	@FindBy(xpath = "//*[@id=\"submitFAQBtn\"]")
	public WebElement Save;
	@FindBy(xpath = "//div[3]/div/div/div/p/span")
	public WebElement AlertMsgPassword;
	@FindBy(xpath = "//*[@id=\"UserRole\"]")
	public WebElement UserRole;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	public WebElement Email;
	@FindBy(xpath = "//div[1]/div/div[2]/span")
	public WebElement CusGTMCode;
	@FindBy(xpath = "//div[2]/div/div[2]/span")
	public WebElement ManGTMCode;
	@FindBy(xpath = "//*[@id=\"email_code_expiry\"]")
	public WebElement ExpiryCode;
	@FindBy(xpath = "//*[@id=\"google_tag_manager\"]")
	public WebElement CusGTMInput;
	@FindBy(xpath = "//div[1]/div[2]/div/div/div/div/p/span")
	public WebElement SettingsAlert;
	@FindBy(xpath = "//*[@id=\"SearchUser\"]")
	public WebElement SearchJob;
	@FindBy(xpath = "//li/div/div/div[1]/span")
	public WebElement Jobsname;
	@FindBy(xpath = "//li/div/div/div[2]/span")
	public WebElement Schedule;
	@FindBy(xpath = "//li/div/div/div[3]/span")
	public WebElement LastRun;
	@FindBy(xpath = "//li/div/div/div[4]/span")
	public WebElement Status1;
	@FindBy(xpath = "//*[@id=\"SelectRole\"]")
	public WebElement SelectRole;
	@FindBy(xpath = "//*[@id=\"SelectStatus\"]")
	public WebElement SelectStatus;
	@FindBy(xpath = "//section/div/div[1]/p")
	public WebElement CreateUserDetail;
	@FindBy(xpath = "//div[3]/div/ul/li[2]/a")
	public WebElement SendBulkEmails;
	@FindBy(xpath = "//div/div[14]/div/div/div/div/button")
	public WebElement CloseAdd;
	@FindBy(xpath = "//table/thead/tr/th[5]")
	public WebElement FisrtColumn;
	@FindBy(xpath = "//table/thead/tr/th[6]")
	public WebElement SeconColumn;
	@FindBy(xpath = "//table/thead/tr/th[2]/div/div[3]")
	public WebElement FirstFilter;
	@FindBy(xpath = "//thead/tr/th[3]/div/div[3]")
	public WebElement SecondFilter;
	@FindBy(xpath = "//thead/tr/th[4]/div/div[3]")
	public WebElement ThirdFilter;
	@FindBy(xpath = "//thead/tr/th[5]/div/div[3]")
	public WebElement FourthFilter;
	@FindBy(xpath = "//thead/tr/th[6]/div/div[3]")
	public WebElement FifthFilter;
	@FindBy(xpath = "//tr/th[7]/div/div[3]")
	public WebElement SixthFilter;
	@FindBy(xpath = "(//div[@class='tdParentWrap'])[1]")
	public WebElement VerifyFirstFilter;
	@FindBy(xpath = "(//div[@class='tdParentWrap'])[2]")
	public WebElement VerifySecondFilter;
	@FindBy(xpath = "(//div[@class='tdParentWrap'])[3]")
	public WebElement VerifyThirdFilter;
	@FindBy(xpath = "(//div[@class='tdParentWrap'])[4]")
	public WebElement VerifyFourthFilter;
	@FindBy(xpath = "(//div[@class='tdParentWrap'])[5]")
	public WebElement VerifyFifthFilter;
	@FindBy(xpath = "(//label[@class='control control--checkbox'])[2]")
	public WebElement SelectSecOption;
	@FindBy(xpath = "(//label[@class='control control--checkbox'])[1]")
	public WebElement SelectFirstOption;
	@FindBy(xpath = "//table/tbody/tr/td/caption")
	public WebElement ResultNotFound;
	@FindBy(xpath = "//*[@id=\"From\"]")
	public WebElement SeatsFrom;
	@FindBy(xpath = "//*[@id=\"To\"]")
	public WebElement SeatsTo;
	@FindBy(xpath = "(//label[contains(text(),'Created By')])[1]")
	public WebElement AccountIDCol;
	@FindBy(xpath = "//div/div/div/img")
	public WebElement connectionLogo;
	@FindBy(xpath = "//div/div[2]/div/div/div/div/div/div")
	public WebElement Moto;
	@FindBy(xpath = "//div[6]/div/div/div/div/div[3]/div/div/div/button[2]")
	public WebElement Cancelbtn1;
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	public WebElement FirstColumn;
	@FindBy(xpath = "//div[@class=\"col-sm-12 sync-msg-sm\"]")
	public WebElement SyncSuccessful;
	@FindBy(xpath = "//div/div/div[2]/div/div/div/p/span")
	public WebElement RoleCreated;
	@FindBy(xpath = "//div[1]/div/div/div/div/div/div/p/span")
	public WebElement RoleEdited;
	@FindBy(xpath = "//section/section/div/div/p")
	public WebElement RoleDesc;
	@FindBy(xpath = "//*[@id=\"RoleName\"]")
	public WebElement RoleName;
	@FindBy(xpath = "//div/div/div/form/div[2]/button")
	public WebElement submitbtn;
	public By verify2ndCol = By.xpath("(//div[@class='tdParentWrap'])[1]");
	public By ExistRole = By.xpath("//div/div[11]/div[1]/div/div/div/div/div/div/p/span");
	public By ConfirmationMsg = By.xpath("//div[contains(text(),'Are you sure you want Re-execute')]");
	public By NotReexecute = By.xpath(
			"//div[contains(text(),'Re-execution is not available, either it has been processed successfully before or currently in-progress.')]");

	public void getNextWindow() {
		button.click();
		Set<String> abc = driver.getWindowHandles();
		java.util.Iterator<String> it = abc.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
		}
	}

	public void ApplyOnRow(int val) {
		WebElement Row = driver.findElement(By.xpath("(//td[@columnname='Arrow'])[" + val + "]"));
		Row.click();
	}

	public void clickOnMenu(String val) {
		WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'" + val + "')]"));
		if (menu.isEnabled()) {
			menu.click();
		} else {
			driver.quit();
		}
	}

	public void getNaviagte() {
		driver.navigate().back();
	}

	public void ColumnFilter(String value) {
		if (value.contentEquals("First")) {
			FirstFilter.click();
		}
		if (value.contentEquals("Second")) {
			SecondFilter.click();
		}
		if (value.contentEquals("Third")) {
			ThirdFilter.click();
		}
		if (value.contentEquals("Four")) {
			FourthFilter.click();
		}
		if (value.contentEquals("Five")) {
			FifthFilter.click();
		}
		if (value.contentEquals("Six")) {
			SixthFilter.click();
		}

	}
	public String Filter(int val) {
		String value=" ";
		if (val == 5) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
			 value=column1.getText();
		}
		return value;
	}
	public void Verify(String value, int val) {
		if (val == 1) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 0) {
				if ((FirstColumn).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			
		}
		if (val == 2) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 3) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 4) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 5) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 6) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(value)) {
					System.out.println("The information is appeared correctly");
				} else {
					System.out.println("The information is not appeared correctly");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
	}

	public void Apply(int val) {
		WebElement apply = driver
				.findElement(By.xpath("(//a[@class='btn btn-primary left-btn' and text()='Apply'])[" + val + "]"));
		apply.click();
	}

	public void VerifyDate(int val) {
		if (val == 1) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 2) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			// WebElement
			// Column=driver.findElement(By.xpath("(//div[@class='tdParentWrap'])["+val+"]"));
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 3) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 4) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 5) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
		if (val == 6) {
			By column = By.xpath("(//div[@class='tdParentWrap'])[" + val + "]");
			if (common_func.isElementPresentBy(column)) {
				WebElement column1 = driver.findElement(By.xpath("(//div[@class='tdParentWrap'])[" + val + "]"));
				if ((column1).getText().contentEquals(CurrentDate())) {
					System.out.println("The date is verified");
				} else {
					System.out.println("The date is not verified");
				}
			}
			if (!common_func.isElementPresentBy(column)) {
				System.out.println(ResultNotFound.getText());
			}
		}
	}

	public String CurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		return date1;
	}

	public void HoverGetUsersTab() {
		Actions an = new Actions(driver);
		an.moveToElement(Users).perform();
	}

	public void ClickOnColumn(String value) {
		WebElement col = driver.findElement(By.xpath("(//label[contains(text(),'" + value + "')])[1]"));
		col.click();
	}

	public void DragsCol() throws InterruptedException, AWTException {
		WebElement From = driver.findElement(By.xpath("//table/thead/tr/th[5]"));
		// WebElement
		// To=driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/section[2]/table/thead/tr/th[2]/label"));
		WebElement To = driver.findElement(By.xpath("//table/thead/tr/th[6]"));
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		// act.dragAndDropBy(From,250,(int) 103.367).build().perform();
	}

	static String sort;
	String[] BeforeSort;
	String s;
	List<WebElement> columns;
	List<String> originalList1;

	public void fetchColumnData(int i) {
		if (i == 1) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 2) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 6) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 5) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 3) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 4) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		originalList1 = columns.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println("before sorting");
		System.out.println(originalList1);
	}
	public void fetchColumnData1(int i) {
		if (i == 1) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/div[1]"));
		}
		originalList1 = columns.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println("before sorting");
		System.out.println(originalList1);
	}

	List<WebElement> columns1;

	public void VerifyColumnData(int i) {
		if (i == 1) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 2) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 6) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 5) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 3) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 4) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		List<String> originalList = columns1.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println("sorted by clicking");
		System.out.println(originalList);
		List<String> sortedlist = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("sorted by method");
		System.out.println(sortedlist);
		Assert.assertTrue(originalList.equals(sortedlist));
	}
	

	int[] intArray;

	public void fetchColumnDataBySimpleMethod(int i) {
		if (i == 1) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 2) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 6) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 5) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 3) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 4) {
			columns = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		// List<WebElement> columns=
		// driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		BeforeSort = new String[columns.size()];
		System.out.println("Before Sorting");
		for (i = 0; i < columns.size(); i++) {
			BeforeSort[i] = columns.get(i).getText().trim();
			System.out.print(BeforeSort[i] + ", ");
		}

		/*
		 * for( i=0; i<columns.size()-1;i++) { Arrays.sort(BeforeSort);
		 * sort=BeforeSort[i]; System.out.print(sort+", ");}
		 */
		// String[] stringArray = BeforeSort.split(" ");
		// Converting each element into an integer
		/*
		 * intArray = new int[BeforeSort.length]; for(int i1 = 0; i1 <
		 * BeforeSort.length; i1++) { intArray[i1] = Integer.parseInt(BeforeSort[i1]); }
		 * Arrays.sort(intArray);
		 * System.out.println("Sorted integer values: "+Arrays.toString(intArray));
		 */
	}

	int[] intArray1;

	public void VerifyColumnDataBySimpleMethod(int i) {
		if (i == 1) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 2) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 6) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 3) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 4) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		if (i == 5) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/td[" + i + "]"));
		}
		// List<WebElement> columns=
		// driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		String[] afterSort = new String[columns.size()];
		System.out.println("\nSorted by clicking");
		for (i = 0; i < columns.size(); i++) {
			afterSort[i] = columns.get(i).getText().trim();
			System.out.print(afterSort[i] + ", ");
		}
		intArray = new int[afterSort.length];
		for (int i1 = 0; i1 < afterSort.length; i1++) {
			intArray[i1] = Integer.parseInt(afterSort[i1]);
		}
		Arrays.sort(intArray);
		intArray1 = new int[afterSort.length];
		for (int i1 = 0; i1 < afterSort.length; i1++) {
			intArray1[i1] = Integer.parseInt(afterSort[i1]);
		}
		System.out.println("\nSorted integer values: " + Arrays.toString(intArray));
		Assert.assertEquals(intArray, intArray1);

	}
	public void VerifyColumnDataBySimpleMethod2(int i) {
		if (i == 1) {
			columns1 = driver.findElements(By.xpath("//table/tbody/tr/div[1]"));
		}

		String[] afterSort = new String[columns.size()];
		System.out.println("\nSorted by clicking");
		for (i = 0; i < columns.size(); i++) {
			afterSort[i] = columns.get(i).getText().trim();
			System.out.print(afterSort[i] + ", ");
		}
		intArray = new int[afterSort.length];
		for (int i1 = 0; i1 < afterSort.length; i1++) {
			intArray[i1] = Integer.parseInt(afterSort[i1]);
		}
		Arrays.sort(intArray);
		intArray1 = new int[afterSort.length];
		for (int i1 = 0; i1 < afterSort.length; i1++) {
			intArray1[i1] = Integer.parseInt(afterSort[i1]);
		}
		System.out.println("\nSorted integer values: " + Arrays.toString(intArray));
		Assert.assertEquals(intArray, intArray1);

	}
}
