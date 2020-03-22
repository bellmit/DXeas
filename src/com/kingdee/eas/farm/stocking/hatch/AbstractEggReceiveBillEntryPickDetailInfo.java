package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggReceiveBillEntryPickDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggReceiveBillEntryPickDetailInfo()
    {
        this("id");
    }
    protected AbstractEggReceiveBillEntryPickDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 挑选明细 's null property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 挑选明细 's 挑选人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPickPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("pickPerson");
    }
    public void setPickPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("pickPerson", item);
    }
    /**
     * Object:挑选明细's 挑选蛋数property 
     */
    public int getQty()
    {
        return getInt("qty");
    }
    public void setQty(int item)
    {
        setInt("qty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7821EB35");
    }
}