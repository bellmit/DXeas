package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkAgeAwardBonuFactory
{
    private WorkAgeAwardBonuFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardBonu getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardBonu)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26F85E4B") ,com.kingdee.eas.custom.wages.IWorkAgeAwardBonu.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardBonu getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardBonu)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26F85E4B") ,com.kingdee.eas.custom.wages.IWorkAgeAwardBonu.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardBonu getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardBonu)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26F85E4B"));
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAwardBonu getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAwardBonu)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26F85E4B"));
    }
}