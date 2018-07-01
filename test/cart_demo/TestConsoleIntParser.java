package cart_demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fitz.ecommerce.ConsoleUtils;

class TestConsoleIntParser {

	@Test
	void test() {
		
		String s1 = "Fred";
		String s2 = "2";
		String s3 = "-2";
		String s4 = "02";
		String s5 = "c";
		
		assertTrue(ConsoleUtils.parseIntFromConsole(s1) == -1);
		assertTrue(ConsoleUtils.parseIntFromConsole(s2) == 2);
		assertTrue(ConsoleUtils.parseIntFromConsole(s3) == -1);
		assertTrue(ConsoleUtils.parseIntFromConsole(s4) == 2);
		assertTrue(ConsoleUtils.parseIntFromConsole(s5) == -1);
		
	}

}
