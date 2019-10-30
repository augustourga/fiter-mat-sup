package com.matsup.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.matsup.configuration.utils.BasicModule;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.ProcessFirstMenu;


public class Main {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new BasicModule());
		ProcessFirstMenu processFirstMenu = injector.getInstance(ProcessFirstMenu.class);

		Renders.renderHeader();

		processFirstMenu.execute();

	}


}
