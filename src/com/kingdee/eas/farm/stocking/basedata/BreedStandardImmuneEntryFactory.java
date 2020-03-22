package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardImmuneEntryFactory
{
    private BreedStandardImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE4170EF") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE4170EF") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE4170EF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE4170EF"));
    }
}