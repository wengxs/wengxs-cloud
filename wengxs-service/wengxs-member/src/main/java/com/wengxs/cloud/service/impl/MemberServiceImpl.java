package com.wengxs.cloud.service.impl;

import com.wengxs.cloud.mapper.MemberMapper;
import com.wengxs.cloud.model.Member;
import com.wengxs.cloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        Long id = memberMapper.insert(member);
        return memberMapper.select(id);
    }

    @Override
    public Member update(Member member) {
        memberMapper.update(member);
        return member;
    }

    @Override
    public Member find(Long id) {
        return memberMapper.select(id);
    }
}
