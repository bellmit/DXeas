package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaiginBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaiginBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMaiginBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 进雏明细 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 进雏明细 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:进雏明细's 实际上苗日期property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object: 进雏明细 's 批次合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: 进雏明细 's 品种 property 
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
     * Object:进雏明细's 上苗只数property 
     */
    public int getBatchQty()
    {
        return getInt("batchQty");
    }
    public void setBatchQty(int item)
    {
        setInt("batchQty", item);
    }
    /**
     * Object:进雏明细's 本批使用保证金property 
     */
    public java.math.BigDecimal getMinMargin()
    {
        return getBigDecimal("minMargin");
    }
    public void setMinMargin(java.math.BigDecimal item)
    {
        setBigDecimal("minMargin", item);
    }
    /**
     * Object:进雏明细's 本批状态property 
     */
    public String getStatus()
    {
        return getString("status");
    }
    public void setStatus(String item)
    {
        setString("status", item);
    }
    /**
     * Object:进雏明细's 实际单只保证金property 
     */
    public java.math.BigDecimal getSingleMargin()
    {
        return getBigDecimal("singleMargin");
    }
    public void setSingleMargin(java.math.BigDecimal item)
    {
        setBigDecimal("singleMargin", item);
    }
    /**
     * Object:进雏明细's 合同数量property 
     */
    public int getContractQty()
    {
        return getInt("contractQty");
    }
    public void setContractQty(int item)
    {
        setInt("contractQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("590FDA9D");
    }
}