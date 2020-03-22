package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchBabyBillInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyBillInfo(String pkField)
    {
        super(pkField);
        put("SaleEntry", new com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection());
    }
    /**
     * Object: ������old 's ��¼ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection)get("entrys");
    }
    /**
     * Object:������old's �Ƿ�����ƾ֤property 
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
     * Object: ������old 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:������old's ���ʱ��property 
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
     * Object:������old's ״̬property 
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
     * Object:������old's ��עproperty 
     */
    public String getTransDescription()
    {
        return getString("transDescription");
    }
    public void setTransDescription(String item)
    {
        setString("transDescription", item);
    }
    /**
     * Object: ������old 's ת�䵥 property 
     */
    public com.kingdee.eas.farm.hatch.TranferBoxBillInfo getTransferBoxBill()
    {
        return (com.kingdee.eas.farm.hatch.TranferBoxBillInfo)get("transferBoxBill");
    }
    public void setTransferBoxBill(com.kingdee.eas.farm.hatch.TranferBoxBillInfo item)
    {
        put("transferBoxBill", item);
    }
    /**
     * Object: ������old 's ����ȥ�� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getCommercialStoorg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("commercialStoorg");
    }
    public void setCommercialStoorg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("commercialStoorg", item);
    }
    /**
     * Object: ������old 's ���߷�¼ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: ������old 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object: ������old 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:������old's ת����property 
     */
    public int getAllTransQty()
    {
        return getInt("allTransQty");
    }
    public void setAllTransQty(int item)
    {
        setInt("allTransQty", item);
    }
    /**
     * Object:������old's ����property 
     */
    public int getHealthQty()
    {
        return getInt("healthQty");
    }
    public void setHealthQty(int item)
    {
        setInt("healthQty", item);
    }
    /**
     * Object:������old's ������property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:������old's ���property 
     */
    public int getLossQty()
    {
        return getInt("lossQty");
    }
    public void setLossQty(int item)
    {
        setInt("lossQty", item);
    }
    /**
     * Object:������old's �������property 
     */
    public int getOtherLossQty()
    {
        return getInt("otherLossQty");
    }
    public void setOtherLossQty(int item)
    {
        setInt("otherLossQty", item);
    }
    /**
     * Object:������old's ë��property 
     */
    public int getUnhatchedEggQty()
    {
        return getInt("unhatchedEggQty");
    }
    public void setUnhatchedEggQty(int item)
    {
        setInt("unhatchedEggQty", item);
    }
    /**
     * Object: ������old 's ����ȥ��� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOtherStoorg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("otherStoorg");
    }
    public void setOtherStoorg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("otherStoorg", item);
    }
    /**
     * Object:������old's ȥ���������property 
     */
    public int getOtherHealthQty()
    {
        return getInt("otherHealthQty");
    }
    public void setOtherHealthQty(int item)
    {
        setInt("otherHealthQty", item);
    }
    /**
     * Object:������old's ȥ��һ������property 
     */
    public int getOneHealthQty()
    {
        return getInt("oneHealthQty");
    }
    public void setOneHealthQty(int item)
    {
        setInt("oneHealthQty", item);
    }
    /**
     * Object: ������old 's ������¼ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection getSaleEntry()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection)get("SaleEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("065CC30F");
    }
}