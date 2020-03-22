package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKGrowthFreightBillInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCKGrowthFreightBillInfo()
    {
        this("id");
    }
    protected AbstractCKGrowthFreightBillInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryCollection());
    }
    /**
     * Object: 毛鸡增幅运费表 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object: 毛鸡增幅运费表 's 品种 property 
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
     * Object:毛鸡增幅运费表's 基本状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 毛鸡增幅运费表 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryCollection)get("Entrys");
    }
    /**
     * Object:毛鸡增幅运费表's 均重起始值property 
     */
    public java.math.BigDecimal getMinAvgWgt()
    {
        return getBigDecimal("minAvgWgt");
    }
    public void setMinAvgWgt(java.math.BigDecimal item)
    {
        setBigDecimal("minAvgWgt", item);
    }
    /**
     * Object:毛鸡增幅运费表's 均重终止值property 
     */
    public java.math.BigDecimal getMaxAvgWgt()
    {
        return getBigDecimal("maxAvgWgt");
    }
    public void setMaxAvgWgt(java.math.BigDecimal item)
    {
        setBigDecimal("maxAvgWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA6F692C");
    }
}