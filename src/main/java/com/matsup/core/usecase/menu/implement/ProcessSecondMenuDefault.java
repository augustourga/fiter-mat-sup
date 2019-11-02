package com.matsup.core.usecase.menu.implement;

import com.google.inject.Inject;
import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.usecase.menu.ProcessSecondMenu;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProcessSecondMenuDefault implements ProcessSecondMenu {

	private Map<Integer, ProcessPolynomialGenerator> strategy = new HashMap<>();

	@Inject
	public ProcessSecondMenuDefault(@Named("lagrange") ProcessPolynomialGenerator processLagrange,
									@Named("newtonGregoryProgresive") ProcessPolynomialGenerator processNewtonGregoryProgresive,
									@Named("newtonGregoryRegresive") ProcessPolynomialGenerator processNewtonGregoryRegresive) {
		this.strategy.put(1, processLagrange);
		this.strategy.put(2, processNewtonGregoryProgresive);
		this.strategy.put(3, processNewtonGregoryRegresive);


	}

	@Override
	public void execute() {
		while (true) {
			Renders.renderSecondDescription();
			Integer optionSelected = Keyin.inInt("> ");

			if (optionSelected < 4) {
				this.strategy.get(optionSelected).execute();
			} else {
				break;
			}
		}
	}


}
