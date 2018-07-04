package com.fitz.main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.ShoppingSession;
import com.fitz.ecommerce.Unit;

public class CartDemo {



	public static void main(String[] args) {


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
