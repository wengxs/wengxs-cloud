package com.wengxs.cloud.cms.mapper;

import com.wengxs.cloud.cms.model.CmsArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zorg
 * 2020-03-13 21:28
 */
@Mapper
public interface CmsAreaMapper {

    @Select("SELECT * FROM cms_area WHERE parent_code = #{parent_code}")
    List<CmsArea> findAllByParentCode(Integer parentCode);

}
