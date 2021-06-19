package com.jakartalabs.may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

	public ProfilePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	String profileUsername = "//strong[text()='%s']";

	public boolean verifyProfileName(String actualProfileName) {

		By finalXpath = By.xpath(String.format(profileUsername, actualProfileName));

		return getText(finalXpath).equals(actualProfileName);

	}

}
