package com.matsup.core.utils;

import com.google.common.collect.Lists;
import com.matsup.core.entities.Point;

import java.util.*;

public class FinitesDifferencesGenerator {
	public static Map<Integer, List<Double>> generateFinitesDifferences(List<Point> points) {
		Map<Integer, List<Double>> finitesDifferences = new HashMap<>();

		for (int i = 0; i <= points.size() - 1  ; i++) {

			finitesDifferences.put(i,generateFinitesDifferencesByOrder(i,points,finitesDifferences));

		}

		return finitesDifferences;
	}

	private static List<Double> generateFinitesDifferencesByOrder(int position, List<Point> points, Map<Integer, List<Double>> finitesDifferences) {
		List<Double> doubleList = null;
		if (position == 0) {
			doubleList = baseCase(points);
		} else {
			doubleList = nCase(position,points,finitesDifferences);
		}
		return doubleList;
	}

	private static List<Double> nCase(int position, List<Point> points, Map<Integer, List<Double>> finitesDifferences) {
		List<Double> doubleList = new ArrayList<>();
		List<Double> iterableList = finitesDifferences.get(position-1);
		for (int i = 0; i <= finitesDifferences.get(position-1).size() - 2; i++) {
			doubleList.add(
					generateFiniteDifference(points.get(i).getX(),
											 points.get(i+ position +1).getX(),
											 iterableList.get(i),
											 iterableList.get(i+1))
			);

		}
		return doubleList;
	}

	private static List<Double> baseCase(List<Point> points) {
		List<Double> doubleList = new ArrayList<>();
		for (int i = 0; i <= points.size() - 2; i++) {
			doubleList.add(generateFiniteDifference(points.get(i).getX(),
													points.get(i+1).getX(),
													points.get(i).getY(),
													points.get(i+1).getY()));
		}
		return doubleList;
	}

	private static Double generateFiniteDifference(Double x1,Double x2,Double y1,Double y2) {
		return ( y2 - y1 )/( x2 - x1 );
	}

	public static List<Polynom> generateSubPolynoms(Map<Integer, List<Double>> finitesDifferences, List<Point> points) {
		List<Polynom> polynoms = new ArrayList<>();

		for (int i = 0; i <= finitesDifferences.size() - 1; i++) {
			if (i == 0) {
				polynoms.add(new Polynom(points.get(i).getY(), i));
			} else {
				polynoms.add(generatePolynom(i,finitesDifferences,points));
			}
		}

		return polynoms;
	}

	private static Polynom generatePolynom(int position, Map<Integer, List<Double>> finitesDifferences, List<Point> points) {
		List<Polynom> polynoms = new ArrayList<>();

		polynoms.add(new Polynom(finitesDifferences.get(position - 1).get(0), 0));

		for (int i = 0; i <= position - 1; i++) {
			polynoms.add(new Polynom(1.0, 1).subtract(new Polynom(points.get(i).getX(), 0)));
		}

		return productOfPolynoms(polynoms);
	}

	private static Polynom productOfPolynoms(List<Polynom> polynoms) {
		return polynoms.stream().reduce(Polynom::multiply).get();
	}

	public static Map<Integer, List<Double>> invertFinitesDifferences(Map<Integer, List<Double>> finitesDifferences) {
		Map<Integer, List<Double>> inverseDifferences = new HashMap<>();

		for (int i = 0; i <= finitesDifferences.size() - 1; i++) {
			inverseDifferences.put(i,Lists.reverse(finitesDifferences.get(i)));
		}
		return inverseDifferences;
	}
}
