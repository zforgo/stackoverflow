package io.github.zforgo.stackoverflow.openapi;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.GenericOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResolveTest {
    private OpenAPI openAPI;

    @BeforeAll
    void setUp() throws OpenApiConfigurationException {
        SwaggerConfiguration config = new SwaggerConfiguration()
                .prettyPrint(Boolean.TRUE)
                .readAllResources(Boolean.TRUE)
                .resourcePackages(Collections.singleton("io.github.zforgo.stackoverflow.openapi"));
        GenericOpenApiContextBuilder builder = new JaxrsOpenApiContextBuilder()
                .openApiConfiguration(config);
        openAPI = builder
                .buildContext(true)
                .read();
    }

    @Test
    void resolveTest() {
        String openapiYaml = Yaml.pretty(openAPI);
        assertNotNull(openapiYaml);
        System.out.println(openapiYaml);
    }
}

