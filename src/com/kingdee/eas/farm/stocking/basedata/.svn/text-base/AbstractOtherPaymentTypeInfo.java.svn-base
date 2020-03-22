package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherPaymentTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOtherPaymentTypeInfo()
    {
        this("id");
    }
    protected AbstractOtherPaymentTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖收付款类型 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.OtherPaymentTypeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:养殖收付款类型's 内容property 
     */
    public String getContext()
    {
        return getString("context");
    }
    public void setContext(String item)
    {
        setString("context", item);
    }
    /**
     * Object:养殖收付款类型's 基本状态property 
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
     * Object: 养殖收付款类型 's 财务组织 property 
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
     * Object:养殖收付款类型's 生活费每只金额property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:养殖收付款类型's 收付款property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum getROrPType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum.getEnum(getInt("ROrPType"));
    }
    public void setROrPType(com.kingdee.eas.farm.stocking.basedata.FarmROrPTypeEnum item)
    {
		if (item != null) {
        setInt("ROrPType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("545E1A81");
    }
}