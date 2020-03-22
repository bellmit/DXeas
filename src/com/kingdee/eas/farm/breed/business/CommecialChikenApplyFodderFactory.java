package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChikenApplyFodderFactory
{
    private CommecialChikenApplyFodderFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("08A076B8") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("08A076B8") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("08A076B8"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodder)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("08A076B8"));
    }
}