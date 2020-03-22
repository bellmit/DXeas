package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChikenApplyFodderFodderPlanEntryFactory
{
    private CommecialChikenApplyFodderFodderPlanEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("287B041B") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("287B041B") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("287B041B"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderFodderPlanEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("287B041B"));
    }
}