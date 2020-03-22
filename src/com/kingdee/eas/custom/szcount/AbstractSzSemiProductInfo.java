package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzSemiProductInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSzSemiProductInfo()
    {
        this("id");
    }
    protected AbstractSzSemiProductInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection());
    }
    /**
     * Object: ��������� 's ��¼ property 
     */
    public com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection)get("entrys");
    }
    /**
     * Object:���������'s �Ƿ�����ƾ֤property 
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
     * Object:���������'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object: ��������� 's ����Ա property 
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
     * Object:���������'s ��λ����property 
     */
    public com.kingdee.eas.custom.szcount.szCountSet getCount()
    {
        return com.kingdee.eas.custom.szcount.szCountSet.getEnum(getString("count"));
    }
    public void setCount(com.kingdee.eas.custom.szcount.szCountSet item)
    {
		if (item != null) {
        setString("count", item.getValue());
		}
    }
    /**
     * Object:���������'s ���property 
     */
    public com.kingdee.eas.custom.szcount.szClasses getClasses()
    {
        return com.kingdee.eas.custom.szcount.szClasses.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.custom.szcount.szClasses item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    /**
     * Object: ��������� 's �ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getHouseName()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("houseName");
    }
    public void setHouseName(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("houseName", item);
    }
    /**
     * Object:���������'s ���ʱ��property 
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
     * Object:���������'s ��������property 
     */
    public java.util.Date getProductionDate()
    {
        return getDate("productionDate");
    }
    public void setProductionDate(java.util.Date item)
    {
        setDate("productionDate", item);
    }
    /**
     * Object: ��������� 's ��˾ property 
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
     * Object:���������'s �Ƿ�������ⵥproperty 
     */
    public boolean isWhetherProduction()
    {
        return getBoolean("whetherProduction");
    }
    public void setWhetherProduction(boolean item)
    {
        setBoolean("whetherProduction", item);
    }
    /**
     * Object: ��������� 's ������λ property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetInfo getStation()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetInfo)get("station");
    }
    public void setStation(com.kingdee.eas.custom.szcount.SzCountPositionSetInfo item)
    {
        put("station", item);
    }
    /**
     * Object:���������'s ʱ���property 
     */
    public String getTimeLong()
    {
        return getString("timeLong");
    }
    public void setTimeLong(String item)
    {
        setString("timeLong", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("02ABF12F");
    }
}