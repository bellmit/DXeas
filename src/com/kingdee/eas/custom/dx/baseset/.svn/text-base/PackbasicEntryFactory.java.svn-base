package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PackbasicEntryFactory
{
    private PackbasicEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasicEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasicEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E562909") ,com.kingdee.eas.custom.dx.baseset.IPackbasicEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.baseset.IPackbasicEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasicEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E562909") ,com.kingdee.eas.custom.dx.baseset.IPackbasicEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasicEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasicEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E562909"));
    }
    public static com.kingdee.eas.custom.dx.baseset.IPackbasicEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.baseset.IPackbasicEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E562909"));
    }
}