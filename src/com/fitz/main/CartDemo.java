package com.fitz.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fitz.ecommerce.ConsoleUtils;
import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.ShoppingSession;
import com.fitz.ecommerce.Unit;

public class CartDemo {

	// UI Messages

	final static String CART_FORMATTER = "%1$-40s %2$10s %3$10s %4$10s";
	final static String CATALOG_FORMATTER = "%1$-8s %2$-40s %3$-10s %4$-10s %5$-5s";

	final static String WELCOME = "Welcome %s!\r\nProducts we offer:\r\n";
	final static String BYE = "Bye for now!";

	final static String CONFIRM_PRODUCT = "You selected %s.";
	final static String CONFIRM_ADD = "Added %s %s to your cart.";
	final static String CONFIRM_REMOVE = "Removed %s %s from your cart.";

	final static String PROMPT_SELECT_PRODUCT = "To select, please enter the product id, "
			+ "then <return>, to add to cart.\r\nEnter <q> to exit.";
	final static String PROMPT_SELECT_QUANTITY = "Please enter the quantity you'd like to purchase, or q to cancel.";
	final static String PROMPT_RESELECT = "I could not find your response %s in the catalog. Please try again.\r\n";
	final static String PROMPT_INVALID_QUANTITY = "We are unable to fulfill order with quantities less than one. "
			+ "Please re-enter the quantity you wish to purchase.\r\n";
	final static String PROMPT_CHECKOUT = "Your total is %s. Please select one of the payment options:\n"
			+ "<v> Visa\n<p>Paypal";
	final static String PROMPT_CONTINUE_SHOPPING = "Continue shopping <s>, view cart <v>, remove items from cart <r>, checkout now <c>, or quit <q>?";
	final static String PROMPT_EDIT_CART = "Continue shopping <s> or remove item from cart <r>?";
	final static String PROMPT_REMOVE_PRODUCT = "Remove from cart? Please enter the product Id. "
			+ "<s> to cancel and continue shopping, <c> to checkout now, <q> to quit.";
	final static String PROMPT_REMOVE_QUANTITY = "Please enter the quantity to remove."
			+ "<s> to cancel and continue shopping, <c> to checkout now, <q> to quit.";

	// Console codes
	private static List<String> consoleCodes = new ArrayList<String>();

	public static void main(String[] args) {

		// displayWelcome("Nancy Onesy, Member 111!");

		// createConsoleCodes();

		ShoppingSession session = new ShoppingSession(111, createCatalog());

		String nextTask = session.shop();

		while (true) {

			switch (nextTask) {

			case "s":
				nextTask = session.shop();
				break;

			case "a":
				nextTask = session.addToCart();
				break;

			case "v":
				nextTask = session.viewCart();
				break;

			case "c":
				nextTask = session.checkout();
				break;

			case "r":
				nextTask = session.removeFromCart();
				break;

			case "e":
				nextTask = session.clearCart();
				break;

			case "q":
				session.quit();

			default:
				System.out.println("Code not found");
				nextTask = session.shop();
				break;

			}

		}
	}

	private static Map<Integer, Product> createCatalog() {

		Map<Integer, Product> catalog = new HashMap<Integer, Product>();

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

		return catalog;

	}

}
