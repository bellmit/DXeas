package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggHouseSetInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLayEggHouseSetInfo()
    {
        this("id");
    }
    protected AbstractLayEggHouseSetInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.layegg.LayEggHouseSetEntryCollection());
    }
    /**
     * Object: 产蛋鸡舍设置 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggHouseSetEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggHouseSetEntryCollection)get("entrys");
    }
    /**
     * Object:产蛋鸡舍设置's 是否生成凭证property 
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
     * Object: 产蛋鸡舍设置 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object:产蛋鸡舍设置's 审核时间property 
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
     * Object: 产蛋鸡舍设置 's 鸡舍 property 
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
     * Object:产蛋鸡舍设置's 鸡舍名称property 
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
     * Object: 产蛋鸡舍设置 's 传送带 property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorInfo getConveyor()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorInfo)get("conveyor");
    }
    public void setConveyor(com.kingdee.eas.farm.breed.layegg.EggConveyorInfo item)
    {
        put("conveyor", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D7AFD1D0");
    }
}