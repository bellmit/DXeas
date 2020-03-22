package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyImmuneEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������Ϣ 's ������� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getVaccineMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("vaccineMaterial");
    }
    public void setVaccineMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("vaccineMaterial", item);
    }
    /**
     * Object:������Ϣ's ������property 
     */
    public java.math.BigDecimal getVaccineGetQty()
    {
        return getBigDecimal("vaccineGetQty");
    }
    public void setVaccineGetQty(java.math.BigDecimal item)
    {
        setBigDecimal("vaccineGetQty", item);
    }
    /**
     * Object:������Ϣ's ʹ������property 
     */
    public java.math.BigDecimal getVaccineUsedQty()
    {
        return getBigDecimal("vaccineUsedQty");
    }
    public void setVaccineUsedQty(java.math.BigDecimal item)
    {
        setBigDecimal("vaccineUsedQty", item);
    }
    /**
     * Object:������Ϣ's ��λproperty 
     */
    public String getVaccineUnit()
    {
        return getString("vaccineUnit");
    }
    public void setVaccineUnit(String item)
    {
        setString("vaccineUnit", item);
    }
    /**
     * Object: ������Ϣ 's ���� property 
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
     * Object:������Ϣ's ����property 
     */
    public String getLot()
    {
        return getString("lot");
    }
    public void setLot(String item)
    {
        setString("lot", item);
    }
    /**
     * Object:������Ϣ's ��עproperty 
     */
    public String getDescriptionNew()
    {
        return getString("descriptionNew");
    }
    public void setDescriptionNew(String item)
    {
        setString("descriptionNew", item);
    }
    /**
     * Object:������Ϣ's ����property 
     */
    public String getSupplier()
    {
        return getString("supplier");
    }
    public void setSupplier(String item)
    {
        setString("supplier", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public java.util.Date getManuDate()
    {
        return getDate("manuDate");
    }
    public void setManuDate(java.util.Date item)
    {
        setDate("manuDate", item);
    }
    /**
     * Object:������Ϣ's ��Ч����property 
     */
    public java.util.Date getEffectiveDate()
    {
        return getDate("effectiveDate");
    }
    public void setEffectiveDate(java.util.Date item)
    {
        setDate("effectiveDate", item);
    }
    /**
     * Object: ������Ϣ 's ����;�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo getVaccineWay()
    {
        return (com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo)get("vaccineWay");
    }
    public void setVaccineWay(com.kingdee.eas.farm.stocking.basedata.ImmuneWayInfo item)
    {
        put("vaccineWay", item);
    }
    /**
     * Object:������Ϣ's ������property 
     */
    public String getResponsible()
    {
        return getString("responsible");
    }
    public void setResponsible(String item)
    {
        setString("responsible", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public String getVaccineName()
    {
        return getString("vaccineName");
    }
    public void setVaccineName(String item)
    {
        setString("vaccineName", item);
    }
    /**
     * Object:������Ϣ's ��ֻ����property 
     */
    public java.math.BigDecimal getDose()
    {
        return getBigDecimal("dose");
    }
    public void setDose(java.math.BigDecimal item)
    {
        setBigDecimal("dose", item);
    }
    /**
     * Object:������Ϣ's ����ͺ�property 
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
     * Object:������Ϣ's ������λproperty 
     */
    public String getBaseUnit()
    {
        return getString("baseUnit");
    }
    public void setBaseUnit(String item)
    {
        setString("baseUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4D657479");
    }
}