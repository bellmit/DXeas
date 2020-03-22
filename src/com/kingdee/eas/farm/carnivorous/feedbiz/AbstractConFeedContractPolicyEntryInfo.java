package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedContractPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractConFeedContractPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractConFeedContractPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 政策分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 政策分录 's 连养政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo getConfeedPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo)get("confeedPolicy");
    }
    public void setConfeedPolicy(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo item)
    {
        put("confeedPolicy", item);
    }
    /**
     * Object:政策分录's 起始日期property 
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
     * Object:政策分录's 终止日期property 
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
     * Object:政策分录's 是否默认property 
     */
    public boolean isIsDefault()
    {
        return getBoolean("isDefault");
    }
    public void setIsDefault(boolean item)
    {
        setBoolean("isDefault", item);
    }
    /**
     * Object:政策分录's 政策年限property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object: 政策分录 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:政策分录's 补贴类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyType getSubsidyType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.SubsidyType.getEnum(getString("subsidyType"));
    }
    public void setSubsidyType(com.kingdee.eas.farm.carnivorous.basedata.SubsidyType item)
    {
		if (item != null) {
        setString("subsidyType", item.getValue());
		}
    }
    /**
     * Object:政策分录's 补贴单价property 
     */
    public java.math.BigDecimal getSubsidy()
    {
        return getBigDecimal("subsidy");
    }
    public void setSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("subsidy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BC2964F2");
    }
}