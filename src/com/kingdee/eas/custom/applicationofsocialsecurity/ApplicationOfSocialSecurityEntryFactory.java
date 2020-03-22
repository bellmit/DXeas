package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ApplicationOfSocialSecurityEntryFactory
{
    private ApplicationOfSocialSecurityEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E290CB3D") ,com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E290CB3D") ,com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E290CB3D"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurityEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E290CB3D"));
    }
}