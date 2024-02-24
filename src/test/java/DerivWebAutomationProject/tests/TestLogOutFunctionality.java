package DerivWebAutomationProject.tests;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DerivWebAutomationProject.PageObjects.OrangeHrmAdminPanelPage;
import DerivWebAutomationProject.PageObjects.OrangeHrmLogInPage;
import DerivWebAutomationProject.PageObjects.OrangeHrmMyInfoPage;
import DerivWebAutomationProject.testcomponents.baseTest;

public class TestLogOutFunctionality extends baseTest{
	
	
	@Test
	public void validateLogOut() throws IOException, UnsupportedFlavorException
	{
		OrangeHrmAdminPanelPage hpp=lp.logInApp(getPropertyValue("username"),getPropertyValue("password"));
		OrangeHrmLogInPage lp1=hpp.logOut();
		lp1.validateLoginPage();
		
	}
	
	
}
