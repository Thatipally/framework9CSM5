package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	//Declaration
	@FindBy(id="First Name")
	private WebElement firstnameTF;
	
	@FindBy(id="Last Name")
	private WebElement lastnameTF;
	
	@FindBy(xpath="//div[@id='Gender']/descendant::label/span[2]")
	private List<WebElement> genderRadioButtons;
	
	@FindBy(id="Phone Number")
	private WebElement phonenumberTF;
	
	@FindBy(id="Email Address")
	private WebElement emailaddressTF;
	
	@FindBy(id="Password")
	private WebElement passwordTF;
	
	@FindBy(id="Confirm Password")
	private WebElement confirmpasswordTF;
	
	@FindBy(id="Terms and Conditions")
	private WebElement termsandconditionsCB;
	
	@FindBy(xpath="//button[text()='Register']")
	private WebElement registerButton;
	
	//Initialization
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
	//Utilization
	public void createUserAccount(String firstname,String lastname,String expectedGender,String phnnumber,String email,
			String password)
	{
		firstnameTF.sendKeys(firstname);
		lastnameTF.sendKeys(lastname);
		for (WebElement element : genderRadioButtons) {
			String gender = element.getText();
			if(gender.equals(expectedGender))
			{
				element.click();
				break;
			}
		}
		
		phonenumberTF.sendKeys(phnnumber);
		emailaddressTF.sendKeys(email);
		passwordTF.sendKeys(password);
		confirmpasswordTF.sendKeys(password);
		termsandconditionsCB.click();
		try
		{
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		registerButton.click();
	
	}
}
