package com.kingdee.eas.farm.feemanager.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportationrecordEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTransportationrecordEntryInfo()
    {
        this("id");
    }
    protected AbstractTransportationrecordEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: �����¼ 's ���۶������ property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleOrderInfo getSalesid()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleOrderInfo)get("salesid");
    }
    public void setSalesid(com.kingdee.eas.scm.sd.sale.SaleOrderInfo item)
    {
        put("salesid", item);
    }
    /**
     * Object: �����¼ 's ���۳��ⵥ�� property 
     */
    public com.kingdee.eas.scm.im.inv.SaleIssueBillInfo getStockout()
    {
        return (com.kingdee.eas.scm.im.inv.SaleIssueBillInfo)get("stockout");
    }
    public void setStockout(com.kingdee.eas.scm.im.inv.SaleIssueBillInfo item)
    {
        put("stockout", item);
    }
    /**
     * Object:�����¼'s �ͻ���ַproperty 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:�����¼'s ����property 
     */
    public java.math.BigDecimal getMaterrelnumber()
    {
        return getBigDecimal("materrelnumber");
    }
    public void setMaterrelnumber(java.math.BigDecimal item)
    {
        setBigDecimal("materrelnumber", item);
    }
    /**
     * Object: �����¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMateriel()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materiel");
    }
    public void setMateriel(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materiel", item);
    }
    /**
     * Object:�����¼'s ·��property 
     */
    public java.math.BigDecimal getLossnumber()
    {
        return getBigDecimal("lossnumber");
    }
    public void setLossnumber(java.math.BigDecimal item)
    {
        setBigDecimal("lossnumber", item);
    }
    /**
     * Object:�����¼'s ������property 
     */
    public java.math.BigDecimal getRealnumber()
    {
        return getBigDecimal("realnumber");
    }
    public void setRealnumber(java.math.BigDecimal item)
    {
        setBigDecimal("realnumber", item);
    }
    /**
     * Object:�����¼'s ������property 
     */
    public java.math.BigDecimal getReplenishnumber()
    {
        return getBigDecimal("replenishnumber");
    }
    public void setReplenishnumber(java.math.BigDecimal item)
    {
        setBigDecimal("replenishnumber", item);
    }
    /**
     * Object: �����¼ 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalesman()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salesman");
    }
    public void setSalesman(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salesman", item);
    }
    /**
     * Object: �����¼ 's �ͻ����� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FFF843CF");
    }
}