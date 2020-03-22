package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CommecialChikenApplyFodderEntryFactory
{
    private CommecialChikenApplyFodderEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F535149A") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F535149A") ,com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F535149A"));
    }
    public static com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICommecialChikenApplyFodderEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F535149A"));
    }
}