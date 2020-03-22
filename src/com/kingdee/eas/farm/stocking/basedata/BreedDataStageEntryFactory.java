package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedDataStageEntryFactory
{
    private BreedDataStageEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C3E7C701") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C3E7C701") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C3E7C701"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataStageEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C3E7C701"));
    }
}