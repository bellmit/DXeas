package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardLayEggEntryFactory
{
    private BreedStandardLayEggEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("53991871") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("53991871") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("53991871"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardLayEggEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("53991871"));
    }
}