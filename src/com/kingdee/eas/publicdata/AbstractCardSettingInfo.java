package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCardSettingInfo()
    {
        this("id");
    }
    protected AbstractCardSettingInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.publicdata.CardSettingEntryCollection());
    }
    /**
     * Object:刷卡基础设置's 本机MAC地址property 
     */
    public String getMac()
    {
        return getString("mac");
    }
    public void setMac(String item)
    {
        setString("mac", item);
    }
    /**
     * Object: 刷卡基础设置 's 库存组织 property 
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
     * Object: 刷卡基础设置 's 详细设置 property 
     */
    public com.kingdee.eas.publicdata.CardSettingEntryCollection getEntry()
    {
        return (com.kingdee.eas.publicdata.CardSettingEntryCollection)get("Entry");
    }
    /**
     * Object:刷卡基础设置's 文本property 
     */
    public String getBIMUDF0021()
    {
        return getString("BIMUDF0021");
    }
    public void setBIMUDF0021(String item)
    {
        setString("BIMUDF0021", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B8BF3D5D");
    }
}