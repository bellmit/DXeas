package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerViewReqBillFactory
{
    private CustomerViewReqBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B45036AB") ,com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B45036AB") ,com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B45036AB"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.ICustomerViewReqBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B45036AB"));
    }
}