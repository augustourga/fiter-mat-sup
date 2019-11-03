package com.matsup.core.utils;

import com.matsup.core.entities.Point;

import java.util.List;

public  class ProcessCommonPolinomial {

	public static Boolean isEquispaced(List<Point> points) {
		Boolean isEquispaced = Boolean.TRUE;
		Double distance = getDistance(points.get(0), points.get(1));

		for (int i = 0; i <= points.size() - 2; i++) {
			if (!distance.equals(getDistance(points.get(i),points.get(i+1)))) {
				isEquispaced = Boolean.FALSE;
				break;
			}
		}
		return isEquispaced;
	}


	private static Double getDistance(Point point, Point point1) {
		return point1.getX() - point.getX();
	}


}
