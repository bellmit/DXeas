package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillRewardPunishInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillRewardPunishInfo()
    {
        this("id");
    }
    protected AbstractSettleBillRewardPunishInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖惩项目 's null property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.SettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 奖惩项目 's 奖惩项目 property 
     */
    public com.kingdee.eas.custom.settlebill.RewardAndPunishProjectInfo getRewardPunishItem()
    {
        return (com.kingdee.eas.custom.settlebill.RewardAndPunishProjectInfo)get("rewardPunishItem");
    }
    public void setRewardPunishItem(com.kingdee.eas.custom.settlebill.RewardAndPunishProjectInfo item)
    {
        put("rewardPunishItem", item);
    }
    /**
     * Object:奖惩项目's 数量property 
     */
    public java.math.BigDecimal getQuantity()
    {
        return getBigDecimal("quantity");
    }
    public void setQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("quantity", item);
    }
    /**
     * Object:奖惩项目's 单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:奖惩项目's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:奖惩项目's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("77690F27");
    }
}