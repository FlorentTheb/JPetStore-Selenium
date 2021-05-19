import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogIn extends BandeauMenu {
	
	@FindBy(name = "username")
	private WebElement usernameField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "signon")
	private WebElement submitButton;
	
	public PageAccueil submit(WebDriver driver, String username, String password) {

		usernameField.clear();
		usernameField.sendKeys(username);
		
		passwordField.clear();
		passwordField.sendKeys(password);
		
		submitButton.click();
		
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
