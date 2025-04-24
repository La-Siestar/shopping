package com.siesta.modern.application.ports.input;

import com.siesta.modern.infrastructure.inbound.rest.dto.MemberRequestDto;

public interface MemberInput {

    void registerMember(MemberRequestDto memberRequestDto);
}
