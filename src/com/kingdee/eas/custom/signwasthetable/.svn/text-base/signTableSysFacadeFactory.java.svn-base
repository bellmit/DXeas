package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class signTableSysFacadeFactory
{
    private signTableSysFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E1118520") ,com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E1118520") ,com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E1118520"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IsignTableSysFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E1118520"));
    }
}