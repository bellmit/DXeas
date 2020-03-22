package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherPaymentInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractOtherPaymentInfo()
    {
        this("id");
    }
    protected AbstractOtherPaymentInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.OtherPaymentEntryCollection());
    }
    /**
     * Object: 养殖收付款业务 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.OtherPaymentEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.OtherPaymentEntryCollection)get("entrys");
    }
    /**
     * Object:养殖收付款业务's 是否生成凭证property 
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
     * Object:养殖收付款业务's 单据状态property 
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
     * Object: 养殖收付款业务 's 财务组织 property 
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
     * Object:养殖收付款业务's 审核时间property 
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
     * Object: 养殖收付款业务 's 养户名称 property 
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
     * Object: 养殖收付款业务 's 批次 property 
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
     * Object: 养殖收付款业务 's 养殖场 property 
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
     * Object:养殖收付款业务's 业务类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum.getEnum(getInt("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum item)
    {
		if (item != null) {
        setInt("bizType", item.getValue());
		}
    }
    /**
     * Object: 养殖收付款业务 's 结算方式 property 
     */
    public com.kingdee.eas.basedata.assistant.SettlementTypeInfo getSettleType()
    {
        return (com.kingdee.eas.basedata.assistant.SettlementTypeInfo)get("settleType");
    }
    public void setSettleType(com.kingdee.eas.basedata.assistant.SettlementTypeInfo item)
    {
        put("settleType", item);
    }
    /**
     * Object: 养殖收付款业务 's 收款类型 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillTypeInfo getReviceType()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillTypeInfo)get("reviceType");
    }
    public void setReviceType(com.kingdee.eas.fi.cas.ReceivingBillTypeInfo item)
    {
        put("reviceType", item);
    }
    /**
     * Object: 养殖收付款业务 's 付款类型 property 
     */
    public com.kingdee.eas.fi.cas.PaymentBillTypeInfo getPaymentType()
    {
        return (com.kingdee.eas.fi.cas.PaymentBillTypeInfo)get("paymentType");
    }
    public void setPaymentType(com.kingdee.eas.fi.cas.PaymentBillTypeInfo item)
    {
        put("paymentType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D3D984BB");
    }
}