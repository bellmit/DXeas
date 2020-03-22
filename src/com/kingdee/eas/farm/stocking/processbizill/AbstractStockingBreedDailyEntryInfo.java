package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ����ͷ property 
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
     * Object: ��ι��Ϣ��¼ 's �����ϱ��� property 
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
     * Object:��ι��Ϣ��¼'s ����������property 
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
     * Object:��ι��Ϣ��¼'s ������ι��property 
     */
    public java.math.BigDecimal getDailyQtyAll()
    {
        return getBigDecimal("dailyQtyAll");
    }
    public void setDailyQtyAll(java.math.BigDecimal item)
    {
        setBigDecimal("dailyQtyAll", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ��ˮ��property 
     */
    public java.math.BigDecimal getWaterQty()
    {
        return getBigDecimal("waterQty");
    }
    public void setWaterQty(java.math.BigDecimal item)
    {
        setBigDecimal("waterQty", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ���Ƿ�ʽproperty 
     */
    public String getLimitFeedType()
    {
        return getString("limitFeedType");
    }
    public void setLimitFeedType(String item)
    {
        setString("limitFeedType", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ���property 
     */
    public String getMaterialModel()
    {
        return getString("materialModel");
    }
    public void setMaterialModel(String item)
    {
        setString("materialModel", item);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ��λ property 
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
     * Object: ��ι��Ϣ��¼ 's ���� property 
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
     * Object:��ι��Ϣ��¼'s ������property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ����property 
     */
    public java.math.BigDecimal getBagQty()
    {
        return getBigDecimal("bagQty");
    }
    public void setBagQty(java.math.BigDecimal item)
    {
        setBigDecimal("bagQty", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ĸ����ι��property 
     */
    public java.math.BigDecimal getFemaleDailyQty()
    {
        return getBigDecimal("femaleDailyQty");
    }
    public void setFemaleDailyQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleDailyQty", item);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ĸ�������� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFeMaterail()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("feMaterail");
    }
    public void setFeMaterail(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("feMaterail", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ��עproperty 
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
     * Object:��ι��Ϣ��¼'s ĸ���ϱ���property 
     */
    public String getMqlbm()
    {
        return getString("mqlbm");
    }
    public void setMqlbm(String item)
    {
        setString("mqlbm", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ƽ��ֻι��property 
     */
    public java.math.BigDecimal getAverageBreed()
    {
        return getBigDecimal("averageBreed");
    }
    public void setAverageBreed(java.math.BigDecimal item)
    {
        setBigDecimal("averageBreed", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ����property 
     */
    public java.math.BigDecimal getPackageQty()
    {
        return getBigDecimal("packageQty");
    }
    public void setPackageQty(java.math.BigDecimal item)
    {
        setBigDecimal("packageQty", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ĸ�ݹ��property 
     */
    public String getFemaleModel()
    {
        return getString("femaleModel");
    }
    public void setFemaleModel(String item)
    {
        setString("femaleModel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B75796BC");
    }
}