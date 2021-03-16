package com.wengxs.cloud.cms.service.impl;

import com.wengxs.cloud.cms.mapper.CmsAreaMapper;
import com.wengxs.cloud.cms.model.CmsArea;
import com.wengxs.cloud.cms.service.CmsAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zorg
 * 2020-03-13 21:41
 */
@Service
public class CmsAreaServiceImpl implements CmsAreaService {

    @Autowired
    private CmsAreaMapper cmsAreaMapper;

    @Override
    public List<CmsArea> listByParent(Integer parentCode) {
        return cmsAreaMapper.findAllByParentCode(parentCode);
    }

}
