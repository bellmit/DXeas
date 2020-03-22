package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProcesstechInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProcesstechInfo()
    {
        this("id");
    }
    protected AbstractProcesstechInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.ProcesstechEntryCollection());
        put("Picentrys", new com.kingdee.eas.custom.foodtrac.ProcesstechPicentryCollection());
    }
    /**
     * Object: 加工工艺 's 分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.ProcesstechEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ProcesstechEntryCollection)get("entrys");
    }
    /**
     * Object:加工工艺's 是否生成凭证property 
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
     * Object: 加工工艺 's 物料 property 
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
     * Object:加工工艺's 描述property 
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
     * Object: 加工工艺 's 图片分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.ProcesstechPicentryCollection getPicentrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ProcesstechPicentryCollection)get("Picentrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("698223A0");
    }
}