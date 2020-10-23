package com.visionit.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.visionit.automation.pageobjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	WebDriver driver;
	String base_url="https://amazon.in/";
	int implicit_wait_timeout_in_sec=20;
	Scenario scn;

	CmnPageObjects cmnPageObjects;
	SearchPageObjects searchPageObjects;
	ProductDescriptionPageObjects productDescriptionPageObjects;

	@Before
	public void setUp(Scenario scn)throws Exception {
		this.scn=scn;
		logger.info("Browser invoked.");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		cmnPageObjects=new CmnPageObjects(driver);
		searchPageObjects=new SearchPageObjects(driver);
		productDescriptionPageObjects=new ProductDescriptionPageObjects(driver);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...

			TakesScreenshot scrnShot=(TakesScreenshot)driver;
			byte[] data=scrnShot.getScreenshotAs(OutputType.BYTES);
			////scn.attach(data, "image/png", "screenshot_01");

			driver.quit();
			scn.log("Browser Closed");
		}
	}
	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to URL: " + base_url);
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		cmnPageObjects.validatePageTitleMatch(expected);	
	}

	@When("User Search for product {string}")
	public void user_search_for_product(String productName) {
		cmnPageObjects.SetSearchTextBox(productName);
		cmnPageObjects.ClickOnSearchButton();
		scn.log("Product Searched: " + productName);   
	}

	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
		searchPageObjects.ValidateProductSearchIsSuccessfull();
		scn.log("Search page is displayed");
	}

	@When("User click on any product")
	public void user_click_on_any_product() {
		searchPageObjects.ClickOnTheProductLink(0);
		scn.log("Click on any product");
	}

	@Then("Product Description is displayed in new tab")
	public void product_description_is_displayed_in_new_tab() {
		productDescriptionPageObjects.ValidateProductTitleIsDisplayed();
		scn.log("Switched to the new tab");	
	}

	@Then("User is click on Add to cart")
	public void user_is_click_on_add_to_cart() {
		searchPageObjects.UserClickOnAddToCartBtn();
		scn.log("Clicked on add to cart button");
	}

	@Given("User search for tha product {string}")
	public void user_search_for_tha_product(String productName) {
		cmnPageObjects.SetSearchTextBox(productName);
		cmnPageObjects.ClickOnSearchButton();
		scn.log("Product Searched: " + productName);
	}

	@Then("User is click on Add to wish list button")
	public void user_is_click_on_add_to_wish_list_button() {
		searchPageObjects.UserClickOnAddToWishListBtn();
		scn.log("User clicked on Add to wish list button");
	}

	@Then("Search result page are displayed")
	public void search_result_page_are_displayed() {
		searchPageObjects.ValidateProductSearchIsSuccessfull();
		scn.log("Search page are displayed");
	}
	
}
