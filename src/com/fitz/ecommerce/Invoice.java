package com.fitz.ecommerce;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoice {

	private int customerId;

	private HashMap<Integer, Integer> cart;

	public Invoice(int customerId) {

		this.customerId = customerId;
		this.cart = new HashMap<Integer, Integer>();

	}

	public void addProduct(Integer productId, Integer quantity) {

		Integer count = cart.get(productId);
		count += quantity;
		this.cart.put(productId, count);

	}

	public void deleteProduct(Integer productId, Integer quantity) {

		if (quantity <= 0) {

			System.out.println(String.format("Sorry, you eneterd %s. Please enter a positive whole number", quantity));
			return;

		}

		Integer count = cart.get(productId);

		if (quantity >= cart.get(productId)) {

			// Remove all <product> from cart Yes, No , Cancel
			boolean response = false;
			if (response) {
				cart.put(productId, 0);
				return;
			}
			
			else {
				
				// Cancel transaction
				return;
				
			}

		}
		
		else {
			
			count -= quantity;
			this.cart.put(productId, count);
			return;
			
		}



	}
	
	public BigDecimal getCartTotal() {
		
		BigDecimal total = new BigDecimal(BigInteger.ZERO, 2);
		
		for (Map.Entry<Integer, Integer> entry: cart.entrySet()) {
			
			Integer quantity = entry.getValue();
			Product p = new Product(entry.getKey());
			
			total.add(p.getCost().multiply(new BigDecimal(quantity)));
			
		}
		
		
		return total;
		
		
	}
	
	
	
	

	public HashMap<Integer, Integer> getCart() {
		return this.cart;
	}

}
