package com.kishan.infinitestreams.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sequence {
    private BigInteger index;
    private BigInteger value;
}
