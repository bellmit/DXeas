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
     * Object: ��Ʒ����ֳ�淶 's ��� property 
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
     * Object: ��Ʒ����ֳ�淶 's ��ι�ƻ� property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection)get("Entrys");
    }
    /**
     * Object:��Ʒ����ֳ�淶's ��������property 
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
     * Object:��Ʒ����ֳ�淶's ��������property 
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
     * Object: ��Ʒ����ֳ�淶 's ����� property 
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
     * Object:��Ʒ����ֳ�淶's ���ʱ��property 
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
     * Object:��Ʒ����ֳ�淶's ��׼��ι����(��)property 
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
     * Object:��Ʒ����ֳ�淶's �����ι����(��)property 
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
     * Object: ��Ʒ����ֳ�淶 's ���߼ƻ� property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: ��Ʒ����ֳ�淶 's ������ֳ�� property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFarmEntryCollection getFarmEntrys()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFarmEntryCollection)get("FarmEntrys");
    }
    /**
     * Object:��Ʒ����ֳ�淶's ״̬property 
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