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
     * Object: ������� 's null property 
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
     * Object: ������� 's ���� property 
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
     * Object:�������'s ����Ƥ��property 
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
     * Object:�������'s ��צצ��property 
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
     * Object:�������'s ������Ѫproperty 
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
     * Object:�������'s ��Ҵ�ʳproperty 
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
     * Object:�������'s ������ȶ�property 
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
     * Object:�������'s ��עproperty 
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
     * Object:�������'s ��Ƥ���property 
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