package com.wengxs.cloud.mms.feign.fallback;

import com.wengxs.cloud.mms.feign.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Zorg
 * 2020-03-13 15:52
 */
@Component
@Slf4j
public class MemberServiceHystrix implements MemberService {
}
