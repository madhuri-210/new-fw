package com.visionit.automation.pageobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {
	private static final Logger logger=LogManager.getLogger(CmnPageObjects.class);

	WebDriver driver;
	private By search_text_box=By.id("twotabsearchtextbox");
	private By search_button=By.xpath("//input[@value='Go']");

	public CmnPageObjects(WebDriver driver){
		this.driver=driver;
	}

	public void SetSearchTextBox(String text){
		WebDriverWait webDriverWait=new WebDriverWait(driver,20);
		WebElement elementSearchBox=webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		elementSearchBox.sendKeys(text);
		logger.info("Value entered in search box: " + text);
	}

	public void ClickOnSearchButton(){
		driver.findElement(search_button).click();
		logger.info("Clicked on Search Button");
	}

	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Page title matched: " + expectedTitle );
	}

}
