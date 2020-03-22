package com.kingdee.eas.custom.taihe.sale;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractComplaintTableInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractComplaintTableInfo()
    {
        this("id");
    }
    protected AbstractComplaintTableInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection());
    }
    /**
     * Object: �ͻ�Ͷ�ߵǼǱ� 's ��¼ property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplaintTableEntryCollection)get("entrys");
    }
    /**
     * Object:�ͻ�Ͷ�ߵǼǱ�'s �Ƿ�����ƾ֤property 
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
     * Object: �ͻ�Ͷ�ߵǼǱ� 's ��Ͷ�߹�˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getComplainedCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("complainedCompany");
    }
    public void setComplainedCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("complainedCompany", item);
    }
    /**
     * Object: �ͻ�Ͷ�ߵǼǱ� 's Ͷ�߿ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getComplainedCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("complainedCustomer");
    }
    public void setComplainedCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("complainedCustomer", item);
    }
    /**
     * Object: �ͻ�Ͷ�ߵǼǱ� 's Ͷ����Ŀ property 
     */
    public com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo getComplainedType()
    {
        return (com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo)get("complainedType");
    }
    public void setComplainedType(com.kingdee.eas.custom.taihe.sale.ComplainedTypeInfo item)
    {
        put("complainedType", item);
    }
    /**
     * Object:�ͻ�Ͷ�ߵǼǱ�'s Ͷ������property 
     */
    public String getComplContent()
    {
        return getString("ComplContent");
    }
    public void setComplContent(String item)
    {
        setString("ComplContent", item);
    }
    /**
     * Object:�ͻ�Ͷ�ߵǼǱ�'s Ͷ�߶�����property 
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
     * Object:�ͻ�Ͷ�ߵǼǱ�'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:�ͻ�Ͷ�ߵǼǱ�'s ����״̬property 
     */
    public com.kingdee.eas.custom.taihe.sale.dealStatus getDealStatus()
    {
        return com.kingdee.eas.custom.taihe.sale.dealStatus.getEnum(getString("dealStatus"));
    }
    public void setDealStatus(com.kingdee.eas.custom.taihe.sale.dealStatus item)
    {
		if (item != null) {
        setString("dealStatus", item.getValue());
		}
    }
    /**
     * Object:�ͻ�Ͷ�ߵǼǱ�'s �������property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF5C2C2A");
    }
}