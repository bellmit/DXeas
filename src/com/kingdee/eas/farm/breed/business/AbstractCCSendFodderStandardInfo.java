package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCSendFodderStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCCSendFodderStandardInfo()
    {
        this("id");
    }
    protected AbstractCCSendFodderStandardInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.breed.business.CCSendFodderStandardEntryCollection());
    }
    /**
     * Object: 商品鸡料塔送料规范 's 组别 property 
     */
    public com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 商品鸡料塔送料规范 's 送料计划 property 
     */
    public com.kingdee.eas.farm.breed.business.CCSendFodderStandardEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CCSendFodderStandardEntryCollection)get("Entrys");
    }
    /**
     * Object:商品鸡料塔送料规范's 启用日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:商品鸡料塔送料规范's 禁用日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: 商品鸡料塔送料规范 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:商品鸡料塔送料规范's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:商品鸡料塔送料规范's 状态property 
     */
    public com.kingdee.eas.farm.breed.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.breed.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.breed.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    /**
     * Object:商品鸡料塔送料规范's 开始送料日龄property 
     */
    public int getBeginSendDays()
    {
        return getInt("beginSendDays");
    }
    public void setBeginSendDays(int item)
    {
        setInt("beginSendDays", item);
    }
    /**
     * Object:商品鸡料塔送料规范's 批次最大日龄property 
     */
    public int getEndSendDays()
    {
        return getInt("endSendDays");
    }
    public void setEndSendDays(int item)
    {
        setInt("endSendDays", item);
    }
    /**
     * Object:商品鸡料塔送料规范's 规范送料最大日龄property 
     */
    public int getAutoSendMaxDays()
    {
        return getInt("autoSendMaxDays");
    }
    public void setAutoSendMaxDays(int item)
    {
        setInt("autoSendMaxDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D0118CA9");
    }
}