package io.github.zforgo.stackoverflow.openapi;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.core.util.AnnotationsUtils;
import io.swagger.v3.jaxrs2.DefaultParameterExtension;
import io.swagger.v3.jaxrs2.ResolvedParameter;
import io.swagger.v3.jaxrs2.ext.OpenAPIExtension;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.models.Components;

import javax.ws.rs.Consumes;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ParameterAliasExtension extends DefaultParameterExtension {
    @Override
    public ResolvedParameter extractParameters(List<Annotation> annotations, Type type, Set<Type> typesToSkip, Components components, Consumes classConsumes, Consumes methodConsumes, boolean includeRequestBody, JsonView jsonViewAnnotation, Iterator<OpenAPIExtension> chain) {
        List<Annotation> extendedAnnotations = null;
        if (null != annotations) {
            extendedAnnotations = new ArrayList<>(annotations);
            ParameterAlias alias = AnnotationsUtils.getAnnotation(ParameterAlias.class, annotations.toArray(new Annotation[0]));
            if (null != alias) {
                Parameter aliasParameter = AnnotationsUtils.getAnnotation(Parameter.class, alias.value().getDeclaredAnnotations());
                if (null != aliasParameter) {
                    extendedAnnotations.add(aliasParameter);
                }
            }
        }
        return super.extractParameters(extendedAnnotations == null ? annotations : extendedAnnotations, type, typesToSkip, components, classConsumes, methodConsumes, includeRequestBody, jsonViewAnnotation, chain);
    }
}
