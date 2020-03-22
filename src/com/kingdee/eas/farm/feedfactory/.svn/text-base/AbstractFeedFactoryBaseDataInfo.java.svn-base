package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryBaseDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFeedFactoryBaseDataInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryBaseDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料厂基础设置 's 组别 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 饲料厂基础设置 's 饲料厂 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFeedFactory()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("feedFactory");
    }
    public void setFeedFactory(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("feedFactory", item);
    }
    /**
     * Object:饲料厂基础设置's 起始装车时间property 
     */
    public java.sql.Time getStartLoadTime()
    {
        return getTime("startLoadTime");
    }
    public void setStartLoadTime(java.sql.Time item)
    {
        setTime("startLoadTime", item);
    }
    /**
     * Object:饲料厂基础设置's 最晚装车时间property 
     */
    public java.sql.Time getEndLoadTime()
    {
        return getTime("endLoadTime");
    }
    public void setEndLoadTime(java.sql.Time item)
    {
        setTime("endLoadTime", item);
    }
    /**
     * Object:饲料厂基础设置's 同时打料能力(车)property 
     */
    public int getMaxEntruckCount()
    {
        return getInt("maxEntruckCount");
    }
    public void setMaxEntruckCount(int item)
    {
        setInt("maxEntruckCount", item);
    }
    /**
     * Object:饲料厂基础设置's 午饭开始时间property 
     */
    public java.sql.Time getLunchBeginTime()
    {
        return getTime("lunchBeginTime");
    }
    public void setLunchBeginTime(java.sql.Time item)
    {
        setTime("lunchBeginTime", item);
    }
    /**
     * Object:饲料厂基础设置's 午饭结束时间property 
     */
    public java.sql.Time getLunchEndTime()
    {
        return getTime("lunchEndTime");
    }
    public void setLunchEndTime(java.sql.Time item)
    {
        setTime("lunchEndTime", item);
    }
    /**
     * Object:饲料厂基础设置's 午饭耗时(分钟)property 
     */
    public int getLunchTimecost()
    {
        return getInt("lunchTimecost");
    }
    public void setLunchTimecost(int item)
    {
        setInt("lunchTimecost", item);
    }
    /**
     * Object:饲料厂基础设置's 状态property 
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
     * Object:饲料厂基础设置's 打料时间(分钟)property 
     */
    public int getLoadingTimes()
    {
        return getInt("LoadingTimes");
    }
    public void setLoadingTimes(int item)
    {
        setInt("LoadingTimes", item);
    }
    /**
     * Object: 饲料厂基础设置 's 质检标准组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getQcOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("qcOrgUnit");
    }
    public void setQcOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("qcOrgUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E9089AA5");
    }
}