package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalPurMATPriceEntryFactory
{
    private LocalPurMATPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0BA84D05") ,com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0BA84D05") ,com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0BA84D05"));
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0BA84D05"));
    }
}