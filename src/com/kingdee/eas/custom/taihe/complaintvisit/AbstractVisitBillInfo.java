package com.kingdee.eas.custom.taihe.complaintvisit;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVisitBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractVisitBillInfo()
    {
        this("id");
    }
    protected AbstractVisitBillInfo(String pkField)
    {
        super(pkField);
        put("Project", new com.kingdee.eas.custom.taihe.complaintvisit.VisitBillProjectCollection());
    }
    /**
     * Object:回访单's 是否生成凭证property 
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
     * Object: 回访单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalesMan()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salesMan");
    }
    public void setSalesMan(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salesMan", item);
    }
    /**
     * Object: 回访单 's 回访公司 property 
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
     * Object: 回访单 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCunstomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("cunstomer");
    }
    public void setCunstomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("cunstomer", item);
    }
    /**
     * Object:回访单's 客户联系人property 
     */
    public String getCustomerContacts()
    {
        return getString("customerContacts");
    }
    public void setCustomerContacts(String item)
    {
        setString("customerContacts", item);
    }
    /**
     * Object:回访单's 客户手机号property 
     */
    public String getCustomerTelephone()
    {
        return getString("customerTelephone");
    }
    public void setCustomerTelephone(String item)
    {
        setString("customerTelephone", item);
    }
    /**
     * Object: 回访单 's 应收单编号 property 
     */
    public com.kingdee.eas.fi.ar.OtherBillInfo getReceivableNum()
    {
        return (com.kingdee.eas.fi.ar.OtherBillInfo)get("receivableNum");
    }
    public void setReceivableNum(com.kingdee.eas.fi.ar.OtherBillInfo item)
    {
        put("receivableNum", item);
    }
    /**
     * Object: 回访单 's 项目详情 property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.VisitBillProjectCollection getProject()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.VisitBillProjectCollection)get("Project");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26F7D484");
    }
}