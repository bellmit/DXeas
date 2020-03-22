package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostAllocationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCostAllocationInfo()
    {
        this("id");
    }
    protected AbstractCostAllocationInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.dayratecost.CostAllocationEntryCollection());
    }
    /**
     * Object: 费用分摊 's 分录 property 
     */
    public com.kingdee.eas.farm.dayratecost.CostAllocationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.dayratecost.CostAllocationEntryCollection)get("entrys");
    }
    /**
     * Object:费用分摊's 是否生成凭证property 
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
     * Object:费用分摊's 单据状态property 
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
     * Object: 费用分摊 's 财务组织 property 
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
     * Object:费用分摊's 审核时间property 
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
     * Object: 费用分摊 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 费用分摊 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 费用分摊 's 期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:费用分摊's 分摊方式property 
     */
    public com.kingdee.eas.farm.dayratecost.AllocationTypeEnum getAllocationType()
    {
        return com.kingdee.eas.farm.dayratecost.AllocationTypeEnum.getEnum(getInt("allocationType"));
    }
    public void setAllocationType(com.kingdee.eas.farm.dayratecost.AllocationTypeEnum item)
    {
		if (item != null) {
        setInt("allocationType", item.getValue());
		}
    }
    /**
     * Object: 费用分摊 's 养殖场区域 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo getFarmGroup()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo)get("farmGroup");
    }
    public void setFarmGroup(com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo item)
    {
        put("farmGroup", item);
    }
    /**
     * Object: 费用分摊 's 养殖户区域 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmerGroup()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmerGroup");
    }
    public void setFarmerGroup(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmerGroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8337DD32");
    }
}