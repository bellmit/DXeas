package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBatchChangeBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStockingBatchChangeBillInfo()
    {
        this("id");
    }
    protected AbstractStockingBatchChangeBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:批次调整单's 是否生成凭证property 
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
     * Object:批次调整单's 单据状态property 
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
     * Object: 批次调整单 's 财务组织 property 
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
     * Object:批次调整单's 审核时间property 
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
     * Object: 批次调整单 's 养户名称 property 
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
     * Object: 批次调整单 's 批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:批次调整单's 调整数量property 
     */
    public java.math.BigDecimal getChangeQty()
    {
        return getBigDecimal("changeQty");
    }
    public void setChangeQty(java.math.BigDecimal item)
    {
        setBigDecimal("changeQty", item);
    }
    /**
     * Object:批次调整单's 原因property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object: 批次调整单 's 养殖场 property 
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
     * Object:批次调整单's 母禽调整数量property 
     */
    public java.math.BigDecimal getFemaleChangeQty()
    {
        return getBigDecimal("femaleChangeQty");
    }
    public void setFemaleChangeQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleChangeQty", item);
    }
    /**
     * Object:批次调整单's 业务类型property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchChangeTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.stocking.processbizill.BatchChangeTypeEnum.getEnum(getInt("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.stocking.processbizill.BatchChangeTypeEnum item)
    {
		if (item != null) {
        setInt("bizType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1CCA4700");
    }
}