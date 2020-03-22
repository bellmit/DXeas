package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerBalanceEditEntryFactory
{
    private CustomerBalanceEditEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3F459505") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3F459505") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3F459505"));
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEditEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3F459505"));
    }
}