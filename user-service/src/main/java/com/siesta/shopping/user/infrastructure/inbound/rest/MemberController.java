package com.siesta.shopping.user.infrastructure.inbound.rest;


import com.siesta.application.ports.input.MemberCommandPort;
import com.siesta.application.ports.input.MemberQueryPort;
import com.siesta.infrastructure.inbound.rest.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class MemberController {

     private final MemberCommandPort memberCommandPort;
     private final MemberQueryPort memberQueryPort;


     @PostMapping("/member/v1")
     public ResponseEntity<?> create(
             @RequestBody MemberRequestDto request
     ) {
         Long memberId = memberCommandPort.registerMember(request);
         URI location = URI.create("/api/v1/members/" + memberId);
         return ResponseEntity.created(location).build();
     }

}
