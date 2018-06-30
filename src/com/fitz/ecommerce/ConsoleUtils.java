package com.fitz.ecommerce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;

public class ConsoleUtils {

	final static String CART_FORMATTER = "%1$-40s %2$10s %3$10s %4$10s";
	final static String CATALOG_FORMATTER = "%1$-8s %2$-40s %3$-10s %4$-10s %5$-5s";

	final static String WELCOME = "Welcome %s!\r\nProducts we offer:\r\n";

	final static String SELECT_PRODUCT = "To select, please enter the product id, "
			+ "then <return>, to add to cart.\r\n" + "Enter (h) for a list of available commands.";

	final static String SELECT_QUANTITY = "Please enter the quantity you'd like to purchase, or q to cancel.";

	final static String PROMPT_CONFIRM = "You selected %s.";
	final static String PROMPT_RESELECT = "I could not find your response %s in the catalog. Please try again\r\n";

	final static String CONFIRM_ADD = "%s, %s added to cart.";
	final static String PROMPT_CHECKOUT = "Your total is %s. Please select one of the payment options:\n"
			+ "<v> Visa\n<p>Paypal";
	final static String PROMPT_CANCEL = "Cancel transaction? Enter <1> OK, <2> to continue shopping.";
	final static String COMMANDS = "<1> OK\n<q>Cancel, remove from cart\n<3>View cart\n<4>Edit cart<5>"
			+ "<6>Cancel order\n<h>Help, show commands.";

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void displayWelcome(String customerName) {
		System.out.println(String.format(WELCOME, customerName));
	}

	public static void displayCatalog(Map<Integer, Product> catalog) {

		String header = String.format(CATALOG_FORMATTER, "ID", "Product", "Unit", "Quantity", "Cost");
		System.out.println(header);

		for (Map.Entry<Integer, Product> entry : catalog.entrySet()) {

			Integer productId = entry.getKey();
			String productName = entry.getValue().getProductName();
			String unit = entry.getValue().getUnit().toString();
			Integer quantity = entry.getValue().getQuantityPerProduct();
			BigDecimal unitCost = entry.getValue().getCost();

			System.out.println(String.format(CATALOG_FORMATTER, productId, productName, unit, quantity, unitCost));
		}

		System.out.println("\r\n");

	}

	public static int displaySelectPrompt() {

		System.out.println(SELECT_PRODUCT);
		return readIntFromConsole();

	}

	public static int displayQuantityPrompt() {

		System.out.println(SELECT_QUANTITY);
		return readIntFromConsole();

	}

	public static void printItemizedList(String content) {

		System.out.println(content);

	}

	public static void displayReselect(int response) {

		System.out.println(String.format(PROMPT_RESELECT, response));
		displaySelectPrompt();

	}

	public static void displayConfirm(String product) {

		System.out.println(String.format(PROMPT_CONFIRM, product));

	}

	private static int readIntFromConsole() {

		String s = null;
		int response = -1;

		try {
			s = bufferedReader.readLine();
		} catch (IOException e) {

			System.out.println("Could not parse console input.");
			e.printStackTrace();

		}

		try {
			response = Integer.parseInt(s);
		} catch (Exception e) {
			System.out.println("Could not parse int");
			return response;
		}

		return response;

	}

}
