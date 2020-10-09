package com.visionit.automation.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObjects {
	private static final Logger logger=LogManager.getLogger(SearchPageObjects.class);

	private WebDriver driver;
	private By search_refinement_categories_segment  = By.id("s-refinements");
	private By product_link_list=By.xpath("//a[@class='a-link-normal a-text-normal']");
	private By add_to_cart_btn=By.id("add-to-cart-button");
	
	public SearchPageObjects(WebDriver driver){
		this.driver=driver;
	}
	
	public void ValidateProductSearchIsSuccessfull(){
		if (driver.findElement(search_refinement_categories_segment).isDisplayed()){
			Assert.assertTrue(true);
			logger.info("Search Page is displayed because refinement category is displayed");
		}else{
			logger.fatal("Search Page is not displayed because refinement category is not displayed");
			Assert.fail("Search Page is not displayed because refinement category is not displayed");
		}
	}
	
	public String ClickOnTheProductLink(int productIndex){
		//listOfProducts will have all the links displayed in the search box
		List<WebElement> listOfProducts = driver.findElements(product_link_list);
		logger.info("Number of products searched: " + listOfProducts.size());

		//Link on the  link with argument productIndex
		listOfProducts.get(productIndex).click();
		logger.info("Clicked on the Link in the List with index: " + productIndex +
				". Link Text: " + listOfProducts.get(productIndex).getText());
		return listOfProducts.get(productIndex).getText();

	}
	
	public void UserClickOnAddToCartBtn(){
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(add_to_cart_btn).click();
		logger.info("Clicked on the Add To Cart Buttun");
	}
	

}
