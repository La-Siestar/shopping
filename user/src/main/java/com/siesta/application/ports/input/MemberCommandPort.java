package com.siesta.application.ports.input;

import com.siesta.infrastructure.inbound.rest.dto.MemberRequestDto;

public interface MemberCommandPort {

    Long registerMember(MemberRequestDto request);

    void updateMember(Long memberId, MemberRequestDto request);

    void deleteMember(Long memberId);
}
