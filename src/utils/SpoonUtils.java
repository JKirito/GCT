package utils;

import java.util.ArrayList;
import java.util.List;

import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.reference.CtTypeReference;

public class SpoonUtils
{

	public static List<CtTypeReference<?>> getTypeReferences(CtMethod<?> method)
	{
		List<CtTypeReference<?>> typeRefs = new ArrayList<>();
		for (CtParameter<?> P : method.getParameters())
		{
			typeRefs.add(P.getType());
		}

		return typeRefs;
	}
}
