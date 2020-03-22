package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasePriceAdjustPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBasePriceAdjustPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractBasePriceAdjustPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��Ŀ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��Ŀ's ����(��)�Ƚ�ֵproperty 
     */
    public java.math.BigDecimal getWeightCompareValue()
    {
        return getBigDecimal("weightCompareValue");
    }
    public void setWeightCompareValue(java.math.BigDecimal item)
    {
        setBigDecimal("weightCompareValue", item);
    }
    /**
     * Object:��Ŀ's ���ز���ϵ��property 
     */
    public java.math.BigDecimal getWeightDiffCoe()
    {
        return getBigDecimal("weightDiffCoe");
    }
    public void setWeightDiffCoe(java.math.BigDecimal item)
    {
        setBigDecimal("weightDiffCoe", item);
    }
    /**
     * Object:��Ŀ's �������ռ۸��µ�����(Ԫ/��)property 
     */
    public java.math.BigDecimal getBasePriceReduceRadio()
    {
        return getBigDecimal("basePriceReduceRadio");
    }
    public void setBasePriceReduceRadio(java.math.BigDecimal item)
    {
        setBigDecimal("basePriceReduceRadio", item);
    }
    /**
     * Object:��Ŀ's �Ƿ��г�ë���۸����property 
     */
    public boolean isIsMarketPrice()
    {
        return getBoolean("isMarketPrice");
    }
    public void setIsMarketPrice(boolean item)
    {
        setBoolean("isMarketPrice", item);
    }
    /**
     * Object:��Ŀ's ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getHighCompare()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("highCompare"));
    }
    public void setHighCompare(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("highCompare", item.getValue());
		}
    }
    /**
     * Object:��Ŀ's ë������(��)����ֵproperty 
     */
    public java.math.BigDecimal getChicHighValue()
    {
        return getBigDecimal("chicHighValue");
    }
    public void setChicHighValue(java.math.BigDecimal item)
    {
        setBigDecimal("chicHighValue", item);
    }
    /**
     * Object:��Ŀ's ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getLessCompareValue()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("lessCompareValue"));
    }
    public void setLessCompareValue(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("lessCompareValue", item.getValue());
		}
    }
    /**
     * Object:��Ŀ's ë������(��)����ֵproperty 
     */
    public java.math.BigDecimal getChicLessValue()
    {
        return getBigDecimal("chicLessValue");
    }
    public void setChicLessValue(java.math.BigDecimal item)
    {
        setBigDecimal("chicLessValue", item);
    }
    /**
     * Object:��Ŀ's �г�ë���۸����µ�(Ԫ)property 
     */
    public java.math.BigDecimal getBeginDown()
    {
        return getBigDecimal("beginDown");
    }
    public void setBeginDown(java.math.BigDecimal item)
    {
        setBigDecimal("beginDown", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BF2385B");
    }
}