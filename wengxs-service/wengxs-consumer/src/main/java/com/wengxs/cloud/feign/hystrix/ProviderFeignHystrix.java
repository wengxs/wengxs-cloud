package com.wengxs.cloud.feign.hystrix;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.feign.ProviderFeign;
import org.springframework.stereotype.Component;

/**
 * Created by Zorg
 * 2021/3/15 下午6:19
 */
@Component
public class ProviderFeignHystrix implements ProviderFeign {

    @Override
    public R<String> create() {
//        throw new RuntimeException("失败了");
        return R.fail("服务调用失败");
    }
}
