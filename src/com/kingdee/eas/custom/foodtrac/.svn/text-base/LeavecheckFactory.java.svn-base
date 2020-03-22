package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeavecheckFactory
{
    private LeavecheckFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8DD06F36") ,com.kingdee.eas.custom.foodtrac.ILeavecheck.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ILeavecheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8DD06F36") ,com.kingdee.eas.custom.foodtrac.ILeavecheck.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8DD06F36"));
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8DD06F36"));
    }
}