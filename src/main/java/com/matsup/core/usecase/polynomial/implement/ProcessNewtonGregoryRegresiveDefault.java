package com.matsup.core.usecase.polynomial.implement;

import com.matsup.configuration.utils.DataBean;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProcessNewtonGregoryRegresiveDefault implements ProcessPolynomialGenerator {


	private DataBean dataBean;

	@Inject
	public ProcessNewtonGregoryRegresiveDefault(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {
		System.out.println("Voy a generar el polinomio de NGR con estos puntos: "  + this.dataBean.getPoints().toString());

	}
}
