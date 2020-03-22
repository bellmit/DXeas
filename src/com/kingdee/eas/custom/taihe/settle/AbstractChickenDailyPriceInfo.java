package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenDailyPriceInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractChickenDailyPriceInfo()
    {
        this("id");
    }
    protected AbstractChickenDailyPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ë���۸� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:ë���۸�'s ��Ч����property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:ë���۸�'s ʧЧ����property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object:ë���۸�'s �۸�property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:ë���۸�'s �Ӽ�property 
     */
    public java.math.BigDecimal getAddPrice()
    {
        return getBigDecimal("addPrice");
    }
    public void setAddPrice(java.math.BigDecimal item)
    {
        setBigDecimal("addPrice", item);
    }
    /**
     * Object:ë���۸�'s С���۸�property 
     */
    public java.math.BigDecimal getSmallChickPrice()
    {
        return getBigDecimal("smallChickPrice");
    }
    public void setSmallChickPrice(java.math.BigDecimal item)
    {
        setBigDecimal("smallChickPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("96BCA162");
    }
}