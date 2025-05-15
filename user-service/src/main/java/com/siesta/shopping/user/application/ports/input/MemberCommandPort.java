package com.siesta.shopping.user.application.ports.input;


import com.siesta.shopping.user.infrastructure.inbound.rest.dto.MemberRequestDto;

public interface MemberCommandPort {

    Long registerMember(MemberRequestDto request);

    void updateMember(Long memberId, MemberRequestDto request);

    void deleteMember(Long memberId);
}
