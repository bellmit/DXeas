package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerBalanceTreeFactory
{
    private CustomerBalanceTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26BD2501") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceTree.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26BD2501") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26BD2501"));
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26BD2501"));
    }
}