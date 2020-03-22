package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardRelationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCardRelationInfo()
    {
        this("id");
    }
    protected AbstractCardRelationInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 磁卡关系维护 's 组别 property 
     */
    public com.kingdee.eas.publicdata.CardRelationTreeInfo getTreeid()
    {
        return (com.kingdee.eas.publicdata.CardRelationTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.publicdata.CardRelationTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 磁卡关系维护 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object: 磁卡关系维护 's 基础资料 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getBaseData()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("baseData");
    }
    public void setBaseData(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("baseData", item);
    }
    /**
     * Object:磁卡关系维护's 基础资料名称property 
     */
    public String getBaseDataName()
    {
        return getString("baseDataName");
    }
    public void setBaseDataName(String item)
    {
        setString("baseDataName", item);
    }
    /**
     * Object:磁卡关系维护's 文本property 
     */
    public String getBIMUDF0008()
    {
        return getString("BIMUDF0008");
    }
    public void setBIMUDF0008(String item)
    {
        setString("BIMUDF0008", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E899AC8F");
    }
}