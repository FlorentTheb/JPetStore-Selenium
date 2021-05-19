import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFishPrices extends BandeauMenu {
	
	@FindBy(tagName = "h2")
	WebElement fishName;
	
	@FindBy(xpath = "//a[contains(@href,'addItemToCart=&workingItemId=EST-1')]")
	private WebElement addToCartButton;
	
	public PageCart addToCart(WebDriver driver) {
		
		addToCartButton.click();
		
		return PageFactory.initElements(driver, PageCart.class);
	}
	
	public String getFishName() {
		return fishName.getText();
	}
}
