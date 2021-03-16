package com.wengxs.cloud.mms.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 会员钱包
 * Created by Zorg
 * 2020-03-13 16:07
 */
@Data
public class MemberWallet {

    /** 会员ID */
    private Long memberId;

    /** 积分 */
    private Integer integration;

    /** 历史积分 */
    private Integer historyIntegration;

    /** 余额 */
    private BigDecimal balance;

}
