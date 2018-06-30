package cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.Invoice;
import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.Unit;

class TestCart {

	Map<Integer, Product> catalog = new HashMap<Integer, Product>();

	@BeforeEach

	void setup() {

		Product p1 = new Product(0);
		p1.setProductName("JASMINE RICE TEN POUNDS");
		p1.setUnit(Unit.EACH);
		p1.setCost(new BigDecimal("12.00"));

		Product p2 = new Product(1);
		p2.setProductName("BEER LAO CASE");
		p2.setQuantityPerProduct(24);
		p2.setUnit(Unit.EACH);
		p2.setCost(new BigDecimal("28.00"));

		Product p3 = new Product(2);
		p3.setProductName("SUMATRA ARABICA COFFEE 12 OUNCE");
		p3.setQuantityPerProduct(1);
		p3.setUnit(Unit.CASE);
		p3.setCost(new BigDecimal("7.99"));

		catalog.put(p1.getProductId(), p1);
		catalog.put(p2.getProductId(), p2);
		catalog.put(p3.getProductId(), p3);

	}

	@Test
	void test() {

		Integer customerId = new Integer(0);

		Invoice invoice = new Invoice(customerId);

		invoice.addProduct(0, 1);
		invoice.addProduct(0, 1);
		invoice.addProduct(1, 1);
		invoice.addProduct(2, 2);

		Map<Integer, Integer> cart = invoice.getCart();

		String formatter = "%1$-40s %2$10s %3$10s %4$10s";
		String header = String.format(formatter, "Product", "Quantity", "Unit Cost", "Subtotal");
		System.out.println(header);

		for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

			Integer productId = entry.getKey();
			BigDecimal quantity = new BigDecimal(entry.getValue());
			BigDecimal unitCost = catalog.get(productId).getCost();

			BigDecimal productTotal = quantity.multiply(unitCost);

			System.out.println(String.format(formatter, catalog.get(productId).getProductName(), cart.get(productId),
					catalog.get(productId).getCost(), productTotal));
		}

	}

}
