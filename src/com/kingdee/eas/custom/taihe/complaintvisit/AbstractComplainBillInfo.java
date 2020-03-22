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
     * Object:Ͷ�ߵǼǱ�'s �Ƿ�����ƾ֤property 
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
     * Object: Ͷ�ߵǼǱ� 's ��Ͷ�߹�˾ property 
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
     * Object: Ͷ�ߵǼǱ� 's Ͷ�߶����� property 
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
     * Object:Ͷ�ߵǼǱ�'s Ͷ������property 
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
     * Object: Ͷ�ߵǼǱ� 's Ͷ�ߵ���¼ property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillComplainEntryCollection getComplainEntry()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillComplainEntryCollection)get("ComplainEntry");
    }
    /**
     * Object: Ͷ�ߵǼǱ� 's Ͷ�߿ͻ� property 
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
     * Object: Ͷ�ߵǼǱ� 's ��¼ property 
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