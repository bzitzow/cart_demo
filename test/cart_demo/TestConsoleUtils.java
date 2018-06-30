package cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.ConsoleUtils;
import com.fitz.ecommerce.Product;
import com.fitz.ecommerce.Unit;

class TestConsoleUtils {
	
	private Map<Integer, Product> catalog = new HashMap<Integer, Product>();

	
	@BeforeEach
	void setup() {
		
		Product p1 = new Product(0);
		p1.setProductName("JASMINE RICE TEN POUNDS");
		p1.setQuantityPerProduct(1);
		p1.setUnit(Unit.EACH);
		p1.setCost(new BigDecimal("12.00"));

		Product p2 = new Product(1);
		p2.setProductName("BEER LAO, 24 BOTTLE");
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
		
	}
	
	
	
	@Test
	void testListPrinter() {
		
//		String  formatter = "%1$-40s %2$10s %3$10s %4$10s\n";
//		StringBuilder sb = new StringBuilder();
//		
//		String header = String.format(formatter,"Product","Quantity","Unit Cost","Subtotal");
//		sb.append(header);
//		
//
//		
//		for (int i = 0; i < 5; i++) {
//			
//			String item = String.format(formatter, String.format("p%s,q%s,c%s,t%s", i,i,i,i));
//			sb.append(item);		
//			
//		}
//		
//		ConsoleUtils.printItemizedList(sb.toString());
		
	}
	
	
	@Test
	void testPrompter() {
		
		//assertTrue(ConsoleUtils.consoleResponse("Please enter 'y' to test positive"));
		
		
		
	}
	
	@Test
	
	void testWelcome() {
		
		ConsoleUtils.displayWelcome("Nancy Onesy");
		ConsoleUtils.displayCatalog(catalog);
		
		
	}
	
	
	@Test
	void testDisplaySelectPrompt() {
		
		int response = ConsoleUtils.displaySelectPrompt();
		assertTrue(response>0);
		
		if (!catalog.keySet().contains(response)) {
			
			ConsoleUtils.displayReselect(response);
			
		}
		
		else {
			
			ConsoleUtils.displayConfirm(catalog.get(response).getProductName());
			
		}
		
		
	} 
		

}
