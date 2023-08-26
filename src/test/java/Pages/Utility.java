package Pages;

import Utilities.YmlUtil;
import Utilities.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.Keys;
public class Utility {
	public WebDriver driver;
	YmlUtil yamlData = new YmlUtil();

	public Utility() {
		try {
			this.driver = basePage.getdriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	WebDriverWait wait = new WebDriverWait(driver, 100);

	public void waitForElement(WebDriver d, WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(d, 10000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void fluentWaitForElement(WebDriver d, WebElement element) {
		Wait wait = new FluentWait(d).withTimeout(Duration.ofSeconds(100))
				.ignoring(Exception.class).ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementEnabled(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickButton(WebElement locator) {
		waitForElementEnabled(driver, locator);
		locator.click();
	}

	public void setText(WebElement locator, String value) {
		fluentWaitForElement(driver, locator);
		locator.clear();
		locator.click();
		locator.sendKeys(value);
	}
	public String getTextFunc(WebElement locator) {
		fluentWaitForElement(driver, locator);
		return locator.getText();
	}
	public void clickOnWebElement(String textView) {
		driver.findElement(By.xpath("//a[contains(@text,'" + textView + "')]")).click();
		;
	}

}
