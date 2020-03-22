package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RPTRoleRoleEntryFactory
{
    private RPTRoleRoleEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DE30B56F") ,com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry.class);
    }
    
    public static com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DE30B56F") ,com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DE30B56F"));
    }
    public static com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.IRPTRoleRoleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DE30B56F"));
    }
}