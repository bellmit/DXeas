package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginBreedPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarginBreedPolicyInfo()
    {
        this("id");
    }
    protected AbstractMarginBreedPolicyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyEntryCollection());
    }
    /**
     * Object:保证金雏苗让利政策's 单据状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBillStatue()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("billStatue"));
    }
    public void setBillStatue(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatue", item.getValue());
		}
    }
    /**
     * Object: 保证金雏苗让利政策 's 公司 property 
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
     * Object:保证金雏苗让利政策's 开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:保证金雏苗让利政策's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: 保证金雏苗让利政策 's 基础信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyEntryCollection)get("Entry");
    }
    /**
     * Object: 保证金雏苗让利政策 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C00593D6");
    }
}