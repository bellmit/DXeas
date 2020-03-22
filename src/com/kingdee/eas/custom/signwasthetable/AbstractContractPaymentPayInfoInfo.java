package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractContractPaymentPayInfoInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractContractPaymentPayInfoInfo()
    {
        this("id");
    }
    protected AbstractContractPaymentPayInfoInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo getParent1()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:������Ϣ's ���idproperty 
     */
    public String getPayBillId()
    {
        return getString("payBillId");
    }
    public void setPayBillId(String item)
    {
        setString("payBillId", item);
    }
    /**
     * Object:������Ϣ's ������property 
     */
    public java.math.BigDecimal getPayAmount()
    {
        return getBigDecimal("payAmount");
    }
    public void setPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payAmount", item);
    }
    /**
     * Object:������Ϣ's �����λ��property 
     */
    public java.math.BigDecimal getPayAmountLocal()
    {
        return getBigDecimal("payAmountLocal");
    }
    public void setPayAmountLocal(java.math.BigDecimal item)
    {
        setBigDecimal("payAmountLocal", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public java.util.Date getPayDate()
    {
        return getDate("payDate");
    }
    public void setPayDate(java.util.Date item)
    {
        setDate("payDate", item);
    }
    /**
     * Object:������Ϣ's �������뵥idproperty 
     */
    public String getPayReqBillID()
    {
        return getString("payReqBillID");
    }
    public void setPayReqBillID(String item)
    {
        setString("payReqBillID", item);
    }
    /**
     * Object:������Ϣ's ����������property 
     */
    public java.math.BigDecimal getPayReqBillreqAmt()
    {
        return getBigDecimal("payReqBillreqAmt");
    }
    public void setPayReqBillreqAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payReqBillreqAmt", item);
    }
    /**
     * Object:������Ϣ's �׶�property 
     */
    public int getPhaseCoding()
    {
        return getInt("phaseCoding");
    }
    public void setPhaseCoding(int item)
    {
        setInt("phaseCoding", item);
    }
    /**
     * Object:������Ϣ's �׶�idproperty 
     */
    public String getPhaseID()
    {
        return getString("PhaseID");
    }
    public void setPhaseID(String item)
    {
        setString("PhaseID", item);
    }
    /**
     * Object:������Ϣ's δ������property 
     */
    public java.math.BigDecimal getUnOverFlow()
    {
        return getBigDecimal("unOverFlow");
    }
    public void setUnOverFlow(java.math.BigDecimal item)
    {
        setBigDecimal("unOverFlow", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B9C0B5CC");
    }
}