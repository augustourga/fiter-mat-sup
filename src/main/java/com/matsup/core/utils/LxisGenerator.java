package com.matsup.core.utils;

import com.matsup.core.entities.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LxisGenerator {


	public static List<Polynom> generateLxis(List<Point> points) {
		List<Polynom> polynomials = new ArrayList<>();

		for (int i = 0; i <= points.size() - 1; i++) {
			polynomials.add(generateLx(i, points));
		}
		return polynomials;
	}

	protected static Polynom generateLx(int i, List<Point> points) {
		Point pointToFilter = points.get(i);
		List<Point> filtredPoints = filterPoints(pointToFilter, points);

		Polynom numerator = generateNumerator(filtredPoints);

		Double denominator = generateDenominator(pointToFilter, filtredPoints);

		return numerator.divideCoeffs(denominator);
	}

	private static Polynom generateNumerator(List<Point> filtredPoints) {
		return generateProducts(
				filtredPoints.stream().map(LxisGenerator::generateLinealFunction
				).collect(Collectors.toList())
		);

	}

	protected static Double generateDenominator(Point pointToFilter, List<Point> points) {
		Double acum = 1.0;
		for (Point x : points) {
			acum = acum * (pointToFilter.getX() - x.getX());
		}

		return acum;
	}

	;

	protected static Polynom generateProducts(List<Polynom> polynomials) {
		Polynom acum = new Polynom(1.0, 0);
		for (Polynom x : polynomials) {
			acum = acum.multiply(x);
		}
		return acum;
	}

	;

	protected static List<Point> filterPoints(Point point, List<Point> points) {
		return points.stream().filter(x -> !x.getX().equals(point.getX())).collect(Collectors.toList());

	}

	protected static Polynom generateLinealFunction(Point point) {
		return new Polynom(1, 1).subtract(new Polynom(point.getX(), 0));
	}
}
