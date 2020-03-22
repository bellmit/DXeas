package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigDailyOutEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigDailyOutEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigDailyOutEntryInfo(String pkField)
    {
        super(pkField);
        put("OutEarNumberEntrys", new com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryOutEarNumberEntryCollection());
    }
    /**
     * Object: 出栏分录 's null property 
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
     * Object:出栏分录's 头数property 
     */
    public int getQty()
    {
        return getInt("qty");
    }
    public void setQty(int item)
    {
        setInt("qty", item);
    }
    /**
     * Object:出栏分录's 总重（kg）property 
     */
    public String getWeight()
    {
        return getString("weight");
    }
    public void setWeight(String item)
    {
        setString("weight", item);
    }
    /**
     * Object:出栏分录's 均重(kg/头)property 
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
     * Object: 出栏分录 's 出栏耳标明细 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryOutEarNumberEntryCollection getOutEarNumberEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryOutEarNumberEntryCollection)get("OutEarNumberEntrys");
    }
    /**
     * Object: 出栏分录 's 猪舍 property 
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
     * Object:出栏分录's 出栏等级property 
     */
    public com.kingdee.eas.farm.pig.OutPigLevel getOutLevel()
    {
        return com.kingdee.eas.farm.pig.OutPigLevel.getEnum(getString("outLevel"));
    }
    public void setOutLevel(com.kingdee.eas.farm.pig.OutPigLevel item)
    {
		if (item != null) {
        setString("outLevel", item.getValue());
		}
    }
    /**
     * Object:出栏分录's 备注property 
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
     * Object:出栏分录's 总重（kg）property 
     */
    public java.math.BigDecimal getAllWeight()
    {
        return getBigDecimal("allWeight");
    }
    public void setAllWeight(java.math.BigDecimal item)
    {
        setBigDecimal("allWeight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E9742D2F");
    }
}