package com.siesta.modern.infrastructure.inbound.rest;

import com.siesta.modern.application.ports.input.MemberInput;
import com.siesta.modern.infrastructure.inbound.rest.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberInput memberInputPort;

    @PostMapping("/member/v1")
    public void create(
            @RequestBody MemberRequestDto request
    ) {
        memberInputPort.registerMember(request);
    }
}

