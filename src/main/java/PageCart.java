import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCart extends BandeauMenu {
	
	@FindBy(tagName = "h2")
	private WebElement title;
	
	@FindBy(name = "EST-1")
	private WebElement quantityField;
	
	@FindBy(xpath = "(//td[contains(text(), '$')])[1]")
	private WebElement unitPrice;
	
	@FindBy(xpath = "(//td[contains(text(), '$')])[2]")
	private WebElement totalPrice;
	
	@FindBy(name = "updateCartQuantities")
	private WebElement updateCartButton;
	
	public void updateQuantity(String quantity) {
		quantityField.clear();
		quantityField.sendKeys(quantity);
		updateCart();
	}
	
	public void updateCart() {
		updateCartButton.click();
	}
	
	public double reformatPrice(String price) {
		price = price.substring(1);
		price = price.replace(',', '.');
		return Double.parseDouble(price);
	}

	public String getTitle() {
		return title.getText();
	}
	
	public String getUnitPrice() {
		return unitPrice.getText();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}
}
