package com.fitz.ecommerce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;


public class ConsoleUtils {

	final static String CART_FORMATTER = "%1$-40s %2$10s %3$10s %4$10s";
	final static String CATALOG_FORMATTER = "%1$-8s %2$-40s %3$-10s %4$-10s %5$-5s";
	
	final static String WELCOME = "Welcome %s!\nProducts we offer:\n";
	final static String SELECT_OPTION = "Please enter the product id, "
			+ "then type <1>, then <return>, to add to cart.\n"
			+ "Enter (h) for a list of available commands.";
	
	final static String PROMPT_CONFIRM = "You entered %s, %s. Enter <1> OK, <2> to cancel.";
	final static String CONFIRM_ADD = "%s, %s added to cart.";
	final static String PROMPT_CHECKOUT = "Your total is %s. Please select one of the payment options:\n"
			+ "<v> Visa\n<p>Paypal";
	final static String PROMPT_CANCEL = "Cancel transaction? Enter <1> OK, <2> to continue shopping.";
	final static String COMMANDS = "<1> OK\n<2>Cancel, remove from cart\n<3>View cart\n<4>Edit cart<5>"
			+ "<6>Cancel order\n<h>Help, show commands.";
			
	

	public static void displayWelcome(String customerName) {
		System.out.println(String.format(WELCOME,customerName)); }
	
	
	public static void displayCatalog(Map<Integer, Product> catalog) {
		
		String header = String.format(CATALOG_FORMATTER, "ID", "Product", "Unit", "Quantity", "Cost" );
		System.out.println(header);
		
		for (Map.Entry<Integer, Product> entry : catalog.entrySet()) {

			Integer productId = entry.getKey();
			String productName = entry.getValue().getProductName();
			String unit = entry.getValue().getUnit().toString();
			Integer quantity = entry.getValue().getQuantityPerProduct();
			BigDecimal unitCost = entry.getValue().getCost();


			System.out.println(String.format(CATALOG_FORMATTER, productId, productName, unit, quantity, unitCost));
		}
		
		System.out.println("\n");
		
		
	}
	
	
	
	public static void printItemizedList(String content) {

		System.out.println(content);

	}

	public static boolean consoleResponse(String prompt) {

		boolean response = false;

		System.out.println(prompt);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null;
		
		try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}


		if (input.toLowerCase().equals("y")) {
			response = true;
		} else if (input.toLowerCase().equals("n")) {
			response = false;
		}

		else {

			System.out.println("Sorry, please enter 'y' for yes, 'n' for no");

		}

		return response;

	}

}
