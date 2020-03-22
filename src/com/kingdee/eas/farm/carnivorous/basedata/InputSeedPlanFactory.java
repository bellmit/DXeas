package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InputSeedPlanFactory
{
    private InputSeedPlanFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8899A4C2") ,com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8899A4C2") ,com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8899A4C2"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8899A4C2"));
    }
}