package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCommecialChilkenDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCommecialChilkenDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractCommecialChilkenDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ���� property 
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
     * Object:��ι��Ϣ��¼'s ��������property 
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
     * Object:��ι��Ϣ��¼'s ��ι������kg��property 
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
     * Object: ��ι��Ϣ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo item)
    {
        put("henhouse", item);
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
     * Object:��ι��Ϣ��¼'s ��������property 
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
     * Object:��ι��Ϣ��¼'s ����property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ƽ��ֻ�أ�g��property 
     */
    public java.math.BigDecimal getAverageWeight()
    {
        return getBigDecimal("averageWeight");
    }
    public void setAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("averageWeight", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ȼú��̯property 
     */
    public java.math.BigDecimal getCoalShare()
    {
        return getBigDecimal("coalShare");
    }
    public void setCoalShare(java.math.BigDecimal item)
    {
        setBigDecimal("coalShare", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ���ͷ�̯property 
     */
    public java.math.BigDecimal getDieselShare()
    {
        return getBigDecimal("dieselShare");
    }
    public void setDieselShare(java.math.BigDecimal item)
    {
        setBigDecimal("dieselShare", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ��׼����ι��(g/ֻ)property 
     */
    public java.math.BigDecimal getStandardFeedQty()
    {
        return getBigDecimal("standardFeedQty");
    }
    public void setStandardFeedQty(java.math.BigDecimal item)
    {
        setBigDecimal("standardFeedQty", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("294A9D89");
    }
}