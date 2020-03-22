package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class signTableFacdeFactory
{
    private signTableFacdeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableFacde getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableFacde)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6736C162") ,com.kingdee.eas.custom.signwasthetable.IsignTableFacde.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IsignTableFacde getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableFacde)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6736C162") ,com.kingdee.eas.custom.signwasthetable.IsignTableFacde.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableFacde getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableFacde)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6736C162"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableFacde getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableFacde)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6736C162"));
    }
}