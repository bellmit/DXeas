package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountrycheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCountrycheckInfo()
    {
        this("id");
    }
    protected AbstractCountrycheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.CountrycheckEntryCollection());
        put("Picentrys", new com.kingdee.eas.custom.foodtrac.CountrycheckPicentryCollection());
    }
    /**
     * Object: ���Ҽ�����Ϣ 's ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.CountrycheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.CountrycheckEntryCollection)get("entrys");
    }
    /**
     * Object:���Ҽ�����Ϣ's �Ƿ�����ƾ֤property 
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
     * Object: ���Ҽ�����Ϣ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:���Ҽ�����Ϣ's ��������property 
     */
    public String getNewdesc()
    {
        return getString("newdesc");
    }
    public void setNewdesc(String item)
    {
        setString("newdesc", item);
    }
    /**
     * Object: ���Ҽ�����Ϣ 's ͼƬ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.CountrycheckPicentryCollection getPicentrys()
    {
        return (com.kingdee.eas.custom.foodtrac.CountrycheckPicentryCollection)get("Picentrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A7528C77");
    }
}