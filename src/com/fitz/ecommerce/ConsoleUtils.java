package com.fitz.ecommerce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleUtils {

	final static String FORMATTER = "%1$-40s %2$10s %3$10s %4$10s";
	
	final static String WELCOME = "Welcome %s!\nAvailable products:";
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
