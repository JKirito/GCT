package test;

public class Ejemplo
{

	// public void max(int x, int y)
	// {
	// if (x >= y)
	// {
	// x = 0;
	// } else
	// {
	// y = 0;
	// }
	// }

	public void method(int x)
	{
		// if (x >= 0)
		// {
		// x = 0;
		// } else if (x < -10)
		// {
		// x = x * 10;
		// }

		while (x < 3)
		{
			x = x + 1;
			int i = 0;
			int c = 3;
			while (i + c < 5)
			{
				i = i + 1;
				c = i - 1;
			}
			System.out.println("x = " + x);
		}

	}

}
