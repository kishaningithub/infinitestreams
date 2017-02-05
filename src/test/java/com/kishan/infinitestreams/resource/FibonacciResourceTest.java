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

public class FibonacciResourceTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new FibonacciResource())
            .build();

    @Test
    public void shouldReturnFibonacciNos() {
        List<Sequence> first10FibonacciNos = ImmutableList.of(
                new Sequence(new BigInteger("1"), new BigInteger("0")),
                new Sequence(new BigInteger("2"), new BigInteger("1")),
                new Sequence(new BigInteger("3"), new BigInteger("1")),
                new Sequence(new BigInteger("4"), new BigInteger("2")),
                new Sequence(new BigInteger("5"), new BigInteger("3")),
                new Sequence(new BigInteger("6"), new BigInteger("5")),
                new Sequence(new BigInteger("7"), new BigInteger("8")),
                new Sequence(new BigInteger("8"), new BigInteger("13")),
                new Sequence(new BigInteger("9"), new BigInteger("21")),
                new Sequence(new BigInteger("10"), new BigInteger("34"))
        );
        List<Sequence> evenNos = resources.client().target("/fibonacci?limit=100").request().get(new GenericType<List<Sequence>>(){});

        assertThat(evenNos).hasSize(100);
        assertThat(evenNos).containsAll(first10FibonacciNos);
        assertThat(evenNos).contains(new Sequence(new BigInteger("100"), new BigInteger("218922995834555169026")));
    }
}
