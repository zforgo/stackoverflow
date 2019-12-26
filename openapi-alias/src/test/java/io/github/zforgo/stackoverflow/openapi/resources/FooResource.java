package io.github.zforgo.stackoverflow.openapi.resources;

import io.github.zforgo.stackoverflow.openapi.ParameterAlias;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Tags(@Tag(name = "test", description = ""))
public class FooResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{FieldId}")
    @Operation(operationId = "createFoo", summary = "Creates a Foo entity")
    public void create(@Parameter(in = ParameterIn.PATH,
            name = "FieldId",
            required = true,
            extensions = {@Extension(properties = @ExtensionProperty(name = "custom-tipcsi",
                    value = "FieldId"))},
            schema = @Schema(type = "string")) final FieldId fieldId) {

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{FieldId}")
    @Operation(operationId = "modifyFoo", summary = "Modifies a Foo entity")
    public void modify(@ParameterAlias(MyAnnotator.class) final FieldId fieldId) {

    }
}