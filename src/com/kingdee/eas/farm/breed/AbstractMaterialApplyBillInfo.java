package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialApplyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMaterialApplyBillInfo()
    {
        this("id");
    }
    protected AbstractMaterialApplyBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.MaterialApplyBillEntryCollection());
    }
    /**
     * Object: �������� 's ��¼ property 
     */
    public com.kingdee.eas.farm.breed.MaterialApplyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.MaterialApplyBillEntryCollection)get("entrys");
    }
    /**
     * Object:��������'s �Ƿ�����ƾ֤property 
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
     * Object:��������'s ���ʱ��property 
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
     * Object: �������� 's ��ֳ�� property 
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
     * Object:��������'s ״̬property 
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
     * Object: �������� 's ������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getApplyPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("applyPerson");
    }
    public void setApplyPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("applyPerson", item);
    }
    /**
     * Object:��������'s ��;property 
     */
    public String getPurpose()
    {
        return getString("purpose");
    }
    public void setPurpose(String item)
    {
        setString("purpose", item);
    }
    /**
     * Object: �������� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:��������'s �Ƿ������property 
     */
    public boolean isIsEmpty()
    {
        return getBoolean("isEmpty");
    }
    public void setIsEmpty(boolean item)
    {
        setBoolean("isEmpty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1AC0F114");
    }
}