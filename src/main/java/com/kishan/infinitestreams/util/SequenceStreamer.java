package com.kishan.infinitestreams.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kishan.infinitestreams.dto.out.Sequence;

import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.math.BigInteger;
import java.util.stream.Stream;

public final class SequenceStreamer {
    public static StreamingOutput from(Stream<BigInteger> bigIntegerStream) {
        return output -> {
            try (
                    Writer writer = new BufferedWriter(new OutputStreamWriter(output));
                    JsonGenerator jsonGenerator = new JsonFactory(new ObjectMapper()).createGenerator(writer)
            ) {
                BigInteger index = BigInteger.ONE;
                jsonGenerator.writeStartArray();
                for(BigInteger v: (Iterable<BigInteger>) bigIntegerStream::iterator) {
                    try {
                        jsonGenerator.writeObject(new Sequence(index, v));
                        index = index.add(BigInteger.ONE);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
                jsonGenerator.writeEndArray();
            } catch (UncheckedIOException ignored) {}
        };
    }
}
