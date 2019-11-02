package com.matsup.core.entities;

import com.matsup.core.utils.Polynom;

import java.util.List;

public class DataBean {


	List<Point> points;

	Polynom generatedPolynom;

	List<Polynom> subPolynoms;

	Boolean isEquispaced;

	int degree;

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

	public static DataBeanBuilder builder() {
		return new DataBeanBuilder();
	}


	public static final class DataBeanBuilder {
		private DataBean dataBean;

		private DataBeanBuilder() {
			dataBean = new DataBean();
		}

		public DataBeanBuilder points(List<Point> points) {
			dataBean.setPoints(points);
			return this;
		}

		public DataBeanBuilder generatedPolynom(Polynom generatedPolynom) {
			dataBean.setGeneratedPolynom(generatedPolynom);
			return this;
		}

		public DataBeanBuilder subPolynoms(List<Polynom> subPolynoms) {
			dataBean.setSubPolynoms(subPolynoms);
			return this;
		}

		public DataBeanBuilder isEquispaced(Boolean isEquispaced) {
			dataBean.setEquispaced(isEquispaced);
			return this;
		}

		public DataBeanBuilder degree(int degree) {
			dataBean.setDegree(degree);
			return this;
		}

		public DataBean build() {
			return dataBean;
		}
	}
}
