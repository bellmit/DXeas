package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractThirdpartycheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractThirdpartycheckInfo()
    {
        this("id");
    }
    protected AbstractThirdpartycheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.ThirdpartycheckEntryCollection());
        put("Picentrys", new com.kingdee.eas.custom.foodtrac.ThirdpartycheckPicentryCollection());
    }
    /**
     * Object: ������������Ϣ 's ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.ThirdpartycheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ThirdpartycheckEntryCollection)get("entrys");
    }
    /**
     * Object:������������Ϣ's �Ƿ�����ƾ֤property 
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
     * Object: ������������Ϣ 's ���� property 
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
     * Object:������������Ϣ's ��������property 
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
     * Object: ������������Ϣ 's ͼƬ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.ThirdpartycheckPicentryCollection getPicentrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ThirdpartycheckPicentryCollection)get("Picentrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D040E724");
    }
}