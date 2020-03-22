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
     * Object:�طõ�'s �Ƿ�����ƾ֤property 
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
     * Object: �طõ� 's ҵ��Ա property 
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
     * Object: �طõ� 's �طù�˾ property 
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
     * Object: �طõ� 's �ͻ� property 
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
     * Object:�طõ�'s �ͻ���ϵ��property 
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
     * Object:�طõ�'s �ͻ��ֻ���property 
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
     * Object: �طõ� 's Ӧ�յ���� property 
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
     * Object: �طõ� 's ��Ŀ���� property 
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