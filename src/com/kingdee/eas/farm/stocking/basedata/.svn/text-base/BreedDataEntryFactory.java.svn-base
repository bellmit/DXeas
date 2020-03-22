package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedDataEntryFactory
{
    private BreedDataEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8EFBE565") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8EFBE565") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8EFBE565"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8EFBE565"));
    }
}