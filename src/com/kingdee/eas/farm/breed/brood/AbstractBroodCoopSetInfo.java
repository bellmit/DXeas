package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodCoopSetInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBroodCoopSetInfo()
    {
        this("id");
    }
    protected AbstractBroodCoopSetInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryCollection());
    }
    /**
     * Object: 育成鸡舍设置 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryCollection)get("entrys");
    }
    /**
     * Object:育成鸡舍设置's 是否生成凭证property 
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
     * Object:育成鸡舍设置's 审核时间property 
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
     * Object: 育成鸡舍设置 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:育成鸡舍设置's 鸡舍名称property 
     */
    public String getWarehouse()
    {
        return getString("warehouse");
    }
    public void setWarehouse(String item)
    {
        setString("warehouse", item);
    }
    /**
     * Object: 育成鸡舍设置 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A16BE215");
    }
}