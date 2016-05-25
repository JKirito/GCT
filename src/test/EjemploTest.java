package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EjemploTest
{

	@Test
	public void toTest2_1()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(0);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void toTest2_2()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(1);
		assertEquals(new Integer(1), ret);
	}

	@Test
	public void toTest2_3()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(2);
		assertEquals(new Integer(2), ret);
	}

	@Test
	public void toTest2_4()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(3);
		assertEquals(new Integer(3), ret);
	}

	@Test
	public void toTest2_5()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(4);
		assertEquals(new Integer(4), ret);
	}

	@Test
	public void toTest2_6()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(5);
		assertEquals(new Integer(5), ret);
	}

	@Test
	public void toTest2_7()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(6);
		assertEquals(new Integer(6), ret);
	}

	@Test
	public void toTest2_8()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest2(7);
		assertEquals(new Integer(7), ret);
	}

	@Test
	public void toTest_1()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest(0, 0);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void toTest_2()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest(8, 11);
		assertEquals(new Integer(11), ret);
	}

	@Test
	public void toTest_3()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.toTest(-1, 3);
		assertEquals(new Integer(3), ret);
	}

}