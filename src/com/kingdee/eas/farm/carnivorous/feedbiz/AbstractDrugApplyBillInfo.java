package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDrugApplyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDrugApplyBillInfo()
    {
        this("id");
    }
    protected AbstractDrugApplyBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillEntryCollection());
    }
    /**
     * Object: 用药申请单 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillEntryCollection)get("entrys");
    }
    /**
     * Object:用药申请单's 是否生成凭证property 
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
     * Object:用药申请单's 开始日期property 
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
     * Object:用药申请单's 结束日期property 
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
     * Object:用药申请单's 审核时间property 
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
     * Object: 用药申请单 's 公司 property 
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
     * Object:用药申请单's 单据状态property 
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
     * Object: 用药申请单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getBusPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("busPerson");
    }
    public void setBusPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("busPerson", item);
    }
    /**
     * Object: 用药申请单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("08CA30F1");
    }
}