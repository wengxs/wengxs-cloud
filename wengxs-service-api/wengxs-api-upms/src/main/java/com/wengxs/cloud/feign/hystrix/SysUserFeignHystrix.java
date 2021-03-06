package com.wengxs.cloud.feign.hystrix;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.dto.UserInfo;
import com.wengxs.cloud.feign.SysUserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Zorg
 * 2019-08-15 15:22
 */
@Component
@Slf4j
public class SysUserFeignHystrix implements SysUserFeign {

    @Override
    public R<UserInfo> userInfo(String username) {
        log.error("<wengxs-upms>:/user/info -> username:{}", username);
        return null;
    }

}
