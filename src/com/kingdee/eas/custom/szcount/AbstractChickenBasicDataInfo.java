package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenBasicDataInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractChickenBasicDataInfo()
    {
        this("id");
    }
    protected AbstractChickenBasicDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����ձ��������� 's ��˾ property 
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
     * Object:�����ձ���������'s ����ӵ���property 
     */
    public java.math.BigDecimal getChickenCropPrice()
    {
        return getBigDecimal("chickenCropPrice");
    }
    public void setChickenCropPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenCropPrice", item);
    }
    /**
     * Object:�����ձ���������'s ���͵���property 
     */
    public java.math.BigDecimal getChickenMixedOilPrice()
    {
        return getBigDecimal("chickenMixedOilPrice");
    }
    public void setChickenMixedOilPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenMixedOilPrice", item);
    }
    /**
     * Object:�����ձ���������'s ��������property 
     */
    public java.math.BigDecimal getChickenIntestinesPrice()
    {
        return getBigDecimal("chickenIntestinesPrice");
    }
    public void setChickenIntestinesPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenIntestinesPrice", item);
    }
    /**
     * Object:�����ձ���������'s ��ë����property 
     */
    public java.math.BigDecimal getChickenFeatherPrice()
    {
        return getBigDecimal("chickenFeatherPrice");
    }
    public void setChickenFeatherPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenFeatherPrice", item);
    }
    /**
     * Object:�����ձ���������'s ��Ѫ�۸�property 
     */
    public java.math.BigDecimal getChickenBooldPrice()
    {
        return getBigDecimal("chickenBooldPrice");
    }
    public void setChickenBooldPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenBooldPrice", item);
    }
    /**
     * Object:�����ձ���������'s �ַ���property 
     */
    public java.math.BigDecimal getTonPrice()
    {
        return getBigDecimal("tonPrice");
    }
    public void setTonPrice(java.math.BigDecimal item)
    {
        setBigDecimal("tonPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D0049E2E");
    }
}