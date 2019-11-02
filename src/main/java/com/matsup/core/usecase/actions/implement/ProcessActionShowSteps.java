package com.matsup.core.usecase.actions.implement;

import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.DataBean;
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
		for (int i = 0; i <= this.dataBean.getSubPolynoms().size() - 1; i++) {
			Renders.renderSubPolynoms(this.dataBean.getSubPolynoms().get(i), i);
		}
	}
}
