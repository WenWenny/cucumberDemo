package seleniumCucumberDemo.seleniumCucumberDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class TestingSeleniumSteps {

	@Before
	public void setUp() throws Exception {
		System.setProperty ( "webdriver.firefox.bin" , "D:\\firefox\\firefox.exe" );
		driver = new FirefoxDriver();
		//baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	private WebDriver driver;

}
