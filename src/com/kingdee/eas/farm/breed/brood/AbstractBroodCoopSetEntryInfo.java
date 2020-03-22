package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodCoopSetEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodCoopSetEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodCoopSetEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ι���� property 
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
     * Object:��¼'s ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:��¼'s Ĭ����Ͷ������KG��property 
     */
    public java.math.BigDecimal getDefaultQuantity()
    {
        return getBigDecimal("defaultQuantity");
    }
    public void setDefaultQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("defaultQuantity", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("58873B5D");
    }
}