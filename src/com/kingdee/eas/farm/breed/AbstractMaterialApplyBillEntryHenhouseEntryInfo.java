package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialApplyBillEntryHenhouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaterialApplyBillEntryHenhouseEntryInfo()
    {
        this("id");
    }
    protected AbstractMaterialApplyBillEntryHenhouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������ϸ 's null property 
     */
    public com.kingdee.eas.farm.breed.MaterialApplyBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.breed.MaterialApplyBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.breed.MaterialApplyBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: ������ϸ 's ʹ�ü��� property 
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
     * Object:������ϸ's Ԥ�ƿ�ʼ����property 
     */
    public int getBeginDays()
    {
        return getInt("beginDays");
    }
    public void setBeginDays(int item)
    {
        setInt("beginDays", item);
    }
    /**
     * Object:������ϸ's Ԥ��ͣҩ����property 
     */
    public int getEndDays()
    {
        return getInt("endDays");
    }
    public void setEndDays(int item)
    {
        setInt("endDays", item);
    }
    /**
     * Object:������ϸ's ��ȫ��ɱ����property 
     */
    public int getSafeDays()
    {
        return getInt("safeDays");
    }
    public void setSafeDays(int item)
    {
        setInt("safeDays", item);
    }
    /**
     * Object:������ϸ's ��ȫ��ɱ����property 
     */
    public java.util.Date getSafeDate()
    {
        return getDate("safeDate");
    }
    public void setSafeDate(java.util.Date item)
    {
        setDate("safeDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8F6E77E5");
    }
}