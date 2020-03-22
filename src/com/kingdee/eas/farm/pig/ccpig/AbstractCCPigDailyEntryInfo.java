package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigDailyEntryInfo(String pkField)
    {
        super(pkField);
        put("FeedDetailEntry", new com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryFeedDetailEntryCollection());
    }
    /**
     * Object: 饲喂分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 饲喂分录 's 饲料 property 
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
     * Object:饲喂分录's 饲料名称property 
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
     * Object:饲喂分录's 理论饲喂量(kg)property 
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
     * Object:饲喂分录's 实际饲喂量(kg)property 
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
     * Object:饲喂分录's 备注property 
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
     * Object: 饲喂分录 's 猪舍 property 
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
     * Object: 饲喂分录 's 饲喂明细 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryFeedDetailEntryCollection getFeedDetailEntry()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryFeedDetailEntryCollection)get("FeedDetailEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F2FE54E7");
    }
}