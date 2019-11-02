package com.matsup.core.usecase.polynomial.implement;


import com.matsup.configuration.utils.DataBean;
import com.matsup.core.usecase.polynomial.ProcessCommonPolinomial;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;
import com.matsup.core.utils.LxisGenerator;
import com.matsup.core.utils.Polynom;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProcessLagrangeDefault extends ProcessCommonPolinomial implements ProcessPolynomialGenerator {

	private DataBean dataBean;

	@Inject
	public ProcessLagrangeDefault(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {
		System.out.println("Voy a generar el polinomio de Lagrange con estos puntos: " + this.dataBean.getPoints().toString());

		List<Polynom> lxiList = LxisGenerator.generateLxis(this.dataBean.getPoints());
		Polynom lagrangePolynom = generateLagrangePolynom(lxiList);

		System.out.println("Polinomio generado: P(X)=  " + lagrangePolynom.toString());
	}

	private Polynom generateLagrangePolynom(List<Polynom> lxiList) {
		List<Polynom> products = new ArrayList<>();

		for (int i = 0; i <= this.dataBean.getPoints().size() - 1; i++) {
			products.add(lxiList.get(i).multiply(
					this.dataBean.getPoints().get(i).getY()));
		}

		return  products.stream().reduce(Polynom::add).get();
	}
}
