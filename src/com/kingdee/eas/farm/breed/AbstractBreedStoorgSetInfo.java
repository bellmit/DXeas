package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStoorgSetInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedStoorgSetInfo()
    {
        this("id");
    }
    protected AbstractBreedStoorgSetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:养殖场设置's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:养殖场设置's 养殖场名称property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object: 养殖场设置 's 库存组织（养殖场） property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object:养殖场设置's 建厂日期property 
     */
    public java.util.Date getBuildDate()
    {
        return getDate("buildDate");
    }
    public void setBuildDate(java.util.Date item)
    {
        setDate("buildDate", item);
    }
    /**
     * Object:养殖场设置's 地址property 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object: 养殖场设置 's 场长 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getFarmLeader()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("farmLeader");
    }
    public void setFarmLeader(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("farmLeader", item);
    }
    /**
     * Object:养殖场设置's 启用状态property 
     */
    public com.kingdee.eas.farm.breed.DisableState getStatus()
    {
        return com.kingdee.eas.farm.breed.DisableState.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.farm.breed.DisableState item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object:养殖场设置's 养殖场类别property 
     */
    public com.kingdee.eas.farm.breed.HenhouseType getHenhouseType()
    {
        return com.kingdee.eas.farm.breed.HenhouseType.getEnum(getString("henhouseType"));
    }
    public void setHenhouseType(com.kingdee.eas.farm.breed.HenhouseType item)
    {
		if (item != null) {
        setString("henhouseType", item.getValue());
		}
    }
    /**
     * Object:养殖场设置's 电话property 
     */
    public String getTel()
    {
        return getString("tel");
    }
    public void setTel(String item)
    {
        setString("tel", item);
    }
    /**
     * Object: 养殖场设置 's 所属公司 property 
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
     * Object:养殖场设置's 启用自动要料property 
     */
    public boolean isIsEnableAutoApplyFodder()
    {
        return getBoolean("isEnableAutoApplyFodder");
    }
    public void setIsEnableAutoApplyFodder(boolean item)
    {
        setBoolean("isEnableAutoApplyFodder", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("03931B52");
    }
}