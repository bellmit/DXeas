package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillRewardsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsBillRewardsEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillRewardsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖惩分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:奖惩分录's 项目名称property 
     */
    public String getItemName()
    {
        return getString("itemName");
    }
    public void setItemName(String item)
    {
        setString("itemName", item);
    }
    /**
     * Object:奖惩分录's 金额property 
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
     * Object:奖惩分录's 结算项目idproperty 
     */
    public String getItemID()
    {
        return getString("itemID");
    }
    public void setItemID(String item)
    {
        setString("itemID", item);
    }
    /**
     * Object:奖惩分录's 备注property 
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
        return new BOSObjectType("FD6F157E");
    }
}