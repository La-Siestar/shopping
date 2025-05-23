package com.siesta.shopping.user.application.usecase;


import com.siesta.shopping.user.application.ports.input.MemberQueryPort;
import com.siesta.shopping.user.infrastructure.inbound.rest.dto.MemberResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberQueryService implements MemberQueryPort {
    @Override
    public List<MemberResponseDto> findAllMembers() {
        return List.of();
    }

    @Override
    public List<MemberResponseDto> findMembersByEmail(String email) {
        return List.of();
    }

    @Override
    public boolean existsById(Long memberId) {
        return false;
    }
}
