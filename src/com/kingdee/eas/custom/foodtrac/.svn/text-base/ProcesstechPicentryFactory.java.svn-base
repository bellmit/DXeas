package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProcesstechPicentryFactory
{
    private ProcesstechPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A4F3A4E8") ,com.kingdee.eas.custom.foodtrac.IProcesstechPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IProcesstechPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A4F3A4E8") ,com.kingdee.eas.custom.foodtrac.IProcesstechPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A4F3A4E8"));
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A4F3A4E8"));
    }
}