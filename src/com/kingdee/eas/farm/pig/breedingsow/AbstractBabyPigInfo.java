package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBabyPigInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBabyPigInfo()
    {
        this("id");
    }
    protected AbstractBabyPigInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.BabyPigEntryCollection());
    }
    /**
     * Object: 仔猪建档 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.BabyPigEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.BabyPigEntryCollection)get("entrys");
    }
    /**
     * Object:仔猪建档's 是否生成凭证property 
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
     * Object:仔猪建档's 审核时间property 
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
     * Object:仔猪建档's 状态property 
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
     * Object: 仔猪建档 's 养猪场 property 
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
     * Object: 仔猪建档 's 分娩母猪 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowInfo getSow()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowInfo)get("sow");
    }
    public void setSow(com.kingdee.eas.farm.pig.breedingsow.SowInfo item)
    {
        put("sow", item);
    }
    /**
     * Object: 仔猪建档 's 仔猪品种 property 
     */
    public com.kingdee.eas.farm.pig.PigTypeInfo getBabyPigType()
    {
        return (com.kingdee.eas.farm.pig.PigTypeInfo)get("babyPigType");
    }
    public void setBabyPigType(com.kingdee.eas.farm.pig.PigTypeInfo item)
    {
        put("babyPigType", item);
    }
    /**
     * Object:仔猪建档's 幼崽数量property 
     */
    public int getBabyNum()
    {
        return getInt("babyNum");
    }
    public void setBabyNum(int item)
    {
        setInt("babyNum", item);
    }
    /**
     * Object:仔猪建档's 出生时间property 
     */
    public java.sql.Time getBirthday()
    {
        return getTime("birthday");
    }
    public void setBirthday(java.sql.Time item)
    {
        setTime("birthday", item);
    }
    /**
     * Object: 仔猪建档 's 建档人员 property 
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
     * Object: 仔猪建档 's 分娩记录单 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo getDeliveryBill()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo)get("deliveryBill");
    }
    public void setDeliveryBill(com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillInfo item)
    {
        put("deliveryBill", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D6E1CF97");
    }
}