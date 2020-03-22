package com.kingdee.eas.custom.taihe.server;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReturnBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractReturnBillInfo()
    {
        this("id");
    }
    protected AbstractReturnBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.taihe.server.ReturnBillEntryCollection());
    }
    /**
     * Object: �طõ� 's ��¼ property 
     */
    public com.kingdee.eas.custom.taihe.server.ReturnBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.server.ReturnBillEntryCollection)get("entrys");
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
     * Object:�طõ�'s �طö�����property 
     */
    public String getBillNum()
    {
        return getString("billNum");
    }
    public void setBillNum(String item)
    {
        setString("billNum", item);
    }
    /**
     * Object: �طõ� 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalerPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salerPerson");
    }
    public void setSalerPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salerPerson", item);
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
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:�طõ�'s �ͻ��ֻ���property 
     */
    public String getCustomerCell()
    {
        return getString("customerCell");
    }
    public void setCustomerCell(String item)
    {
        setString("customerCell", item);
    }
    /**
     * Object:�طõ�'s �ͻ�������ϵ��property 
     */
    public String getCustomerEmer()
    {
        return getString("customerEmer");
    }
    public void setCustomerEmer(String item)
    {
        setString("customerEmer", item);
    }
    /**
     * Object:�طõ�'s �ۺ�����property 
     */
    public java.math.BigDecimal getGrade()
    {
        return getBigDecimal("grade");
    }
    public void setGrade(java.math.BigDecimal item)
    {
        setBigDecimal("grade", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("76E5DBE2");
    }
}