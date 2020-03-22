package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerBalanceFactory
{
    private CustomerBalanceFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalance getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalance)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("79F456C3") ,com.kingdee.eas.custom.salediscount.ICustomerBalance.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.ICustomerBalance getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalance)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("79F456C3") ,com.kingdee.eas.custom.salediscount.ICustomerBalance.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalance getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalance)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("79F456C3"));
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalance getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalance)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("79F456C3"));
    }
}