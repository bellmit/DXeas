package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTablePayStatuInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSignWasTheTablePayStatuInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTablePayStatuInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����ִ����� 's null property 
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
     * Object:����ִ�����'s ������property 
     */
    public java.math.BigDecimal getPayAmt()
    {
        return getBigDecimal("payAmt");
    }
    public void setPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payAmt", item);
    }
    /**
     * Object:����ִ�����'s �����븶����property 
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
     * Object:����ִ�����'s �Ѹ�����property 
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
     * Object:����ִ�����'s δ���븶����property 
     */
    public java.math.BigDecimal getUnReqPayAmt()
    {
        return getBigDecimal("unReqPayAmt");
    }
    public void setUnReqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unReqPayAmt", item);
    }
    /**
     * Object:����ִ�����'s δ������property 
     */
    public java.math.BigDecimal getUnPayedAmt()
    {
        return getBigDecimal("unPayedAmt");
    }
    public void setUnPayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unPayedAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23CED398");
    }
}