package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchEggReceivingBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchEggReceivingBillEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchEggReceivingBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��עproperty 
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getEggWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("eggWarehouse");
    }
    public void setEggWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("eggWarehouse", item);
    }
    /**
     * Object: ��¼ 's �ڲ����ݳ� property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getInternalFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("internalFarm");
    }
    public void setInternalFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("internalFarm", item);
    }
    /**
     * Object: ��¼ 's �������� property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getInternalBreedingBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("internalBreedingBatch");
    }
    public void setInternalBreedingBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("internalBreedingBatch", item);
    }
    /**
     * Object: ��¼ 's �ֵ����� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getInternalEggBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("internalEggBatch");
    }
    public void setInternalEggBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("internalEggBatch", item);
    }
    /**
     * Object: ��¼ 's ��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public int getOtherEggQty()
    {
        return getInt("otherEggQty");
    }
    public void setOtherEggQty(int item)
    {
        setInt("otherEggQty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getStockingFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("stockingFarmer");
    }
    public void setStockingFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("stockingFarmer", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getStockingFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("stockingFarm");
    }
    public void setStockingFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("stockingFarm", item);
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getStockingHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("stockingHouse");
    }
    public void setStockingHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("stockingHouse", item);
    }
    /**
     * Object:��¼'s Ʒϵproperty 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGrendType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("grendType"));
    }
    public void setGrendType(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("grendType", item.getValue());
		}
    }
    /**
     * Object:��¼'s �൰property 
     */
    public java.math.BigDecimal getZd()
    {
        return getBigDecimal("zd");
    }
    public void setZd(java.math.BigDecimal item)
    {
        setBigDecimal("zd", item);
    }
    /**
     * Object:��¼'s ��property 
     */
    public java.math.BigDecimal getRd()
    {
        return getBigDecimal("rd");
    }
    public void setRd(java.math.BigDecimal item)
    {
        setBigDecimal("rd", item);
    }
    /**
     * Object:��¼'s С�Ƶ�property 
     */
    public java.math.BigDecimal getXpd()
    {
        return getBigDecimal("xpd");
    }
    public void setXpd(java.math.BigDecimal item)
    {
        setBigDecimal("xpd", item);
    }
    /**
     * Object:��¼'s ��ѡ��property 
     */
    public java.math.BigDecimal getFxd()
    {
        return getBigDecimal("fxd");
    }
    public void setFxd(java.math.BigDecimal item)
    {
        setBigDecimal("fxd", item);
    }
    /**
     * Object:��¼'s ����������property 
     */
    public java.math.BigDecimal getReQty()
    {
        return getBigDecimal("reQty");
    }
    public void setReQty(java.math.BigDecimal item)
    {
        setBigDecimal("reQty", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getCys()
    {
        return getBigDecimal("cys");
    }
    public void setCys(java.math.BigDecimal item)
    {
        setBigDecimal("cys", item);
    }
    /**
     * Object:��¼'s ��ֳ����������property 
     */
    public java.math.BigDecimal getSendQty()
    {
        return getBigDecimal("sendQty");
    }
    public void setSendQty(java.math.BigDecimal item)
    {
        setBigDecimal("sendQty", item);
    }
    /**
     * Object:��¼'s �ϸ�property 
     */
    public java.math.BigDecimal getQuaEggQty()
    {
        return getBigDecimal("quaEggQty");
    }
    public void setQuaEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("quaEggQty", item);
    }
    /**
     * Object:��¼'s ���ϸ�property 
     */
    public java.math.BigDecimal getQuaSmaallEggQty()
    {
        return getBigDecimal("quaSmaallEggQty");
    }
    public void setQuaSmaallEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("quaSmaallEggQty", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getWeakEggQty()
    {
        return getBigDecimal("weakEggQty");
    }
    public void setWeakEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("weakEggQty", item);
    }
    /**
     * Object:��¼'s ���ε�property 
     */
    public java.math.BigDecimal getMutanEggQty()
    {
        return getBigDecimal("mutanEggQty");
    }
    public void setMutanEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("mutanEggQty", item);
    }
    /**
     * Object:��¼'s ˫�Ƶ�property 
     */
    public java.math.BigDecimal getDoubleYolkQty()
    {
        return getBigDecimal("doubleYolkQty");
    }
    public void setDoubleYolkQty(java.math.BigDecimal item)
    {
        setBigDecimal("doubleYolkQty", item);
    }
    /**
     * Object:��¼'s �Ƶ�property 
     */
    public java.math.BigDecimal getBrokenEggQty()
    {
        return getBigDecimal("brokenEggQty");
    }
    public void setBrokenEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("brokenEggQty", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getDz()
    {
        return getBigDecimal("dz");
    }
    public void setDz(java.math.BigDecimal item)
    {
        setBigDecimal("dz", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E31BD2BE");
    }
}