import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BandeauMenu {

	@FindBy(xpath = "//a[@href='shop/viewCart.do']")
	protected WebElement cartButton;

	@FindBy(xpath = "//a[text()='Sign In']")
	protected WebElement signInButton;

	@FindBy(xpath = "//a[@href='/jpetstore-1.0.5-env2/shop/signoff.do']")
	protected WebElement signOutButton;

	@FindBy(xpath = "//a[@href='help.html']")
	protected WebElement helpButton;

	@FindBy(xpath = "//input[@name='keyword']")
	protected WebElement search_field;

	@FindBy(xpath = "//src[@src='images/search.gif']")
	protected WebElement searchButton;
}
