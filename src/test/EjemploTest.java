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
		Integer ret = var.m0(5, 6);
		assertEquals(new Integer(2), ret);
	}

}