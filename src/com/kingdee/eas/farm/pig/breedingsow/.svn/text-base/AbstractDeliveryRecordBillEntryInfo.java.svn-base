package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryRecordBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDeliveryRecordBillEntryInfo()
    {
        this("id");
    }
    protected AbstractDeliveryRecordBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 性状property 
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
     * Object:分录's 性别property 
     */
    public com.kingdee.eas.farm.pig.Sex getSex()
    {
        return com.kingdee.eas.farm.pig.Sex.getEnum(getString("sex"));
    }
    public void setSex(com.kingdee.eas.farm.pig.Sex item)
    {
		if (item != null) {
        setString("sex", item.getValue());
		}
    }
    /**
     * Object:分录's 左乳数property 
     */
    public int getLeftNippleCount()
    {
        return getInt("leftNippleCount");
    }
    public void setLeftNippleCount(int item)
    {
        setInt("leftNippleCount", item);
    }
    /**
     * Object:分录's 右乳数property 
     */
    public int getRightNippleCount()
    {
        return getInt("rightNippleCount");
    }
    public void setRightNippleCount(int item)
    {
        setInt("rightNippleCount", item);
    }
    /**
     * Object:分录's 重量（克）property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object:分录's 状态property 
     */
    public com.kingdee.eas.farm.pig.BabyPigStatus getBabyPigStatus()
    {
        return com.kingdee.eas.farm.pig.BabyPigStatus.getEnum(getString("babyPigStatus"));
    }
    public void setBabyPigStatus(com.kingdee.eas.farm.pig.BabyPigStatus item)
    {
		if (item != null) {
        setString("babyPigStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("349C8985");
    }
}