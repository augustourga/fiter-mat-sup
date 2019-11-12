package com.matsup.core.usecase.actions.implement;

import com.matsup.configuration.utils.Keyin;
import com.matsup.configuration.utils.Renders;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.actions.ProcessAction;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProcessActionChangePoints implements ProcessAction {

	private DataBean dataBean;

	@Inject
	public ProcessActionChangePoints(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@Override
	public void execute() {

		while (true) {
			Renders.renderChangePointsMenu(this.dataBean.getPoints());
			int option  = Keyin.pointMenu(" > ", this.dataBean.getPoints().size());

			if (option <= this.dataBean.getPoints().size()+1 ){
				Renders.renderEnterPoint("X");
				Double x = Keyin.inDouble(" > ");
				Renders.renderEnterPoint("Y");
				Double y = Keyin.inDouble(" > ");

				if (option <= this.dataBean.getPoints().size()) {
					this.dataBean.getPoints().get(option-1).setX(x);
					this.dataBean.getPoints().get(option-1).setY(y);
				} else {
					Point newPoint = Point.builder().X(x).Y(y).build();
					this.dataBean.getPoints().add(newPoint);
				}
			} else break;
		}

		}
}
