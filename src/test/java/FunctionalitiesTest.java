import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class FunctionalitiesTest extends AbstractTest {

	@Before
	public void setup() {
		selectBrowser(browser);
		System.out.println("Debut de la serie de test !");
	}

	@Test
	public void jPetTest() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8085/jpetstore/");

		// On instancie la page index
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		// Je me log
		PageLogIn page_login = page_index.signIn(driver);

		PageAccueil page_accueil = page_login.submit(driver, login, passwd);

		// Vérification du message de bienvenue
		String expectedMessage = "Welcome ABC!";
		assertEquals("Le message de bienvenue n'est pas correctement affiche", expectedMessage,
				page_accueil.getWelcomeMessage());

		// Cliquer sur l'image du 'Fish'
		PageFishTypes page_fishtypes = page_accueil.goFishCategory(driver);

		// Vérification du titre
		String expectedTitle = "Fish";
		assertEquals("Le titre est different de celui attendu", expectedTitle, page_fishtypes.getTitle());

		// Selectionner le produit
		PageFishPrices page_fishprices = page_fishtypes.selectFirstProduct(driver);

		// Vérification du nom du poisson
		String expectedFishName = "Angelfish";
		assertEquals("Le nom du poisson n'est pas celui precedemment selectionne", expectedFishName,
				page_fishprices.getFishName());

		// Ajouter le produit au panier
		PageCart page_cart = page_fishprices.addToCart(driver);

		// Vérification que le panier est affiché
		String expectedCartTitle = "Shopping Cart";
		assertEquals("Le titre est different du titre attendu", expectedCartTitle, page_cart.getTitle());

		// Modifie la quantité de produits à 2 et update le panier
		page_cart.updateQuantity("2");

		// Vérification que le total est bien le double du prix unitaire
		double unitPrice = page_cart.reformatPrice(page_cart.getUnitPrice());
		double totalPrice = page_cart.reformatPrice(page_cart.getTotalPrice());
		assertEquals("Le prix total ne correspond pas au prix unitaire x la quantité", 2 * unitPrice, totalPrice, 0);
	}
//
//	@After
//	public void teardown() {
//		driver.quit();
//		System.out.println("Fin de la série de test !");
//	}
}
