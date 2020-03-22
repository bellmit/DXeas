package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChangepackingEntryFactory
{
    private ChangepackingEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepackingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepackingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4658FDC5") ,com.kingdee.eas.custom.dx.baseset.IChangepackingEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IChangepackingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepackingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4658FDC5") ,com.kingdee.eas.custom.dx.baseset.IChangepackingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepackingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepackingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4658FDC5"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IChangepackingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IChangepackingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4658FDC5"));
    }
}