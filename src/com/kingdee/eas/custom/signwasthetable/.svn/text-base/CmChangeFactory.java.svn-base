package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CmChangeFactory
{
    private CmChangeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D82D25C4") ,com.kingdee.eas.custom.signwasthetable.ICmChange.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ICmChange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D82D25C4") ,com.kingdee.eas.custom.signwasthetable.ICmChange.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D82D25C4"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ICmChange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ICmChange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D82D25C4"));
    }
}