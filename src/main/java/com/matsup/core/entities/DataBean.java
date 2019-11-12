package com.matsup.core.entities;

import com.matsup.core.utils.Polynom;

import java.util.List;
import java.util.Map;

public class DataBean {


	List<Point> points;

	Polynom generatedPolynom;

	Polynom lastGeneratedPolynom;

	List<Polynom> subPolynoms;

	Boolean isEquispaced;

	int degree;

	Method method;

	Map<Integer, List<Double>> finitesDifferences;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Polynom getGeneratedPolynom() {
		return generatedPolynom;
	}

	public void setGeneratedPolynom(Polynom generatedPolynom) {
		this.lastGeneratedPolynom = this.generatedPolynom;
		this.generatedPolynom = generatedPolynom;
	}

	public Boolean getEquispaced() {
		return isEquispaced;
	}

	public void setEquispaced(Boolean equispaced) {
		isEquispaced = equispaced;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public List<Polynom> getSubPolynoms() {
		return subPolynoms;
	}

	public void setSubPolynoms(List<Polynom> subPolynoms) {
		this.subPolynoms = subPolynoms;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Map<Integer, List<Double>> getFinitesDifferences() {
		return finitesDifferences;
	}

	public void setFinitesDifferences(Map<Integer, List<Double>> finitesDifferences) {
		this.finitesDifferences = finitesDifferences;
	}

	public Polynom getLastGeneratedPolynom() {
		return lastGeneratedPolynom;
	}

	public void setLastGeneratedPolynom(Polynom lastGeneratedPolynom) {
		this.lastGeneratedPolynom = lastGeneratedPolynom;
	}
}
