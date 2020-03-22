package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsteadSeedPriceDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractInsteadSeedPriceDataInfo()
    {
        this("id");
    }
    protected AbstractInsteadSeedPriceDataInfo(String pkField)
    {
        super(pkField);
        put("Range", new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection());
        put("PriceEntry", new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection());
    }
    /**
     * Object: 苗价维护(代孵) 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:苗价维护(代孵)'s 说明property 
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
     * Object: 苗价维护(代孵) 's 对应物料 property 
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
     * Object:苗价维护(代孵)'s 基本状态property 
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
     * Object:苗价维护(代孵)'s 价格property 
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
     * Object:苗价维护(代孵)'s 日期property 
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
     * Object: 苗价维护(代孵) 's 财务组织 property 
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
     * Object:苗价维护(代孵)'s 失效日期property 
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
     * Object: 苗价维护(代孵) 's 价格分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object: 苗价维护(代孵) 's 作用范围 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection getRange()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection)get("Range");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E8049D1");
    }
}