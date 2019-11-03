package com.matsup.core.usecase.polynomial;

import com.google.common.collect.Lists;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.polynomial.implement.ProcessLagrangeDefault;
import com.matsup.core.utils.Polynom;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProcessLagrangeTest {

	private DataBean dataBean;
	private ProcessPolynomialGenerator instance;

	@Before
	public void setUp() {
		this.dataBean = mock(DataBean.class);
		instance = new ProcessLagrangeDefault(this.dataBean);
	}

	@Test
	public void whenProcess_mustBeProcess() {

		/*[{"X": 0,"Y":1},{"X": 1,"Y":1},{"X":2,"Y":2},{"X":4,"Y":5}]*/

		Point point1 = Point.builder().X(0.0).Y(1.0).build();
		Point point2 = Point.builder().X(1.0).Y(1.0).build();
		Point point3 = Point.builder().X(2.0).Y(2.0).build();
		Point point4 = Point.builder().X(4.0).Y(5.0).build();

		when(this.dataBean.getPoints()).thenReturn(Lists.newArrayList(point1, point2, point3, point4));

		this.instance.execute();

		verify(this.dataBean).setDegree(3);
		verify(this.dataBean).setGeneratedPolynom(new Polynom("1.0 - 0.6666666666666669·x + 0.75·x^2 - 0.08333333333333337·x^3"));
		verify(this.dataBean).setEquispaced(Boolean.FALSE);
		verify(this.dataBean).setSubPolynoms(Lists.newArrayList(new Polynom("1.0"),
				new Polynom("1.0 - 1.75·x + 0.875·x^2 - 0.125·x^3"),
				new Polynom("2.6666666666666665·x - 2.0·x^2 + 0.3333333333333333·x^3"),
				new Polynom("- 1.0·x + 1.25·x^2 - 0.25·x^3"),
				new Polynom("0.08333333333333333·x - 0.125·x^2 + 0.041666666666666664·x^3")));


	}
}