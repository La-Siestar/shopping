package com.siesta.shopping.user.infrastructure.inbound.rest.dto;

public record MemberRequestDto(
        String username,
        String email
) {
}
