package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillEggSettleDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsBillEggSettleDetailInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillEggSettleDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 蛋品结算明细 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 蛋品结算明细 's 批次 property 
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
     * Object:蛋品结算明细's 总数量property 
     */
    public java.math.BigDecimal getAllQty()
    {
        return getBigDecimal("allQty");
    }
    public void setAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("allQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2F795E51");
    }
}