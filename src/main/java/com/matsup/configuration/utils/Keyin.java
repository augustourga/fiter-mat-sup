package com.matsup.configuration.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.matsup.core.entities.Point;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Keyin {


	//*******************************
	//   support methods
	//*******************************
	//Method to display the user's prompt string
	public static void printPrompt(String prompt) {
		System.out.print(prompt + " ");
		System.out.flush();
	}

	//Method to make sure no data is available in the
	//input stream
	public static void inputFlush() {
		int dummy;
		int bAvail;

		try {
			while ((System.in.available()) != 0)
				dummy = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input error");
		}
	}

	public static String inString() {
		int aChar;
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			} catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	public static int inInt(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Integer.valueOf(inString().trim());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Not an integer");
			}
		}
	}

	public static List<Point> initPoints(String prompt, Gson json) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return parseInput(inString().trim(), json);
			} catch (Exception e) {
				System.out.println("Entrada inválida. No cumple el formato especificado");
			}
		}
	}

	private static List<Point> parseInput(String trim, Gson json) {
		Type listType = new TypeToken<ArrayList<Point>>(){}.getType();
		return json.fromJson(trim,listType);
	}

}