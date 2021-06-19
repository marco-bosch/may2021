package com.jakartalabs.may2021.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jakartalabs.may2021.utils.TestUtils;

public class LoginPage extends BasePage {

	/**
	 * @param driver
	 */
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit' and text()='Login']");

	public void login(String user, String pwd) {

		setText(username, user);
		setText(password, pwd);
		clickAndWait(loginBtn);

	}

	public void loginWithRightClick(String user, String pwd) {

		clickAndWait(username);
		contextClick(username);
		TestUtils.hardWait(15);

	}
}
