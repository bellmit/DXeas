package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractJournalTimesInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractJournalTimesInfo()
    {
        this("id");
    }
    protected AbstractJournalTimesInfo(String pkField)
    {
        super(pkField);
        put("FarmToFarmEntrys", new com.kingdee.eas.farm.feedfactory.JournalTimesFarmToFarmEntryCollection());
        put("FacToFarmEntrys", new com.kingdee.eas.farm.feedfactory.JournalTimesFacToFarmEntryCollection());
    }
    /**
     * Object: 路程时间设置 's 组别 property 
     */
    public com.kingdee.eas.farm.feedfactory.JournalTimesTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feedfactory.JournalTimesTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feedfactory.JournalTimesTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 路程时间设置 's 饲料厂与养殖场间车程 property 
     */
    public com.kingdee.eas.farm.feedfactory.JournalTimesFacToFarmEntryCollection getFacToFarmEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.JournalTimesFacToFarmEntryCollection)get("FacToFarmEntrys");
    }
    /**
     * Object: 路程时间设置 's 养殖场间车程设置 property 
     */
    public com.kingdee.eas.farm.feedfactory.JournalTimesFarmToFarmEntryCollection getFarmToFarmEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.JournalTimesFarmToFarmEntryCollection)get("FarmToFarmEntrys");
    }
    /**
     * Object:路程时间设置's 状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1082BD31");
    }
}