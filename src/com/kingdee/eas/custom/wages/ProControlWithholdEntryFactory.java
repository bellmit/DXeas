package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProControlWithholdEntryFactory
{
    private ProControlWithholdEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IProControlWithholdEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithholdEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("81F5A3D5") ,com.kingdee.eas.custom.wages.IProControlWithholdEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IProControlWithholdEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithholdEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("81F5A3D5") ,com.kingdee.eas.custom.wages.IProControlWithholdEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IProControlWithholdEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithholdEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("81F5A3D5"));
    }
    public static com.kingdee.eas.custom.wages.IProControlWithholdEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IProControlWithholdEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("81F5A3D5"));
    }
}