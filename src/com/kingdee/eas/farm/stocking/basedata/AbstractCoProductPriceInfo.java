package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCoProductPriceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCoProductPriceInfo()
    {
        this("id");
    }
    protected AbstractCoProductPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 副产品价格维护 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:副产品价格维护's 说明property 
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
     * Object:副产品价格维护's 基本状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:副产品价格维护's 日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object: 副产品价格维护 's 财务组织 property 
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
     * Object:副产品价格维护's 失效日期property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object:副产品价格维护's 破单黄property 
     */
    public java.math.BigDecimal getBrokenSinglePrice()
    {
        return getBigDecimal("brokenSinglePrice");
    }
    public void setBrokenSinglePrice(java.math.BigDecimal item)
    {
        setBigDecimal("brokenSinglePrice", item);
    }
    /**
     * Object:副产品价格维护's 菜蛋property 
     */
    public java.math.BigDecimal getGreensPrice()
    {
        return getBigDecimal("greensPrice");
    }
    public void setGreensPrice(java.math.BigDecimal item)
    {
        setBigDecimal("greensPrice", item);
    }
    /**
     * Object:副产品价格维护's 脏蛋property 
     */
    public java.math.BigDecimal getDirtyPirce()
    {
        return getBigDecimal("dirtyPirce");
    }
    public void setDirtyPirce(java.math.BigDecimal item)
    {
        setBigDecimal("dirtyPirce", item);
    }
    /**
     * Object:副产品价格维护's 畸形蛋property 
     */
    public java.math.BigDecimal getMutantPrice()
    {
        return getBigDecimal("mutantPrice");
    }
    public void setMutantPrice(java.math.BigDecimal item)
    {
        setBigDecimal("mutantPrice", item);
    }
    /**
     * Object:副产品价格维护's 双黄蛋property 
     */
    public java.math.BigDecimal getDoublePrice()
    {
        return getBigDecimal("doublePrice");
    }
    public void setDoublePrice(java.math.BigDecimal item)
    {
        setBigDecimal("doublePrice", item);
    }
    /**
     * Object:副产品价格维护's 流蛋property 
     */
    public java.math.BigDecimal getFlowPrice()
    {
        return getBigDecimal("flowPrice");
    }
    public void setFlowPrice(java.math.BigDecimal item)
    {
        setBigDecimal("flowPrice", item);
    }
    /**
     * Object:副产品价格维护's 破双黄property 
     */
    public java.math.BigDecimal getBrokenDoublePrice()
    {
        return getBigDecimal("brokenDoublePrice");
    }
    public void setBrokenDoublePrice(java.math.BigDecimal item)
    {
        setBigDecimal("brokenDoublePrice", item);
    }
    /**
     * Object: 副产品价格维护 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("566729B7");
    }
}