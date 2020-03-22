package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggConveyorInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEggConveyorInfo()
    {
        this("id");
    }
    protected AbstractEggConveyorInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������ʹ� 's ��� property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.layegg.EggConveyorTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �������ʹ� 's ������ property 
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
     * Object:�������ʹ�'s ��������property 
     */
    public String getHenhouseDesc()
    {
        return getString("henhouseDesc");
    }
    public void setHenhouseDesc(String item)
    {
        setString("henhouseDesc", item);
    }
    /**
     * Object: �������ʹ� 's ���� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getEggWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("eggWarehouse");
    }
    public void setEggWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("eggWarehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("453E2B43");
    }
}