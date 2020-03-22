package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountRecordBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDiscountRecordBillInfo()
    {
        this("id");
    }
    protected AbstractDiscountRecordBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.salediscount.DiscountRecordBillEntryCollection());
    }
    /**
     * Object: 折让记录单 's 分录 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountRecordBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountRecordBillEntryCollection)get("entrys");
    }
    /**
     * Object:折让记录单's 是否生成凭证property 
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
     * Object:折让记录单's 折让类别property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountTypeEnum getDiscountType()
    {
        return com.kingdee.eas.custom.salediscount.DiscountTypeEnum.getEnum(getString("discountType"));
    }
    public void setDiscountType(com.kingdee.eas.custom.salediscount.DiscountTypeEnum item)
    {
		if (item != null) {
        setString("discountType", item.getValue());
		}
    }
    /**
     * Object:折让记录单's 总金额property 
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
     * Object:折让记录单's 审核日期property 
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
     * Object:折让记录单's 单据状态property 
     */
    public com.kingdee.eas.custom.salediscount.billStatus getStatus()
    {
        return com.kingdee.eas.custom.salediscount.billStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.custom.salediscount.billStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    /**
     * Object:折让记录单's 是否初始化单property 
     */
    public boolean isIsInitBill()
    {
        return getBoolean("isInitBill");
    }
    public void setIsInitBill(boolean item)
    {
        setBoolean("isInitBill", item);
    }
    /**
     * Object: 折让记录单 's 销售订单 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleOrderInfo getSaleOrder()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleOrderInfo)get("saleOrder");
    }
    public void setSaleOrder(com.kingdee.eas.scm.sd.sale.SaleOrderInfo item)
    {
        put("saleOrder", item);
    }
    /**
     * Object: 折让记录单 's 期间 property 
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
     * Object:折让记录单's 版本序号property 
     */
    public int getVersion()
    {
        return getInt("version");
    }
    public void setVersion(int item)
    {
        setInt("version", item);
    }
    /**
     * Object:折让记录单's 调整类型及方式property 
     */
    public String getAdjustType()
    {
        return getString("adjustType");
    }
    public void setAdjustType(String item)
    {
        setString("adjustType", item);
    }
    /**
     * Object: 折让记录单 's 公司 property 
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
     * Object: 折让记录单 's 客户 property 
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
     * Object: 折让记录单 's 销售退货申请单 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleReturnsInfo getSaleReturns()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleReturnsInfo)get("saleReturns");
    }
    public void setSaleReturns(com.kingdee.eas.scm.sd.sale.SaleReturnsInfo item)
    {
        put("saleReturns", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BB4F0454");
    }
}