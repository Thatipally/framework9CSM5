package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.JavaUtility;
import genericLibraries.WebDriverUtility;

public class AddressFormPage {

	// Declaration
	@FindBy(id = "Name")
	private WebElement nameTF;

	@FindBy(id = "House/Office Info")
	private WebElement houseinfoTF;

	@FindBy(id = "Street Info")
	private WebElement streetinfoTF;

	@FindBy(id = "Landmark")
	private WebElement landmarkTF;

	@FindBy(id = "Country")
	private WebElement countryDropdown;

	@FindBy(id = "State")
	private WebElement stateDropdown;

	@FindBy(id = "City")
	private WebElement cityDropdown;

	@FindBy(id = "Pincode")
	private WebElement pincodeTF;

	@FindBy(id = "Phone Number")
	private WebElement phonenumberTF;

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressButton;

	// Initialization
	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void addAddressDetails(String name, String houseinfo, String street, String landmark, String pincode,
			String phonenumber, String country, String state, String city, WebDriverUtility web) {
		nameTF.sendKeys(name);
		houseinfoTF.sendKeys(houseinfo);
		streetinfoTF.sendKeys(street);
		landmarkTF.sendKeys(landmark);

		web.selectFromDropdown(country, countryDropdown);
		web.selectFromDropdown(state, stateDropdown);
		web.selectFromDropdown(city, cityDropdown);

		pincodeTF.sendKeys(pincode);
		phonenumberTF.sendKeys(phonenumber);
		addAddressButton.click();
	}

	// Utilization
	public void addAddressDetails(WebDriverUtility web, Map<String,String> details) {

		nameTF.sendKeys(details.get("Name"));
		houseinfoTF.sendKeys(details.get("House/Office Info"));
		streetinfoTF.sendKeys(details.get("Street Info"));
		landmarkTF.sendKeys(details.get("Landmark"));

		web.selectFromDropdown(details.get("Country"), countryDropdown);
		web.selectFromDropdown(details.get("State"), stateDropdown);
		web.selectFromDropdown(details.get("City"), cityDropdown);

		pincodeTF.sendKeys(details.get("Pincode"));
		phonenumberTF.sendKeys(details.get("Phone Number"));
		addAddressButton.click();
		

	}
}
