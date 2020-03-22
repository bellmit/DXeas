package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBRelationBatchListEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBRelationBatchListEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingBRelationBatchListEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 批次信息 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 批次信息 's 批次编码 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getBNum()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("bNum");
    }
    public void setBNum(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("bNum", item);
    }
    /**
     * Object:批次信息's 批次名称property 
     */
    public String getBName()
    {
        return getString("bName");
    }
    public void setBName(String item)
    {
        setString("bName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("158BDC5B");
    }
}