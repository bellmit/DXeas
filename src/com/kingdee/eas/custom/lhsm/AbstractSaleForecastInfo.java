package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleForecastInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSaleForecastInfo()
    {
        this("id");
    }
    protected AbstractSaleForecastInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection());
    }
    /**
     * Object: ����Ԥ���� 's ��¼ property 
     */
    public com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection)get("entrys");
    }
    /**
     * Object:����Ԥ����'s �Ƿ�����ƾ֤property 
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
     * Object: ����Ԥ���� 's �����ͻ� property 
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
     * Object:����Ԥ����'s ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:����Ԥ����'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:����Ԥ����'s ��ϵ��property 
     */
    public String getLinkman()
    {
        return getString("linkman");
    }
    public void setLinkman(String item)
    {
        setString("linkman", item);
    }
    /**
     * Object:����Ԥ����'s �绰property 
     */
    public String getLinkmanTel()
    {
        return getString("linkmanTel");
    }
    public void setLinkmanTel(String item)
    {
        setString("linkmanTel", item);
    }
    /**
     * Object:����Ԥ����'s �����ʽproperty 
     */
    public com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum getWayOfTakingDelivery()
    {
        return com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum.getEnum(getString("wayOfTakingDelivery"));
    }
    public void setWayOfTakingDelivery(com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum item)
    {
		if (item != null) {
        setString("wayOfTakingDelivery", item.getValue());
		}
    }
    /**
     * Object:����Ԥ����'s �ͻ���ַproperty 
     */
    public String getSendAddress()
    {
        return getString("sendAddress");
    }
    public void setSendAddress(String item)
    {
        setString("sendAddress", item);
    }
    /**
     * Object: ����Ԥ���� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salePerson");
    }
    public void setSalePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salePerson", item);
    }
    /**
     * Object: ����Ԥ���� 's ������ property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo getSaleGroup()
    {
        return (com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo)get("saleGroup");
    }
    public void setSaleGroup(com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo item)
    {
        put("saleGroup", item);
    }
    /**
     * Object: ����Ԥ���� 's ���ʽ property 
     */
    public com.kingdee.eas.basedata.assistant.PaymentTypeInfo getPayType()
    {
        return (com.kingdee.eas.basedata.assistant.PaymentTypeInfo)get("payType");
    }
    public void setPayType(com.kingdee.eas.basedata.assistant.PaymentTypeInfo item)
    {
        put("payType", item);
    }
    /**
     * Object: ����Ԥ���� 's ��˾ property 
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
     * Object: ����Ԥ���� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.SaleOrgUnitInfo getSaleOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.SaleOrgUnitInfo)get("saleOrgUnit");
    }
    public void setSaleOrgUnit(com.kingdee.eas.basedata.org.SaleOrgUnitInfo item)
    {
        put("saleOrgUnit", item);
    }
    /**
     * Object:����Ԥ����'s �ܼ۸�property 
     */
    public java.math.BigDecimal getTotalAmount()
    {
        return getBigDecimal("totalAmount");
    }
    public void setTotalAmount(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmount", item);
    }
    /**
     * Object:����Ԥ����'s ������property 
     */
    public java.math.BigDecimal getTotalQty()
    {
        return getBigDecimal("totalQty");
    }
    public void setTotalQty(java.math.BigDecimal item)
    {
        setBigDecimal("totalQty", item);
    }
    /**
     * Object:����Ԥ����'s ����״̬property 
     */
    public com.kingdee.eas.custom.lhsm.ForecastEnum getState()
    {
        return com.kingdee.eas.custom.lhsm.ForecastEnum.getEnum(getString("state"));
    }
    public void setState(com.kingdee.eas.custom.lhsm.ForecastEnum item)
    {
		if (item != null) {
        setString("state", item.getValue());
		}
    }
    /**
     * Object:����Ԥ����'s ���ʱ��property 
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
     * Object: ����Ԥ���� 's �����ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getSaleCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("saleCustomer");
    }
    public void setSaleCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("saleCustomer", item);
    }
    /**
     * Object: ����Ԥ���� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FFAFDB4F");
    }
}