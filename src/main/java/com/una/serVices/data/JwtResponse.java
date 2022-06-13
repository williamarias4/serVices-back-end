package com.una.serVices.data;

import lombok.Data;
import lombok.Getter;

@Data
public class JwtResponse {

    @Getter
    private final String jwtToken;
}
