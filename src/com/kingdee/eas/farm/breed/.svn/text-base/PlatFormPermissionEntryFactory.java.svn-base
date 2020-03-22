package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PlatFormPermissionEntryFactory
{
    private PlatFormPermissionEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermissionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermissionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8C358036") ,com.kingdee.eas.farm.breed.IPlatFormPermissionEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IPlatFormPermissionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermissionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8C358036") ,com.kingdee.eas.farm.breed.IPlatFormPermissionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermissionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermissionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8C358036"));
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermissionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermissionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8C358036"));
    }
}