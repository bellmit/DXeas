package com.kingdee.eas.custom.taihe.sale;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplaintTableInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractComplaintTableInfo()
    {
        this("id");
    }
    protected AbstractComplaintTableInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection());
    }
    /**
     * Object: 客户投诉登记表 's 分录 property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection)get("entrys");
    }
    /**
     * Object:客户投诉登记表's 是否生成凭证property 
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
     * Object: 客户投诉登记表 's 被投诉公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getComplainedCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("complainedCompany");
    }
    public void setComplainedCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("complainedCompany", item);
    }
    /**
     * Object: 客户投诉登记表 's 投诉客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getComplainedCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("complainedCustomer");
    }
    public void setComplainedCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("complainedCustomer", item);
    }
    /**
     * Object: 客户投诉登记表 's 投诉项目 property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo getComplainedType()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo)get("complainedType");
    }
    public void setComplainedType(com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo item)
    {
        put("complainedType", item);
    }
    /**
     * Object:客户投诉登记表's 投诉内容property 
     */
    public String getComplContent()
    {
        return getString("ComplContent");
    }
    public void setComplContent(String item)
    {
        setString("ComplContent", item);
    }
    /**
     * Object:客户投诉登记表's 投诉订单号property 
     */
    public String getBillNum()
    {
        return getString("billNum");
    }
    public void setBillNum(String item)
    {
        setString("billNum", item);
    }
    /**
     * Object:客户投诉登记表's 单据状态property 
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
     * Object:客户投诉登记表's 处理状态property 
     */
    public com.kingdee.eas.custom.taihe.sale.dealStatus getDealStatus()
    {
        return com.kingdee.eas.custom.taihe.sale.dealStatus.getEnum(getString("dealStatus"));
    }
    public void setDealStatus(com.kingdee.eas.custom.taihe.sale.dealStatus item)
    {
		if (item != null) {
        setString("dealStatus", item.getValue());
		}
    }
    /**
     * Object:客户投诉登记表's 审核日期property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF5C2C2A");
    }
}