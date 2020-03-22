package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChangepackingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChangepackingEntryInfo()
    {
        this("id");
    }
    protected AbstractChangepackingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��Ʒ��ϸ 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.ChangepackingInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.baseset.ChangepackingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.baseset.ChangepackingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��Ʒ��ϸ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNum");
    }
    public void setMaterialNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNum", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��������property 
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
     * Object:��Ʒ��ϸ's ���property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:��Ʒ��ϸ's ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��1����property 
     */
    public String getPackMaterialName()
    {
        return getString("packMaterialName");
    }
    public void setPackMaterialName(String item)
    {
        setString("packMaterialName", item);
    }
    /**
     * Object: ��Ʒ��ϸ 's ��װ��1���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getPackMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("packMaterial");
    }
    public void setPackMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("packMaterial", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��1���property 
     */
    public String getPackMaterialMod()
    {
        return getString("packMaterialMod");
    }
    public void setPackMaterialMod(String item)
    {
        setString("packMaterialMod", item);
    }
    /**
     * Object: ��Ʒ��ϸ 's ��װ��2���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getPackMtwo()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("packMtwo");
    }
    public void setPackMtwo(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("packMtwo", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��2����property 
     */
    public String getPackMtwoName()
    {
        return getString("packMtwoName");
    }
    public void setPackMtwoName(String item)
    {
        setString("packMtwoName", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��2���property 
     */
    public String getPackMtwomod()
    {
        return getString("packMtwomod");
    }
    public void setPackMtwomod(String item)
    {
        setString("packMtwomod", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��1����property 
     */
    public java.math.BigDecimal getPackM1Qty()
    {
        return getBigDecimal("packM1Qty");
    }
    public void setPackM1Qty(java.math.BigDecimal item)
    {
        setBigDecimal("packM1Qty", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��װ��2����property 
     */
    public java.math.BigDecimal getPackM2Qty()
    {
        return getBigDecimal("packM2Qty");
    }
    public void setPackM2Qty(java.math.BigDecimal item)
    {
        setBigDecimal("packM2Qty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4658FDC5");
    }
}