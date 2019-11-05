package com.matsup.core.usecase.actions.implement;

import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Method;
import com.matsup.core.usecase.actions.ProcessAction;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProcessActionShowSteps implements ProcessAction {

	private DataBean dataBean;

	@Inject
	public ProcessActionShowSteps(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {

		if (this.dataBean.getMethod().equals(Method.LAGRANGE)){
			this.renderLagrange();
		} else {
			this.renderNewtonGregory();
		}
	}

	private void renderNewtonGregory() {
		for (int i = 0; i <= this.dataBean.getFinitesDifferences().size() - 1; i++) {
			Renders.renderFinitesDifferences(this.dataBean.getFinitesDifferences().get(i), i);
		}
	}

	private void renderLagrange() {
		for (int i = 0; i <= this.dataBean.getSubPolynoms().size() - 1; i++) {
			Renders.renderSubPolynoms(this.dataBean.getSubPolynoms().get(i), i);
		}
	}
}
