package com.fitz.ecommerce;

import java.math.BigDecimal;
import java.util.Map;

public class ShoppingSession implements ShoppingTask {

	private Invoice invoice;
	private Map<Integer, Product> catalog = null;
	final String CATALOG_FORMATTER = "%1$-8s %2$-40s %3$-10s %4$-10s %5$-5s";
	final String PROMPT_OPTIONS = "Please choose one of the options above.";
	final String OPTIONS = "<s> Continue shopping\r\n<a> Add to cart\r\n" + "<r> Remove from cart\r\n<v> View cart\r\n"
			+ "<c>Checkout\r\n<e>Clear cart\r\n<q> Quit\r\n";

	public ShoppingSession(int customerId, Map<Integer, Product> catalog) {

		this.catalog = catalog;
		this.invoice = new Invoice(customerId, catalog);
	}

	@Override
	public String shop() {

		displayCatalog();
		displayOptions();
		String nextTask = ConsoleUtils.displayPrompt(PROMPT_OPTIONS);
		return nextTask;

	}

	@Override
	public String addToCart() {

		String promptSelect = "To select, please enter the product id.";
		String promptQuantity = "Please enter the quantity you'd like to purchase.";

		String response = ConsoleUtils.displayPrompt(promptSelect);

		int productId = -1;
		int quantity = -1;

		while (!ConsoleUtils.isValidInt(response)) {

			System.out.println("Product ID not found in catalog: " + response);
			response = ConsoleUtils.displayPrompt(promptSelect);
		}

		productId = Integer.parseInt(response);

		while (!this.catalog.containsKey(productId)) {

			System.out.println("Product ID not found in catalog: " + response);
			response = ConsoleUtils.displayPrompt(promptSelect);

		}

		// Get the quantity
		response = ConsoleUtils.displayPrompt(promptQuantity);

		while (!ConsoleUtils.isValidInt(response)) {

			System.out.println("This number does not seem real: " + response);

			response = ConsoleUtils.displayPrompt(promptQuantity);

		}

		quantity = Integer.parseInt(response);
		invoice.addToCart(productId, quantity);
		System.out.println("Item added to cart");

		return ConsoleUtils.displayPrompt(String.format("Please select next task\r\n%s", OPTIONS));

	}

	@Override
	public String removeFromCart() {

		System.out.println("Removed from cart");
		return ConsoleUtils.displayPrompt("Enter next task");

	}

	@Override
	public String viewCart() {

		invoice.viewInvoice();
		return ConsoleUtils.displayPrompt(String.format("Please select next task\r\n%s", OPTIONS));

	}

	@Override
	public String checkout() {

		// TODO: Implement
		invoice.viewInvoice();
		System.out.println("Payment options: Visa. Thank you for your purchase!");
		return "q";

	}

	@Override
	public String clearCart() {

		invoice.getCart().clear();
		System.out.println("Cart cleared.");
		return ConsoleUtils.displayPrompt("Enter next task");

	}

	@Override
	public void quit() {

		System.out.println("Bye for now!");
		System.exit(0);

	}

	public void displayOptions() {

		System.out.println(OPTIONS);

	}

	private void displayCatalog() {

		String header = String.format(CATALOG_FORMATTER, "ID", "Product", "Unit", "Quantity", "Cost");
		System.out.println("Our products:\r\n");
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

}
