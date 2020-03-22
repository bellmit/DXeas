package com.kingdee.eas.custom.taihe.door;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DoorWsFacadeFactory
{
    private DoorWsFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.door.IDoorWsFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.door.IDoorWsFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("19DD97E4") ,com.kingdee.eas.custom.taihe.door.IDoorWsFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.door.IDoorWsFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.door.IDoorWsFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("19DD97E4") ,com.kingdee.eas.custom.taihe.door.IDoorWsFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.door.IDoorWsFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.door.IDoorWsFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("19DD97E4"));
    }
    public static com.kingdee.eas.custom.taihe.door.IDoorWsFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.door.IDoorWsFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("19DD97E4"));
    }
}