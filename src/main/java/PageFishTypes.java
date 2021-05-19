import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFishTypes extends BandeauMenu {
	
	@FindBy(tagName = "h2")
	private WebElement title;
	
	@FindBy(xpath = "//a[contains(@href,'productId=FI-SW-01')]")
	private WebElement product;

	public PageFishPrices selectFirstProduct(WebDriver driver) {
		
		product.click();
		
		return PageFactory.initElements(driver, PageFishPrices.class);
	}
	
	public String getTitle() {
		return title.getText();
	}
}
