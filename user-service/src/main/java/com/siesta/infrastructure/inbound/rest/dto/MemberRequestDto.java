package com.siesta.infrastructure.inbound.rest.dto;

public record MemberRequestDto(
        String username,
        String email
) {
}
