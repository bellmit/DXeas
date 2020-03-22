package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmPostStandInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmPostStandInfo()
    {
        this("id");
    }
    protected AbstractFarmPostStandInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.farm.FarmPostStandEntryCollection());
    }
    /**
     * Object: ��������λ��׼ 's ��λ��¼ property 
     */
    public com.kingdee.eas.custom.wages.farm.FarmPostStandEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.farm.FarmPostStandEntryCollection)get("Entry");
    }
    /**
     * Object:��������λ��׼'s ����״̬property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBaseStatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("BaseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("BaseStatus", item.getValue());
		}
    }
    /**
     * Object:��������λ��׼'s ��λ����property 
     */
    public String getPostname()
    {
        return getString("postname");
    }
    public void setPostname(String item)
    {
        setString("postname", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("64902796");
    }
}