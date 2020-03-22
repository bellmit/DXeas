package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAvgWgtSectionInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAvgWgtSectionInfo()
    {
        this("id");
    }
    protected AbstractAvgWgtSectionInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionEntryCollection());
    }
    /**
     * Object: 均重区间表 's 财务组织 property 
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
     * Object: 均重区间表 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionEntryCollection)get("Entrys");
    }
    /**
     * Object: 均重区间表 's 品种 property 
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
        return new BOSObjectType("99C848B1");
    }
}