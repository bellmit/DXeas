package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedCostPriceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFeedCostPriceInfo()
    {
        this("id");
    }
    protected AbstractFeedCostPriceInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryCollection());
    }
    /**
     * Object: 饲料运费价格维护 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryCollection)get("entrys");
    }
    /**
     * Object:饲料运费价格维护's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 饲料运费价格维护 's 财务组织 property 
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
     * Object:饲料运费价格维护's 单据状态property 
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
     * Object: 饲料运费价格维护 's 品种 property 
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
     * Object:饲料运费价格维护's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D1CABB1C");
    }
}