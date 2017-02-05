package com.kishan.infinitestreams.resource;

import com.codahale.metrics.annotation.Timed;
import com.kishan.infinitestreams.streamer.ResponseSequenceStreamer;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

@Path("even")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class EvenNosResource {

    @GET
    @Timed
    public Response getEvenNos(@QueryParam("limit") Optional<Long> limit) {
        Stream<BigInteger> evenNoStream = Stream.iterate(BigInteger.ONE, v -> v.add(BigInteger.ONE))
                .filter(v -> v.remainder(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0);
        if(limit.isPresent()) {
            evenNoStream = evenNoStream.limit(limit.get());
        }
        return Response.ok(new ResponseSequenceStreamer(evenNoStream)).build();
    }

}
