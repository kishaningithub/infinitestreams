package com.kishan.infinitestreams.resource;

import com.google.common.collect.ImmutableList;
import com.kishan.infinitestreams.dto.out.Sequence;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EvenNosResourceTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new EvenNosResource())
            .build();

    @Test
    public void shouldReturnEvenNos() {
        List<Sequence> first10EvenNos = ImmutableList.of(
                new Sequence(new BigInteger("1"), new BigInteger("2")),
                new Sequence(new BigInteger("2"), new BigInteger("4")),
                new Sequence(new BigInteger("3"), new BigInteger("6")),
                new Sequence(new BigInteger("4"), new BigInteger("8")),
                new Sequence(new BigInteger("5"), new BigInteger("10")),
                new Sequence(new BigInteger("6"), new BigInteger("12")),
                new Sequence(new BigInteger("7"), new BigInteger("14")),
                new Sequence(new BigInteger("8"), new BigInteger("16")),
                new Sequence(new BigInteger("9"), new BigInteger("18")),
                new Sequence(new BigInteger("10"), new BigInteger("20"))
        );
        List<Sequence> evenNos = resources.client().target("/even?limit=100").request().get(new GenericType<List<Sequence>>(){});

        assertThat(evenNos).hasSize(100);
        assertThat(evenNos).containsAll(first10EvenNos);
        assertThat(evenNos).contains(new Sequence(new BigInteger("100"), new BigInteger("200")));
    }
}
