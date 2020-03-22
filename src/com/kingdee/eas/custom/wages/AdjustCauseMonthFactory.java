package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustCauseMonthFactory
{
    private AdjustCauseMonthFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAdjustCauseMonth getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCauseMonth)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("225D108E") ,com.kingdee.eas.custom.wages.IAdjustCauseMonth.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAdjustCauseMonth getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCauseMonth)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("225D108E") ,com.kingdee.eas.custom.wages.IAdjustCauseMonth.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAdjustCauseMonth getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCauseMonth)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("225D108E"));
    }
    public static com.kingdee.eas.custom.wages.IAdjustCauseMonth getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCauseMonth)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("225D108E"));
    }
}