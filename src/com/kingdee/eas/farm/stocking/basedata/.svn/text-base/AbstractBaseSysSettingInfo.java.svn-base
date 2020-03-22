package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseSysSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBaseSysSettingInfo()
    {
        this("id");
    }
    protected AbstractBaseSysSettingInfo(String pkField)
    {
        super(pkField);
        put("MarginTypeEntry", new com.kingdee.eas.farm.stocking.basedata.BaseSysSettingMarginTypeEntryCollection());
        put("StorageEntry", new com.kingdee.eas.farm.stocking.basedata.BaseSysSettingStorageEntryCollection());
    }
    /**
     * Object: 系统参数设置 's 财务组织 property 
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
     * Object:系统参数设置's 养殖户内部管理property 
     */
    public boolean isIsInner()
    {
        return getBoolean("isInner");
    }
    public void setIsInner(boolean item)
    {
        setBoolean("isInner", item);
    }
    /**
     * Object: 系统参数设置 's 饲料厂分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BaseSysSettingStorageEntryCollection getStorageEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BaseSysSettingStorageEntryCollection)get("StorageEntry");
    }
    /**
     * Object: 系统参数设置 's 批次成本对象分组 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectGroupInfo getCostGroup()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectGroupInfo)get("costGroup");
    }
    public void setCostGroup(com.kingdee.eas.basedata.assistant.CostObjectGroupInfo item)
    {
        put("costGroup", item);
    }
    /**
     * Object:系统参数设置's 核算维度property 
     */
    public com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum getAccountType()
    {
        return com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum.getEnum(getInt("accountType"));
    }
    public void setAccountType(com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum item)
    {
		if (item != null) {
        setInt("accountType", item.getValue());
		}
    }
    /**
     * Object:系统参数设置's 棚舍管理property 
     */
    public boolean isIsHouseManager()
    {
        return getBoolean("isHouseManager");
    }
    public void setIsHouseManager(boolean item)
    {
        setBoolean("isHouseManager", item);
    }
    /**
     * Object: 系统参数设置 's 养户父成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getParentCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("parentCostCenter");
    }
    public void setParentCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("parentCostCenter", item);
    }
    /**
     * Object: 系统参数设置 's 默认库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getDefaultStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("defaultStorageOrgUnit");
    }
    public void setDefaultStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("defaultStorageOrgUnit", item);
    }
    /**
     * Object: 系统参数设置 's 保证金收款类型 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BaseSysSettingMarginTypeEntryCollection getMarginTypeEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BaseSysSettingMarginTypeEntryCollection)get("MarginTypeEntry");
    }
    /**
     * Object:系统参数设置's 自动生成供应单据property 
     */
    public boolean isIsAutoSCM()
    {
        return getBoolean("isAutoSCM");
    }
    public void setIsAutoSCM(boolean item)
    {
        setBoolean("isAutoSCM", item);
    }
    /**
     * Object:系统参数设置's 自动创建养户核算项目property 
     */
    public boolean isIsCreateFarmerAsst()
    {
        return getBoolean("isCreateFarmerAsst");
    }
    public void setIsCreateFarmerAsst(boolean item)
    {
        setBoolean("isCreateFarmerAsst", item);
    }
    /**
     * Object: 系统参数设置 's 养户核算项目分组 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupInfo getFarmerAsstActGroup()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupInfo)get("farmerAsstActGroup");
    }
    public void setFarmerAsstActGroup(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupInfo item)
    {
        put("farmerAsstActGroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("22DDC205");
    }
}