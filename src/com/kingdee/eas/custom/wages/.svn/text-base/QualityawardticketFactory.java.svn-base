package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QualityawardticketFactory
{
    private QualityawardticketFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticket getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticket)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E4D44F52") ,com.kingdee.eas.custom.wages.IQualityawardticket.class);
    }
    
    public static com.kingdee.eas.custom.wages.IQualityawardticket getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticket)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E4D44F52") ,com.kingdee.eas.custom.wages.IQualityawardticket.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticket getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticket)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E4D44F52"));
    }
    public static com.kingdee.eas.custom.wages.IQualityawardticket getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQualityawardticket)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E4D44F52"));
    }
}