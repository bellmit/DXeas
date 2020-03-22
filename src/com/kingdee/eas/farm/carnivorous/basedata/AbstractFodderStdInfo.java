package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderStdInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFodderStdInfo()
    {
        this("id");
    }
    protected AbstractFodderStdInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.basedata.FodderStdEntryCollection());
    }
    /**
     * Object: 饲料标准耗用表 's 财务组织 property 
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
     * Object: 饲料标准耗用表 's 品种 property 
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
     * Object:饲料标准耗用表's 基本状态property 
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
     * Object: 饲料标准耗用表 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FodderStdEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FodderStdEntryCollection)get("Entrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("460C756B");
    }
}