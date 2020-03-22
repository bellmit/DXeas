package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTechBatchRangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTechBatchRangeEntryInfo()
    {
        this("id");
    }
    protected AbstractTechBatchRangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 批次分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 批次分录 's 批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object:批次分录's 养殖场property 
     */
    public String getFarm()
    {
        return getString("farm");
    }
    public void setFarm(String item)
    {
        setString("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7D17BFA8");
    }
}