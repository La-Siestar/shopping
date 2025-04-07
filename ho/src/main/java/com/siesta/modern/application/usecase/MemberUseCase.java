package com.siesta.modern.application.usecase;
import com.siesta.modern.application.ports.input.MemberInput;
import com.siesta.modern.application.ports.output.MemberPersistenceOutput;
import com.siesta.modern.domain.entity.Member;
import com.siesta.modern.infrastructure.inbound.rest.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberUseCase implements MemberInput {
    private final MemberPersistenceOutput memberOutput;

    @Override
    public void registerMember(MemberRequestDto memberRequestDto) {

        Member member = Member.createMember(memberRequestDto.getUsername(), memberRequestDto.getEmail());

        memberOutput.registerMember(member);
    }
}
