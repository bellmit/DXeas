package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class adminOrgQueryFactory
{
    private adminOrgQueryFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IadminOrgQuery getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IadminOrgQuery)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FED22609") ,com.kingdee.eas.custom.signwasthetable.IadminOrgQuery.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IadminOrgQuery getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IadminOrgQuery)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FED22609") ,com.kingdee.eas.custom.signwasthetable.IadminOrgQuery.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IadminOrgQuery getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IadminOrgQuery)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FED22609"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IadminOrgQuery getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IadminOrgQuery)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FED22609"));
    }
}