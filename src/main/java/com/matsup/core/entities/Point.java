package com.matsup.core.entities;

public class Point {

	Double X;
	Double Y;

	public Double getX() {
		return X;
	}

	public void setX(Double x) {
		X = x;
	}

	public Double getY() {
		return Y;
	}

	public void setY(Double y) {
		Y = y;
	}

	public static PointBuilder builder() {
		return new PointBuilder();
	}


	public static final class PointBuilder {
		private Point point;

		private PointBuilder() {
			point = new Point();
		}

		public PointBuilder X(Double X) {
			point.setX(X);
			return this;
		}

		public PointBuilder Y(Double Y) {
			point.setY(Y);
			return this;
		}

		public Point build() {
			return point;
		}
	}
}

