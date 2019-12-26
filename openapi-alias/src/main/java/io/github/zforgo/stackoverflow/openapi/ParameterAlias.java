package io.github.zforgo.stackoverflow.openapi;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterAlias {
    Class<? extends Annotation> value();
}
