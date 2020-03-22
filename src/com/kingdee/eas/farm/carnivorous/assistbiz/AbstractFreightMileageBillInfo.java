package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreightMileageBillInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFreightMileageBillInfo()
    {
        this("id");
    }
    protected AbstractFreightMileageBillInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryCollection());
    }
    /**
     * Object: 运费里程表 's 财务组织 property 
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
     * Object: 运费里程表 's 品种 property 
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
     * Object:运费里程表's 基本状态property 
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
     * Object: 运费里程表 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryCollection)get("Entrys");
    }
    /**
     * Object:运费里程表's 路线类型property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum getRouteType()
    {
        return com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum.getEnum(getString("routeType"));
    }
    public void setRouteType(com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum item)
    {
		if (item != null) {
        setString("routeType", item.getValue());
		}
    }
    /**
     * Object: 运费里程表 's 车辆规格 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo getCarSize()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)get("carSize");
    }
    public void setCarSize(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo item)
    {
        put("carSize", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9FDB479D");
    }
}