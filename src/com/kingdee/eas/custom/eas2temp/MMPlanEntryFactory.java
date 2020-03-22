package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MMPlanEntryFactory
{
    private MMPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A77AE2D5") ,com.kingdee.eas.custom.eas2temp.IMMPlanEntry.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IMMPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A77AE2D5") ,com.kingdee.eas.custom.eas2temp.IMMPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A77AE2D5"));
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A77AE2D5"));
    }
}