package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementItemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettlementItemInfo()
    {
        this("id");
    }
    protected AbstractSettlementItemInfo(String pkField)
    {
        super(pkField);
        put("MaterialEntry", new com.kingdee.eas.farm.stocking.basedata.SettlementItemMaterialEntryCollection());
    }
    /**
     * Object: 结算项目 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.SettlementItemTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 结算项目 's 物料分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemMaterialEntryCollection getMaterialEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemMaterialEntryCollection)get("MaterialEntry");
    }
    /**
     * Object:结算项目's 状态property 
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
     * Object: 结算项目 's 财务组织 property 
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
     * Object:结算项目's 结算项目类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettleItemType getSettleItemType()
    {
        return com.kingdee.eas.farm.stocking.basedata.SettleItemType.getEnum(getInt("settleItemType"));
    }
    public void setSettleItemType(com.kingdee.eas.farm.stocking.basedata.SettleItemType item)
    {
		if (item != null) {
        setInt("settleItemType", item.getValue());
		}
    }
    /**
     * Object: 结算项目 's 结算单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getSettleUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("settleUnit");
    }
    public void setSettleUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("settleUnit", item);
    }
    /**
     * Object: 结算项目 's 物料分组 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BC1156D");
    }
}