package com.example.snsservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    final private MemberWriteService memberWriteService;

    @PostMapping("/members")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto memberRequestDto)
    {
        return memberWriteService.createMember(memberRequestDto);
    }


}
