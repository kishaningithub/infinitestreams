package com.kishan.infinitestreams.resource;

import com.codahale.metrics.annotation.Timed;
import com.kishan.infinitestreams.util.SequenceStreamer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

@Path("fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {

    @GET
    @Timed
    public Response getFibNos(@QueryParam("limit") Optional<Long> limit) {
        List<BigInteger> fibonacciWindow = new LinkedList<>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE));
        Stream<BigInteger> fibonacciStream = Stream.generate(() -> {
            BigInteger nextValue = fibonacciWindow.get(1).add(fibonacciWindow.get(0));
            fibonacciWindow.add(nextValue);
            return fibonacciWindow.remove(0);
        });

        if(limit.isPresent()) {
            fibonacciStream = fibonacciStream.limit(limit.get());
        }
        return Response.ok(SequenceStreamer.from(fibonacciStream)).build();
    }

}
