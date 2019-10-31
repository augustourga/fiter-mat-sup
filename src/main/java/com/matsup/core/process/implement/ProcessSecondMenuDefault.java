package com.matsup.core.process.implement;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.matsup.configuration.utils.DataBean;
import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.ProcessSecondMenu;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProcessSecondMenuDefault implements ProcessSecondMenu {

	private ProcessSecondMenu processSecondMenu;

	private DataBean dataBean;

	private Map<Integer, String> strategy = new HashMap<>();

	private Gson json;

	@Inject
	public ProcessSecondMenuDefault(ProcessSecondMenu processSecondMenu, DataBean dataBean, Gson json) {
		this.processSecondMenu = processSecondMenu;
		this.dataBean = dataBean;
		this.json = json;
		this.strategy.put(1,"Lagrange");
		this.strategy.put(2,"Newton Gregory Progresivo");
		this.strategy.put(3,"Newton Gregory Regresivo");


	}

	@Override
	public void execute() {
		if (dataBean.getPoints()!= null) {
			while (true) {
				Renders.renderSecondDescription();
				String option = this.strategy.get(Keyin.inInt("> "));
				System.out.println("\nSe ha seleccionado: " + option);
			}
		}
	}

}
