package com.wengxs.cloud.service;

import com.wengxs.cloud.model.CmsArea;

import java.util.List;

/**
 * Created by Zorg
 * 2020-03-13 21:41
 */
public interface CmsAreaService {

    List<CmsArea> listByParent(Integer parentCode);

}
