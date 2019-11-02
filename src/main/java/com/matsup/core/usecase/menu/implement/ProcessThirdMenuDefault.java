package com.matsup.core.usecase.menu.implement;

import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.usecase.actions.ProcessAction;
import com.matsup.core.usecase.menu.ProcessThirdMenu;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProcessThirdMenuDefault implements ProcessThirdMenu {

	private Map<Integer, ProcessAction> strategy = new HashMap<>();

	@Inject
	public ProcessThirdMenuDefault(@Named("showSteps") ProcessAction processShowSteps,
								   @Named("specializePolynom")ProcessAction processSpecializePolynom) {
		this.strategy.put(1,processShowSteps);
		this.strategy.put(2,processSpecializePolynom);


	}

	@Override
	public void execute() {
		while (true) {
			Renders.renderThirdDescription();
			Integer optionSelected = Keyin.inInt("> ");

			if (optionSelected < 3) {
				this.strategy.get(optionSelected).execute();
			} else {
				break;
			}
		}
	}
}
