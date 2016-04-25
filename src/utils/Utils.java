package utils;

import java.io.File;
import java.io.IOException;

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

	public static void delete(File file) throws IOException
	{
		if (file.isDirectory())
		{
			// directory is empty, then delete it
			if (file.list().length == 0)
			{
				file.delete();
			} else
			{
				// list all the directory contents
				String files[] = file.list();
				for (String temp : files)
				{
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0)
				{
					file.delete();
				}
			}
		} else
		{
			// if file, then delete it
			file.delete();
		}
	}

}
