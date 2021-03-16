package com.wengxs.cloud.mms.service;

import com.wengxs.cloud.mms.model.Member;

public interface MemberService {

    Member save(Member member);

    Member update(Member member);

    Member find(Long id);
}
