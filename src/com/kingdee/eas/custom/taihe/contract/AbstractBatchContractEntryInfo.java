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
     * Object: 保证金分录 's null property 
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
     * Object: 保证金分录 's 收款单单据号 property 
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
     * Object:保证金分录's 收款单金额property 
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
     * Object:保证金分录's 已使用金额property 
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
     * Object:保证金分录's 本次使用金额property 
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