package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTablePayReqInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSignWasTheTablePayReqInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTablePayReqInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's null property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public String getPayCondition()
    {
        return getString("payCondition");
    }
    public void setPayCondition(String item)
    {
        setString("payCondition", item);
    }
    /**
     * Object:��������'s δ���븶����property 
     */
    public java.math.BigDecimal getUnreqPayAmt()
    {
        return getBigDecimal("unreqPayAmt");
    }
    public void setUnreqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unreqPayAmt", item);
    }
    /**
     * Object:��������'s �����븶����property 
     */
    public java.math.BigDecimal getReqPayAmt()
    {
        return getBigDecimal("reqPayAmt");
    }
    public void setReqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("reqPayAmt", item);
    }
    /**
     * Object:��������'s �Ѹ�����property 
     */
    public java.math.BigDecimal getPayedAmt()
    {
        return getBigDecimal("payedAmt");
    }
    public void setPayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payedAmt", item);
    }
    /**
     * Object:��������'s δ������property 
     */
    public java.math.BigDecimal getUnpayedAmt()
    {
        return getBigDecimal("unpayedAmt");
    }
    public void setUnpayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unpayedAmt", item);
    }
    /**
     * Object:��������'s ��עproperty 
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
     * Object:��������'s �������property 
     */
    public java.math.BigDecimal getPayRate()
    {
        return getBigDecimal("payRate");
    }
    public void setPayRate(java.math.BigDecimal item)
    {
        setBigDecimal("payRate", item);
    }
    /**
     * Object:��������'s ������property 
     */
    public java.math.BigDecimal getPayAmt()
    {
        return getBigDecimal("payAmt");
    }
    public void setPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E1B1955");
    }
}