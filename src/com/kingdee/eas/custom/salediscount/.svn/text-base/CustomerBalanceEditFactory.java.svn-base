package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerBalanceEditFactory
{
    private CustomerBalanceEditFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26B61F6D") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26B61F6D") ,com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26B61F6D"));
    }
    public static com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.ICustomerBalanceEdit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26B61F6D"));
    }
}