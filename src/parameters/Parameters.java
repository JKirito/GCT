package parameters;

import java.io.File;

public class Parameters
{

	/*
	 * Estos path tienen que ser una sola carpeta!
	 */

	public static final String	TMP_PATH							= "tmp";
	public final static String	TMP_PATH_JAVA_PREPROCESS_CLASS		= TMP_PATH + File.separator + "preprocess";
	public final static String	TMP_PATH_JAVA_INSTRUMENTED_CLASS	= TMP_PATH + File.separator + "instrument";
	public final static String	TMP_PATH_COMPILED_CLASS				= TMP_PATH + File.separator + "bin";

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
