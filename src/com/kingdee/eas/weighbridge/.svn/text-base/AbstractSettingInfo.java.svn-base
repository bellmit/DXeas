package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettingInfo()
    {
        this("id");
    }
    protected AbstractSettingInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.weighbridge.SettingEntryCollection());
    }
    /**
     * Object:设置's 本机MAC地址property 
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
     * Object: 设置 's 司磅员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getWeighman()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("weighman");
    }
    public void setWeighman(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("weighman", item);
    }
    /**
     * Object: 设置 's 磅秤 property 
     */
    public com.kingdee.eas.weighbridge.WeighBridgeInfo getWeighbridge()
    {
        return (com.kingdee.eas.weighbridge.WeighBridgeInfo)get("weighbridge");
    }
    public void setWeighbridge(com.kingdee.eas.weighbridge.WeighBridgeInfo item)
    {
        put("weighbridge", item);
    }
    /**
     * Object: 设置 's 库存组织 property 
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
     * Object: 设置 's 详细参数设置 property 
     */
    public com.kingdee.eas.weighbridge.SettingEntryCollection getEntrys()
    {
        return (com.kingdee.eas.weighbridge.SettingEntryCollection)get("Entrys");
    }
    /**
     * Object:设置's 端口property 
     */
    public com.kingdee.eas.weighbridge.PortNum getPort()
    {
        return com.kingdee.eas.weighbridge.PortNum.getEnum(getString("port"));
    }
    public void setPort(com.kingdee.eas.weighbridge.PortNum item)
    {
		if (item != null) {
        setString("port", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("64B9EA15");
    }
}