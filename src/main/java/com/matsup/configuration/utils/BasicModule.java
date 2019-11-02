package com.matsup.configuration.utils;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.matsup.core.usecase.menu.ProcessFirstMenu;
import com.matsup.core.usecase.menu.ProcessSecondMenu;
import com.matsup.core.usecase.menu.implement.ProcessFirstMenuDefault;
import com.matsup.core.usecase.menu.implement.ProcessSecondMenuDefault;
import com.matsup.core.usecase.polynomial.ProcessPolynomialGenerator;
import com.matsup.core.usecase.polynomial.implement.ProcessLagrangeDefault;
import com.matsup.core.usecase.polynomial.implement.ProcessNewtonGregoryProgresiveDefault;
import com.matsup.core.usecase.polynomial.implement.ProcessNewtonGregoryRegresiveDefault;


public class BasicModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(DataBean.class).toInstance(new DataBean());
		bind(Gson.class).toInstance(new Gson());

		bind(ProcessFirstMenu.class).to(ProcessFirstMenuDefault.class);
		bind(ProcessSecondMenu.class).to(ProcessSecondMenuDefault.class);
		bind(ProcessPolynomialGenerator.class).annotatedWith(Names.named("lagrange")).to(ProcessLagrangeDefault.class);
		bind(ProcessPolynomialGenerator.class).annotatedWith(Names.named("newtonGregoryProgresive")).to(ProcessNewtonGregoryProgresiveDefault.class);
		bind(ProcessPolynomialGenerator.class).annotatedWith(Names.named("newtonGregoryRegresive")).to(ProcessNewtonGregoryRegresiveDefault.class);



	}
}
