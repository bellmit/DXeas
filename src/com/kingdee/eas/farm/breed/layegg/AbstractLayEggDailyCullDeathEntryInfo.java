package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyCullDeathEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyCullDeathEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyCullDeathEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������Ϣ's ĸ��������property 
     */
    public int getHenDeath()
    {
        return getInt("henDeath");
    }
    public void setHenDeath(int item)
    {
        setInt("henDeath", item);
    }
    /**
     * Object:������Ϣ's ĸ����̭��property 
     */
    public int getHenCull()
    {
        return getInt("henCull");
    }
    public void setHenCull(int item)
    {
        setInt("henCull", item);
    }
    /**
     * Object:������Ϣ's ����������property 
     */
    public int getCockDeath()
    {
        return getInt("cockDeath");
    }
    public void setCockDeath(int item)
    {
        setInt("cockDeath", item);
    }
    /**
     * Object:������Ϣ's ������̭��property 
     */
    public int getCockCull()
    {
        return getInt("cockCull");
    }
    public void setCockCull(int item)
    {
        setInt("cockCull", item);
    }
    /**
     * Object:������Ϣ's ������̭������property 
     */
    public int getCockBatchCull()
    {
        return getInt("cockBatchCull");
    }
    public void setCockBatchCull(int item)
    {
        setInt("cockBatchCull", item);
    }
    /**
     * Object: ������Ϣ 's ���� property 
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
     * Object:������Ϣ's ��������property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:������Ϣ's ������̭ĸ����property 
     */
    public int getHenBatchCull()
    {
        return getInt("henBatchCull");
    }
    public void setHenBatchCull(int item)
    {
        setInt("henBatchCull", item);
    }
    /**
     * Object:������Ϣ's ĸ�ݴ�����property 
     */
    public int getHenhouseBreekingStock()
    {
        return getInt("henhouseBreekingStock");
    }
    public void setHenhouseBreekingStock(int item)
    {
        setInt("henhouseBreekingStock", item);
    }
    /**
     * Object:������Ϣ's ���ݴ�����property 
     */
    public int getCockBreekingStock()
    {
        return getInt("cockBreekingStock");
    }
    public void setCockBreekingStock(int item)
    {
        setInt("cockBreekingStock", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("02B7B27B");
    }
}