package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTempPolicyPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTempPolicyPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractTempPolicyPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������ϸ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������ϸ's �������ڹ���property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DateRelate getPolicyDatR()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.DateRelate.getEnum(getString("policyDatR"));
    }
    public void setPolicyDatR(com.kingdee.eas.farm.carnivorous.basedata.DateRelate item)
    {
		if (item != null) {
        setString("policyDatR", item.getValue());
		}
    }
    /**
     * Object:������ϸ's ����ѡ��property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MaterialType getMatSelect()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.MaterialType.getEnum(getString("matSelect"));
    }
    public void setMatSelect(com.kingdee.eas.farm.carnivorous.basedata.MaterialType item)
    {
		if (item != null) {
        setString("matSelect", item.getValue());
		}
    }
    /**
     * Object:������ϸ's ������λproperty 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CalUnit getUnit()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.CalUnit.getEnum(getString("unit"));
    }
    public void setUnit(com.kingdee.eas.farm.carnivorous.basedata.CalUnit item)
    {
		if (item != null) {
        setString("unit", item.getValue());
		}
    }
    /**
     * Object:������ϸ's ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:������ϸ's ������ʼֵproperty 
     */
    public java.math.BigDecimal getWgtBegin()
    {
        return getBigDecimal("wgtBegin");
    }
    public void setWgtBegin(java.math.BigDecimal item)
    {
        setBigDecimal("wgtBegin", item);
    }
    /**
     * Object:������ϸ's ������ֵֹproperty 
     */
    public java.math.BigDecimal getWgtEnd()
    {
        return getBigDecimal("wgtEnd");
    }
    public void setWgtEnd(java.math.BigDecimal item)
    {
        setBigDecimal("wgtEnd", item);
    }
    /**
     * Object:������ϸ's �۲�����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A36A57F8");
    }
}