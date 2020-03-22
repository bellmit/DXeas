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
     * Object: ϵͳ�������� 's ������֯ property 
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
     * Object:ϵͳ��������'s ��ֳ���ڲ�����property 
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
     * Object: ϵͳ�������� 's ���ϳ���¼ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BaseSysSettingStorageEntryCollection getStorageEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BaseSysSettingStorageEntryCollection)get("StorageEntry");
    }
    /**
     * Object: ϵͳ�������� 's ���γɱ�������� property 
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
     * Object:ϵͳ��������'s ����ά��property 
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
     * Object:ϵͳ��������'s �������property 
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
     * Object: ϵͳ�������� 's �������ɱ����� property 
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
     * Object: ϵͳ�������� 's Ĭ�Ͽ����֯ property 
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
     * Object: ϵͳ�������� 's ��֤���տ����� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BaseSysSettingMarginTypeEntryCollection getMarginTypeEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BaseSysSettingMarginTypeEntryCollection)get("MarginTypeEntry");
    }
    /**
     * Object:ϵͳ��������'s �Զ����ɹ�Ӧ����property 
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
     * Object:ϵͳ��������'s �Զ���������������Ŀproperty 
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
     * Object: ϵͳ�������� 's ����������Ŀ���� property 
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