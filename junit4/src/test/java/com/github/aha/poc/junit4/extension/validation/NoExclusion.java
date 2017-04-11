package com.github.aha.poc.junit4.extension.validation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.validator.ValidateWith;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ValidateWith(NoExclusionValidation.class)
public @interface NoExclusion {

}
