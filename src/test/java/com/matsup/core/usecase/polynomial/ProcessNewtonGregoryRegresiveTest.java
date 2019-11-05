package com.matsup.core.usecase.polynomial;

import com.google.common.collect.Lists;
import com.matsup.core.entities.DataBean;
import com.matsup.core.entities.Method;
import com.matsup.core.entities.Point;
import com.matsup.core.usecase.polynomial.implement.ProcessNewtonGregoryRegresiveDefault;
import com.matsup.core.utils.Polynom;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProcessNewtonGregoryRegresiveTest {

	private DataBean dataBean;
	private ProcessPolynomialGenerator instance;

	@Before
	public void setUp() {
		this.dataBean = mock(DataBean.class);
		instance = new ProcessNewtonGregoryRegresiveDefault(this.dataBean);
	}

	@Test
	public void whenProcessNewtonGregoryRegresiveNotEquispaced_mustBeProcess() {

		/* [{"X":1,"Y":1},{"X":3,"Y":3},{"X":4,"Y":13},{"X":5,"Y":37},{"X":7,"Y":151}] */

		Point point1 = Point.builder().X(1.0).Y(1.0).build();
		Point point2 = Point.builder().X(3.0).Y(3.0).build();
		Point point3 = Point.builder().X(4.0).Y(13.0).build();
		Point point4 = Point.builder().X(5.0).Y(37.0).build();
		Point point5 = Point.builder().X(7.0).Y(151.0).build();

		when(this.dataBean.getPoints()).thenReturn(Lists.newArrayList(point1, point2, point3, point4, point5));

		this.instance.execute();

		verify(this.dataBean).setDegree(3);
		verify(this.dataBean).setGeneratedPolynom(new Polynom("- 3.0 + 8.0·x - 5.0·x^2 + 1.0·x^3"));
		verify(this.dataBean).setEquispaced(Boolean.FALSE);
		verify(this.dataBean).setMethod(Method.REGRESIVE_NEWTON_GREGORY);


		verify(this.dataBean).setSubPolynoms(Lists.newArrayList(
				new Polynom("151.0"),
				new Polynom(" - 399.0 + 57.0·x"),
				new Polynom("385.0 - 132.0·x + 11.0·x^2"),
				new Polynom("- 140.0 + 83.0·x - 16.0·x^2 + 1.0·x^3"),
				new Polynom("0.0")));
	}

	@Test
	public void whenProcessNewtonGregoryRegresiveEquispaced_mustBeProcess() {

		/* [{"X": 0,"Y":1},{"X": 1,"Y":1},{"X":2,"Y":2},{"X":3,"Y":5}] */

		Point point1 = Point.builder().X(0.0).Y(1.0).build();
		Point point2 = Point.builder().X(1.0).Y(1.0).build();
		Point point3 = Point.builder().X(2.0).Y(2.0).build();
		Point point4 = Point.builder().X(3.0).Y(5.0).build();

		when(this.dataBean.getPoints()).thenReturn(Lists.newArrayList(point1, point2, point3, point4));

		this.instance.execute();

		verify(this.dataBean).setDegree(3);
		verify(this.dataBean).setGeneratedPolynom(new Polynom("1.0 - 0.16666666666666674·x + 0.16666666666666666·x^3"));
		verify(this.dataBean).setEquispaced(Boolean.TRUE);
		verify(this.dataBean).setMethod(Method.REGRESIVE_NEWTON_GREGORY);


		verify(this.dataBean).setSubPolynoms(Lists.newArrayList(
				new Polynom("5.0"),
				new Polynom("- 9.0 + 3.0·x"),
				new Polynom(" 6.0 - 5.0·x + 1.0·x^2"),
				new Polynom("- 1.0 + 1.8333333333333333·x - 0.9999999999999999·x^2 + 0.16666666666666666·x^3")));

	}
}