package com.siesta.modern.application.ports.output;

import com.siesta.modern.domain.entity.Member;

public interface MemberPersistenceOutput {
    void registerMember(Member member);
}
