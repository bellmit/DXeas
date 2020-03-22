package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillTempPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillTempPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillTempPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ʱ���� 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��ʱ���� 's ��ʱ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo getTempPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo)get("tempPolicy");
    }
    public void setTempPolicy(com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo item)
    {
        put("tempPolicy", item);
    }
    /**
     * Object:��ʱ����'s �۲�����property 
     */
    public java.math.BigDecimal getKbPrice()
    {
        return getBigDecimal("kbPrice");
    }
    public void setKbPrice(java.math.BigDecimal item)
    {
        setBigDecimal("kbPrice", item);
    }
    /**
     * Object:��ʱ����'s ��������property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MaterialType getMaterialType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.MaterialType.getEnum(getString("materialType"));
    }
    public void setMaterialType(com.kingdee.eas.farm.carnivorous.basedata.MaterialType item)
    {
		if (item != null) {
        setString("materialType", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s ������λproperty 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CalUnit getCalUnit()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.CalUnit.getEnum(getString("calUnit"));
    }
    public void setCalUnit(com.kingdee.eas.farm.carnivorous.basedata.CalUnit item)
    {
		if (item != null) {
        setString("calUnit", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s �۲����property 
     */
    public java.math.BigDecimal getKbAmount()
    {
        return getBigDecimal("kbAmount");
    }
    public void setKbAmount(java.math.BigDecimal item)
    {
        setBigDecimal("kbAmount", item);
    }
    /**
     * Object:��ʱ����'s �������ڹ���property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DateRelate getDateRelate()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.DateRelate.getEnum(getString("dateRelate"));
    }
    public void setDateRelate(com.kingdee.eas.farm.carnivorous.basedata.DateRelate item)
    {
		if (item != null) {
        setString("dateRelate", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s ��ʼ����property 
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
     * Object:��ʱ����'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B3004D75");
    }
}