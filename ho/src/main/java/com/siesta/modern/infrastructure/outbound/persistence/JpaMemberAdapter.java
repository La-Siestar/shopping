package com.siesta.modern.infrastructure.outbound.persistence;
import com.siesta.modern.application.ports.output.MemberPersistenceOutput;
import com.siesta.modern.domain.entity.Member;
import com.siesta.modern.infrastructure.outbound.persistence.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaMemberAdapter implements MemberPersistenceOutput {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public void registerMember(Member member) {
        memberJpaRepository.save(member);
    }
}
