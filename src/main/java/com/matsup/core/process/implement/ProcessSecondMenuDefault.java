package com.matsup.core.process.implement;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.matsup.configuration.utils.DataBean;
import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.ProcessSecondMenu;

import javax.inject.Singleton;

@Singleton
public class ProcessSecondMenuDefault implements ProcessSecondMenu {

	private ProcessSecondMenu processSecondMenu;

	private DataBean dataBean;

	private Gson json;

	@Inject
	public ProcessSecondMenuDefault(ProcessSecondMenu processSecondMenu, DataBean dataBean, Gson json) {
		this.processSecondMenu = processSecondMenu;
		this.dataBean = dataBean;
		this.json = json;
	}

	@Override
	public void execute() {

		if (dataBean.getPoints()!= null) {
			dataBean.setPoints( dataBean.getPoints());
			while (true) {
				Renders.renderSecondDescription();

				int option = principalMenu();

				if (validateNotExit(option)) break;
			}
		}
	}


	private static boolean validateNotExit(int option) {
		return option == 3;
	}


	private static int principalMenu() {
		int option = Keyin.inInt("> ");
		switch (option) {
			case 1:
				System.out.println("Option 1 selected");
			case 2:
				System.out.println("Option 2 selected");
			case 3:
				System.out.println("Exit selected");
				break;
			default:
				System.out.println("Invalid selection");
		}
		return option;
	}
}
