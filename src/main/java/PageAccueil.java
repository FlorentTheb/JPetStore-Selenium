import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends BandeauMenu {

	@FindBy(id = "WelcomeContent")
	private WebElement welcomeMessage;
	
	@FindBy(xpath = "(//*[contains(@href, 'FISH')])[1]")
	private WebElement fishCategory;
	
	public PageFishTypes goFishCategory(WebDriver driver) {
		
		fishCategory.click();
		
		return PageFactory.initElements(driver, PageFishTypes.class);
	}

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
}
