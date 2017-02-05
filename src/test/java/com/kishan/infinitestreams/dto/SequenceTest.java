package com.kishan.infinitestreams.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kishan.infinitestreams.dto.out.Sequence;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.math.BigInteger;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class SequenceTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private final Sequence sequence = new Sequence(new BigInteger("100000000000000000000000000000000000000000"), new BigInteger("173402521172797813159685037284371942044301"));

    @Test
    public void serializesToJSON() throws Exception {
        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/sequence.json"), Sequence.class));

        assertThat(MAPPER.writeValueAsString(sequence)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        assertThat(MAPPER.readValue(fixture("fixtures/sequence.json"), Sequence.class))
                .isEqualTo(sequence);
    }
}
