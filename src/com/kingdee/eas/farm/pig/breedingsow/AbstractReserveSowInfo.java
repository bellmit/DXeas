package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReserveSowInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractReserveSowInfo()
    {
        this("id");
    }
    protected AbstractReserveSowInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection());
    }
    /**
     * Object: 后备母猪 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection)get("entrys");
    }
    /**
     * Object:后备母猪's 是否生成凭证property 
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
     * Object:后备母猪's 审核时间property 
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
     * Object:后备母猪's 状态property 
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
     * Object: 后备母猪 's 养猪场 property 
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
     * Object: 后备母猪 's 建档人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object: 后备母猪 's 猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPighouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pighouse");
    }
    public void setPighouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pighouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A438F020");
    }
}