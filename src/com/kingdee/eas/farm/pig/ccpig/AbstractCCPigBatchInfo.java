package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBatchInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCCPigBatchInfo()
    {
        this("id");
    }
    protected AbstractCCPigBatchInfo(String pkField)
    {
        super(pkField);
        put("PigletBatchEntry", new com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryCollection());
        put("entrys", new com.kingdee.eas.farm.pig.ccpig.CCPigBatchEntryCollection());
    }
    /**
     * Object: 商品猪批次 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchEntryCollection)get("entrys");
    }
    /**
     * Object:商品猪批次's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 商品猪批次 's 批次（成本对象） property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:商品猪批次's 审核时间property 
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
     * Object:商品猪批次's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:商品猪批次's 入栏日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:商品猪批次's 总入栏头数property 
     */
    public int getInitAllQty()
    {
        return getInt("initAllQty");
    }
    public void setInitAllQty(int item)
    {
        setInt("initAllQty", item);
    }
    /**
     * Object: 商品猪批次 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getPigFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("pigFarm");
    }
    public void setPigFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("pigFarm", item);
    }
    /**
     * Object:商品猪批次's 入栏均重(kg)property 
     */
    public java.math.BigDecimal getAveWeight()
    {
        return getBigDecimal("aveWeight");
    }
    public void setAveWeight(java.math.BigDecimal item)
    {
        setBigDecimal("aveWeight", item);
    }
    /**
     * Object: 商品猪批次 's 仔猪批次 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryCollection getPigletBatchEntry()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryCollection)get("PigletBatchEntry");
    }
    /**
     * Object: 商品猪批次 's 猪苗等级 property 
     */
    public com.kingdee.eas.farm.pig.PigLevelInfo getPigLevel()
    {
        return (com.kingdee.eas.farm.pig.PigLevelInfo)get("pigLevel");
    }
    public void setPigLevel(com.kingdee.eas.farm.pig.PigLevelInfo item)
    {
        put("pigLevel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BFBD736C");
    }
}