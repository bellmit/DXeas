package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerViewTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCustomerViewTypeInfo()
    {
        this("id");
    }
    protected AbstractCustomerViewTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客诉类型 's 财务组织 property 
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
     * Object:客诉类型's 基本状态property 
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
     * Object:客诉类型's 客诉日期关联property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DateRelate getDateRelate()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.DateRelate.getEnum(getString("dateRelate"));
    }
    public void setDateRelate(com.kingdee.eas.farm.carnivorous.basedata.DateRelate item)
    {
		if (item != null) {
        setString("dateRelate", item.getValue());
		}
    }
    /**
     * Object:客诉类型's 允许客诉天数property 
     */
    public int getPemitDays()
    {
        return getInt("pemitDays");
    }
    public void setPemitDays(int item)
    {
        setInt("pemitDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23F8171F");
    }
}