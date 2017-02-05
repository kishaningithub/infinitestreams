package com.kishan.infinitestreams.streamer;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kishan.infinitestreams.dto.out.Sequence;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.math.BigInteger;
import java.util.stream.Stream;

public class ResponseSequenceStreamer implements StreamingOutput {

    private Stream<BigInteger> bigIntegerStream;

    public ResponseSequenceStreamer(Stream<BigInteger> bigIntegerStream) {
        this.bigIntegerStream = bigIntegerStream;
    }

    @Override
    public void write(OutputStream output) throws IOException, WebApplicationException {
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(output));
                JsonGenerator jsonGenerator = new JsonFactory(new ObjectMapper()).createGenerator(writer)
        ) {
            BigInteger index = BigInteger.ONE;
            jsonGenerator.writeStartArray();
            for (BigInteger v : (Iterable<BigInteger>) bigIntegerStream::iterator) {
                try {
                    jsonGenerator.writeObject(new Sequence(index, v));
                    index = index.add(BigInteger.ONE);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            jsonGenerator.writeEndArray();
        } catch (UncheckedIOException ignored) {}
    }
}
