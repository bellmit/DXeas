package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AppraisalclientFactory
{
    private AppraisalclientFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAppraisalclient getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAppraisalclient)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC51F9E8") ,com.kingdee.eas.custom.wages.IAppraisalclient.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAppraisalclient getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAppraisalclient)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC51F9E8") ,com.kingdee.eas.custom.wages.IAppraisalclient.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAppraisalclient getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAppraisalclient)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC51F9E8"));
    }
    public static com.kingdee.eas.custom.wages.IAppraisalclient getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAppraisalclient)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC51F9E8"));
    }
}