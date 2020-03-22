package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillSubsidyInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillSubsidyInfo()
    {
        this("id");
    }
    protected AbstractSettleBillSubsidyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 补贴 's null property 
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
     * Object:补贴's 单号property 
     */
    public String getBillNum()
    {
        return getString("billNum");
    }
    public void setBillNum(String item)
    {
        setString("billNum", item);
    }
    /**
     * Object:补贴's 金额property 
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
     * Object:补贴's 客诉类型property 
     */
    public String getCusComplainType()
    {
        return getString("cusComplainType");
    }
    public void setCusComplainType(String item)
    {
        setString("cusComplainType", item);
    }
    /**
     * Object:补贴's 摘要property 
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
     * Object:补贴's 单只重量property 
     */
    public java.math.BigDecimal getAvgWgt()
    {
        return getBigDecimal("avgWgt");
    }
    public void setAvgWgt(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C1904788");
    }
}