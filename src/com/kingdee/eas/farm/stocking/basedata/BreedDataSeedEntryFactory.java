package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedDataSeedEntryFactory
{
    private BreedDataSeedEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7AD9D3F4") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7AD9D3F4") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7AD9D3F4"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataSeedEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7AD9D3F4"));
    }
}