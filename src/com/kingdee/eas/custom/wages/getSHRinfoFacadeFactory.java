package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class getSHRinfoFacadeFactory
{
    private getSHRinfoFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IgetSHRinfoFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetSHRinfoFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B8AFBB97") ,com.kingdee.eas.custom.wages.IgetSHRinfoFacade.class);
    }
    
    public static com.kingdee.eas.custom.wages.IgetSHRinfoFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetSHRinfoFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B8AFBB97") ,com.kingdee.eas.custom.wages.IgetSHRinfoFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IgetSHRinfoFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetSHRinfoFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B8AFBB97"));
    }
    public static com.kingdee.eas.custom.wages.IgetSHRinfoFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetSHRinfoFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B8AFBB97"));
    }
}