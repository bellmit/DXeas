package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSlaughterPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSlaughterPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractSlaughterPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.food.SlaughterPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.food.SlaughterPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.SlaughterPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henHouse");
    }
    public void setHenHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henHouse", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public String getHenHouseName()
    {
        return getString("henHouseName");
    }
    public void setHenHouseName(String item)
    {
        setString("henHouseName", item);
    }
    /**
     * Object:��¼'s ��ɱֻ��property 
     */
    public int getSlaughterAmt()
    {
        return getInt("SlaughterAmt");
    }
    public void setSlaughterAmt(int item)
    {
        setInt("SlaughterAmt", item);
    }
    /**
     * Object:��¼'s ��ɱ����property 
     */
    public java.util.Date getPkDate()
    {
        return getDate("pkDate");
    }
    public void setPkDate(java.util.Date item)
    {
        setDate("pkDate", item);
    }
    /**
     * Object:��¼'s ��ɱ����property 
     */
    public int getAgeOfDaysActually()
    {
        return getInt("ageOfDaysActually");
    }
    public void setAgeOfDaysActually(int item)
    {
        setInt("ageOfDaysActually", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getLairageDate()
    {
        return getDate("lairageDate");
    }
    public void setLairageDate(java.util.Date item)
    {
        setDate("lairageDate", item);
    }
    /**
     * Object:��¼'s �Ƿ�����property 
     */
    public boolean isIsLocked()
    {
        return getBoolean("isLocked");
    }
    public void setIsLocked(boolean item)
    {
        setBoolean("isLocked", item);
    }
    /**
     * Object: ��¼ 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5940FAC0");
    }
}