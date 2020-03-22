package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSeedBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSeedBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSeedBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ���òֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object:��¼'s ȷ������property 
     */
    public java.math.BigDecimal getConfirmQty()
    {
        return getBigDecimal("confirmQty");
    }
    public void setConfirmQty(java.math.BigDecimal item)
    {
        setBigDecimal("confirmQty", item);
    }
    /**
     * Object: ��¼ 's ��������� property 
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
     * Object:��¼'s ����������property 
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
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's �����絥λ property 
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
     * Object:��¼'s ����������property 
     */
    public java.math.BigDecimal getAllReceiveQty()
    {
        return getBigDecimal("allReceiveQty");
    }
    public void setAllReceiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("allReceiveQty", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:��¼'s ����������property 
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
     * Object: ��¼ 's ĸ������� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFematerial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("fematerial");
    }
    public void setFematerial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("fematerial", item);
    }
    /**
     * Object:��¼'s ĸ��������property 
     */
    public String getFematerialName()
    {
        return getString("fematerialName");
    }
    public void setFematerialName(String item)
    {
        setString("fematerialName", item);
    }
    /**
     * Object:��¼'s ĸ������property 
     */
    public String getFemodel()
    {
        return getString("femodel");
    }
    public void setFemodel(String item)
    {
        setString("femodel", item);
    }
    /**
     * Object: ��¼ 's ĸ���絥λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getFeunit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("feunit");
    }
    public void setFeunit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("feunit", item);
    }
    /**
     * Object:��¼'s ĸ��������property 
     */
    public java.math.BigDecimal getFeqty()
    {
        return getBigDecimal("feqty");
    }
    public void setFeqty(java.math.BigDecimal item)
    {
        setBigDecimal("feqty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C0B191F5");
    }
}