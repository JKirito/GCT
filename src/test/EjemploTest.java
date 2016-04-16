package test;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class EjemploTest
 {

	@Test
	public void method_1()
	{
		Ejemplo var = new Ejemplo();
		var.method(0);
	}

	@Test
	public void method_2()
	{
		Ejemplo var = new Ejemplo();
		var.method(-1);
	}

	@Test
	public void method_3()
	{
		Ejemplo var = new Ejemplo();
		var.method(-11);
	}

}