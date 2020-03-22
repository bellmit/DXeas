package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeavecheckPicentryFactory
{
    private LeavecheckPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87DFFA7E") ,com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87DFFA7E") ,com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87DFFA7E"));
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87DFFA7E"));
    }
}