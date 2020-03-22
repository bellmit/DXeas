package com.kingdee.eas.custom.taihe.complaintvisit;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplainBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractComplainBillInfo()
    {
        this("id");
    }
    protected AbstractComplainBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillEntryCollection());
        put("ComplainEntry", new com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillComplainEntryCollection());
    }
    /**
     * Object:投诉登记表's 是否生成凭证property 
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
     * Object: 投诉登记表 's 被投诉公司 property 
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
     * Object: 投诉登记表 's 投诉订单号 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleOrderInfo getComplainNumber()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleOrderInfo)get("complainNumber");
    }
    public void setComplainNumber(com.kingdee.eas.scm.sd.sale.SaleOrderInfo item)
    {
        put("complainNumber", item);
    }
    /**
     * Object:投诉登记表's 投诉内容property 
     */
    public String getComplainContent()
    {
        return getString("complainContent");
    }
    public void setComplainContent(String item)
    {
        setString("complainContent", item);
    }
    /**
     * Object: 投诉登记表 's 投诉单分录 property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillComplainEntryCollection getComplainEntry()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillComplainEntryCollection)get("ComplainEntry");
    }
    /**
     * Object: 投诉登记表 's 投诉客户 property 
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
     * Object: 投诉登记表 's 分录 property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2A796EBE");
    }
}