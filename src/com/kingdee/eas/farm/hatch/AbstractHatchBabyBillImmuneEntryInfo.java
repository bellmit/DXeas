package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyBillImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchBabyBillImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyBillImmuneEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���߷�¼ 's null property 
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
     * Object: ���߷�¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getImmuneMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("immuneMaterial");
    }
    public void setImmuneMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("immuneMaterial", item);
    }
    /**
     * Object:���߷�¼'s ʹ����property 
     */
    public int getUsedQty()
    {
        return getInt("usedQty");
    }
    public void setUsedQty(int item)
    {
        setInt("usedQty", item);
    }
    /**
     * Object:���߷�¼'s ��עproperty 
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
     * Object:���߷�¼'s ������λproperty 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EB53FB20");
    }
}