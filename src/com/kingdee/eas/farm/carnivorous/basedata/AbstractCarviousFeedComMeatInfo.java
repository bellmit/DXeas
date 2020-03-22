package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarviousFeedComMeatInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCarviousFeedComMeatInfo()
    {
        this("id");
    }
    protected AbstractCarviousFeedComMeatInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryCollection());
    }
    /**
     * Object: 商品代料肉比标准 's 财务组织 property 
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
     * Object: 商品代料肉比标准 's 品种 property 
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
     * Object:商品代料肉比标准's 基本状态property 
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
     * Object: 商品代料肉比标准 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryCollection)get("Entrys");
    }
    /**
     * Object:商品代料肉比标准's 开始日期property 
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
     * Object:商品代料肉比标准's 结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0962A446");
    }
}