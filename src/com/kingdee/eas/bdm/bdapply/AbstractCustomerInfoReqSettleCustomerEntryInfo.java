package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerInfoReqSettleCustomerEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCustomerInfoReqSettleCustomerEntryInfo()
    {
        this("id");
    }
    protected AbstractCustomerInfoReqSettleCustomerEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���˿ͻ���¼ 's null property 
     */
    public com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo getParent1()
    {
        return (com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: ���˿ͻ���¼ 's ���˿ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getSettleCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("settleCustomer");
    }
    public void setSettleCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("settleCustomer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2E2139AE");
    }
}