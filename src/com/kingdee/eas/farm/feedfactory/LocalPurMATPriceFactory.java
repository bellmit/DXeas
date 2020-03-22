package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LocalPurMATPriceFactory
{
    private LocalPurMATPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E580676D") ,com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E580676D") ,com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E580676D"));
    }
    public static com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.ILocalPurMATPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E580676D"));
    }
}