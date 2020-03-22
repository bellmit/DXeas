package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayrateFeeItemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDayrateFeeItemInfo()
    {
        this("id");
    }
    protected AbstractDayrateFeeItemInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.dayratecost.DayrateFeeItemEntryCollection());
    }
    /**
     * Object: 费用项目 's 组别 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:费用项目's 状态property 
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
     * Object: 费用项目 's 财务组织 property 
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
     * Object: 费用项目 's 分录 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3D245642");
    }
}