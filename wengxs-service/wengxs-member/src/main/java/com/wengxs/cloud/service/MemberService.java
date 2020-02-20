package com.wengxs.cloud.service;

import com.wengxs.cloud.model.Member;

public interface MemberService {

    Member save(Member member);

    Member update(Member member);

    Member find(Long id);
}
