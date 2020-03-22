package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QualityawardticketEntryFactory
{
    private QualityawardticketEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticketEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticketEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5E728C40") ,com.kingdee.eas.custom.wages.IQualityawardticketEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IQualityawardticketEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticketEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5E728C40") ,com.kingdee.eas.custom.wages.IQualityawardticketEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticketEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticketEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5E728C40"));
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticketEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticketEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5E728C40"));
    }
}