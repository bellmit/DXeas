package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBRelationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractStockingBRelationInfo()
    {
        this("id");
    }
    protected AbstractStockingBRelationInfo(String pkField)
    {
        super(pkField);
        put("BatchListEntry", new com.kingdee.eas.farm.stocking.basedata.StockingBRelationBatchListEntryCollection());
    }
    /**
     * Object: 种禽批次关联关系 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:种禽批次关联关系's 单据状态property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus.getEnum(getString("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus item)
    {
		if (item != null) {
        setString("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 种禽批次关联关系 's 财务组织 property 
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
     * Object: 种禽批次关联关系 's 批次信息 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBRelationBatchListEntryCollection getBatchListEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBRelationBatchListEntryCollection)get("BatchListEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("424919A1");
    }
}