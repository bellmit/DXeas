package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchContractEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchContractEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��֤���¼ 's null property 
     */
    public com.kingdee.eas.custom.taihe.contract.BatchContractInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.contract.BatchContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.contract.BatchContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��֤���¼ 's �տ���ݺ� property 
     */
    public com.kingdee.eas.ma.crbg.ReceiveBillInfo getReceiveBill()
    {
        return (com.kingdee.eas.ma.crbg.ReceiveBillInfo)get("receiveBill");
    }
    public void setReceiveBill(com.kingdee.eas.ma.crbg.ReceiveBillInfo item)
    {
        put("receiveBill", item);
    }
    /**
     * Object:��֤���¼'s �տ���property 
     */
    public java.math.BigDecimal getReceiveBillAmt()
    {
        return getBigDecimal("receiveBillAmt");
    }
    public void setReceiveBillAmt(java.math.BigDecimal item)
    {
        setBigDecimal("receiveBillAmt", item);
    }
    /**
     * Object:��֤���¼'s ��ʹ�ý��property 
     */
    public java.math.BigDecimal getUsedAmt()
    {
        return getBigDecimal("usedAmt");
    }
    public void setUsedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("usedAmt", item);
    }
    /**
     * Object:��֤���¼'s ����ʹ�ý��property 
     */
    public java.math.BigDecimal getCurrentAmt()
    {
        return getBigDecimal("currentAmt");
    }
    public void setCurrentAmt(java.math.BigDecimal item)
    {
        setBigDecimal("currentAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B172182");
    }
}