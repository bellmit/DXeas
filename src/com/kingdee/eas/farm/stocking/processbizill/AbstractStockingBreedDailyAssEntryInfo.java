package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyAssEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ֳ��Ϣ��¼ 's null property 
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
     * Object:��ֳ��Ϣ��¼'s ��ʳʱ��property 
     */
    public java.math.BigDecimal getBreedTime()
    {
        return getBigDecimal("breedTime");
    }
    public void setBreedTime(java.math.BigDecimal item)
    {
        setBigDecimal("breedTime", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����ʱ����h��property 
     */
    public java.math.BigDecimal getLightingTime()
    {
        return getBigDecimal("lightingTime");
    }
    public void setLightingTime(java.math.BigDecimal item)
    {
        setBigDecimal("lightingTime", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����¶ȣ��棩property 
     */
    public java.math.BigDecimal getTemperatureTo()
    {
        return getBigDecimal("temperatureTo");
    }
    public void setTemperatureTo(java.math.BigDecimal item)
    {
        setBigDecimal("temperatureTo", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����¶ȣ��棩property 
     */
    public java.math.BigDecimal getTemperatureFrom()
    {
        return getBigDecimal("temperatureFrom");
    }
    public void setTemperatureFrom(java.math.BigDecimal item)
    {
        setBigDecimal("temperatureFrom", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ���ʪ�ȣ�%��property 
     */
    public java.math.BigDecimal getHumidityTo()
    {
        return getBigDecimal("humidityTo");
    }
    public void setHumidityTo(java.math.BigDecimal item)
    {
        setBigDecimal("humidityTo", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ���ʪ�ȣ�%��property 
     */
    public java.math.BigDecimal getHumidityFrom()
    {
        return getBigDecimal("humidityFrom");
    }
    public void setHumidityFrom(java.math.BigDecimal item)
    {
        setBigDecimal("humidityFrom", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����������property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ������̭��property 
     */
    public int getCullQty()
    {
        return getInt("cullQty");
    }
    public void setCullQty(int item)
    {
        setInt("cullQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����������property 
     */
    public int getBreekingStock()
    {
        return getInt("breekingStock");
    }
    public void setBreekingStock(int item)
    {
        setInt("breekingStock", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s �Ƿ���ȫ����property 
     */
    public boolean isIsMarketed()
    {
        return getBoolean("isMarketed");
    }
    public void setIsMarketed(boolean item)
    {
        setBoolean("isMarketed", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ����̭��property 
     */
    public java.math.BigDecimal getFemaleCullQty()
    {
        return getBigDecimal("femaleCullQty");
    }
    public void setFemaleCullQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleCullQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ��������property 
     */
    public java.math.BigDecimal getFemaleDeathQty()
    {
        return getBigDecimal("femaleDeathQty");
    }
    public void setFemaleDeathQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleDeathQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ��������property 
     */
    public java.math.BigDecimal getFemaleBreedkingStock()
    {
        return getBigDecimal("femaleBreedkingStock");
    }
    public void setFemaleBreedkingStock(java.math.BigDecimal item)
    {
        setBigDecimal("femaleBreedkingStock", item);
    }
    /**
     * Object: ��ֳ��Ϣ��¼ 's ���� property 
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
     * Object:��ֳ��Ϣ��¼'s ��������property 
     */
    public java.math.BigDecimal getAvgWeight()
    {
        return getBigDecimal("avgWeight");
    }
    public void setAvgWeight(java.math.BigDecimal item)
    {
        setBigDecimal("avgWeight", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ������property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����property 
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
     * Object:��ֳ��Ϣ��¼'s ����property 
     */
    public java.math.BigDecimal getWeekDays()
    {
        return getBigDecimal("weekDays");
    }
    public void setWeekDays(java.math.BigDecimal item)
    {
        setBigDecimal("weekDays", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����������property 
     */
    public int getMarkedQty()
    {
        return getInt("markedQty");
    }
    public void setMarkedQty(int item)
    {
        setInt("markedQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ��������ֵproperty 
     */
    public int getAdjustQty()
    {
        return getInt("adjustQty");
    }
    public void setAdjustQty(int item)
    {
        setInt("adjustQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ������ֵproperty 
     */
    public int getAdjustFemaleQty()
    {
        return getInt("adjustFemaleQty");
    }
    public void setAdjustFemaleQty(int item)
    {
        setInt("adjustFemaleQty", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ��������property 
     */
    public int getFemaleMarketed()
    {
        return getInt("femaleMarketed");
    }
    public void setFemaleMarketed(int item)
    {
        setInt("femaleMarketed", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ��̭������?property 
     */
    public java.math.BigDecimal getCullTotalWgt()
    {
        return getBigDecimal("cullTotalWgt");
    }
    public void setCullTotalWgt(java.math.BigDecimal item)
    {
        setBigDecimal("cullTotalWgt", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ��̭�ܽ��property 
     */
    public java.math.BigDecimal getCullTotalAmt()
    {
        return getBigDecimal("cullTotalAmt");
    }
    public void setCullTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("cullTotalAmt", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ��̭����property 
     */
    public java.math.BigDecimal getCullAvgPrice()
    {
        return getBigDecimal("cullAvgPrice");
    }
    public void setCullAvgPrice(java.math.BigDecimal item)
    {
        setBigDecimal("cullAvgPrice", item);
    }
    /**
     * Object: ��ֳ��Ϣ��¼ 's �ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s �������ȶ�property 
     */
    public java.math.BigDecimal getGjUniformity()
    {
        return getBigDecimal("gjUniformity");
    }
    public void setGjUniformity(java.math.BigDecimal item)
    {
        setBigDecimal("gjUniformity", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ�����ȶ�property 
     */
    public java.math.BigDecimal getMjUniformity()
    {
        return getBigDecimal("mjUniformity");
    }
    public void setMjUniformity(java.math.BigDecimal item)
    {
        setBigDecimal("mjUniformity", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ��עproperty 
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
     * Object:��ֳ��Ϣ��¼'s ĸ��ʧ��(g)property 
     */
    public java.math.BigDecimal getFemaleLossW()
    {
        return getBigDecimal("femaleLossW");
    }
    public void setFemaleLossW(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLossW", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����ʧ��(g)property 
     */
    public java.math.BigDecimal getMaleLossW()
    {
        return getBigDecimal("maleLossW");
    }
    public void setMaleLossW(java.math.BigDecimal item)
    {
        setBigDecimal("maleLossW", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ��ʧ����(%)property 
     */
    public java.math.BigDecimal getFemaleLossRate()
    {
        return getBigDecimal("femaleLossRate");
    }
    public void setFemaleLossRate(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLossRate", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ����ʧ����(%)property 
     */
    public java.math.BigDecimal getMaleLossRate()
    {
        return getBigDecimal("maleLossRate");
    }
    public void setMaleLossRate(java.math.BigDecimal item)
    {
        setBigDecimal("maleLossRate", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ����׼ʧ��(g)property 
     */
    public java.math.BigDecimal getFemaleLossStand()
    {
        return getBigDecimal("femaleLossStand");
    }
    public void setFemaleLossStand(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLossStand", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ������׼ʧ��(g)property 
     */
    public java.math.BigDecimal getMaleLossStand()
    {
        return getBigDecimal("maleLossStand");
    }
    public void setMaleLossStand(java.math.BigDecimal item)
    {
        setBigDecimal("maleLossStand", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ĸ����׼ʧ��(%)property 
     */
    public java.math.BigDecimal getFemaleLosWeiRate()
    {
        return getBigDecimal("femaleLosWeiRate");
    }
    public void setFemaleLosWeiRate(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLosWeiRate", item);
    }
    /**
     * Object:��ֳ��Ϣ��¼'s ������׼ʧ����(%)property 
     */
    public java.math.BigDecimal getMaleLosWeiStand()
    {
        return getBigDecimal("maleLosWeiStand");
    }
    public void setMaleLosWeiStand(java.math.BigDecimal item)
    {
        setBigDecimal("maleLosWeiStand", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1E965BE7");
    }
}