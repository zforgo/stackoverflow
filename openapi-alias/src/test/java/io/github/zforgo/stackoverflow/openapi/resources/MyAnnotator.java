package io.github.zforgo.stackoverflow.openapi.resources;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Parameter(in = ParameterIn.PATH,
        name = "FieldId",
        required = true,
        extensions = {@Extension(properties = @ExtensionProperty(name = "custom-type",
                value = "FieldId"))})
public @interface MyAnnotator {
}
