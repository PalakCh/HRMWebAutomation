package DerivWebAutomationProject.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DerivWebAutomationProject.AbstractComponents.AbstractComponents;


public class OrangeHrmLogInPage extends AbstractComponents{
	private static Logger log = LogManager.getLogger(OrangeHrmLogInPage.class.getName());
	WebDriver driver;
	
	public OrangeHrmLogInPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement logIn;
	
	@FindBy(xpath="//h5")
	WebElement title;
	
	public OrangeHrmAdminPanelPage logInApp(String uname, String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		logIn.click();
		log.info("Logged In Successfully");
		OrangeHrmAdminPanelPage hpp = new OrangeHrmAdminPanelPage(driver);
		return hpp;
	}
	
	public void validateLoginPage()
	{
		Assert.assertEquals("Login", title.getText());
		log.info("Logged Out Successfully");
	}
	
		
}
