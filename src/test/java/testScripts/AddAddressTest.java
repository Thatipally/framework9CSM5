package testScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddAddressTest extends BaseClass{

	@Test
	public void addAdressTest() throws InterruptedException
	{
		Map<String,String> map = excel.getData("Sheet1", "Add Address");
		welcome.clickLoginButton();
		login.loginToApp(map.get("email"), map.get("password"));
		Thread.sleep(2000);
		home.ClickProfileButton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(2000);
		myProfile.clickMyAddress();
		myAddress.clickAddAddress();
		address.addAddressDetails(webUtil, map);;
		Thread.sleep(2000);
		Assert.assertEquals(myAddress.getSuccessMessage(), "successfully added");
	}
}
