package com.kishan.infinitestreams.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Optional;

@Path("example")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET
    @Timed
    public Response getUris(@Context UriInfo uriInfo, @Context ResourceContext rc) {
        URI fibonacciNosURI = uriInfo.getBaseUriBuilder().path(FibonacciResource.class).build();
        Object fibonacciNosResponse = rc.getResource(FibonacciResource.class).getFibNos(Optional.of(100L)).getEntity();
        return Response.created(fibonacciNosURI).entity(fibonacciNosResponse).build();
    }
}
