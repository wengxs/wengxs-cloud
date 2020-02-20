package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.util.R;
import com.wengxs.cloud.model.Member;
import com.wengxs.cloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/integral")
    public R addIntegral(@RequestParam Long memberId, Integer integral) {
        Member member = memberService.find(memberId);
        member.setIntegral(member.getIntegral() + integral);
        memberService.update(member);
        return R.success(member);
    }

    @PostMapping()
    public R addMember(@RequestParam String name, @RequestParam(required = false) String mobile) {
        Member member = new Member();
        member.setName(name);
        member.setMobile(mobile);
        memberService.save(member);
        return R.success(member);
    }

}
