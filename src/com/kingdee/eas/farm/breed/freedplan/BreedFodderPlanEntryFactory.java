package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedFodderPlanEntryFactory
{
    private BreedFodderPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3824A4A6") ,com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3824A4A6") ,com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3824A4A6"));
    }
    public static com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.freedplan.IBreedFodderPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3824A4A6"));
    }
}