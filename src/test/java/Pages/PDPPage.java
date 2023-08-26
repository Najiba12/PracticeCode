package Pages;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.basePage;

public class PDPPage {
	public WebDriver driver;
	public static Logger logger;
	Utility utility = new Utility();
	public WebDriverWait wait;
	commonFunctions common_func = new commonFunctions();

	public PDPPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchedText")
	WebElement ctaPopupSearchText;
	@FindBy(xpath = "//input[@name='productQty']")
	public WebElement prodQty1;
	@FindBy(xpath = "//a[@id='updateSubscription']")
	public WebElement User;
	@FindBy(xpath = "//button[contains(text(),'Cancel Update')]")
	public WebElement updtaeCancel;
	@FindBy(xpath = "//button[contains(text(),'Continue with Update')]")
	public WebElement contUp;
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement cont;
	@FindBy(xpath = "//*[@class='btn btn-to-cart modal-btn hide-for-print']")
	WebElement PDetailGetEstimate;
	@FindBy(xpath = "//input[@id='searchedText']")
	WebElement CreateEstimateEmail;
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"][contains(text(),'Continue')]")
	WebElement CreateEstimateEmailContIn;
	@FindBy(xpath = "//textarea[@title='note']")
	WebElement CreateEstimateNote;
	@FindBy(xpath = "//*[@id='invoice-view']//p[@class='comp-name']//a[contains(text(),'Submit')]")
	WebElement CreateEstimateNoteContinue;
	@FindBy(xpath = "//div[@class='shopping-cart checkout-cart-header']//a[contains(text(),'Back')]")
	public WebElement noaccessback;
	@FindBy(xpath = "//*[@class='order-container container clearfix']//a[contains(text(),'Manage')]")
	public WebElement mangesubscCTA;
	@FindBy(xpath = "//a[@class='action-icon icon-estimates']")
	public WebElement viewestimate;
	@FindBy(xpath = "//p[@class='detail blue'][contains(text(),'Active')][1]")
	public WebElement add;
	@FindBy(xpath = "//a[@id=\"getNowBtn\"][text()='Get it Now']")
	public WebElement getitNow;
	@FindBy(xpath = "//input[@id='SearchBySubscription']")
	public WebElement SearchSub;
	@FindBy(xpath = "//img[@class='tooltip_img']")
	public WebElement Username_tooltip1v;
	@FindBy(xpath = "//div[@class='tooltip tt-text']")
	public WebElement Username_tooltip1;
	@FindBy(xpath = "//div[@class='search-container']//i[@class='fa fa-search icon-search']")
	public WebElement pop7;
	@FindBy(xpath = "//section/div[1]/div/ul/li[1]/p/span")
	public WebElement show11v;
	@FindBy(xpath = "//section/div[1]/div/ul/li[2]/p/span")
	public WebElement show21;
	@FindBy(xpath = "//section/div[1]/div/ul/li[3]/p/span")
	public WebElement show31;
	@FindBy(xpath = "//section/div[1]/div/p[1]")
	public WebElement show41;
	@FindBy(xpath = "//section/div[1]/div/ul/li[5]/p/span")
	public WebElement show51;
	@FindBy(xpath = "//section/div[1]/div/div[1]/h1")
	public WebElement show61;
	@FindBy(xpath = "//div[1]/div[1]/section[3]/h2")
	public WebElement show71;
	@FindBy(xpath = "//p[contains(text(),'Active')]")
	public WebElement Active;
	@FindBy(xpath = "//p[contains(text(),'Cancelled')]")
	public WebElement Cancelled;
	@FindBy(xpath = "//*[@class='order-container container clearfix']//a[contains(text(),'Buy it Again')]")
	public WebElement BuyItAgain;
	public void image() {
		By show11v1 = By.xpath("//a[@class='image-link']//img");
		wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(show11v1));
		driver.findElement(show11v1).click();
	}

	public void clickAgree() {
		By agree = By.xpath("//*[@id='OrderApp']/div[6]/div/div/div/div/div/div[3]/div/div/div[3]/a");
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(agree));
		if (common_func.isElementPresentBy(agree)) {
			driver.findElement(agree).click();
		}
	}

	public void CTAPopupSearching(String text, String[] Dropdown)
			throws IOException, InterruptedException, ClassNotFoundException {
		int cnt = 0;
		(ctaPopupSearchText).sendKeys(Keys.CONTROL, "a");
		Thread.sleep(3000);
		(ctaPopupSearchText).sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		(ctaPopupSearchText).sendKeys(text);
		WebElement menu = driver.findElement(By.xpath(
				"//div[@id='marketplace-content']//div[@id='pdp-main-wrapper']//div[@class='modal-content']//div[@class='refine-section-content']"));
		List<WebElement> elems = menu.findElements(By.tagName("li"));
		for (WebElement ddlList : elems) {
			Assert.assertEquals(ddlList.getText().trim(), Dropdown[cnt],
					"The Options appearing are not same as expected");
			cnt++;
		}
	}

	public void gotoURL1(String url) throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		driver.navigate().to(url);
	}

	public void envFetchID(String env, String dburl, String dbun, String dbpswd)
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		if (env.contentEquals("uat")) {
			String QUERY = "SELECT id FROM estimates WHERE user_id=725 ORDER BY ID  DESC LIMIT 1";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(dburl, dbun, dbpswd);
			java.sql.Statement stmt2 = con1.createStatement();
			ResultSet rsg = stmt2.executeQuery(QUERY);
			int cs121 = 0;
			while (rsg.next()) {
				cs121 = rsg.getInt("id");
			}
			String hurl = "https://ccpuat-customerportal.arpatech.com/catalog/estimates/" + cs121;
			gotoURL1(hurl);
			Thread.sleep(5000);
		}
	}

	public void presenceElement() {

		if (show11v.isDisplayed()) {
			System.out.println("1dfdfd");
		}
		if (show21.isDisplayed()) {
			System.out.println("dfd");
		}
		if (show31.isDisplayed()) {
			System.out.println("1");
		}
		if (show41.isDisplayed()) {
			System.out.println("2");
		}
		if (show51.isDisplayed()) {
			System.out.println("3");
		}
		if (show61.isDisplayed()) {
			System.out.println("4");
		}
		if (show71.isDisplayed()) {
			System.out.println("5");
		}
	}

	public void Tooltip() throws InterruptedException {
		Actions builder1 = new Actions(driver);
		Thread.sleep(3000);
		builder1.moveToElement(Username_tooltip1v).perform();
		Thread.sleep(3000);
		String tooltip_msg1 = Username_tooltip1.getText();
		Thread.sleep(3000);
		System.out.println("Tooltip/ Help message is " + tooltip_msg1);
	}

	public void createEstimates() throws IOException, InterruptedException, ClassNotFoundException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 10000);
		System.out.println("hi");
		common_func.ClickOnLink(PDetailGetEstimate);
		Thread.sleep(5000);
		CreateEstimateEmail.sendKeys("ayer.shuja@arpatech.com");
		Thread.sleep(5000);
		common_func.ClickOnLink(CreateEstimateEmailContIn);
		Thread.sleep(8000);
		common_func.ClickOnLink(CreateEstimateNote);
		CreateEstimateNote.sendKeys("Hello This is Dummy Estimate Notes");
		Thread.sleep(5000);
		common_func.ClickOnLink(CreateEstimateNoteContinue);
		Thread.sleep(5000);
	}

	public void fetchCurrentSeats(String env, String dburl, String dbun, String dbpswd)
			throws ClassNotFoundException, SQLException, InterruptedException {
		if (env.contentEquals("uat")) {
			String j1;
			int ten = 262;
			String query = "SELECT current_seats FROM  subscriptions where tenant_id=" + ten + ";";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbun, dbpswd);
			java.sql.Statement stmt = con.createStatement();
			System.out.println("query =" + query);
			ResultSet rs = stmt.executeQuery(query);
			int consult = 0;
			while (rs.next()) {
				consult = rs.getInt("current_seats");
			}
			Thread.sleep(5000);
			j1 = String.valueOf(consult + 1);
			Thread.sleep(5000);
			prodQty1.sendKeys(Keys.CONTROL);
			prodQty1.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(5000);
			prodQty1.clear();
			prodQty1.sendKeys(j1);
			Thread.sleep(6000);
			User.click();
			Thread.sleep(5000);
			updtaeCancel.click();
			prodQty1.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(5000);
			prodQty1.clear();
			prodQty1.sendKeys(j1);
			Thread.sleep(6000);
		}

	}

	public void passValueClickOnActive(String value) throws InterruptedException {
		SearchSub.sendKeys(value);
		Thread.sleep(5000);
		pop7.click();
		Thread.sleep(15000);
	}

	public void Order() throws InterruptedException {
		wait = new WebDriverWait(driver, 10000);
		WebElement h1 = driver.findElement(By.xpath("//*[@id='step5-form']/div/div[2]/div[3]/a"));
		h1.click();
		Thread.sleep(5000);
		By submitorder = By.xpath("//button[@class='btn btn-default btn-create-account btn-primary']");
		Thread.sleep(5000);
		driver.findElement(submitorder).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.titleContains("Order Received - CCM"));
		Assert.assertEquals(driver.getTitle(), "Order Received - CCM",
				"After clicking on submit button on procurement checkout, user is not able to navigate to order received page");
	}

	public void fetchesSeats(String dburl, String dbun, String dbpswd)
			throws InterruptedException, ClassNotFoundException, SQLException {
		String query = "SELECT id FROM estimates WHERE user_id=988 ORDER BY ID  DESC LIMIT 1";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dburl, dbun, dbpswd);
		java.sql.Statement stmt = con.createStatement();
		System.out.println("query =" + query);
		ResultSet rs = stmt.executeQuery(query);
		int cs1 = 0;
		while (rs.next()) {
			cs1 = rs.getInt("id");
		}
		String j2 = String.valueOf(cs1);
		int j3 = Integer.parseInt(j2);
		String query1 = "SELECT seats FROM estimate_items WHERE estimate_id=" + j3 + ";";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("query =" + query1);
		ResultSet rs1 = stmt.executeQuery(query1);
		int consult = 0;
		while (rs1.next()) {
			consult = rs1.getInt("seats");
		}
		String j4 = String.valueOf(consult + 1);
		prodQty1.sendKeys(j4);
		Thread.sleep(3000);
	}
}
