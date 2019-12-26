package io.github.zforgo.stackoverflow.openapi.resources;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(
        info = @Info(title = "Sample alias title", version = "1.0.0", description = "Sample alias description")
)
public class JaxRSActivator extends Application {

}
