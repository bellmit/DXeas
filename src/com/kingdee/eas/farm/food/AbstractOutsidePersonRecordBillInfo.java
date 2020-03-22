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
     * Object:外部人员来访考察审批表's 单据状态property 
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
     * Object:外部人员来访考察审批表's 审核时间property 
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
     * Object:外部人员来访考察审批表's 公司名称property 
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
     * Object:外部人员来访考察审批表's 人数property 
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
     * Object:外部人员来访考察审批表's 来访/结束时间property 
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
     * Object:外部人员来访考察审批表's 目的property 
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
     * Object:外部人员来访考察审批表's 生产车间property 
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
     * Object:外部人员来访考察审批表's 参观走廊property 
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
     * Object:外部人员来访考察审批表's 制冷机房property 
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
     * Object:外部人员来访考察审批表's 其他property 
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
     * Object:外部人员来访考察审批表's 饲料厂property 
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
     * Object:外部人员来访考察审批表's 种鸡场property 
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
     * Object:外部人员来访考察审批表's 孵化场property 
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
     * Object:外部人员来访考察审批表's 商品场property 
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
     * Object:外部人员来访考察审批表's 化验室property 
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
     * Object:外部人员来访考察审批表's 派车时间property 
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
     * Object:外部人员来访考察审批表's 就餐时间property 
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
     * Object: 外部人员来访考察审批表 's 接待人 property 
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
     * Object:外部人员来访考察审批表's 电话property 
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
     * Object:外部人员来访考察审批表's 责任人property 
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
     * Object:外部人员来访考察审批表's 职务property 
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
     * Object:外部人员来访考察审批表's 电话property 
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
     * Object: 外部人员来访考察审批表 's 部门 property 
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
     * Object:外部人员来访考察审批表's 接待地点property 
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
     * Object:外部人员来访考察审批表's 是否送到接待处property 
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
     * Object:外部人员来访考察审批表's 备注property 
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
     * Object: 外部人员来访考察审批表 's 申请部门 property 
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
     * Object: 外部人员来访考察审批表 's 申请人 property 
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
     * Object: 外部人员来访考察审批表 's 职位 property 
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