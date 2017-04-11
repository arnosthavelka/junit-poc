package com.github.aha.poc.junit4.extension.validation;

import static java.util.Arrays.asList;

import java.util.List;

import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationValidator;

public class NoExclusionValidation extends AnnotationValidator {

	@Override
	public List<Exception> validateAnnotatedClass(TestClass testClass) {
		ExcludeCategory annotation = testClass.getAnnotation(ExcludeCategory.class);
		if (annotation == null) {
			// annotation is not present
			return super.validateAnnotatedClass(testClass);
		}
		return asList(new Exception("Usage of annotation ExcludeCategory is forbidden!"));
	}

}
