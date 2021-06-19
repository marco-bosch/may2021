package com.jakartalabs.may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogHomePage extends BasePage {
	/**
	 * @param driver
	 */
	public BlogHomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	By blogName = By.xpath("//a[contains(text(),'TestAutomasi Blog')]");
}
