package com.matsup.configuration.utils;

import com.matsup.core.utils.Polynom;

public class Renders {

	public static void renderThirdDescription() {
		System.out.println("\n|--------------------------------------------------------------------------------|");
		System.out.println("| ¿Y ahora? ¿Qué podemos hacer por ti?                                   		 |");
		System.out.println("|             																 	 |");
		System.out.println("| 1)  Mostrar pasos de cálculo	             								 	 |");
		System.out.println("| 2)  Especializar el polinomio en un valor K.									 |");
		System.out.println("| 3)  Alterar valores iniciales.												 |");
		System.out.println("| 4)  Finalizar              													 |");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

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

	public static void renderPolynom(Polynom polynom, int degree, Boolean equispaced) {
		System.out.println("\n|--------------------------------------------------------------------------------|\n");
		System.out.println("  El polinomio generado es: P(X)= " + polynom.toString());
		System.out.println("\n  El grado de P(X) es  " + degree);
		System.out.println("\n  ¿Es equiespaciado?  " + equispaced);
		System.out.println("\n|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderSubPolynoms(Polynom polynom, int i) {

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("| Li("+i+") = "+ polynom.toString()) 			 ;
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderSpecializePolynom(double v, Double inDouble) {

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("| El valor del P("+inDouble+") = " + v 	)		 ;
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderSpecializeInput() {
		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("| Ingrese el valor en el que desea especializar el polinomio. Ej 2.1 			 |");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}
}
