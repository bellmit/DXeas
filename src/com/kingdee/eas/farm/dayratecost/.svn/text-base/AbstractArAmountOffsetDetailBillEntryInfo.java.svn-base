package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractArAmountOffsetDetailBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractArAmountOffsetDetailBillEntryInfo()
    {
        this("id");
    }
    protected AbstractArAmountOffsetDetailBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 金额property 
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
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: 分录 's 项目 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo getFeeItem()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo)get("feeItem");
    }
    public void setFeeItem(com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo item)
    {
        put("feeItem", item);
    }
    /**
     * Object:分录's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:分录's 冲减占用property 
     */
    public boolean isIsTemp()
    {
        return getBoolean("isTemp");
    }
    public void setIsTemp(boolean item)
    {
        setBoolean("isTemp", item);
    }
    /**
     * Object:分录's 结算单idproperty 
     */
    public String getSettleBillID()
    {
        return getString("settleBillID");
    }
    public void setSettleBillID(String item)
    {
        setString("settleBillID", item);
    }
    /**
     * Object:分录's 结算单明细idproperty 
     */
    public String getSettleBillDetailID()
    {
        return getString("settleBillDetailID");
    }
    public void setSettleBillDetailID(String item)
    {
        setString("settleBillDetailID", item);
    }
    /**
     * Object: 分录 's 操作人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    /**
     * Object: 分录 's 固定资产 property 
     */
    public com.kingdee.eas.fi.fa.manage.FaCurCardInfo getFaCard()
    {
        return (com.kingdee.eas.fi.fa.manage.FaCurCardInfo)get("faCard");
    }
    public void setFaCard(com.kingdee.eas.fi.fa.manage.FaCurCardInfo item)
    {
        put("faCard", item);
    }
    /**
     * Object:分录's 结算单编码property 
     */
    public String getSettleBillNum()
    {
        return getString("settleBillNum");
    }
    public void setSettleBillNum(String item)
    {
        setString("settleBillNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("ECC53E99");
    }
}