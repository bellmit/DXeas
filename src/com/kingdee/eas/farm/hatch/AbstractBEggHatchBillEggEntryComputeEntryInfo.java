package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggHatchBillEggEntryComputeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggHatchBillEggEntryComputeEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggHatchBillEggEntryComputeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���� 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:����'s ����property 
     */
    public int getFloorQty()
    {
        return getInt("floorQty");
    }
    public void setFloorQty(int item)
    {
        setInt("floorQty", item);
    }
    /**
     * Object:����'s ����property 
     */
    public int getCarQty()
    {
        return getInt("carQty");
    }
    public void setCarQty(int item)
    {
        setInt("carQty", item);
    }
    /**
     * Object:����'s ����property 
     */
    public int getPlateQty()
    {
        return getInt("plateQty");
    }
    public void setPlateQty(int item)
    {
        setInt("plateQty", item);
    }
    /**
     * Object:����'s ö��property 
     */
    public int getMeiQty()
    {
        return getInt("meiQty");
    }
    public void setMeiQty(int item)
    {
        setInt("meiQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A3C03FBE");
    }
}