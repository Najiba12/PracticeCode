package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class basePage {
//	public static Logger Log = LogManager.getLogger(base.class.getName());

	public static SoftAssert softAssertH;
	public static WebDriver driver;

	public static WebDriver initializeDriver() throws IOException, InterruptedException {
		softAssertH = new SoftAssert();
			Properties prop = new Properties();
			try (InputStream fis = basePage.class.getClassLoader().getResourceAsStream("config/data.properties")) {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			String browserName = prop.getProperty("browserType");
			//String url = prop.getProperty("customer_uat_url");
			System.out.println("Browser selected is " + browserName);

			if (browserName.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				if (System.getProperty("headless") != null && System.getProperty("headless").equalsIgnoreCase("true")) {
					options.addArguments("--headless");
					options.addArguments("--no-sandbox");
				}

				String chromeBinaryPath = prop.getProperty("chrome_binary_path");
				if (chromeBinaryPath != null && !chromeBinaryPath.isEmpty()) {
					options.setBinary(chromeBinaryPath);
				}
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equals("ie")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}

			if (driver != null) {
				//driver.get(url);
				driver.manage().window().maximize();
			}

			return driver;
	}

	public static WebDriver getdriver() {
		if (driver == null) {
			return driver;
		} else {
			return driver;
		}
	}
	public static void quitDriver() {
		driver.quit();
	}
}