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
     * Object: 回访单 's 分录 property 
     */
    public com.kingdee.eas.custom.taihe.server.ReturnBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.server.ReturnBillEntryCollection)get("entrys");
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
     * Object:回访单's 回访订单号property 
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
     * Object: 回访单 's 业务员 property 
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
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:回访单's 客户手机号property 
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
     * Object:回访单's 客户紧急联系人property 
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
     * Object:回访单's 综合评分property 
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