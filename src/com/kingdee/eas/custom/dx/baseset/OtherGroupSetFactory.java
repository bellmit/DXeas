package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherGroupSetFactory
{
    private OtherGroupSetFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F135A1C7") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSet.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F135A1C7") ,com.kingdee.eas.custom.dx.baseset.IOtherGroupSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F135A1C7"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IOtherGroupSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IOtherGroupSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F135A1C7"));
    }
}