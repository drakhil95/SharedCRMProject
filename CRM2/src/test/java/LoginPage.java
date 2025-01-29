


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//object creation
	@FindBy(name="user_name")private WebElement usernameEdt;
	@FindBy(name="user_password")private WebElement passwordEdt;
	@FindBy(id="submitButton")private WebElement loginBtn;
	
	//object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//provide action(business library)
	public void LoginToapp(String url,String username,String password)
	{
		
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
	}
	private void waitForPageToLoad(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
