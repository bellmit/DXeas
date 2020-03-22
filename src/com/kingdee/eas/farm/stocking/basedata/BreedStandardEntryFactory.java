package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardEntryFactory
{
    private BreedStandardEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4A2FA3B2") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4A2FA3B2") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4A2FA3B2"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4A2FA3B2"));
    }
}