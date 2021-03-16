package com.wengxs.cloud.cms.service;

import com.wengxs.cloud.cms.model.CmsArea;

import java.util.List;

/**
 * Created by Zorg
 * 2020-03-13 21:41
 */
public interface CmsAreaService {

    List<CmsArea> listByParent(Integer parentCode);

}
