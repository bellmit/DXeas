package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedContractFeedEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractConFeedContractFeedEntryInfo()
    {
        this("id");
    }
    protected AbstractConFeedContractFeedEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: �������� 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: �������� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo getConFeedPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo)get("conFeedPolicy");
    }
    public void setConFeedPolicy(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo item)
    {
        put("conFeedPolicy", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public java.math.BigDecimal getSubsidyPrice()
    {
        return getBigDecimal("subsidyPrice");
    }
    public void setSubsidyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("subsidyPrice", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public int getBatchQty()
    {
        return getInt("batchQty");
    }
    public void setBatchQty(int item)
    {
        setInt("batchQty", item);
    }
    /**
     * Object:��������'s ��������property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:��������'s �������property 
     */
    public java.math.BigDecimal getSubsidyAmount()
    {
        return getBigDecimal("subsidyAmount");
    }
    public void setSubsidyAmount(java.math.BigDecimal item)
    {
        setBigDecimal("subsidyAmount", item);
    }
    /**
     * Object:��������'s ����״̬property 
     */
    public String getSettleStatus()
    {
        return getString("settleStatus");
    }
    public void setSettleStatus(String item)
    {
        setString("settleStatus", item);
    }
    /**
     * Object:��������'s ��ͬ������property 
     */
    public java.math.BigDecimal getInContractWgt()
    {
        return getBigDecimal("inContractWgt");
    }
    public void setInContractWgt(java.math.BigDecimal item)
    {
        setBigDecimal("inContractWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("675E0486");
    }
}