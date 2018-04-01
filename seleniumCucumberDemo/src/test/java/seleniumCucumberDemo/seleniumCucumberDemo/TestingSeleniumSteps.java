package seleniumCucumberDemo.seleniumCucumberDemo;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class TestingSeleniumSteps {

	@Before
	public void setUp() throws Exception {
		//System.setProperty ( "webdriver.firefox.bin" , "D:\\Program Files\\Mozilla Firefox\\firefox.exe" );
		System.setProperty ( "webdriver.chrome.driver" , "./driver/chromedriver.exe" );

		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		// baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^I am on the Baidu search page \"([^\"]*)\"$")
	public void i_am_on_the_Baidu_search_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		System.out.println(driver.toString()+""+arg1);
		//driver = new FirefoxDriver();
		driver.get(arg1+"/");
	}

	@When("^Enter \"([^\"]*)\" on the search text$")
	public void enter_on_the_search_text(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("selenium");
	    driver.findElement(By.id("su")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("selenium_百度搜索".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	}

	@When("^Click Search button$")
	public void click_Search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("su")).click();
	}

	@Then("^Check the title of website is \"([^\"]*)\"$")
	public void check_the_title_of_website_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("selenium_百度搜索", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	private WebDriver driver;
}
