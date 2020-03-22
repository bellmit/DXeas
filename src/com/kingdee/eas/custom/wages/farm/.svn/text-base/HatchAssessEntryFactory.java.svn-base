package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchAssessEntryFactory
{
    private HatchAssessEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssessEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssessEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("71E55B38") ,com.kingdee.eas.custom.wages.farm.IHatchAssessEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IHatchAssessEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssessEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("71E55B38") ,com.kingdee.eas.custom.wages.farm.IHatchAssessEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssessEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssessEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("71E55B38"));
    }
    public static com.kingdee.eas.custom.wages.farm.IHatchAssessEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IHatchAssessEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("71E55B38"));
    }
}