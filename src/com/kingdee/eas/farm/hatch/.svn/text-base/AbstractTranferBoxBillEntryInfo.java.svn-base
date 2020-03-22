package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTranferBoxBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTranferBoxBillEntryInfo()
    {
        this("id");
    }
    protected AbstractTranferBoxBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.TranferBoxBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.TranferBoxBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.TranferBoxBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 出雏箱 property 
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
     * Object:分录's 转入数property 
     */
    public int getTransQty()
    {
        return getInt("transQty");
    }
    public void setTransQty(int item)
    {
        setInt("transQty", item);
    }
    /**
     * Object:分录's 备注property 
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
        return new BOSObjectType("63360EFA");
    }
}