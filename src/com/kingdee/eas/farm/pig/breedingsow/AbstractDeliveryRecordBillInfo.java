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
     * Object: �����¼�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.DeliveryRecordBillEntryCollection)get("entrys");
    }
    /**
     * Object:�����¼��'s �Ƿ�����ƾ֤property 
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
     * Object:�����¼��'s ���ʱ��property 
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
     * Object:�����¼��'s ״̬property 
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
     * Object: �����¼�� 's ���� property 
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
     * Object: �����¼�� 's ����ĸ�� property 
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
     * Object: �����¼�� 's ����Ʒ�� property 
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
     * Object:�����¼��'s ̥��property 
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
     * Object: �����¼�� 's �������� property 
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
     * Object: �����¼�� 's ������λ property 
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
     * Object:�����¼��'s ��������property 
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
     * Object:�����¼��'s ���̾���(��)property 
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
     * Object:�����¼��'s ����ʱ��property 
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
     * Object: �����¼�� 's ���Ӳ�Ա property 
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
     * Object: �����¼�� 's ���Ӳ�Ա property 
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
     * Object:�����¼��'s ����״̬property 
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