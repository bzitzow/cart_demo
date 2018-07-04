package cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.ConsoleUtils;
import com.fitz.main.CartDemo;

class TestConsoleIntParser {

	@Test
	void test() {
		
		String s1 = "Fred";
		String s2 = "2";
		String s3 = "-2";
		String s4 = "02";
		String s5 = "c";
		
		assertFalse(ConsoleUtils.isValidInt(s1));
		assertTrue(ConsoleUtils.isValidInt(s2));
		assertFalse(ConsoleUtils.isValidInt(s3));
		assertTrue(ConsoleUtils.isValidInt(s4));
		assertFalse(ConsoleUtils.isValidInt(s5));
		
	}

}
