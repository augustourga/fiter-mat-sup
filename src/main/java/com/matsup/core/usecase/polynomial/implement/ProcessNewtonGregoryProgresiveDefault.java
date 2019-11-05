package com.matsup.core.usecase.polynomial.implement;

import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Method;
import com.matsup.core.utils.ProcessCommonPolinomial;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;
import com.matsup.core.utils.FinitesDifferencesGenerator;
import com.matsup.core.utils.Polynom;

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

		List<Polynom> subPolynom = FinitesDifferencesGenerator.generateSubPolynoms(finitesDifferences,this.dataBean.getPoints());
		Polynom newtonGregoryProgresivePolynom = generateNewtonGregoryProgresivePolynom(subPolynom);

		this.dataBean.setGeneratedPolynom(newtonGregoryProgresivePolynom);
		this.dataBean.setEquispaced(ProcessCommonPolinomial.isEquispaced(this.dataBean.getPoints()));
		this.dataBean.setDegree(newtonGregoryProgresivePolynom.degree());
		this.dataBean.setSubPolynoms(subPolynom);
		this.dataBean.setMethod(Method.PROGRESIVE_NEWTON_GREGORY);
		this.dataBean.setFinitesDifferences(finitesDifferences);


		Renders.renderPolynom(newtonGregoryProgresivePolynom,
				newtonGregoryProgresivePolynom.degree(),
				ProcessCommonPolinomial.isEquispaced(this.dataBean.getPoints()));


	}

	private Polynom generateNewtonGregoryProgresivePolynom(List<Polynom> subPolynom) {
		return subPolynom.stream().reduce(Polynom::add).get();
	}
}
