package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyLayEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyLayEggEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyLayEggEntryInfo(String pkField)
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
     * Object:������Ϣ's �ϸ���property 
     */
    public int getQualifiedEggs()
    {
        return getInt("qualifiedEggs");
    }
    public void setQualifiedEggs(int item)
    {
        setInt("qualifiedEggs", item);
    }
    /**
     * Object:������Ϣ's ���ε���property 
     */
    public int getFreakEggs()
    {
        return getInt("freakEggs");
    }
    public void setFreakEggs(int item)
    {
        setInt("freakEggs", item);
    }
    /**
     * Object:������Ϣ's ˫�Ƶ���property 
     */
    public int getDoubleYolkEggs()
    {
        return getInt("doubleYolkEggs");
    }
    public void setDoubleYolkEggs(int item)
    {
        setInt("doubleYolkEggs", item);
    }
    /**
     * Object:������Ϣ's �Ƶ���property 
     */
    public int getBrokenEggs()
    {
        return getInt("brokenEggs");
    }
    public void setBrokenEggs(int item)
    {
        setInt("brokenEggs", item);
    }
    /**
     * Object:������Ϣ's ����property 
     */
    public java.math.BigDecimal getEggWeight()
    {
        return getBigDecimal("eggWeight");
    }
    public void setEggWeight(java.math.BigDecimal item)
    {
        setBigDecimal("eggWeight", item);
    }
    /**
     * Object:������Ϣ's �ܵ���property 
     */
    public int getAllEggs()
    {
        return getInt("allEggs");
    }
    public void setAllEggs(int item)
    {
        setInt("allEggs", item);
    }
    /**
     * Object:������Ϣ's ����property 
     */
    public int getSoftegg()
    {
        return getInt("softegg");
    }
    public void setSoftegg(int item)
    {
        setInt("softegg", item);
    }
    /**
     * Object:������Ϣ's ˫�Ƶ���property 
     */
    public java.math.BigDecimal getDoubleYolklv()
    {
        return getBigDecimal("doubleYolklv");
    }
    public void setDoubleYolklv(java.math.BigDecimal item)
    {
        setBigDecimal("doubleYolklv", item);
    }
    /**
     * Object:������Ϣ's �ϸ���property 
     */
    public java.math.BigDecimal getQualifiedEgglv()
    {
        return getBigDecimal("qualifiedEgglv");
    }
    public void setQualifiedEgglv(java.math.BigDecimal item)
    {
        setBigDecimal("qualifiedEgglv", item);
    }
    /**
     * Object:������Ϣ's ������property 
     */
    public int getPrimieggs()
    {
        return getInt("Primieggs");
    }
    public void setPrimieggs(int item)
    {
        setInt("Primieggs", item);
    }
    /**
     * Object:������Ϣ's С�ϸ�property 
     */
    public int getSqualifiedEgg()
    {
        return getInt("squalifiedEgg");
    }
    public void setSqualifiedEgg(int item)
    {
        setInt("squalifiedEgg", item);
    }
    /**
     * Object:������Ϣ's �൰property 
     */
    public int getDirtyEgg()
    {
        return getInt("DirtyEgg");
    }
    public void setDirtyEgg(int item)
    {
        setInt("DirtyEgg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1A8DB806");
    }
}