package com.wengxs.cloud.core.base.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * Created by Zorg
 * 2021/3/16 上午9:33
 */
@Data
public class BaseEntity<ID> {

    @TableId(value = "id", type = IdType.AUTO)
    private ID id;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Date createTime;

    @TableField(update = "NOW()")
    private Date updateTime;

}
