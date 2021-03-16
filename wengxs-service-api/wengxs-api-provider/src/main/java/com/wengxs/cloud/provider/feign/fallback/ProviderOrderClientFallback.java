package com.wengxs.cloud.provider.feign.fallback;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.entity.ProviderOrder;
import com.wengxs.cloud.provider.feign.ProviderOrderClient;
import org.springframework.stereotype.Component;

/**
 * Created by Zorg
 * 2021/3/16 上午10:21
 */
@Component
public class ProviderOrderClientFallback implements ProviderOrderClient {

    @Override
    public R<ProviderOrder> create(ProviderOrder providerOrder) {
        return R.fail("服务调用失败");
    }
}
