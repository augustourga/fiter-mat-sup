package com.matsup.core.usecase.polynomial.implement;


import com.matsup.core.entities.DataBean;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.menu.ProcessThirdMenu;
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

		List<Polynom> lxiList = LxisGenerator.generateLxis(this.dataBean.getPoints());
		Polynom lagrangePolynom = generateLagrangePolynom(lxiList);

		this.dataBean.setGeneratedPolynom(lagrangePolynom);
		this.dataBean.setEquispaced(ProcessCommonPolinomial.isEquispaced(this.dataBean.getPoints()));
		this.dataBean.setSubPolynoms(lxiList);
		this.dataBean.setSubPolynoms(lxiList);

		Renders.renderPolynom(lagrangePolynom);

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
