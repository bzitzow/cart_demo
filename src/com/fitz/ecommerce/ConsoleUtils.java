package com.fitz.ecommerce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleUtils {

	public static String displayPrompt(String prompt) {

		System.out.println(prompt);

		return readConsole();

	}

	private static String readConsole() {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = null;

		try {
			s = bufferedReader.readLine();
		} catch (IOException e) {

			System.out.println("Could not parse console input.");
			e.printStackTrace();

		}

		return s;

	}
	
	
	public static boolean isValidInt(String s) {

		// Positive integers with optional leading zeroes
		String pattern = "^([0-9]+\\d*)$|^0$";

		if (s.matches(pattern)) {

			return true;

		}

		else {
			return false;
		}

	}

}
