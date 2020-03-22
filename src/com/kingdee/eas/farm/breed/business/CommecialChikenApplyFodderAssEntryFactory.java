package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChikenApplyFodderAssEntryFactory
{
    private CommecialChikenApplyFodderAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70D0A949") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70D0A949") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70D0A949"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70D0A949"));
    }
}