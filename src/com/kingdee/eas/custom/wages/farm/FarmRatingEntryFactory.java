package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmRatingEntryFactory
{
    private FarmRatingEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRatingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRatingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E9104955") ,com.kingdee.eas.custom.wages.farm.IFarmRatingEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IFarmRatingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRatingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E9104955") ,com.kingdee.eas.custom.wages.farm.IFarmRatingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRatingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRatingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E9104955"));
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmRatingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmRatingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E9104955"));
    }
}