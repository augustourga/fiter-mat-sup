package com.matsup.configuration.utils;

public class Renders {

	public static void renderSecondDescription() {
		System.out.println("|  1)		 |");
		System.out.println("|  2)		 |");
		System.out.println("|  3)     |");
		System.out.println("|     					    {(a,b),(c,d),(e,d)}    								 |\n\n\n\n");
	}

	public static void renderPrincipalDescription() {
		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("| Ingrese los puntos que se desean interpolar con el siguiente formato:          |");
		System.out.println("|                   [{\"X\":a,\"Y\":b},{\"X\":c,\"Y\":d},{\"X\":e,\"Y\":f}]                  |");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

	public static void renderHeader() {
		System.out.println("|  							 Matemática Superior   								 |");
		System.out.println("|  							 [FINTER] - 2c 2019    								 |");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}
}
