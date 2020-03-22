package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyEntryInfo(String pkField)
    {
        super(pkField);
        put("FeedDetailEntry", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryFeedDetailEntryCollection());
    }
    /**
     * Object: ��ι��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��ι��¼ 's ���� property 
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
     * Object:��ι��¼'s ��������property 
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
     * Object:��ι��¼'s ������ι��(kg)property 
     */
    public java.math.BigDecimal getStandardQty()
    {
        return getBigDecimal("standardQty");
    }
    public void setStandardQty(java.math.BigDecimal item)
    {
        setBigDecimal("standardQty", item);
    }
    /**
     * Object:��ι��¼'s ʵ����ι��(kg)property 
     */
    public java.math.BigDecimal getActualQty()
    {
        return getBigDecimal("actualQty");
    }
    public void setActualQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualQty", item);
    }
    /**
     * Object:��ι��¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: ��ι��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    /**
     * Object: ��ι��¼ 's ��ι��ϸ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryFeedDetailEntryCollection getFeedDetailEntry()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryFeedDetailEntryCollection)get("FeedDetailEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("20C93673");
    }
}