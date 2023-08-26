package Pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import Utilities.basePage;
import org.openqa.selenium.Keys;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctions {
	public WebDriver driver;
	Utility utility = new Utility();
	@FindBy(xpath = "//input[@id='main-search']")
	public WebElement SearchTab;
	@FindBy(xpath = "//title")
	public WebElement titleText;

	public commonFunctions() {
		this.driver = basePage.getdriver();
		PageFactory.initElements(driver, this);
	}

	public void GetSearchTab(String value) {
		utility.setText(SearchTab, value + Keys.ENTER);
	}

	public void Scrolls() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void ScrollsUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
	}

	public void ClickOnLink(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
	//	wait.until(ExpectedConditions.visibilityOf(Element));
		Element.click();
	}
	public WebElement getWebElement(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(Element));
		return Element;
	}
	public WebElement getOnLinkText(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.linkText(text));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	public WebElement getSpanText(String Expectedtext) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'"+Expectedtext+"')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public WebElement getAreftext(String Expectedtext) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'"+Expectedtext+"')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public void clickOnButton(String Expectedtext) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.xpath("//button[contains(text(),'"+Expectedtext+"')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	public WebElement getLabelText(String Expectedtext) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'"+Expectedtext+"')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public WebElement getById(String Expectedtext) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement element=driver.findElement(By.id(Expectedtext));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	public String getText(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	public boolean isElementPresent(WebElement element) {
	try {
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresentBy(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public String getTitlePage() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title")));
		return titleText.getText();
	}
}
