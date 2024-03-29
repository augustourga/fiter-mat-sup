package com.matsup.configuration.utils;

import com.matsup.core.entities.Point;
import com.matsup.core.utils.Polynom;

import java.util.List;

public class Renders {

	public static void renderThirdDescription() {
		System.out.println("\n|--------------------------------------------------------------------------------|");
		System.out.println(" ¿Y ahora? ¿Que podemos hacer por ti?                                   		 ");
		System.out.println("             																 	 ");
		System.out.println(" 1)  Mostrar pasos de calculo	             								 	 ");
		System.out.println(" 2)  Especializar el polinomio en un valor K.									 ");
		System.out.println(" 3)  Volver              										    			 ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

	public static void renderSecondDescription() {
		System.out.println("\n|--------------------------------------------------------------------------------|");
		System.out.println(" ¿Qué metodo desea utilizar para obtener el polinomio interpolante?     		 ");
		System.out.println("             																 	 ");
		System.out.println(" 1)  Lagrange																 	 ");
		System.out.println(" 2)  Newton Gregory Progresivo													 ");
		System.out.println(" 3)  Newton Gregory Regresivo													 ");
		System.out.println(" 4)  Alterar valores iniciales.												 ");
		System.out.println(" 5)  Volver                 													 ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");


	}

	public static void renderPrincipalDescription() {
		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println(" Ingrese los puntos que se desean interpolar con el siguiente formato:          ");
		System.out.println("                   [{\"X\":a,\"Y\":b},{\"X\":c,\"Y\":d},{\"X\":e,\"Y\":f}]                  ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

	public static void renderHeader() {
		System.out.println("  				 Matematica Superior   				  			 	  ");
		System.out.println("  	   		 	 [FINTER] - 2c 2019    						 		  ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

	public static void renderPolynom(Polynom polynom, int degree, Boolean equispaced, Polynom lastGeneratedPolynom) {
		System.out.println("\n|--------------------------------------------------------------------------------|\n");
		System.out.println("  El polinomio generado es: P(X)= " + polynom.toString());
		System.out.println("\n  El grado de P(X) es  " + degree);
		System.out.println("\n  ¿Es equiespaciado?  " + getYesOrNo(equispaced));
		System.out.println("\n  ¿Es igual al polinomio anteriormente generado?  " + getYesOrNo(polynom.equals(lastGeneratedPolynom)));
		System.out.println("\n|--------------------------------------------------------------------------------|\n\n");
	}

	private static String getYesOrNo(Boolean equispaced) {
		return equispaced ? " SI" : " NO";
	}

	public static void renderSubPolynoms(Polynom polynom, int i) {

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("  Li(" + i + ") = " + polynom.toString());
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderFinitesDifferences(List<Double> list, int i) {

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("  Las diferencias divididas de orden (" + (i + 1) + ") = " + list.toString());
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}


	public static void renderSpecializePolynom(double v, Double inDouble) {

		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("  El valor del P(" + inDouble + ") = " + v);
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderSpecializeInput() {
		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("  Ingrese el valor en el que desea especializar el polinomio. Ej 2.1 			  ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}

	public static void renderEnterPoint(String variable) {
		System.out.println("|--------------------------------------------------------------------------------|");
		System.out.println("  Ingrese el nuevo valor de " + variable + ":  									     ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");
	}

	public static void renderChangePointsMenu(List<Point> points) {
		System.out.println("\n|--------------------------------------------------------------------------------|");
		System.out.println("  ¿Desea cambiar un punto en particular o agregar uno nuevo ?					  ");
		System.out.println("              																 	  ");

		for (int i = 0; i <= points.size() - 1; i++) {
			System.out.println(" " + (i + 1) + ") {  " + points.get(i).getX() + "  ,  " + points.get(i).getY() + "  }	     ");

		}

		System.out.println(" " + (points.size() + 1) + ")  Agregar un punto nuevo		                                            	 ");
		System.out.println(" " + (points.size() + 2) + ")  Volver			                                                             ");
		System.out.println("|--------------------------------------------------------------------------------|\n\n");

	}
}
