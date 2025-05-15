package com.siesta.shopping.user.application.usecase;


import com.siesta.shopping.user.application.ports.input.MemberCommandPort;
import com.siesta.shopping.user.infrastructure.inbound.rest.dto.MemberRequestDto;
import org.springframework.stereotype.Service;

@Service
public class MemberCommandService implements MemberCommandPort {
    @Override
    public Long registerMember(MemberRequestDto request) {
        return null;
    }

    @Override
    public void updateMember(Long memberId, MemberRequestDto request) {

    }

    @Override
    public void deleteMember(Long memberId) {

    }
}
