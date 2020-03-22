package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBreedModelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCCPigBreedModelInfo()
    {
        this("id");
    }
    protected AbstractCCPigBreedModelInfo(String pkField)
    {
        super(pkField);
        put("ImmuneEntrys", new com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection());
        put("Entrys", new com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection());
        put("FarmEntrys", new com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFarmEntryCollection());
    }
    /**
     * Object: 商品猪养殖规范 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 商品猪养殖规范 's 饲喂计划 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection)get("Entrys");
    }
    /**
     * Object:商品猪养殖规范's 启用日期property 
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
     * Object:商品猪养殖规范's 禁用日期property 
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
     * Object: 商品猪养殖规范 's 审核人 property 
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
     * Object:商品猪养殖规范's 审核时间property 
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
     * Object:商品猪养殖规范's 标准饲喂周期(天)property 
     */
    public int getBreedDays()
    {
        return getInt("breedDays");
    }
    public void setBreedDays(int item)
    {
        setInt("breedDays", item);
    }
    /**
     * Object:商品猪养殖规范's 最短饲喂周期(天)property 
     */
    public int getLimitBreedDays()
    {
        return getInt("limitBreedDays");
    }
    public void setLimitBreedDays(int item)
    {
        setInt("limitBreedDays", item);
    }
    /**
     * Object: 商品猪养殖规范 's 免疫计划 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: 商品猪养殖规范 's 适用养殖场 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFarmEntryCollection getFarmEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFarmEntryCollection)get("FarmEntrys");
    }
    /**
     * Object:商品猪养殖规范's 状态property 
     */
    public com.kingdee.eas.farm.pig.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.pig.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.pig.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("ADC1AD23");
    }
}