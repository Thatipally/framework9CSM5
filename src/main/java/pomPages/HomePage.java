package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class HomePage {

	//Declaration
	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement profileButton;
	
	@FindBy(xpath="//li[.='My Profile']")
	private WebElement myProfile;
	
	@FindBy(xpath="//li[.='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Electronic']")
	private WebElement electronicTab;
	
	@FindBy(xpath="//a[text()='Headphones']")
	private WebElement headphoneLink;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
	//Utilization
	public void ClickProfileButton() throws InterruptedException
	{
		profileButton.click();
		Thread.sleep(2000);
	}
	
	public void selectMyProfile()
	{
		myProfile.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	public void mouseHoverToElectronic(WebDriverUtility web)
	{
		web.mouseHover(electronicTab);
	}
	public void clickHeadPhoneLink()
	{
		headphoneLink.click();
	}
}
