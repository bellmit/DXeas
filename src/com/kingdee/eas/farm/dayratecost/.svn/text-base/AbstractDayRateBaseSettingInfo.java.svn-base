package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateBaseSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDayRateBaseSettingInfo()
    {
        this("id");
    }
    protected AbstractDayRateBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础设置 's 财务组织 property 
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
     * Object: 基础设置 's 当前期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getCurrentPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("currentPeriod");
    }
    public void setCurrentPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("currentPeriod", item);
    }
    /**
     * Object:基础设置's 已经初始化property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object: 基础设置 's 苗对应物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getSeedMateiral()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("seedMateiral");
    }
    public void setSeedMateiral(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("seedMateiral", item);
    }
    /**
     * Object: 基础设置 's 苗对应成本项目 property 
     */
    public com.kingdee.eas.basedata.assistant.CostItemInfo getSeedCostItem()
    {
        return (com.kingdee.eas.basedata.assistant.CostItemInfo)get("seedCostItem");
    }
    public void setSeedCostItem(com.kingdee.eas.basedata.assistant.CostItemInfo item)
    {
        put("seedCostItem", item);
    }
    /**
     * Object:基础设置's 最高工作量property 
     */
    public int getFullWorkQty()
    {
        return getInt("fullWorkQty");
    }
    public void setFullWorkQty(int item)
    {
        setInt("fullWorkQty", item);
    }
    /**
     * Object: 基础设置 's 初始化期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getIntPeroid()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("intPeroid");
    }
    public void setIntPeroid(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("intPeroid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("11CFDC28");
    }
}