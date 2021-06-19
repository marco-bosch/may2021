package com.jakartalabs.may2021.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.jakartalabs.may2021.AppEnums;
import com.jakartalabs.may2021.pages.CommonWebPage;
import com.jakartalabs.may2021.pages.HomePage;
import com.jakartalabs.may2021.pages.LoginPage;
import com.jakartalabs.may2021.pages.ProfilePage;
import com.jakartalabs.may2021.utils.DataUtils;

/**
 * Unit test for simple AppEnums.
 */
public class AppTest extends BaseWebTest {

	HomePage homePage = new HomePage(driver, explicitWait);
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	CommonWebPage CommonWebPage = new CommonWebPage(driver, explicitWait);

	@Test
	public void loginTest() {

		String username = DataUtils.getDataFromExcel("Config", "Username");
		String password = DataUtils.getDataFromExcel("Config", "Password");

		homePage.clickOnMenuItem(AppEnums.MenuNames.LOGIN.toString());
		loginPage.login(username, password);
		assertEquals(profilePage.verifyProfileName(username), true);

	}

	@Test
	public void verifyBlogUrl() {
		homePage.clickOnMenuItem(AppEnums.MenuNames.BLOG.toString());
		assertEquals(CommonWebPage.getCurrentUrlFromWebPage(), "https://testautomasi.com/blog/");

	}

	@Test
	public void verifyTabAndWindowSwitches() {
		CommonWebPage.openTab();
		CommonWebPage.switchTabOrWindow(1);
		CommonWebPage.goToUrl("https://facebook.com");
		CommonWebPage.openWindow();
		CommonWebPage.switchTabOrWindow(2);
		CommonWebPage.goToUrl("https://twitter.com");

		CommonWebPage.switchTabOrWindow(0);

	}

	@Test
	public void verifyNavigations() {
		CommonWebPage.goToUrl("https://facebook.com");
		CommonWebPage.navigateBrowser(AppEnums.NavigationCommands.BACK.toString());
		CommonWebPage.navigateBrowser(AppEnums.NavigationCommands.FORWARD.toString());
		CommonWebPage.navigateBrowser(AppEnums.NavigationCommands.REFRESH.toString());

	}

	@Test
	public void verifyJSAndAlerts() {
		String script = "alert('hello')";
		CommonWebPage.runJavaScript(script);
		CommonWebPage.acceptPopup();
	}

	@Test
	public void rightClick() {

		String username = DataUtils.getDataFromExcel("Config", "Username");
		String password = DataUtils.getDataFromExcel("Config", "Password");

		homePage.clickOnMenuItem(AppEnums.MenuNames.LOGIN.toString());
		loginPage.loginWithRightClick(username, password);

	}

}
