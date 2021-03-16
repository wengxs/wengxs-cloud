package com.wengxs.cloud.oms.mapper;

import com.wengxs.cloud.oms.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

    @Update("update tb_order set `status`= #{status} where sn=#{sn}")
    int updateStatus(String sn, Integer status);

    @Insert(
            "insert into tb_order(sn, status, goods_name, goods_id, number, total, price, member_id) " +
                    "values(#{sn}, #{status}, #{goodsName}, #{goodsId}, #{number}, #{total}, #{price}, #{memberId})"
    )
    int insert(Order order);

}
