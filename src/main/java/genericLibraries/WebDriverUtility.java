package genericLibraries;

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	private WebDriver driver;
	public WebDriver navigateToApp(String browser,String url,long time)
	{
		switch(browser)
		{
		case"chrome": 
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ShoppersStack\\src\\main\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Boolean> prefs = new HashMap<>();
			prefs.put("autofill.profile_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver();
		break;
		case"firefox": driver = new FirefoxDriver();
		break;
		case"edge": driver = new EdgeDriver();
		break;
		default:System.out.println("invalid browser info");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}
	
	//explicitWait
	public WebElement explicitWait(long time ,WebElement element ) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement explicitWait(WebElement element, long time) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Boolean explicitWait(long time ,String title) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	//mouse Actions
	public void mouseHover(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClickonElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void rightClick(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void dragAndDropAnElement(WebElement element,WebElement target)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element,target).perform();
	}
	
	//dropdowns
	public void selectFromDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectFromDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectFromDropdown( String text,WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	//Frames
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	//scrolling JavaScriptExecutor
	public void scrollTillElement(WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//popups , alertpopup & child browser popup
	
	public void handleAlert(String status)
	{
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			al.accept();
		else
			al.dismiss();
	}
	public void switchToChildBrowser()
	{
		Set<String> set = driver.getWindowHandles();
		for(String s :set)
		{
			driver.switchTo().window(s);
		}
	}
	//alert
	public void switchToWindow(String id)
	{
		driver.switchTo().window(id);
	}
	//childbrowser
	public String getParentWindow()
	{
		return driver.getWindowHandle();
	}
	
	//closing website
	
	public void closeSingleBrowser()
	{
		driver.close();
	}
	
	public void closeAllBrowser()
	{
		driver.quit();
	}
	
}
