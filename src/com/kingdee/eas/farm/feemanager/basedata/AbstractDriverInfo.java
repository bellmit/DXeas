package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDriverInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDriverInfo()
    {
        this("id");
    }
    protected AbstractDriverInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ˾�� 's ��� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:˾��'s ˾������property 
     */
    public String getDrivername()
    {
        return getString("drivername");
    }
    public void setDrivername(String item)
    {
        setString("drivername", item);
    }
    /**
     * Object:˾��'s ˾������property 
     */
    public String getDriverplace()
    {
        return getString("driverplace");
    }
    public void setDriverplace(String item)
    {
        setString("driverplace", item);
    }
    /**
     * Object:˾��'s ˾�����֤��property 
     */
    public String getDrivercardid()
    {
        return getString("drivercardid");
    }
    public void setDrivercardid(String item)
    {
        setString("drivercardid", item);
    }
    /**
     * Object:˾��'s ˾������property 
     */
    public String getDriverage()
    {
        return getString("driverage");
    }
    public void setDriverage(String item)
    {
        setString("driverage", item);
    }
    /**
     * Object:˾��'s ������Ϣproperty 
     */
    public String getDrivercarinfo()
    {
        return getString("drivercarinfo");
    }
    public void setDrivercarinfo(String item)
    {
        setString("drivercarinfo", item);
    }
    /**
     * Object:˾��'s ˾����ϵ��ʽproperty 
     */
    public String getDriverphone()
    {
        return getString("driverphone");
    }
    public void setDriverphone(String item)
    {
        setString("driverphone", item);
    }
    /**
     * Object:˾��'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getState()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("state"));
    }
    public void setState(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("state", item.getValue());
		}
    }
    /**
     * Object: ˾�� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("CompanyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("CompanyOrgUnit", item);
    }
    /**
     * Object:˾��'s ����״̬property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("68E9FED4");
    }
}