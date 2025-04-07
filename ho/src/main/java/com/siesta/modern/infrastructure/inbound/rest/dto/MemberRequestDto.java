package com.siesta.modern.infrastructure.inbound.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String username;
    private String email;
}
