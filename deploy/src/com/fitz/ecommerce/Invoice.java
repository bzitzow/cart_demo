package com.fitz.ecommerce;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoice {

	private int customerId;

	final String INVOICE_FORMATTER = "%1$-40s %2$10s %3$10s %4$10s";

	private Map<Integer, Integer> cart;
	private Map<Integer, Product> catalog = new HashMap<Integer, Product>();

	public Invoice(int customerId, Map<Integer, Product> catalog) {

		this.customerId = customerId;
		this.catalog = catalog;
		this.cart = new HashMap<Integer, Integer>();

	}

	public void addToCart(Integer productId, Integer quantity) {

		Integer count = null;

		// If there aren't products of this kind in the cart initialize count to zero
		// Otherwise get the current quantity

		if (!cart.keySet().contains(productId)) {
			count = 0;
		} else {
			count = cart.get(productId);
		}

		count += quantity;
		cart.put(productId, count);

	}

	public void removeFromCart(Integer productId, Integer quantity) {

		String productName = catalog.get(productId).getProductName();

		if (!cart.containsKey(productId)) {

			System.out.println(String
					.format("I could not find this item in the cart %s. Please re-enter the product Id", productName));
			return;

		}

		Integer count = cart.get(productId);

		if (quantity >= cart.get(productId)) {

			// TODO: Message: Remove all <product> from cart Yes, No , Cancel
			// For now, just blow away the table entry
			System.out.println(String.format("Removed %s from your cart.", productName));
			cart.remove(productId);

		}

		else {

			count -= quantity;
			cart.put(productId, count);
			return;

		}

	}

	public BigDecimal getCartTotal() {

		BigDecimal total = new BigDecimal(BigInteger.ZERO, 2);

		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

			Integer quantity = entry.getValue();
			Product p = new Product(entry.getKey());

			total.add(p.getCost().multiply(new BigDecimal(quantity)));

		}

		return total;

	}

	public Map<Integer, Integer> getCart() {
		return this.cart;
	}

	public void viewInvoice() {

		if (cart.size() == 0) {
			System.out.println("There are no items in your cart");
			return;
		}

		BigDecimal total = new BigDecimal(BigInteger.ZERO, 2);
		String header = String.format(INVOICE_FORMATTER, "Product", "Quantity", "Unit Cost", "Total");
		System.out.println("Your cart:\r\n");
		System.out.println(header);

		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

			Integer quantity = entry.getValue();
			Product p = catalog.get((entry.getKey()));
			BigDecimal cost = p.getCost();
			BigDecimal q = new BigDecimal(quantity);
			BigDecimal subTotal = cost.multiply(q);
			total = total.add(subTotal);

			System.out.println(
					String.format(INVOICE_FORMATTER, p.getProductName(), quantity, p.getCost().toString(), subTotal));

		}

		System.out.println(String.format(INVOICE_FORMATTER, "Grand Total", "", "", total.toString()));
		System.out.println("\r\n");

	}

}
