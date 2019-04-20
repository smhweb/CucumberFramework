package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class UsbFlashDrivesTestDefinitions {

	WebDriver driver = null;

	@Before
	public void Login() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Baba-PC\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.customink.com/");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^Buyer at home page of CustomInk$")
	public void buyer_at_home_page_of_CustomInk() throws Throwable {
		
		System.out.println();
		String expectedURL = "https://www.customink.com/";

		if (expectedURL.contentEquals(driver.getCurrentUrl())) {
			System.out.println("Buyer at home page of Custom Ink!");
		} else {
			System.out.println("Buyer is NOT at home page of Cutom Ink.");
		}
	}

	@When("^Buyer mouse over PRODUCTS tab$")
	public void buyer_mouse_over_PRODUCTS_tab() throws Throwable {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("sb-menu-products"))).build().perform();

	}

	@And("^Buyer selects Tech Accessories from dropdown$")
	public void buyer_selects_Tech_Accessories_from_dropdown() throws Throwable {
		driver.findElement(By.linkText("Tech Accessories")).click();
	}

	@And("^Buyer selects USB Flash Drives display$")
	public void buyer_selects_USB_Flash_Drives_display() throws Throwable {
		driver.findElement(By.linkText("USB Flash Drives")).click();
	}

	@And("^Buyer prints Drivers Displayed$")
	public void buyer_prints_Drivers_Displayed() throws Throwable {
		System.out.println();
		System.out.println("USB Drives by GB displayed on page are: ");
		System.out.println("USB Drive " + driver.findElement(By.cssSelector(
				"body > div.sb-PageWrapper > main > div.pc-Styles.is-pcActivationControl > div.pc-Styles-body.sb-Wrapper > div.pc-Styles-products.is-filterSortShown > div.pc-Products > div:nth-child(1) > a > div.pc-ProductCard-details > div.pc-ProductCard-detailTitle"))
				.getText().charAt(23) + " GB");
		System.out.println("USB Drive " + driver.findElement(By.cssSelector(
				"body > div.sb-PageWrapper > main > div.pc-Styles.is-pcActivationControl > div.pc-Styles-body.sb-Wrapper > div.pc-Styles-products.is-filterSortShown > div.pc-Products > div:nth-child(2) > a > div.pc-ProductCard-details > div.pc-ProductCard-detailTitle"))
				.getText().charAt(23) + " GB");
		System.out.println("USB Drive " + driver.findElement(By.cssSelector(
				"body > div.sb-PageWrapper > main > div.pc-Styles.is-pcActivationControl > div.pc-Styles-body.sb-Wrapper > div.pc-Styles-products.is-filterSortShown > div.pc-Products > div:nth-child(4) > a > div.pc-ProductCard-details > div.pc-ProductCard-detailTitle"))
				.getText().charAt(23) + " GB");
		System.out.println("USB Drive " + driver.findElement(By.cssSelector(
				"body > div.sb-PageWrapper > main > div.pc-Styles.is-pcActivationControl > div.pc-Styles-body.sb-Wrapper > div.pc-Styles-products.is-filterSortShown > div.pc-Products > div:nth-child(5) > a > div.pc-ProductCard-details > div.pc-ProductCard-detailTitle"))
				.getText().charAt(23) + " GB");
	}

	@Then("^Buyer prints page title$")
	public void buyer_prints_page_title() throws Throwable {
		System.out.println();
		System.out.println("Title of the page is: " + driver.getTitle());
	}
}
