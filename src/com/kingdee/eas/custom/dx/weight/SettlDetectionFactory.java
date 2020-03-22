package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlDetectionFactory
{
    private SettlDetectionFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ISettlDetection getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettlDetection)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("10F5932C") ,com.kingdee.eas.custom.dx.weight.ISettlDetection.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ISettlDetection getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettlDetection)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("10F5932C") ,com.kingdee.eas.custom.dx.weight.ISettlDetection.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ISettlDetection getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettlDetection)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("10F5932C"));
    }
    public static com.kingdee.eas.custom.dx.weight.ISettlDetection getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettlDetection)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("10F5932C"));
    }
}