package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleDataBaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettleDataBaseInfo()
    {
        this("id");
    }
    protected AbstractSettleDataBaseInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection());
    }
    /**
     * Object: ��������������� 's ҩƷ�ɱ����Ϸ�¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseEntryCollection)get("Entry");
    }
    /**
     * Object: ��������������� 's ��˾ property 
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
     * Object:���������������'s ��Ч����property 
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
     * Object:���������������'s ʧЧ����property 
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
     * Object:���������������'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: ��������������� 's ����� property 
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
     * Object:���������������'s ���ʱ��property 
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
     * Object: ��������������� 's �ͻ� property 
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
     * Object: ��������������� 's �ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("wareHouse");
    }
    public void setWareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("wareHouse", item);
    }
    /**
     * Object:���������������'s �˲��Ƿ���벹��property 
     */
    public boolean isIsDisSubsidy()
    {
        return getBoolean("isDisSubsidy");
    }
    public void setIsDisSubsidy(boolean item)
    {
        setBoolean("isDisSubsidy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("339A0E28");
    }
}