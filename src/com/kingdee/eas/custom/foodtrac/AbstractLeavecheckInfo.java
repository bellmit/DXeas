package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLeavecheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLeavecheckInfo()
    {
        this("id");
    }
    protected AbstractLeavecheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.LeavecheckEntryCollection());
        put("Picentrys", new com.kingdee.eas.custom.foodtrac.LeavecheckPicentryCollection());
    }
    /**
     * Object: ����������Ϣ 's ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.LeavecheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.LeavecheckEntryCollection)get("entrys");
    }
    /**
     * Object:����������Ϣ's �Ƿ�����ƾ֤property 
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
     * Object: ����������Ϣ 's ���� property 
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
     * Object:����������Ϣ's ��������property 
     */
    public String getProductdate()
    {
        return getString("productdate");
    }
    public void setProductdate(String item)
    {
        setString("productdate", item);
    }
    /**
     * Object:����������Ϣ's ��������property 
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
     * Object: ����������Ϣ 's ͼƬ��¼ property 
     */
    public com.kingdee.eas.custom.foodtrac.LeavecheckPicentryCollection getPicentrys()
    {
        return (com.kingdee.eas.custom.foodtrac.LeavecheckPicentryCollection)get("Picentrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8DD06F36");
    }
}