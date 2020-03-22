package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StandardFrightFactory
{
    private StandardFrightFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.IStandardFright getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStandardFright)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E8803874") ,com.kingdee.eas.custom.dx.weight.IStandardFright.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.IStandardFright getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStandardFright)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E8803874") ,com.kingdee.eas.custom.dx.weight.IStandardFright.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.IStandardFright getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStandardFright)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E8803874"));
    }
    public static com.kingdee.eas.custom.dx.weight.IStandardFright getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStandardFright)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E8803874"));
    }
}