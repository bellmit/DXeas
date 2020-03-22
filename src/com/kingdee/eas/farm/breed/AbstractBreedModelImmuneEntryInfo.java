package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedModelImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedModelImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedModelImmuneEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���߼ƻ� 's null property 
     */
    public com.kingdee.eas.farm.breed.BreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedModelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:���߼ƻ�'s ����property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:���߼ƻ�'s ����property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object: ���߼ƻ� 's ���� property 
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
     * Object:���߼ƻ�'s ��ֻ��׼����property 
     */
    public java.math.BigDecimal getPerQty()
    {
        return getBigDecimal("perQty");
    }
    public void setPerQty(java.math.BigDecimal item)
    {
        setBigDecimal("perQty", item);
    }
    /**
     * Object: ���߼ƻ� 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:���߼ƻ�'s �Ƿ����property 
     */
    public boolean isIsMust()
    {
        return getBoolean("isMust");
    }
    public void setIsMust(boolean item)
    {
        setBoolean("isMust", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA590740");
    }
}