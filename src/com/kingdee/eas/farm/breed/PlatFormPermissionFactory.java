package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PlatFormPermissionFactory
{
    private PlatFormPermissionFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermission getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermission)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("427A399C") ,com.kingdee.eas.farm.breed.IPlatFormPermission.class);
    }
    
    public static com.kingdee.eas.farm.breed.IPlatFormPermission getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermission)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("427A399C") ,com.kingdee.eas.farm.breed.IPlatFormPermission.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermission getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermission)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("427A399C"));
    }
    public static com.kingdee.eas.farm.breed.IPlatFormPermission getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IPlatFormPermission)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("427A399C"));
    }
}