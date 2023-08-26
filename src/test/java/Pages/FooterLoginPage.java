package Pages;

import Utilities.YmlUtil;
import Utilities.basePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.Utility;
import Pages.commonFunctions;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FooterLoginPage extends basePage {
	LoginPage loginPage = new LoginPage();
	commonFunctions common_func = new commonFunctions();
	String urlFileName = "src/test/resources/TestData/Urls.yaml";
	YmlUtil yamlData = new YmlUtil();
	Utility utility = new Utility();
	public WebDriverWait wait;
	@FindBy(id="fname")
	WebElement fn;
	@FindBy(id="lname")
	WebElement ln;
	@FindBy(id="phone")
	WebElement ph;
	@FindBy(id="email")
	WebElement email;
	@FindBy(xpath="//a[@class='btn' and text()='Cancel ']")
	WebElement cancel;
	@FindBy(xpath="//a[@class='btn btn-primary pull-left' and text()='Send']")
	WebElement submit;
	@FindBy(id="message")
	WebElement msg;
	@FindBy(xpath="//span[contains(text(),'Go Back to Login')]")
	WebElement Gobacklogin;
	@FindBy(xpath="/html/body/section/div/div[1]/a/img")
	WebElement backlogin;
	@FindBy(xpath="//*[@class='col-sm-7']/input")
	WebElement emailfield;
	@FindBy(xpath="//a[contains(text(),'Verify Email')]")
	WebElement verifyemail;
	@FindBy(xpath="//span[text()='Please provide your business email address']")
	WebElement Validation_Msg;
	@FindBy(xpath="//span[@class='alert-msg']")
	WebElement alertmsg;
	public FooterLoginPage() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	public void SendMsgContactUsCancel() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(fn));
		fn.sendKeys("test1saima");
		Thread.sleep(3000);
		ln.sendKeys("test1Tabassum");
		Thread.sleep(3000);
		ph.sendKeys("033438473857");
		Thread.sleep(3000);
		email.sendKeys("saima.tabassum@arpatech.com");
		Thread.sleep(3000);
        msg.sendKeys("Hi, This is a test message");
		Thread.sleep(3000);
		cancel.click();
		Thread.sleep(5000);
	}

	public void SendMsgContactUsSubmit() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(fn));
		fn.sendKeys("test1saima");
		Thread.sleep(3000);
		ln.sendKeys("test1Tabassum");
		Thread.sleep(3000);
		ph.sendKeys("033438473857");
		Thread.sleep(3000);
		email.sendKeys("saima.tabassum@arpatech.com");
		Thread.sleep(3000);
		msg.sendKeys("Hi, This is a test message");
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(5000);
	}

	public WebElement BackLoginPage(WebDriver driver) {

		return backlogin;
	}

	public void WindowHandler() throws InterruptedException {
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		Thread.sleep(5000);
	}

	public void ParentWindowHandler() throws InterruptedException {
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler3 = null;
		Set<String> handles3 = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator3 = handles3.iterator();
		while (iterator3.hasNext()) {

			subWindowHandler3 = iterator3.next();
			if (!parentWindowHandler.equals(subWindowHandler3)) {
				driver.switchTo().window(subWindowHandler3);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandler);
	}

	public WebElement GoBackloginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		return Gobacklogin;
	}
}
