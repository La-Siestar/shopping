package com.siesta.shopping.user.application.ports.input;

import com.siesta.shopping.user.infrastructure.inbound.rest.dto.MemberResponseDto;

import java.util.List;

public interface MemberQueryPort {

    List<MemberResponseDto> findAllMembers();

    List<MemberResponseDto> findMembersByEmail(String email);

    boolean existsById(Long memberId);
}
