package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettleBillCompanyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEggSettleBillCompanyInfo()
    {
        this("id");
    }
    protected AbstractEggSettleBillCompanyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryCollection());
    }
    /**
     * Object: �����ѽ��㵥 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryCollection)get("entrys");
    }
    /**
     * Object:�����ѽ��㵥's �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:�����ѽ��㵥's ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: �����ѽ��㵥 's ������֯ property 
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
     * Object:�����ѽ��㵥's ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: �����ѽ��㵥 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:�����ѽ��㵥's ��ʼ������property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object:�����ѽ��㵥's ������property 
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
     * Object:�����ѽ��㵥's ����property 
     */
    public java.math.BigDecimal getCompensateAmount()
    {
        return getBigDecimal("compensateAmount");
    }
    public void setCompensateAmount(java.math.BigDecimal item)
    {
        setBigDecimal("compensateAmount", item);
    }
    /**
     * Object:�����ѽ��㵥's �������property 
     */
    public java.math.BigDecimal getPaymentAmount()
    {
        return getBigDecimal("paymentAmount");
    }
    public void setPaymentAmount(java.math.BigDecimal item)
    {
        setBigDecimal("paymentAmount", item);
    }
    /**
     * Object:�����ѽ��㵥's ʵ�ʽ�����property 
     */
    public java.math.BigDecimal getActualAmount()
    {
        return getBigDecimal("actualAmount");
    }
    public void setActualAmount(java.math.BigDecimal item)
    {
        setBigDecimal("actualAmount", item);
    }
    /**
     * Object:�����ѽ��㵥's �������property 
     */
    public java.math.BigDecimal getOtherAmount()
    {
        return getBigDecimal("otherAmount");
    }
    public void setOtherAmount(java.math.BigDecimal item)
    {
        setBigDecimal("otherAmount", item);
    }
    /**
     * Object:�����ѽ��㵥's ��������(��)property 
     */
    public java.util.Date getHatchBeginDate()
    {
        return getDate("hatchBeginDate");
    }
    public void setHatchBeginDate(java.util.Date item)
    {
        setDate("hatchBeginDate", item);
    }
    /**
     * Object:�����ѽ��㵥's ��������(��)property 
     */
    public java.util.Date getHatchEndDate()
    {
        return getDate("hatchEndDate");
    }
    public void setHatchEndDate(java.util.Date item)
    {
        setDate("hatchEndDate", item);
    }
    /**
     * Object:�����ѽ��㵥's ����Ʒ���property 
     */
    public java.math.BigDecimal getByProductAmount()
    {
        return getBigDecimal("byProductAmount");
    }
    public void setByProductAmount(java.math.BigDecimal item)
    {
        setBigDecimal("byProductAmount", item);
    }
    /**
     * Object: �����ѽ��㵥 's ���㹫˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getDestCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("destCompany");
    }
    public void setDestCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("destCompany", item);
    }
    /**
     * Object:�����ѽ��㵥's �ֵ���Դproperty 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSource()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSource"));
    }
    public void setEggSource(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSource", item.getValue());
		}
    }
    /**
     * Object: �����ѽ��㵥 's ��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("72272190");
    }
}