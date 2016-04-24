package utils;

import java.io.File;

public class Utils
{
	public static String getSimpleJavaFileName(String filePath)
	{
		return new File(filePath).getName().replace(".java", "");
	}

	public static String getPackageName(String filePath)
	{
		if (new File(filePath).isDirectory())
			return new File(filePath).getName();
		String packageName = new File(filePath).getParent();

		return packageName.substring(packageName.lastIndexOf(File.separator) + 1);
	}

}
