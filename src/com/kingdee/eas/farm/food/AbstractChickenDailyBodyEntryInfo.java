package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenDailyBodyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenDailyBodyEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenDailyBodyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 鸡体情况 's null property 
     */
    public com.kingdee.eas.farm.food.ChickenDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.food.ChickenDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.ChickenDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 鸡体情况 's 鸡舍 property 
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
     * Object:鸡体情况's 鸡体皮炎property 
     */
    public java.math.BigDecimal getDermatitis()
    {
        return getBigDecimal("dermatitis");
    }
    public void setDermatitis(java.math.BigDecimal item)
    {
        setBigDecimal("dermatitis", item);
    }
    /**
     * Object:鸡体情况's 鸡爪爪垫property 
     */
    public java.math.BigDecimal getChickenclaw()
    {
        return getBigDecimal("chickenclaw");
    }
    public void setChickenclaw(java.math.BigDecimal item)
    {
        setBigDecimal("chickenclaw", item);
    }
    /**
     * Object:鸡体情况's 鸡翅瘀血property 
     */
    public java.math.BigDecimal getSwingBlood()
    {
        return getBigDecimal("swingBlood");
    }
    public void setSwingBlood(java.math.BigDecimal item)
    {
        setBigDecimal("swingBlood", item);
    }
    /**
     * Object:鸡体情况's 嗉囊带食property 
     */
    public java.math.BigDecimal getGizzardsFood()
    {
        return getBigDecimal("gizzardsFood");
    }
    public void setGizzardsFood(java.math.BigDecimal item)
    {
        setBigDecimal("gizzardsFood", item);
    }
    /**
     * Object:鸡体情况's 鸡体均匀度property 
     */
    public java.math.BigDecimal getChickenUniform()
    {
        return getBigDecimal("chickenUniform");
    }
    public void setChickenUniform(java.math.BigDecimal item)
    {
        setBigDecimal("chickenUniform", item);
    }
    /**
     * Object:鸡体情况's 备注property 
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
     * Object:鸡体情况's 胗皮情况property 
     */
    public java.math.BigDecimal getGizzardCondition()
    {
        return getBigDecimal("gizzardCondition");
    }
    public void setGizzardCondition(java.math.BigDecimal item)
    {
        setBigDecimal("gizzardCondition", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7DB00C82");
    }
}