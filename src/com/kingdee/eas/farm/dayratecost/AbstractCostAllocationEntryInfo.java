package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCostAllocationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCostAllocationEntryInfo()
    {
        this("id");
    }
    protected AbstractCostAllocationEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.dayratecost.CostAllocationInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.CostAllocationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.CostAllocationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 金额property 
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
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: 分录 's 分配明细 property 
     */
    public com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailCollection)get("Detail");
    }
    /**
     * Object: 分录 's 费用项目 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo getFeeItem()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo)get("feeItem");
    }
    public void setFeeItem(com.kingdee.eas.farm.dayratecost.DayrateFeeItemInfo item)
    {
        put("feeItem", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5F7CAA60");
    }
}