package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MMPlanFactory
{
    private MMPlanFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1F3B6F9D") ,com.kingdee.eas.custom.eas2temp.IMMPlan.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IMMPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1F3B6F9D") ,com.kingdee.eas.custom.eas2temp.IMMPlan.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1F3B6F9D"));
    }
    public static com.kingdee.eas.custom.eas2temp.IMMPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IMMPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1F3B6F9D"));
    }
}