package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCatchCKTeamInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCatchCKTeamInfo()
    {
        this("id");
    }
    protected AbstractCatchCKTeamInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 抓鸡队 's 财务组织 property 
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
     * Object:抓鸡队's 基本状态property 
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
     * Object:抓鸡队's 联系人property 
     */
    public String getLinkMan()
    {
        return getString("linkMan");
    }
    public void setLinkMan(String item)
    {
        setString("linkMan", item);
    }
    /**
     * Object:抓鸡队's 电话property 
     */
    public String getPhone()
    {
        return getString("phone");
    }
    public void setPhone(String item)
    {
        setString("phone", item);
    }
    /**
     * Object:抓鸡队's 人数property 
     */
    public int getPersonNum()
    {
        return getInt("personNum");
    }
    public void setPersonNum(int item)
    {
        setInt("personNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0477F67E");
    }
}