package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggPriceDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEggPriceDataInfo()
    {
        this("id");
    }
    protected AbstractEggPriceDataInfo(String pkField)
    {
        super(pkField);
        put("PriceEntry", new com.kingdee.eas.farm.stocking.basedata.EggPriceDataPriceEntryCollection());
    }
    /**
     * Object: 种蛋价格维护 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:种蛋价格维护's 说明property 
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
     * Object: 种蛋价格维护 's 对应物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:种蛋价格维护's 基本状态property 
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
     * Object:种蛋价格维护's 价格property 
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
     * Object:种蛋价格维护's 日期property 
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
     * Object: 种蛋价格维护 's 财务组织 property 
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
     * Object:种蛋价格维护's 失效日期property 
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
     * Object: 种蛋价格维护 's 价格分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.EggPriceDataPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.EggPriceDataPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object: 种蛋价格维护 's 结算政策 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo item)
    {
        put("settlePolicy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B1FA9FDF");
    }
}