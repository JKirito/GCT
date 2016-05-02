package test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EjemploTest
 {

	@Test
	public void m0_1()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.m0(0, 0);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void m0_2()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.m0(3, 1);
		assertEquals(new Integer(2), ret);
	}

	@Test
	public void m0_3()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.m0(6, 1);
		assertEquals(new Integer(2), ret);
	}

	@Test
	public void m0_4()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.m0(4, 1);
		assertEquals(new Integer(2), ret);
	}

	@Test
	public void m2_1()
	{
		Ejemplo var = new Ejemplo();
		var.m2(0);
	}

	@Test
	public void m2_2()
	{
		Ejemplo var = new Ejemplo();
		var.m2(1);
	}

	@Test
	public void m2_3()
	{
		Ejemplo var = new Ejemplo();
		var.m2(2);
	}

	@Test
	public void m2_4()
	{
		Ejemplo var = new Ejemplo();
		var.m2(3);
	}

	@Test
	public void m2_5()
	{
		Ejemplo var = new Ejemplo();
		var.m2(5);
	}

	@Test
	public void getMax_1()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.getMax(0, 0, 0);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void getMax_2()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.getMax(-2, -1, 0);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void getMax_3()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.getMax(-1, 0, -2);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void getMax_4()
	{
		Ejemplo var = new Ejemplo();
		Integer ret = var.getMax(0, -1, -1);
		assertEquals(new Integer(0), ret);
	}

	@Test
	public void m1_1()
	{
		Ejemplo var = new Ejemplo();
		var.m1(0, 0);
	}

	@Test
	public void m1_2()
	{
		Ejemplo var = new Ejemplo();
		var.m1(3, 0);
	}

}