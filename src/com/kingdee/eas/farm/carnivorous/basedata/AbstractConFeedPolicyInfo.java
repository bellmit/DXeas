package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractConFeedPolicyInfo()
    {
        this("id");
    }
    protected AbstractConFeedPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 连养政策 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 连养政策 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:连养政策's 开始日期property 
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
     * Object:连养政策's 结束日期property 
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
     * Object: 连养政策 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreed()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breed");
    }
    public void setBreed(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breed", item);
    }
    /**
     * Object:连养政策's 补贴类型property 
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
     * Object:连养政策's 补贴property 
     */
    public java.math.BigDecimal getSubsidy()
    {
        return getBigDecimal("subsidy");
    }
    public void setSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("subsidy", item);
    }
    /**
     * Object:连养政策's 基本状态property 
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
     * Object:连养政策's 政策年限property 
     */
    public int getEnableYear()
    {
        return getInt("enableYear");
    }
    public void setEnableYear(int item)
    {
        setInt("enableYear", item);
    }
    /**
     * Object: 连养政策 's 养殖户类别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo getFarmerType()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo)get("farmerType");
    }
    public void setFarmerType(com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo item)
    {
        put("farmerType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BB25130");
    }
}