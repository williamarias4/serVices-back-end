package com.una.serVices.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JwtResponse {

    @Getter
    @Setter
    private final String jwtToken;
}
