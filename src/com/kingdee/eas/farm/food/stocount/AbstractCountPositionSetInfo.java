package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPositionSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCountPositionSetInfo()
    {
        this("id");
    }
    protected AbstractCountPositionSetInfo(String pkField)
    {
        super(pkField);
        put("MaterialEntry", new com.kingdee.eas.farm.food.stocount.CountPositionSetMaterialEntryCollection());
        put("OperatorEntry", new com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryCollection());
    }
    /**
     * Object: 计数岗位 's 组别 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.food.stocount.CountPositionSetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 计数岗位 's 操作员分录 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryCollection getOperatorEntry()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryCollection)get("OperatorEntry");
    }
    /**
     * Object: 计数岗位 's 产品列表 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetMaterialEntryCollection getMaterialEntry()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetMaterialEntryCollection)get("MaterialEntry");
    }
    /**
     * Object: 计数岗位 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:计数岗位's 品类property 
     */
    public com.kingdee.eas.farm.food.stocount.CountSet getCountset()
    {
        return com.kingdee.eas.farm.food.stocount.CountSet.getEnum(getString("countset"));
    }
    public void setCountset(com.kingdee.eas.farm.food.stocount.CountSet item)
    {
		if (item != null) {
        setString("countset", item.getValue());
		}
    }
    /**
     * Object:计数岗位's 状态property 
     */
    public com.kingdee.eas.farm.food.stocount.canorcancel getBaseStatus()
    {
        return com.kingdee.eas.farm.food.stocount.canorcancel.getEnum(getString("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.food.stocount.canorcancel item)
    {
		if (item != null) {
        setString("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D338AAA7");
    }
}