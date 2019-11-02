package com.matsup.core.usecase.polynomial.implement;

import com.matsup.configuration.utils.DataBean;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProcessNewtonGregoryProgresiveDefault implements ProcessPolynomialGenerator {


	private DataBean dataBean;

	@Inject
	public ProcessNewtonGregoryProgresiveDefault(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {

		System.out.println("Voy a generar el polinomio de NGP con estos puntos: "  + this.dataBean.getPoints().toString());


	}
}
