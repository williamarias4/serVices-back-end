package com.una.serVices.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JwtResponse {

    private final String jwtToken;
}
