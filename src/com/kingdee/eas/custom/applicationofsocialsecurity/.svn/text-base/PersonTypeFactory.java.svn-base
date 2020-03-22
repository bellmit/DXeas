package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonTypeFactory
{
    private PersonTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4EDEACCE") ,com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4EDEACCE") ,com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4EDEACCE"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IPersonType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4EDEACCE"));
    }
}