package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassDisrateInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractCarcassDisrateInfo()
    {
        this("id");
    }
    protected AbstractCarcassDisrateInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.settle.CarcassDisrateEntryCollection());
        put("DisRateEntry", new com.kingdee.eas.custom.taihe.settle.CarcassDisrateDisRateEntryCollection());
    }
    /**
     * Object: 胴体出成折算标准 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.settle.CarcassDisrateTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 胴体出成折算标准 's 分录 property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateEntryCollection)get("Entry");
    }
    /**
     * Object:胴体出成折算标准's 生效日期property 
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
     * Object:胴体出成折算标准's 失效日期property 
     */
    public java.util.Date getUneffectDate()
    {
        return getDate("uneffectDate");
    }
    public void setUneffectDate(java.util.Date item)
    {
        setDate("uneffectDate", item);
    }
    /**
     * Object: 胴体出成折算标准 's 公司 property 
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
     * Object: 胴体出成折算标准 's 折算系数 property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateDisRateEntryCollection getDisRateEntry()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateDisRateEntryCollection)get("DisRateEntry");
    }
    /**
     * Object:胴体出成折算标准's 收购类型property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettlePurchaseTypeEnum getPurchaseType()
    {
        return com.kingdee.eas.custom.taihe.settle.SettlePurchaseTypeEnum.getEnum(getInt("purchaseType"));
    }
    public void setPurchaseType(com.kingdee.eas.custom.taihe.settle.SettlePurchaseTypeEnum item)
    {
		if (item != null) {
        setInt("purchaseType", item.getValue());
		}
    }
    /**
     * Object:胴体出成折算标准's 是否棚前property 
     */
    public boolean isHouseBefore()
    {
        return getBoolean("houseBefore");
    }
    public void setHouseBefore(boolean item)
    {
        setBoolean("houseBefore", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1A7EFAFF");
    }
}