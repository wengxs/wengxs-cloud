package com.wengxs.cloud.service.impl;

import com.wengxs.cloud.mapper.CmsAreaMapper;
import com.wengxs.cloud.model.CmsArea;
import com.wengxs.cloud.service.CmsAreaService;
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
