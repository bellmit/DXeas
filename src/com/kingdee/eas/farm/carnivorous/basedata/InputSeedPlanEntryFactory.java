package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InputSeedPlanEntryFactory
{
    private InputSeedPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("18D91CD0") ,com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("18D91CD0") ,com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("18D91CD0"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInputSeedPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("18D91CD0"));
    }
}