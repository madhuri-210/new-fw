package com.visionit.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefs {
	WebDriver driver;
	String base_url="http://amazon.in/";
	int implicit_wait_timeout_in_sec=20;
	Scenario scn;
	
	@Before
	public void setUp(Scenario scn) {
		this.scn=scn;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	}

	@After
	public void cleanUp(){
		driver.quit();
		scn.log("Browser Closed");
	}

	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to URL: " + base_url);
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual=driver.getTitle();
		Assert.assertEquals("Page Title validation", expected, actual);
		scn.log("Page Title Valiadation successfull.Actual title: "+actual );
	}

	@When("User Search for product {string}")
	public void user_search_for_product(String productName) {
		WebDriverWait webDriverwait=new WebDriverWait(driver,20);
		WebElement elementSearchBox=webDriverwait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		elementSearchBox.sendKeys(productName);
		driver.findElement(By.xpath("//input[@value='Go']"));
		scn.log("Product Searched: " + productName);   
	}

	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
		WebDriverWait webDriverwait1=new WebDriverWait(driver,20);
		webDriverwait1.until(ExpectedConditions.titleIs("Amazon.in : laptop"));
		//Assertion for page title
		Assert.assertEquals("Page Title validation", "Amazon.in : laptop", driver.getTitle());
		scn.log("Search page is displayed");
	}
}
