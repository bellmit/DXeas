package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerSaleTargetFactory
{
    private CustomerSaleTargetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTarget getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTarget)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B0B3252A") ,com.kingdee.eas.custom.salepayment.ICustomerSaleTarget.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTarget getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTarget)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B0B3252A") ,com.kingdee.eas.custom.salepayment.ICustomerSaleTarget.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTarget getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTarget)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B0B3252A"));
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTarget getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTarget)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B0B3252A"));
    }
}