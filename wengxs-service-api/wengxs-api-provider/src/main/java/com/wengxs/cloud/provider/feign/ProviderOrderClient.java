package com.wengxs.cloud.provider.feign;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.provider.feign.fallback.ProviderOrderClientFallback;
import com.wengxs.cloud.provider.entity.ProviderOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Zorg
 * 2021/3/16 上午10:20
 */
@FeignClient(value = "wengxs-provider", fallback = ProviderOrderClientFallback.class)
public interface ProviderOrderClient {

    @PostMapping("/provider/order/create")
    R<ProviderOrder> create(@RequestBody ProviderOrder providerOrder);

}
