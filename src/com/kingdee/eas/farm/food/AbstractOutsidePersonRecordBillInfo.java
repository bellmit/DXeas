package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOutsidePersonRecordBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractOutsidePersonRecordBillInfo()
    {
        this("id");
    }
    protected AbstractOutsidePersonRecordBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ��˾����property 
     */
    public String getCompanyName()
    {
        return getString("companyName");
    }
    public void setCompanyName(String item)
    {
        setString("companyName", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ����property 
     */
    public int getPeopleCount()
    {
        return getInt("peopleCount");
    }
    public void setPeopleCount(int item)
    {
        setInt("peopleCount", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ����/����ʱ��property 
     */
    public java.util.Date getHappenDate()
    {
        return getDate("happenDate");
    }
    public void setHappenDate(java.util.Date item)
    {
        setDate("happenDate", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s Ŀ��property 
     */
    public String getReasons()
    {
        return getString("reasons");
    }
    public void setReasons(String item)
    {
        setString("reasons", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ��������property 
     */
    public boolean isWorkshop()
    {
        return getBoolean("workshop");
    }
    public void setWorkshop(boolean item)
    {
        setBoolean("workshop", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �ι�����property 
     */
    public boolean isCorridor()
    {
        return getBoolean("corridor");
    }
    public void setCorridor(boolean item)
    {
        setBoolean("corridor", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �������property 
     */
    public boolean isRefrigerate()
    {
        return getBoolean("refrigerate");
    }
    public void setRefrigerate(boolean item)
    {
        setBoolean("refrigerate", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ����property 
     */
    public boolean isOther()
    {
        return getBoolean("other");
    }
    public void setOther(boolean item)
    {
        setBoolean("other", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ���ϳ�property 
     */
    public boolean isFeedMill()
    {
        return getBoolean("feedMill");
    }
    public void setFeedMill(boolean item)
    {
        setBoolean("feedMill", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �ּ���property 
     */
    public boolean isBreedChicken()
    {
        return getBoolean("breedChicken");
    }
    public void setBreedChicken(boolean item)
    {
        setBoolean("breedChicken", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ������property 
     */
    public boolean isHatch()
    {
        return getBoolean("hatch");
    }
    public void setHatch(boolean item)
    {
        setBoolean("hatch", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ��Ʒ��property 
     */
    public boolean isBusinessChicken()
    {
        return getBoolean("businessChicken");
    }
    public void setBusinessChicken(boolean item)
    {
        setBoolean("businessChicken", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ������property 
     */
    public boolean isAssay()
    {
        return getBoolean("assay");
    }
    public void setAssay(boolean item)
    {
        setBoolean("assay", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �ɳ�ʱ��property 
     */
    public java.util.Date getSendCarTime()
    {
        return getDate("sendCarTime");
    }
    public void setSendCarTime(java.util.Date item)
    {
        setDate("sendCarTime", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �Ͳ�ʱ��property 
     */
    public java.util.Date getMealtime()
    {
        return getDate("mealtime");
    }
    public void setMealtime(java.util.Date item)
    {
        setDate("mealtime", item);
    }
    /**
     * Object: �ⲿ��Ա���ÿ��������� 's �Ӵ��� property 
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
     * Object:�ⲿ��Ա���ÿ���������'s �绰property 
     */
    public String getTel()
    {
        return getString("tel");
    }
    public void setTel(String item)
    {
        setString("tel", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ������property 
     */
    public String getResponsible()
    {
        return getString("responsible");
    }
    public void setResponsible(String item)
    {
        setString("responsible", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ְ��property 
     */
    public String getFromPosition()
    {
        return getString("fromPosition");
    }
    public void setFromPosition(String item)
    {
        setString("fromPosition", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �绰property 
     */
    public String getFromTel()
    {
        return getString("fromTel");
    }
    public void setFromTel(String item)
    {
        setString("fromTel", item);
    }
    /**
     * Object: �ⲿ��Ա���ÿ��������� 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �Ӵ��ص�property 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s �Ƿ��͵��Ӵ���property 
     */
    public boolean isIsSendReception()
    {
        return getBoolean("isSendReception");
    }
    public void setIsSendReception(boolean item)
    {
        setBoolean("isSendReception", item);
    }
    /**
     * Object:�ⲿ��Ա���ÿ���������'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: �ⲿ��Ա���ÿ��������� 's ���벿�� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrgUnit");
    }
    public void setAdminOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrgUnit", item);
    }
    /**
     * Object: �ⲿ��Ա���ÿ��������� 's ������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getApplerPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("applerPerson");
    }
    public void setApplerPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("applerPerson", item);
    }
    /**
     * Object: �ⲿ��Ա���ÿ��������� 's ְλ property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("590B1908");
    }
}