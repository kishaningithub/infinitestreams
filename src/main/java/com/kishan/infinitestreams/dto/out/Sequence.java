package com.kishan.infinitestreams.dto.out;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Sequence {
    private BigInteger index;
    private BigInteger value;
}
