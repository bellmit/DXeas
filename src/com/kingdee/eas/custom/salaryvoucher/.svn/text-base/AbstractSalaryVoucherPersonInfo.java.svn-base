package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalaryVoucherPersonInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSalaryVoucherPersonInfo()
    {
        this("id");
    }
    protected AbstractSalaryVoucherPersonInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 员工 's null property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo getParent()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:员工's 选择property 
     */
    public boolean isSelected()
    {
        return getBoolean("selected");
    }
    public void setSelected(boolean item)
    {
        setBoolean("selected", item);
    }
    /**
     * Object: 员工 's 员工编码 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getNumber()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("number");
    }
    public void setNumber(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("number", item);
    }
    /**
     * Object:员工's 员工姓名property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:员工's shr人员编码property 
     */
    public String getShrPersonNum()
    {
        return getString("shrPersonNum");
    }
    public void setShrPersonNum(String item)
    {
        setString("shrPersonNum", item);
    }
    /**
     * Object:员工's shr人员姓名property 
     */
    public String getShrPersonName()
    {
        return getString("shrPersonName");
    }
    public void setShrPersonName(String item)
    {
        setString("shrPersonName", item);
    }
    /**
     * Object: 员工 's 研发项目 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo getGreenDreamProject()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo)get("GreenDreamProject");
    }
    public void setGreenDreamProject(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo item)
    {
        put("GreenDreamProject", item);
    }
    /**
     * Object:员工's 研发项目编码property 
     */
    public String getGreenDreamProjectCode()
    {
        return getString("GreenDreamProjectCode");
    }
    public void setGreenDreamProjectCode(String item)
    {
        setString("GreenDreamProjectCode", item);
    }
    /**
     * Object:员工's 研发项目名称property 
     */
    public String getGreenDreamProjectName()
    {
        return getString("GreenDreamProjectName");
    }
    public void setGreenDreamProjectName(String item)
    {
        setString("GreenDreamProjectName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E186874A");
    }
}