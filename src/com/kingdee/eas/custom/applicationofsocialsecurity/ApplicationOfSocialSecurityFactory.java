package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ApplicationOfSocialSecurityFactory
{
    private ApplicationOfSocialSecurityFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49DFE635") ,com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49DFE635") ,com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49DFE635"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49DFE635"));
    }
}