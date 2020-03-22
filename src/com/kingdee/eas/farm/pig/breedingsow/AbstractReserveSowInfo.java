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
     * Object: ��ĸ�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ReserveSowEntryCollection)get("entrys");
    }
    /**
     * Object:��ĸ��'s �Ƿ�����ƾ֤property 
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
     * Object:��ĸ��'s ���ʱ��property 
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
     * Object:��ĸ��'s ״̬property 
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
     * Object: ��ĸ�� 's ���� property 
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
     * Object: ��ĸ�� 's ������Ա property 
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
     * Object: ��ĸ�� 's ���� property 
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