package com.matsup.core.usecase.actions.implement;

import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.DataBean;
import com.matsup.core.usecase.actions.ProcessAction;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProcessActionSpecializePolynom implements ProcessAction {

	private DataBean dataBean;

	@Inject
	public ProcessActionSpecializePolynom(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {

		Renders.renderSpecializeInput();
		Double inDouble = Keyin.inDouble("> ");

		Renders.renderSpecializePolynom(this.dataBean.getGeneratedPolynom().valueOf(inDouble),inDouble);
	}

}
