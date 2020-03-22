package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTheEggTableEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTheEggTableEntryInfo()
    {
        this("id");
    }
    protected AbstractTheEggTableEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
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
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: ��¼ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostItem()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costItem");
    }
    public void setCostItem(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costItem", item);
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
    public String getWeekAge()
    {
        return getString("weekAge");
    }
    public void setWeekAge(String item)
    {
        setString("weekAge", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:��¼'s �Ƿ�ת��property 
     */
    public boolean isIsFormal()
    {
        return getBoolean("isFormal");
    }
    public void setIsFormal(boolean item)
    {
        setBoolean("isFormal", item);
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
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getSendAllQty()
    {
        return getBigDecimal("sendAllQty");
    }
    public void setSendAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("sendAllQty", item);
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
     * Object:��¼'s ��Ӧ������property 
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
     * Object:��¼'s ���Ϳ���property 
     */
    public java.math.BigDecimal getSendBasketQty()
    {
        return getBigDecimal("sendBasketQty");
    }
    public void setSendBasketQty(java.math.BigDecimal item)
    {
        setBigDecimal("sendBasketQty", item);
    }
    /**
     * Object:��¼'s ȷ������property 
     */
    public java.math.BigDecimal getConfirmAllQty()
    {
        return getBigDecimal("confirmAllQty");
    }
    public void setConfirmAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("confirmAllQty", item);
    }
    /**
     * Object:��¼'s ȷ�Ͽ���property 
     */
    public java.math.BigDecimal getConfirmBasketQty()
    {
        return getBigDecimal("confirmBasketQty");
    }
    public void setConfirmBasketQty(java.math.BigDecimal item)
    {
        setBigDecimal("confirmBasketQty", item);
    }
    /**
     * Object: ��¼ 's Ƭ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmersTree()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmersTree");
    }
    public void setFarmersTree(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmersTree", item);
    }
    /**
     * Object:��¼'s �Ƿ�ȷ��property 
     */
    public boolean isHasConfirm()
    {
        return getBoolean("hasConfirm");
    }
    public void setHasConfirm(boolean item)
    {
        setBoolean("hasConfirm", item);
    }
    /**
     * Object:��¼'s ȷ��ʱ��property 
     */
    public java.util.Date getConfirmTime()
    {
        return getDate("confirmTime");
    }
    public void setConfirmTime(java.util.Date item)
    {
        setDate("confirmTime", item);
    }
    /**
     * Object:��¼'s �ϸ�property 
     */
    public java.math.BigDecimal getQualified()
    {
        return getBigDecimal("qualified");
    }
    public void setQualified(java.math.BigDecimal item)
    {
        setBigDecimal("qualified", item);
    }
    /**
     * Object:��¼'s С�ϸ�property 
     */
    public java.math.BigDecimal getSqualified()
    {
        return getBigDecimal("Squalified");
    }
    public void setSqualified(java.math.BigDecimal item)
    {
        setBigDecimal("Squalified", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getCcd()
    {
        return getBigDecimal("ccd");
    }
    public void setCcd(java.math.BigDecimal item)
    {
        setBigDecimal("ccd", item);
    }
    /**
     * Object:��¼'s ���ε�property 
     */
    public java.math.BigDecimal getJxd()
    {
        return getBigDecimal("jxd");
    }
    public void setJxd(java.math.BigDecimal item)
    {
        setBigDecimal("jxd", item);
    }
    /**
     * Object:��¼'s ˫�Ƶ�property 
     */
    public java.math.BigDecimal getShd()
    {
        return getBigDecimal("shd");
    }
    public void setShd(java.math.BigDecimal item)
    {
        setBigDecimal("shd", item);
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
     * Object:��¼'s ���Ƶ�property 
     */
    public java.math.BigDecimal getDpd()
    {
        return getBigDecimal("dpd");
    }
    public void setDpd(java.math.BigDecimal item)
    {
        setBigDecimal("dpd", item);
    }
    /**
     * Object:��¼'s С�Ƶ�property 
     */
    public java.math.BigDecimal getPd()
    {
        return getBigDecimal("pd");
    }
    public void setPd(java.math.BigDecimal item)
    {
        setBigDecimal("pd", item);
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
     * Object:��¼'s ��עproperty 
     */
    public String getBz()
    {
        return getString("bz");
    }
    public void setBz(String item)
    {
        setString("bz", item);
    }
    /**
     * Object:��¼'s Ʒϵproperty 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getSerial()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("serial"));
    }
    public void setSerial(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("serial", item.getValue());
		}
    }
    /**
     * Object: ��¼ 's Ʒ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:��¼'s ���ε�property 
     */
    public java.math.BigDecimal getDissharpEgg()
    {
        return getBigDecimal("dissharpEgg");
    }
    public void setDissharpEgg(java.math.BigDecimal item)
    {
        setBigDecimal("dissharpEgg", item);
    }
    /**
     * Object:��¼'s ˫�Ƶ�property 
     */
    public java.math.BigDecimal getDoubleEgg()
    {
        return getBigDecimal("doubleEgg");
    }
    public void setDoubleEgg(java.math.BigDecimal item)
    {
        setBigDecimal("doubleEgg", item);
    }
    /**
     * Object:��¼'s �ϸ�property 
     */
    public java.math.BigDecimal getQualifieds()
    {
        return getBigDecimal("qualifieds");
    }
    public void setQualifieds(java.math.BigDecimal item)
    {
        setBigDecimal("qualifieds", item);
    }
    /**
     * Object:��¼'s ���ε�property 
     */
    public java.math.BigDecimal getJxds()
    {
        return getBigDecimal("jxds");
    }
    public void setJxds(java.math.BigDecimal item)
    {
        setBigDecimal("jxds", item);
    }
    /**
     * Object:��¼'s ˫�Ƶ�property 
     */
    public java.math.BigDecimal getShds()
    {
        return getBigDecimal("shds");
    }
    public void setShds(java.math.BigDecimal item)
    {
        setBigDecimal("shds", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getBzz()
    {
        return getString("bzz");
    }
    public void setBzz(String item)
    {
        setString("bzz", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getBBQty()
    {
        return getBigDecimal("BBQty");
    }
    public void setBBQty(java.math.BigDecimal item)
    {
        setBigDecimal("BBQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F0FE2F9D");
    }
}