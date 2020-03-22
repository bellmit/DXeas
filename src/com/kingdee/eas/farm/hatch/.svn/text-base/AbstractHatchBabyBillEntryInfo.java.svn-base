package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchBabyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchBabyBillInfo item)
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
     * Object:分录's 转箱量property 
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
    /**
     * Object:分录's 健雏property 
     */
    public int getHealthQty()
    {
        return getInt("healthQty");
    }
    public void setHealthQty(int item)
    {
        setInt("healthQty", item);
    }
    /**
     * Object:分录's 残死雏property 
     */
    public int getDealthQty()
    {
        return getInt("dealthQty");
    }
    public void setDealthQty(int item)
    {
        setInt("dealthQty", item);
    }
    /**
     * Object:分录's 损耗property 
     */
    public int getLossQty()
    {
        return getInt("lossQty");
    }
    public void setLossQty(int item)
    {
        setInt("lossQty", item);
    }
    /**
     * Object:分录's 毛蛋property 
     */
    public int getUnhatchedEgg()
    {
        return getInt("unhatchedEgg");
    }
    public void setUnhatchedEgg(int item)
    {
        setInt("unhatchedEgg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("71BDE6A3");
    }
}