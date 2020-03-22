package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggHatchBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggHatchBillEntryInfo()
    {
        this("id");
    }
    protected AbstractEggHatchBillEntryInfo(String pkField)
    {
        super(pkField);
        put("EggEntrys", new com.kingdee.eas.farm.hatch.EggHatchBillEntryEggEntryCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.EggHatchBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.EggHatchBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.EggHatchBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 上孵种蛋明细 property 
     */
    public com.kingdee.eas.farm.hatch.EggHatchBillEntryEggEntryCollection getEggEntrys()
    {
        return (com.kingdee.eas.farm.hatch.EggHatchBillEntryEggEntryCollection)get("EggEntrys");
    }
    /**
     * Object: 分录 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object:分录's 上孵总蛋数property 
     */
    public int getEggAllQty()
    {
        return getInt("eggAllQty");
    }
    public void setEggAllQty(int item)
    {
        setInt("eggAllQty", item);
    }
    /**
     * Object: 分录 's 操作员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9DF59B62");
    }
}