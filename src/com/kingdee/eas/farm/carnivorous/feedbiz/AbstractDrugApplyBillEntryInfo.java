package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDrugApplyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDrugApplyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractDrugApplyBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ����property 
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
     * Object:��¼'s ����property 
     */
    public int getDay()
    {
        return getInt("day");
    }
    public void setDay(int item)
    {
        setInt("day", item);
    }
    /**
     * Object: ��¼ 's ҩƷ���� property 
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
     * Object:��¼'s ҩƷ����property 
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
     * Object:��¼'s ������λproperty 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getApplyQty()
    {
        return getBigDecimal("applyQty");
    }
    public void setApplyQty(java.math.BigDecimal item)
    {
        setBigDecimal("applyQty", item);
    }
    /**
     * Object: ��¼ 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOutSto()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("outSto");
    }
    public void setOutSto(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("outSto", item);
    }
    /**
     * Object: ��¼ 's �����ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getOutWare()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("outWare");
    }
    public void setOutWare(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("outWare", item);
    }
    /**
     * Object: ��¼ 's ����ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getInWare()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("inWare");
    }
    public void setInWare(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("inWare", item);
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:��¼'s ҩƷ����property 
     */
    public String getDrugStockBatch()
    {
        return getString("drugStockBatch");
    }
    public void setDrugStockBatch(String item)
    {
        setString("drugStockBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D53D601");
    }
}