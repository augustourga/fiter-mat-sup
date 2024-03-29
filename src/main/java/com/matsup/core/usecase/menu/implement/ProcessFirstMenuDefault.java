package com.matsup.core.usecase.menu.implement;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.matsup.core.entities.DataBean;
import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.menu.ProcessFirstMenu;
import com.matsup.core.usecase.menu.ProcessSecondMenu;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ProcessFirstMenuDefault implements ProcessFirstMenu {

	private ProcessSecondMenu processSecondMenu;

	private DataBean dataBean;

	private Gson json;

	@Inject
	public ProcessFirstMenuDefault(ProcessSecondMenu processSecondMenu,
								   DataBean dataBean,
								   Gson json) {
		this.processSecondMenu = processSecondMenu;
		this.dataBean = dataBean;
		this.json = json;
	}

	@Override
	public void execute() {
		while (true) {
			Renders.renderPrincipalDescription();
			this.dataBean.setPoints(Keyin.initPoints(" > ", json));
			processSecondMenu.execute();
		}
	}
}
