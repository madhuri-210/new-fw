package com.visionit.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescriptionPageObjects {
	private static final Logger logger = LogManager.getLogger(ProductDescriptionPageObjects.class);
	private WebDriver driver;
	private By product_title=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

	public ProductDescriptionPageObjects(WebDriver driver){
		this.driver=driver;
	}
	
	public void ValidateProductTitleIsDisplayed(){
		if(driver.findElement(product_title).isDisplayed()){
			Assert.assertTrue(true);
			logger.info("Product Title is displayed");
		}
		else{
			logger.info("Product Title is not displayed");
			Assert.fail("Product Title is not displayed");
		}
		
	}

}
