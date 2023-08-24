package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {

	@Test
	public void addToCartTest() throws InterruptedException
	{
		Map<String,String> map = excel.getData("Sheet1", "Add Address");
		welcome.clickLoginButton();
		login.loginToApp(map.get("email"), map.get("password"));
		Thread.sleep(2000);
		
	}
}
