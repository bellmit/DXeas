package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillSaleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillSaleEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillSaleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType getSaleType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType.getEnum(getString("saleType"));
    }
    public void setSaleType(com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType item)
    {
		if (item != null) {
        setString("saleType", item.getValue());
		}
    }
    /**
     * Object: ������Ϣ 's �ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:������Ϣ's �����۸�property 
     */
    public java.math.BigDecimal getOutSalePrice()
    {
        return getBigDecimal("outSalePrice");
    }
    public void setOutSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("outSalePrice", item);
    }
    /**
     * Object:������Ϣ's �������property 
     */
    public java.math.BigDecimal getOutSaleAmt()
    {
        return getBigDecimal("outSaleAmt");
    }
    public void setOutSaleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("outSaleAmt", item);
    }
    /**
     * Object:������Ϣ's ҵ������property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:������Ϣ's ��ǰ��������property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object:������Ϣ's ����״̬property 
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
     * Object:������Ϣ's ���վ���property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    /**
     * Object:������Ϣ's ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("69C9FAB4");
    }
}