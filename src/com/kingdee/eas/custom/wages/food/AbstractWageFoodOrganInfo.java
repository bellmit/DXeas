package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWageFoodOrganInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWageFoodOrganInfo()
    {
        this("id");
    }
    protected AbstractWageFoodOrganInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 后勤组织架构 's 组别 property 
     */
    public com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:后勤组织架构's 夜班补贴标准property 
     */
    public java.math.BigDecimal getNightAllowance()
    {
        return getBigDecimal("NightAllowance");
    }
    public void setNightAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("NightAllowance", item);
    }
    /**
     * Object:后勤组织架构's 加班补贴（天）property 
     */
    public java.math.BigDecimal getOverTimeD()
    {
        return getBigDecimal("OverTimeD");
    }
    public void setOverTimeD(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeD", item);
    }
    /**
     * Object:后勤组织架构's 资料状态property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBasestatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("basestatus"));
    }
    public void setBasestatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("basestatus", item.getValue());
		}
    }
    /**
     * Object:后勤组织架构's 出差补贴标准property 
     */
    public String getTravelallowance()
    {
        return getString("travelallowance");
    }
    public void setTravelallowance(String item)
    {
        setString("travelallowance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("37D2DA49");
    }
}