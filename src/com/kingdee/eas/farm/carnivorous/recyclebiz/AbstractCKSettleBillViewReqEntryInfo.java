package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillViewReqEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillViewReqEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillViewReqEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客诉补款 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 客诉补款 's 客诉类型 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo getViewType()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo)get("viewType");
    }
    public void setViewType(com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo item)
    {
        put("viewType", item);
    }
    /**
     * Object:客诉补款's 申请金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:客诉补款's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:客诉补款's 单据编号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object:客诉补款's 单据状态property 
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
     * Object:客诉补款's 审批金额property 
     */
    public java.math.BigDecimal getAuditAmt()
    {
        return getBigDecimal("auditAmt");
    }
    public void setAuditAmt(java.math.BigDecimal item)
    {
        setBigDecimal("auditAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A7511D50");
    }
}