package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import Utilities.YmlUtil;
import Utilities.basePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver driver;
	public static Logger logger;
	String fileName = "src/test/resources/TestData/signInData.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();

	@FindBy(id = "email")
	public WebElement emailAddress;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//*[@id=\"validation_code\"]")
	WebElement Validation_code;
	@FindBy(css = "[type=\"submit\"]")
	WebElement complete_auth;
	@FindBy(xpath = "//title")
	public WebElement titleText;
	@FindBy(css = "[type='submit']")
	public WebElement submitBtn;
	@FindBy(xpath = "/html/body/header/section/div[3]/div[1]/a/span[2]")
	public WebElement AccountMenu;
	@FindBy(xpath = "//*[@id=\"top-header\"]/section/div[3]/div[1]/div/ul/li[12]/a")
	public WebElement logoutBtn;
	@FindBy(xpath = "(//span[contains(text(),'My Account ')])[1]")
	public WebElement myAccount;
	@FindBy(xpath = "//a[@id='forgetUrl']")
	public WebElement Forget_Pswd;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement Sbmt_Btn;
	@FindBy(name = "email")
	public WebElement emailfield;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement Usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement Passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Loginbtn;

	public LoginPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);

	}

	public void insertPassword(String cred) throws Exception {
//		logger.info("------------ ");
		String pass = yamlData.getDataYML(fileName, cred, "password");
		utility.setText(password, pass);
	}

	public String getTitleText() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title")));
		return titleText.getText();
	}

	public void sendUsername(String cred) throws Exception {
		String Username = yamlData.getDataYML(fileName, cred, "Username");
		utility.setText(emailAddress, Username);
	}

	public void sendValidationCode(String cred) throws Exception {

		String code = yamlData.getDataYML(fileName, cred, "code");
		utility.setText(Validation_code, code);
	}

	public String extractMsg(String message) throws Exception {
		String[] s1 = message.split("is ");
		String[] s2 = s1[1].split(" and");
		System.out.println("loginPage Object is: " + s2[0]);
		return s2[0];
	}

	public String extractMsg1(String message) throws Exception {
		String[] s1 = message.split("\\+");
		String name = "00" + s1[1];
		name = name.replaceAll(" ", "");
		return name;
	}

	public void clickOnMyAccount() {
		utility.clickButton(myAccount);
	}

	public void clickOnButton(WebElement btn) {
		utility.clickButton(btn);
	}

	public void clickOnLogoutButton() {
		utility.clickButton(logoutBtn);
	}

	public void clickOnCompleteButton() {
		utility.clickButton(complete_auth);
	}

	public void clickOnLoginButton() {
		utility.clickButton(submitBtn);
	}

	public void clickOnAccountMenuButton() {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOf(AccountMenu));
		utility.clickButton(AccountMenu);
	}

}