package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class socialSecurityFacadeFactory
{
    private socialSecurityFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D72C1686") ,com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D72C1686") ,com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D72C1686"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IsocialSecurityFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D72C1686"));
    }
}