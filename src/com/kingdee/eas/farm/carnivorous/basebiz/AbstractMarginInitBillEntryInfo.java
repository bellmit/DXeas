package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginInitBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMarginInitBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMarginInitBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:��¼'s ���ñ�֤��property 
     */
    public java.math.BigDecimal getEnableMargin()
    {
        return getBigDecimal("enableMargin");
    }
    public void setEnableMargin(java.math.BigDecimal item)
    {
        setBigDecimal("enableMargin", item);
    }
    /**
     * Object:��¼'s ռ�ñ�֤��property 
     */
    public java.math.BigDecimal getOccupyMargin()
    {
        return getBigDecimal("occupyMargin");
    }
    public void setOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("occupyMargin", item);
    }
    /**
     * Object:��¼'s ��֤���ܶ�property 
     */
    public java.math.BigDecimal getTotalMargin()
    {
        return getBigDecimal("totalMargin");
    }
    public void setTotalMargin(java.math.BigDecimal item)
    {
        setBigDecimal("totalMargin", item);
    }
    /**
     * Object:��¼'s ��עproperty 
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
     * Object:��¼'s �ѽ���ռ�ñ�֤��property 
     */
    public java.math.BigDecimal getUnLockedOpMargin()
    {
        return getBigDecimal("unLockedOpMargin");
    }
    public void setUnLockedOpMargin(java.math.BigDecimal item)
    {
        setBigDecimal("unLockedOpMargin", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2F8FCC76");
    }
}