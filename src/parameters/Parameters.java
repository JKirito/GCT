package parameters;

import java.io.File;

public class Parameters
{

	/*
	 * Estos path tienen que ser una sola carpeta!
	 */
	public final static String	TMP_PATH_JAVA_PREPROCESS_CLASS		= "tmp" + File.separator + "preprocess";
	public final static String	TMP_PATH_JAVA_INSTRUMENTED_CLASS	= "tmp" + File.separator + "instrument";
	public final static String	TMP_PATH_COMPILED_CLASS				= "bin";

	public final static String getPackagePreProcess()
	{
		return getPackage(TMP_PATH_JAVA_PREPROCESS_CLASS);
	}

	public final static String getPackageInstrumented()
	{
		return getPackage(TMP_PATH_JAVA_INSTRUMENTED_CLASS);
	}

	public static String getPackage(String path)
	{
		String packageName = path;
		if (path.contains(File.separator))
			packageName = packageName.substring(packageName.lastIndexOf(File.separator) + 1);

		return packageName;
	}
}
