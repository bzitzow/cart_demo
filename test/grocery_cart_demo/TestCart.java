package grocery_cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.Invoice;
import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.Unit;

class TestCart {

	List<Product> products = new ArrayList<Product>();
	
	@BeforeEach
		
	void setup() {
			
		
		Product p1 = new Product(0);
		p1.setProductName("JASMINE RICE TEN POUNDS");
		p1.setUnit(Unit.EACH);
		p1.setCost(new BigDecimal(12.00));
		
		Product p2 = new Product(1);
		p1.setProductName("BEER LAO CASE");
		p1.setQuantityPerProduct(24);
		p1.setUnit(Unit.EACH);
		p1.setCost(new BigDecimal(28.00));
		
		Product p3 = new Product(2);
		p1.setProductName("SUMATRA ARABICA COFFEE 12 OUNCE");
		p1.setQuantityPerProduct(1);
		p1.setUnit(Unit.CASE);
		p1.setCost(new BigDecimal(7.99));
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		
	}
	
	
	
	@Test
	void test() {
		
		Integer customerId = new Integer(0);
		
		Invoice invoice = new Invoice(customerId);
		
		invoice.addProduct(0, 1);
		invoice.addProduct(0, 1);
		
		
		fail("Not yet implemented");
	}

}
