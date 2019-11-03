package com.matsup.core.usecase.polynomial;

import com.google.common.collect.Lists;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.polynomial.implement.ProcessNewtonGregoryProgresiveDefault;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProcessNewtonGregoryProgresiveTest {

	private DataBean dataBean;
	private ProcessPolynomialGenerator instance;

	@Before
	public void setUp() {
		this.dataBean = mock(DataBean.class);
		instance = new ProcessNewtonGregoryProgresiveDefault(this.dataBean);
	}

	@Test
	public void whenProcess_mustBeProcess() {
		Point point1 = Point.builder().X(1.0).Y(1.0).build();
		Point point2 = Point.builder().X(3.0).Y(3.0).build();
		Point point3 = Point.builder().X(4.0).Y(13.0).build();
		Point point4 = Point.builder().X(5.0).Y(37.0).build();
		Point point5 = Point.builder().X(7.0).Y(151.0).build();

		when(this.dataBean.getPoints()).thenReturn(Lists.newArrayList(point1, point2, point3, point4, point5));

		this.instance.execute();

	}
}