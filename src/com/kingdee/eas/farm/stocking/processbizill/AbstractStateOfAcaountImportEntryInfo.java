package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStateOfAcaountImportEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStateOfAcaountImportEntryInfo()
    {
        this("id");
    }
    protected AbstractStateOfAcaountImportEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StateOfAcaountImportInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StateOfAcaountImportInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StateOfAcaountImportInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:��¼'s Ѻ����Ϣproperty 
     */
    public java.math.BigDecimal getDepositInterest()
    {
        return getBigDecimal("depositInterest");
    }
    public void setDepositInterest(java.math.BigDecimal item)
    {
        setBigDecimal("depositInterest", item);
    }
    /**
     * Object:��¼'s Ѻ��property 
     */
    public java.math.BigDecimal getDeposit()
    {
        return getBigDecimal("deposit");
    }
    public void setDeposit(java.math.BigDecimal item)
    {
        setBigDecimal("deposit", item);
    }
    /**
     * Object:��¼'s ռ����Ϣproperty 
     */
    public java.math.BigDecimal getInterestPaid()
    {
        return getBigDecimal("interestPaid");
    }
    public void setInterestPaid(java.math.BigDecimal item)
    {
        setBigDecimal("interestPaid", item);
    }
    /**
     * Object:��¼'s ������Ϣproperty 
     */
    public java.math.BigDecimal getLoanInterest()
    {
        return getBigDecimal("loanInterest");
    }
    public void setLoanInterest(java.math.BigDecimal item)
    {
        setBigDecimal("loanInterest", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getOthers()
    {
        return getBigDecimal("others");
    }
    public void setOthers(java.math.BigDecimal item)
    {
        setBigDecimal("others", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F321F045");
    }
}