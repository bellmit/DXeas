package com.kingdee.eas.custom.rentalapplicationform;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRentalApplicationOfBusinessCarInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRentalApplicationOfBusinessCarInfo()
    {
        this("id");
    }
    protected AbstractRentalApplicationOfBusinessCarInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarEntryCollection());
    }
    /**
     * Object: �����������뵥 's ��¼ property 
     */
    public com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarEntryCollection)get("entrys");
    }
    /**
     * Object:�����������뵥's �Ƿ�����ƾ֤property 
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
     * Object: �����������뵥 's ���벿�� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getApplyDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("applyDepartment");
    }
    public void setApplyDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("applyDepartment", item);
    }
    /**
     * Object: �����������뵥 's ������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getApplier()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("applier");
    }
    public void setApplier(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("applier", item);
    }
    /**
     * Object:�����������뵥's ��ϵ��ʽproperty 
     */
    public String getContact()
    {
        return getString("contact");
    }
    public void setContact(String item)
    {
        setString("contact", item);
    }
    /**
     * Object:�����������뵥's ������Աproperty 
     */
    public String getVisitor()
    {
        return getString("visitor");
    }
    public void setVisitor(String item)
    {
        setString("visitor", item);
    }
    /**
     * Object:�����������뵥's ������Ա��ϵ��ʽproperty 
     */
    public String getVisitorContract()
    {
        return getString("visitorContract");
    }
    public void setVisitorContract(String item)
    {
        setString("visitorContract", item);
    }
    /**
     * Object:�����������뵥's �ӻ�/վ�ص�property 
     */
    public String getDestinationAddress()
    {
        return getString("destinationAddress");
    }
    public void setDestinationAddress(String item)
    {
        setString("destinationAddress", item);
    }
    /**
     * Object:�����������뵥's �ӻ�/վʱ��property 
     */
    public java.sql.Time getPickUpTime()
    {
        return getTime("pickUpTime");
    }
    public void setPickUpTime(java.sql.Time item)
    {
        setTime("pickUpTime", item);
    }
    /**
     * Object:�����������뵥's ��������property 
     */
    public int getVisitorQty()
    {
        return getInt("visitorQty");
    }
    public void setVisitorQty(int item)
    {
        setInt("visitorQty", item);
    }
    /**
     * Object:�����������뵥's Ԥ�Ʒ��ô�property 
     */
    public java.math.BigDecimal getFeeFrom()
    {
        return getBigDecimal("feeFrom");
    }
    public void setFeeFrom(java.math.BigDecimal item)
    {
        setBigDecimal("feeFrom", item);
    }
    /**
     * Object:�����������뵥's Ԥ�Ʒ��õ�property 
     */
    public java.math.BigDecimal getFeeTo()
    {
        return getBigDecimal("feeTo");
    }
    public void setFeeTo(java.math.BigDecimal item)
    {
        setBigDecimal("feeTo", item);
    }
    /**
     * Object:�����������뵥's ����ʹ������property 
     */
    public java.util.Date getUsedDate()
    {
        return getDate("usedDate");
    }
    public void setUsedDate(java.util.Date item)
    {
        setDate("usedDate", item);
    }
    /**
     * Object:�����������뵥's ���ʱ��property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:�����������뵥's ����״̬property 
     */
    public com.kingdee.eas.custom.rentalapplicationform.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.rentalapplicationform.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.rentalapplicationform.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: �����������뵥 's �ӻ���Ա(����˾) property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPickUpInCompany()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("pickUpInCompany");
    }
    public void setPickUpInCompany(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("pickUpInCompany", item);
    }
    /**
     * Object:�����������뵥's �ӻ���Ա(�Ǳ���˾)property 
     */
    public String getPickUpOutCompany()
    {
        return getString("pickUpOutCompany");
    }
    public void setPickUpOutCompany(String item)
    {
        setString("pickUpOutCompany", item);
    }
    /**
     * Object:�����������뵥's Ŀ��property 
     */
    public String getPurpose()
    {
        return getString("purpose");
    }
    public void setPurpose(String item)
    {
        setString("purpose", item);
    }
    /**
     * Object:�����������뵥's ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F6743734");
    }
}