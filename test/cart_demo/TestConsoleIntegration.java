package cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.ConsoleUtils;
import com.fitz.ecommerce.Invoice;
import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.Unit;

class TestConsoleIntegration {

	private Map<Integer, Product> catalog = new HashMap<Integer, Product>();

	@BeforeEach
	void setup() {

		Product p1 = new Product(0);
		p1.setProductName("JASMINE RICE TEN POUNDS");
		p1.setQuantityPerProduct(1);
		p1.setUnit(Unit.EACH);
		p1.setCost(new BigDecimal("12.00"));

		Product p2 = new Product(1);
		p2.setProductName("BEER LAO 24 BOTTLE");
		p2.setQuantityPerProduct(1);
		p2.setUnit(Unit.CASE);
		p2.setCost(new BigDecimal("28.00"));

		Product p3 = new Product(2);
		p3.setProductName("SUMATRA ARABICA COFFEE 12 OUNCE");
		p3.setQuantityPerProduct(1);
		p3.setUnit(Unit.EACH);
		p3.setCost(new BigDecimal("7.99"));

		catalog.put(p1.getProductId(), p1);
		catalog.put(p2.getProductId(), p2);
		catalog.put(p3.getProductId(), p3);

	}

	@Test
	
	
	void test() {

		ConsoleUtils.displayWelcome("Nancy Onesy, Member 111!");
		Invoice invoice = new Invoice(111, catalog);
		
		invoice = continueShopping(invoice);


	}
	
	private Invoice continueShopping(Invoice invoice) {
		
		ConsoleUtils.displayCatalog(catalog);

		int product = ConsoleUtils.displaySelectPrompt();

		product = validateProduct(product);

		ConsoleUtils.displayConfirm(catalog.get(product).getProductName());
		
		int quantity = ConsoleUtils.displayQuantityPrompt();
		
		quantity = validateQuantity(quantity);
			
		invoice.addProduct(product, quantity);
		
		ConsoleUtils.displayConfirmAddProduct(catalog.get(product).getProductName(), quantity);
		
		String response = ConsoleUtils.displayContinueShoppingPrompt();
		
		
		if (response.toLowerCase().equals("s")) {
			
			continueShopping(invoice);			
			
		}
		
		
		else if (response.toLowerCase().equals("c")) {
			
			invoice.viewInvoice();
			
		}
		
		else if (response.toLowerCase().equals("q")) {
			
			ConsoleUtils.displayBye();
			
		}
		
		else if (response.endsWith("-1")) {
			
			continueShopping(invoice);
			
			
		}
		
		return invoice;
		
		
	}

	

	private int validateContinueShopping(int response) {
		
		return 1;
		
		
		
	}
	
	
	private int validateProduct(int response) {

		if (!catalog.keySet().contains(response)) {

			ConsoleUtils.displayReselect(response);
			response = ConsoleUtils.displaySelectPrompt();
			validateProduct(response);

		}
		return response;

	}
	
	private int validateQuantity(int quantity) {

		if (quantity < 1) {
			
			ConsoleUtils.displayQuantityReselectPrompt();
			quantity = ConsoleUtils.displayQuantityPrompt();
			validateQuantity(quantity);
		}
		return quantity;

	}
	

}
