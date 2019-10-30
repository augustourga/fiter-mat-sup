package com.matsup.configuration.utils;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.matsup.core.ProcessFirstMenu;
import com.matsup.core.ProcessSecondMenu;
import com.matsup.core.process.implement.ProcessFirstMenuDefault;
import com.matsup.core.process.implement.ProcessSecondMenuDefault;


public class BasicModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(DataBean.class).toInstance(new DataBean());
		bind(Gson.class).toInstance(new Gson());

		bind(ProcessFirstMenu.class).to(ProcessFirstMenuDefault.class);
		bind(ProcessSecondMenu.class).to(ProcessSecondMenuDefault.class);
	}
}
