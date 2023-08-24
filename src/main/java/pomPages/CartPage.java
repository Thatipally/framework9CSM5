package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	//Declaration
	@FindBy(xpath="//div[@class='cart_productDetails__pKWBd']/h3")
	private WebElement cartItem;
	
	//initialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public String getCartItem()
	{
		return cartItem.getText();
	}
}
