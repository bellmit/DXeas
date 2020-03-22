package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarSendPlanFactory
{
    private CarSendPlanFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("106F56CF") ,com.kingdee.eas.custom.taihe.weight.ICarSendPlan.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarSendPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("106F56CF") ,com.kingdee.eas.custom.taihe.weight.ICarSendPlan.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("106F56CF"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("106F56CF"));
    }
}