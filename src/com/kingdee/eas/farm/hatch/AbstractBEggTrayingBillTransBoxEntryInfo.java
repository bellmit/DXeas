package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggTrayingBillTransBoxEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggTrayingBillTransBoxEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggTrayingBillTransBoxEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 转箱记录 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggTrayingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggTrayingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggTrayingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 转箱记录 's 出雏箱 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxInfo getHatchingBox()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxInfo)get("hatchingBox");
    }
    public void setHatchingBox(com.kingdee.eas.farm.hatch.HatchingBoxInfo item)
    {
        put("hatchingBox", item);
    }
    /**
     * Object:转箱记录's 转入数量property 
     */
    public int getInQty()
    {
        return getInt("inQty");
    }
    public void setInQty(int item)
    {
        setInt("inQty", item);
    }
    /**
     * Object:转箱记录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90DAD84D");
    }
}