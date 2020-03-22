package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTempPolicyPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTempPolicyPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractTempPolicyPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 政策明细 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:政策明细's 政策日期关联property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DateRelate getPolicyDatR()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.DateRelate.getEnum(getString("policyDatR"));
    }
    public void setPolicyDatR(com.kingdee.eas.farm.carnivorous.basedata.DateRelate item)
    {
		if (item != null) {
        setString("policyDatR", item.getValue());
		}
    }
    /**
     * Object:政策明细's 物料选择property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MaterialType getMatSelect()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.MaterialType.getEnum(getString("matSelect"));
    }
    public void setMatSelect(com.kingdee.eas.farm.carnivorous.basedata.MaterialType item)
    {
		if (item != null) {
        setString("matSelect", item.getValue());
		}
    }
    /**
     * Object:政策明细's 计量单位property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CalUnit getUnit()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.CalUnit.getEnum(getString("unit"));
    }
    public void setUnit(com.kingdee.eas.farm.carnivorous.basedata.CalUnit item)
    {
		if (item != null) {
        setString("unit", item.getValue());
		}
    }
    /**
     * Object:政策明细's 开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:政策明细's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:政策明细's 均重起始值property 
     */
    public java.math.BigDecimal getWgtBegin()
    {
        return getBigDecimal("wgtBegin");
    }
    public void setWgtBegin(java.math.BigDecimal item)
    {
        setBigDecimal("wgtBegin", item);
    }
    /**
     * Object:政策明细's 均重终止值property 
     */
    public java.math.BigDecimal getWgtEnd()
    {
        return getBigDecimal("wgtEnd");
    }
    public void setWgtEnd(java.math.BigDecimal item)
    {
        setBigDecimal("wgtEnd", item);
    }
    /**
     * Object:政策明细's 扣补单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A36A57F8");
    }
}