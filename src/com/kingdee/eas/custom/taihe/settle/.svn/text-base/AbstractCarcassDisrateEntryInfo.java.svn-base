package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassDisrateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassDisrateEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassDisrateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 平均只重>=property 
     */
    public java.math.BigDecimal getAvgWgtCell()
    {
        return getBigDecimal("avgWgtCell");
    }
    public void setAvgWgtCell(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtCell", item);
    }
    /**
     * Object:分录's 平均只重<property 
     */
    public java.math.BigDecimal getAvgWgtFloor()
    {
        return getBigDecimal("avgWgtFloor");
    }
    public void setAvgWgtFloor(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtFloor", item);
    }
    /**
     * Object:分录's 出成率property 
     */
    public java.math.BigDecimal getRate()
    {
        return getBigDecimal("rate");
    }
    public void setRate(java.math.BigDecimal item)
    {
        setBigDecimal("rate", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("16F124B3");
    }
}