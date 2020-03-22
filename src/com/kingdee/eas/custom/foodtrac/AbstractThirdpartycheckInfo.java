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
     * Object: 第三方检验信息 's 分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.ThirdpartycheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ThirdpartycheckEntryCollection)get("entrys");
    }
    /**
     * Object:第三方检验信息's 是否生成凭证property 
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
     * Object: 第三方检验信息 's 物料 property 
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
     * Object:第三方检验信息's 报告描述property 
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
     * Object: 第三方检验信息 's 图片分录 property 
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