package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInStorageBillEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInStorageBillEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractInStorageBillEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����������ϸ 's null property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.weighbridge.InStorageBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: ����������ϸ 's ��Դ�������� property 
     */
    public com.kingdee.eas.basedata.scm.common.BillTypeInfo getBillType()
    {
        return (com.kingdee.eas.basedata.scm.common.BillTypeInfo)get("billType");
    }
    public void setBillType(com.kingdee.eas.basedata.scm.common.BillTypeInfo item)
    {
        put("billType", item);
    }
    /**
     * Object:����������ϸ's ��Դ����IDproperty 
     */
    public String getSourceBillID()
    {
        return getString("sourceBillID");
    }
    public void setSourceBillID(String item)
    {
        setString("sourceBillID", item);
    }
    /**
     * Object:����������ϸ's ��Դ���ݷ�¼IDproperty 
     */
    public String getSourceEntryID()
    {
        return getString("sourceEntryID");
    }
    public void setSourceEntryID(String item)
    {
        setString("sourceEntryID", item);
    }
    /**
     * Object:����������ϸ's ��Դ���ݱ���property 
     */
    public String getSourceBillNum()
    {
        return getString("sourceBillNum");
    }
    public void setSourceBillNum(String item)
    {
        setString("sourceBillNum", item);
    }
    /**
     * Object:����������ϸ's ��Դ���ݷ�¼��property 
     */
    public String getSourceEntrySeq()
    {
        return getString("sourceEntrySeq");
    }
    public void setSourceEntrySeq(String item)
    {
        setString("sourceEntrySeq", item);
    }
    /**
     * Object:����������ϸ's ��Դ��������property 
     */
    public java.math.BigDecimal getSourceEntryQty()
    {
        return getBigDecimal("sourceEntryQty");
    }
    public void setSourceEntryQty(java.math.BigDecimal item)
    {
        setBigDecimal("sourceEntryQty", item);
    }
    /**
     * Object:����������ϸ's ��������property 
     */
    public java.math.BigDecimal getWeighQty()
    {
        return getBigDecimal("weighQty");
    }
    public void setWeighQty(java.math.BigDecimal item)
    {
        setBigDecimal("weighQty", item);
    }
    /**
     * Object:����������ϸ's ��Դ��¼BOSTYPEproperty 
     */
    public String getSourceEntryBosType()
    {
        return getString("sourceEntryBosType");
    }
    public void setSourceEntryBosType(String item)
    {
        setString("sourceEntryBosType", item);
    }
    /**
     * Object:����������ϸ's ��Դ����BOSTYPEproperty 
     */
    public String getSourceBillBosType()
    {
        return getString("sourceBillBosType");
    }
    public void setSourceBillBosType(String item)
    {
        setString("sourceBillBosType", item);
    }
    /**
     * Object:����������ϸ's ����˰����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:����������ϸ's ����˰���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:����������ϸ's ��˰����property 
     */
    public java.math.BigDecimal getTaxPrice()
    {
        return getBigDecimal("taxPrice");
    }
    public void setTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("taxPrice", item);
    }
    /**
     * Object:����������ϸ's ˰��property 
     */
    public java.math.BigDecimal getTaxRate()
    {
        return getBigDecimal("taxRate");
    }
    public void setTaxRate(java.math.BigDecimal item)
    {
        setBigDecimal("taxRate", item);
    }
    /**
     * Object:����������ϸ's ˰��property 
     */
    public java.math.BigDecimal getTaxAmount()
    {
        return getBigDecimal("taxAmount");
    }
    public void setTaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("taxAmount", item);
    }
    /**
     * Object:����������ϸ's ��˰���property 
     */
    public java.math.BigDecimal getAllAmount()
    {
        return getBigDecimal("allAmount");
    }
    public void setAllAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allAmount", item);
    }
    /**
     * Object: ����������ϸ 's Ŀ������֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOrderStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("orderStorageOrg");
    }
    public void setOrderStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("orderStorageOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("974C6F41");
    }
}