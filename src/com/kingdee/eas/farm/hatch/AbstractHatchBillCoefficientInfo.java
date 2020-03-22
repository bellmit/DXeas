package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBillCoefficientInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchBillCoefficientInfo()
    {
        this("id");
    }
    protected AbstractHatchBillCoefficientInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.hatch.HatchBillCoefficientEntryCollection());
    }
    /**
     * Object:层盘枚系数设置's 是否集团统一property 
     */
    public boolean isIsGroup()
    {
        return getBoolean("isGroup");
    }
    public void setIsGroup(boolean item)
    {
        setBoolean("isGroup", item);
    }
    /**
     * Object:层盘枚系数设置's 是否公司统一property 
     */
    public boolean isIsCompany()
    {
        return getBoolean("isCompany");
    }
    public void setIsCompany(boolean item)
    {
        setBoolean("isCompany", item);
    }
    /**
     * Object: 层盘枚系数设置 's 库存组织分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillCoefficientEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.hatch.HatchBillCoefficientEntryCollection)get("Entry");
    }
    /**
     * Object: 层盘枚系数设置 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:层盘枚系数设置's 车property 
     */
    public java.math.BigDecimal getCarCoefficient()
    {
        return getBigDecimal("carCoefficient");
    }
    public void setCarCoefficient(java.math.BigDecimal item)
    {
        setBigDecimal("carCoefficient", item);
    }
    /**
     * Object:层盘枚系数设置's 层property 
     */
    public java.math.BigDecimal getFloor()
    {
        return getBigDecimal("floor");
    }
    public void setFloor(java.math.BigDecimal item)
    {
        setBigDecimal("floor", item);
    }
    /**
     * Object:层盘枚系数设置's 盘property 
     */
    public java.math.BigDecimal getPlate()
    {
        return getBigDecimal("plate");
    }
    public void setPlate(java.math.BigDecimal item)
    {
        setBigDecimal("plate", item);
    }
    /**
     * Object:层盘枚系数设置's 枚property 
     */
    public java.math.BigDecimal getUnitMei()
    {
        return getBigDecimal("unitMei");
    }
    public void setUnitMei(java.math.BigDecimal item)
    {
        setBigDecimal("unitMei", item);
    }
    /**
     * Object:层盘枚系数设置's 单据类型property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillTypeEnum getBillType()
    {
        return com.kingdee.eas.farm.hatch.HatchBillTypeEnum.getEnum(getInt("BillType"));
    }
    public void setBillType(com.kingdee.eas.farm.hatch.HatchBillTypeEnum item)
    {
		if (item != null) {
        setInt("BillType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8F8EB95C");
    }
}