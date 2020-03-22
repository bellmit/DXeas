package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurFrightInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPurFrightInfo()
    {
        this("id");
    }
    protected AbstractPurFrightInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection());
    }
    /**
     * Object: �ɹ��˷ѵ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection)get("entrys");
    }
    /**
     * Object:�ɹ��˷ѵ�'s �Ƿ�����ƾ֤property 
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
     * Object: �ɹ��˷ѵ� 's ������ property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillInfo getWeightBill()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillInfo)get("weightBill");
    }
    public void setWeightBill(com.kingdee.eas.weighbridge.InStorageBillInfo item)
    {
        put("weightBill", item);
    }
    /**
     * Object: �ɹ��˷ѵ� 's �ʼ�Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: �ɹ��˷ѵ� 's ��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ����property 
     */
    public String getTruckNumber()
    {
        return getString("truckNumber");
    }
    public void setTruckNumber(String item)
    {
        setString("truckNumber", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ��������property 
     */
    public java.util.Date getArriveDate()
    {
        return getDate("arriveDate");
    }
    public void setArriveDate(java.util.Date item)
    {
        setDate("arriveDate", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s �ͼ�����property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ���ʱ��property 
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
     * Object:�ɹ��˷ѵ�'s ״̬property 
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
    /**
     * Object: �ɹ��˷ѵ� 's �ɹ����� property 
     */
    public com.kingdee.eas.scm.sm.pur.PurOrderInfo getPurOrder()
    {
        return (com.kingdee.eas.scm.sm.pur.PurOrderInfo)get("purOrder");
    }
    public void setPurOrder(com.kingdee.eas.scm.sm.pur.PurOrderInfo item)
    {
        put("purOrder", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s �ɹ���������property 
     */
    public String getPurOrderNumber()
    {
        return getString("purOrderNumber");
    }
    public void setPurOrderNumber(String item)
    {
        setString("purOrderNumber", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ��������property 
     */
    public java.math.BigDecimal getSumweight()
    {
        return getBigDecimal("sumweight");
    }
    public void setSumweight(java.math.BigDecimal item)
    {
        setBigDecimal("sumweight", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ѹ������property 
     */
    public int getYcts()
    {
        return getInt("ycts");
    }
    public void setYcts(int item)
    {
        setInt("ycts", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ѹ�����property 
     */
    public java.math.BigDecimal getYcje()
    {
        return getBigDecimal("ycje");
    }
    public void setYcje(java.math.BigDecimal item)
    {
        setBigDecimal("ycje", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ���ؽ��property 
     */
    public java.math.BigDecimal getKzje()
    {
        return getBigDecimal("kzje");
    }
    public void setKzje(java.math.BigDecimal item)
    {
        setBigDecimal("kzje", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s �˷ѵ���property 
     */
    public java.math.BigDecimal getFrightPrice()
    {
        return getBigDecimal("FrightPrice");
    }
    public void setFrightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("FrightPrice", item);
    }
    /**
     * Object: �ɹ��˷ѵ� 's ������ property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSuppile()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("suppile");
    }
    public void setSuppile(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("suppile", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s �����̳е���������property 
     */
    public java.math.BigDecimal getSuppchkz()
    {
        return getBigDecimal("suppchkz");
    }
    public void setSuppchkz(java.math.BigDecimal item)
    {
        setBigDecimal("suppchkz", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ��׼�˷ѵ���property 
     */
    public java.math.BigDecimal getSfrightPrice()
    {
        return getBigDecimal("SfrightPrice");
    }
    public void setSfrightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("SfrightPrice", item);
    }
    /**
     * Object: �ɹ��˷ѵ� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object:�ɹ��˷ѵ�'s ��������property 
     */
    public java.util.Date getOutDate()
    {
        return getDate("outDate");
    }
    public void setOutDate(java.util.Date item)
    {
        setDate("outDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("32EDC341");
    }
}