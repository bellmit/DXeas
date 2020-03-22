package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginBreedPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMarginBreedPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractMarginBreedPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������Ϣ's ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.highSymbol getHighSymbol()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.highSymbol.getEnum(getString("highSymbol"));
    }
    public void setHighSymbol(com.kingdee.eas.farm.carnivorous.basedata.highSymbol item)
    {
		if (item != null) {
        setString("highSymbol", item.getValue());
		}
    }
    /**
     * Object:������Ϣ's ��ֻ��֤������ֵproperty 
     */
    public java.math.BigDecimal getOneProfitValue()
    {
        return getBigDecimal("oneProfitValue");
    }
    public void setOneProfitValue(java.math.BigDecimal item)
    {
        setBigDecimal("oneProfitValue", item);
    }
    /**
     * Object:������Ϣ's ��ֻ��֤������ֵproperty 
     */
    public java.math.BigDecimal getOnePeofitHigh()
    {
        return getBigDecimal("onePeofitHigh");
    }
    public void setOnePeofitHigh(java.math.BigDecimal item)
    {
        setBigDecimal("onePeofitHigh", item);
    }
    /**
     * Object:������Ϣ's ��ȡ��ֻ�������(%)property 
     */
    public java.math.BigDecimal getReturnRate()
    {
        return getBigDecimal("returnRate");
    }
    public void setReturnRate(java.math.BigDecimal item)
    {
        setBigDecimal("returnRate", item);
    }
    /**
     * Object:������Ϣ's ���ޱȽϷ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.LessSymbol getLessValue()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.LessSymbol.getEnum(getString("lessValue"));
    }
    public void setLessValue(com.kingdee.eas.farm.carnivorous.basedata.LessSymbol item)
    {
		if (item != null) {
        setString("lessValue", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C4AB7A3C");
    }
}