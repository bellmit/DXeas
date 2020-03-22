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
     * Object: 公务车租赁申请单 's 分录 property 
     */
    public com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarEntryCollection)get("entrys");
    }
    /**
     * Object:公务车租赁申请单's 是否生成凭证property 
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
     * Object: 公务车租赁申请单 's 申请部门 property 
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
     * Object: 公务车租赁申请单 's 申请人 property 
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
     * Object:公务车租赁申请单's 联系方式property 
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
     * Object:公务车租赁申请单's 来访人员property 
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
     * Object:公务车租赁申请单's 来访人员联系方式property 
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
     * Object:公务车租赁申请单's 接机/站地点property 
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
     * Object:公务车租赁申请单's 接机/站时间property 
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
     * Object:公务车租赁申请单's 来访人数property 
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
     * Object:公务车租赁申请单's 预计费用从property 
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
     * Object:公务车租赁申请单's 预计费用到property 
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
     * Object:公务车租赁申请单's 车辆使用日期property 
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
     * Object:公务车租赁申请单's 审核时间property 
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
     * Object:公务车租赁申请单's 单据状态property 
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
     * Object: 公务车租赁申请单 's 接机人员(本公司) property 
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
     * Object:公务车租赁申请单's 接机人员(非本公司)property 
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
     * Object:公务车租赁申请单's 目的property 
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
     * Object:公务车租赁申请单's 备注property 
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