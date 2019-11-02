package com.matsup.configuration.utils;

import com.matsup.core.utils.Polynom;

public class Renders {

	public static void renderSecondDescription() {
		System.out.println("\n|--------------------------------------------------------------------------------|");
		System.out.println("| ¿Qué método desea utilizar para obtener el polinomio interpolante?     		 |");
		System.out.println("|             																 	 |");
		System.out.println("| 1)  Lagrange																 	 |");
		System.out.println("| 2)  Newton Gregory Progresivo													 |");
		System.out.println("| 3)  Newton Gregory Regresivo													 |");
		System.out.println("| 4)  Finalizar              													 |");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");


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

	public static void renderPolynom(Polynom polynom) {
		System.out.println("\n|--------------------------------------------------------------------------------|\n");
		System.out.println("  El polinomio generado es: P(X)= "+ polynom.toString());
		System.out.println("\n|--------------------------------------------------------------------------------|\n\n");

	}
}
