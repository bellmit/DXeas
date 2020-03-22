package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowReturnbackBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSowReturnbackBillInfo()
    {
        this("id");
    }
    protected AbstractSowReturnbackBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.SowReturnbackBillEntryCollection());
    }
    /**
     * Object: 母猪回收记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowReturnbackBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowReturnbackBillEntryCollection)get("entrys");
    }
    /**
     * Object:母猪回收记录单's 是否生成凭证property 
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
     * Object:母猪回收记录单's 审核时间property 
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
     * Object:母猪回收记录单's 状态property 
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
     * Object: 母猪回收记录单 's 养猪场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 母猪回收记录单 's 养户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 母猪回收记录单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DEEAAD38");
    }
}