package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BianzhidaiFacadeFactory
{
    private BianzhidaiFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F64A7933") ,com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F64A7933") ,com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F64A7933"));
    }
    public static com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBianzhidaiFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F64A7933"));
    }
}