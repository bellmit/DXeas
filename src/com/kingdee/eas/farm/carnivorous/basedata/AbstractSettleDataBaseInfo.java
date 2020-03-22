package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleDataBaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettleDataBaseInfo()
    {
        this("id");
    }
    protected AbstractSettleDataBaseInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection());
    }
    /**
     * Object: 结算基础资料设置 's 药品成本物料分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection)get("Entry");
    }
    /**
     * Object: 结算基础资料设置 's 公司 property 
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
     * Object:结算基础资料设置's 生效日期property 
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
     * Object:结算基础资料设置's 失效日期property 
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
     * Object:结算基础资料设置's 单据状态property 
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
     * Object: 结算基础资料设置 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:结算基础资料设置's 审核时间property 
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
     * Object: 结算基础资料设置 's 客户 property 
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
     * Object: 结算基础资料设置 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("wareHouse");
    }
    public void setWareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("wareHouse", item);
    }
    /**
     * Object:结算基础资料设置's 伤残是否参与补贴property 
     */
    public boolean isIsDisSubsidy()
    {
        return getBoolean("isDisSubsidy");
    }
    public void setIsDisSubsidy(boolean item)
    {
        setBoolean("isDisSubsidy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("339A0E28");
    }
}