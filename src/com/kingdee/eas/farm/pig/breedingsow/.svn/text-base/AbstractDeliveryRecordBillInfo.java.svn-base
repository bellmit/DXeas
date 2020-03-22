package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryRecordBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDeliveryRecordBillInfo()
    {
        this("id");
    }
    protected AbstractDeliveryRecordBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillEntryCollection());
    }
    /**
     * Object: 分娩记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillEntryCollection)get("entrys");
    }
    /**
     * Object:分娩记录单's 是否生成凭证property 
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
     * Object:分娩记录单's 审核时间property 
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
     * Object:分娩记录单's 状态property 
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
     * Object: 分娩记录单 's 养猪场 property 
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
     * Object: 分娩记录单 's 分娩母猪 property 
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
     * Object: 分娩记录单 's 仔猪品种 property 
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
     * Object:分娩记录单's 胎次property 
     */
    public int getFetusNum()
    {
        return getInt("fetusNum");
    }
    public void setFetusNum(int item)
    {
        setInt("fetusNum", item);
    }
    /**
     * Object: 分娩记录单 's 分娩猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPighouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pighouse");
    }
    public void setPighouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pighouse", item);
    }
    /**
     * Object: 分娩记录单 's 分娩栏位 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldInfo getPifField()
    {
        return (com.kingdee.eas.farm.pig.PigFieldInfo)get("pifField");
    }
    public void setPifField(com.kingdee.eas.farm.pig.PigFieldInfo item)
    {
        put("pifField", item);
    }
    /**
     * Object:分娩记录单's 幼崽数量property 
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
     * Object:分娩记录单's 幼崽均重(克)property 
     */
    public java.math.BigDecimal getAverageWeight()
    {
        return getBigDecimal("averageWeight");
    }
    public void setAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("averageWeight", item);
    }
    /**
     * Object:分娩记录单's 出生时间property 
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
     * Object: 分娩记录单 's 主接产员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getMainDeliver()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("mainDeliver");
    }
    public void setMainDeliver(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("mainDeliver", item);
    }
    /**
     * Object: 分娩记录单 's 副接产员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSecondDeliver()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("secondDeliver");
    }
    public void setSecondDeliver(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("secondDeliver", item);
    }
    /**
     * Object:分娩记录单's 分娩状态property 
     */
    public com.kingdee.eas.farm.pig.DeliveryStatus getDeliveryStatus()
    {
        return com.kingdee.eas.farm.pig.DeliveryStatus.getEnum(getString("deliveryStatus"));
    }
    public void setDeliveryStatus(com.kingdee.eas.farm.pig.DeliveryStatus item)
    {
		if (item != null) {
        setString("deliveryStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("12F85AED");
    }
}