import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex extends BandeauMenu {

	@FindBy(xpath = "//a[text()='Enter the Store']") 
	private WebElement storeEntry;
	
	public PageLogIn signIn(WebDriver driver) {
		storeEntry.click();
		signInButton.click();
		return PageFactory.initElements(driver, PageLogIn.class);
	}
}
