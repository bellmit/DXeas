package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ModifySIStatusFactory
{
    private ModifySIStatusFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6B2A5C1") ,com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6B2A5C1") ,com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6B2A5C1"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IModifySIStatus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6B2A5C1"));
    }
}