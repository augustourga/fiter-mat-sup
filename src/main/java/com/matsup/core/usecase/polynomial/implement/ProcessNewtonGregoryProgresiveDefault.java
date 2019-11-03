package com.matsup.core.usecase.polynomial.implement;

import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;
import com.matsup.core.utils.FinitesDifferencesGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
public class ProcessNewtonGregoryProgresiveDefault implements ProcessPolynomialGenerator {


	private DataBean dataBean;

	@Inject
	public ProcessNewtonGregoryProgresiveDefault(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {

		Map<Integer,List<Double>> finitesDifferences = FinitesDifferencesGenerator.generateFinitesDifferences(this.dataBean.getPoints());
		System.out.println("Voy a generar el polinomio de NGP con estos puntos: "  + this.dataBean.getPoints().toString());


	}
}
