package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCBreedPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCCBreedPlanInfo()
    {
        this("id");
    }
    protected AbstractCCBreedPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.business.CCBreedPlanEntryCollection());
    }
    /**
     * Object: 入栏计划 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.business.CCBreedPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CCBreedPlanEntryCollection)get("entrys");
    }
    /**
     * Object:入栏计划's 是否生成凭证property 
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
     * Object:入栏计划's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 入栏计划 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object:入栏计划's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:入栏计划's 鸡舍类别property 
     */
    public com.kingdee.eas.farm.breed.HenhouseType getHouseType()
    {
        return com.kingdee.eas.farm.breed.HenhouseType.getEnum(getString("houseType"));
    }
    public void setHouseType(com.kingdee.eas.farm.breed.HenhouseType item)
    {
		if (item != null) {
        setString("houseType", item.getValue());
		}
    }
    /**
     * Object:入栏计划's 饲喂周期(天)property 
     */
    public int getBreedDays()
    {
        return getInt("breedDays");
    }
    public void setBreedDays(int item)
    {
        setInt("breedDays", item);
    }
    /**
     * Object: 入栏计划 's 会计期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92CDCA4F");
    }
}