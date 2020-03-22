package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedBatchEditBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedBatchEditBillInfo()
    {
        this("id");
    }
    protected AbstractBreedBatchEditBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.BreedBatchEditBillEntryCollection());
    }
    /**
     * Object: ��ֳ���α༭�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchEditBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchEditBillEntryCollection)get("entrys");
    }
    /**
     * Object:��ֳ���α༭��'s �Ƿ�����ƾ֤property 
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
     * Object:��ֳ���α༭��'s ״̬property 
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
     * Object:��ֳ���α༭��'s ���ʱ��property 
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
     * Object: ��ֳ���α༭�� 's ��ֳ�� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object: ��ֳ���α༭�� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("82DD3C51");
    }
}