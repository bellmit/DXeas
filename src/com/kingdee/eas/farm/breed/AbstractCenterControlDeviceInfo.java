package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCenterControlDeviceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCenterControlDeviceInfo()
    {
        this("id");
    }
    protected AbstractCenterControlDeviceInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.breed.CenterControlDeviceEntryCollection());
    }
    /**
     * Object: �п��豸 's ��� property 
     */
    public com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �п��豸 's ��֯ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("orgUnit");
    }
    public void setOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("orgUnit", item);
    }
    /**
     * Object: �п��豸 's �����ն˻���Ӧ��ϵ property 
     */
    public com.kingdee.eas.farm.breed.CenterControlDeviceEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.CenterControlDeviceEntryCollection)get("Entrys");
    }
    /**
     * Object: �п��豸 's ���ݿ����� property 
     */
    public com.kingdee.eas.publicdata.DatabaseSettingInfo getDbCon()
    {
        return (com.kingdee.eas.publicdata.DatabaseSettingInfo)get("dbCon");
    }
    public void setDbCon(com.kingdee.eas.publicdata.DatabaseSettingInfo item)
    {
        put("dbCon", item);
    }
    /**
     * Object:�п��豸's �Ƿ�����property 
     */
    public boolean isIsEnabled()
    {
        return getBoolean("isEnabled");
    }
    public void setIsEnabled(boolean item)
    {
        setBoolean("isEnabled", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("00E5D024");
    }
}