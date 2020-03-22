package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RPTRoleFactory
{
    private RPTRoleFactory()
    {
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRole getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRole)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("77C90EAD") ,com.kingdee.eas.custom.mobileRPT.IRPTRole.class);
    }
    
    public static com.kingdee.eas.custom.mobileRPT.IRPTRole getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRole)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("77C90EAD") ,com.kingdee.eas.custom.mobileRPT.IRPTRole.class, objectCtx);
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRole getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRole)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("77C90EAD"));
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRole getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRole)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("77C90EAD"));
    }
}