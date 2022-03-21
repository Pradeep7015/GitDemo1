package Steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class google {
	WebDriver driver = null;
//public static final String IO_CUCUMBER_CORE_CLI_MAIN = "io.cucumber.core.cli.Main";
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step-browser is open");
System.out.println("hi");
		String projectpath = System.getProperty("user.dir");
		System.out.println("the project path is:" + projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("inside step-user is on google search page");
		driver.get("https://www.google.com/");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		System.out.println("inside step-user enters a text in search box");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys("how to find locator using console");
Thread.sleep(2000);
	}

	@When("hits enter")
	public void hits_enter() throws InterruptedException {
		System.out.println("inside step-hits enter");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigate to search results")
	public void user_is_navigate_to_search_results() {
		System.out.println("inside step-user is navigate to search results");
		driver.getPageSource().contains("How to Check Locator in console?");
		driver.close();
	}

}
