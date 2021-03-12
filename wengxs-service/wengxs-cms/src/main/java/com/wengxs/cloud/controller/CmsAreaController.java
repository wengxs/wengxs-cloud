package com.wengxs.cloud.controller;

import com.wengxs.cloud.core.R;
import com.wengxs.cloud.service.CmsAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 地区信息Api
 */
@RequestMapping(value = "/cms/area")
@RestController
@Slf4j
public class CmsAreaController {

    @Autowired
    private CmsAreaService sysAreaService;

    @GetMapping()
    public R listByParent(@RequestParam Integer parentCode) {
        return R.ok(sysAreaService.listByParent(parentCode));
    }

}
