package test;

public class Ejemplo
{

	public Integer m0(int x, int y)
	{
		while (x > 2 && y > 0)
		{
			x--;
			int i = x + 1;
			i %= 3;
			while (i < 5)
			{
				i++;
			}
		}
		return x;
	}

	public void m1(int x, int y)
	{
		if (x > 2)
		{
			y = x + 1;
		} else
		{
			y = y + 1;
		}

		for (int i = 0; i < 10; i++)
		{
			if (x <= 2)
			{
				y = y + 1;
			} else
			{
				x = x + 2;
			}
		}

	}

	public void m2(int x)
	{
		if (x < 5)
		{
			if (x < 3)
			{
				do
				{
					x--;
					for (int i = 0; i <= x; i++)
					{
						;
					}
				} while (x > 0);
			}
		}
	}

	public Integer getMax(int x, int y, int z)
	{
		Integer max = Integer.MIN_VALUE;
		if (x > y && x > z)
			max = x;
		else if (y > x && y > z)
			max = y;
		else if (z > y && z > x)
			max = z;
		else
			return x;
		return max;
	}

}
