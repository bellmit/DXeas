package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractArrangementBreedBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractArrangementBreedBillEntryInfo()
    {
        this("id");
    }
    protected AbstractArrangementBreedBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.ArrangementBreedBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ArrangementBreedBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.ArrangementBreedBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 分录 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:分录's 上苗日期property 
     */
    public java.util.Date getBreedDate()
    {
        return getDate("breedDate");
    }
    public void setBreedDate(java.util.Date item)
    {
        setDate("breedDate", item);
    }
    /**
     * Object:分录's 上苗数量property 
     */
    public java.math.BigDecimal getBreedQty()
    {
        return getBigDecimal("breedQty");
    }
    public void setBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("breedQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3755AF7C");
    }
}