package com.wengxs.cloud.mms.mapper;

import com.wengxs.cloud.mms.model.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {

    @Insert(
            "insert into tb_member(name, mobile) values(#{name}, #{mobile})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Long insert(Member member);

    @Update(
            "update tb_member set mobile=#{mobile}, integral=#{integral} where id=#{id}"
    )
    int update(Member member);

    @Select("select * from tb_member where id=#{id}")
    Member select(Long id);
}
