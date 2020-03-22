package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaTargetFactory
{
    private AreaTargetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTarget getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTarget)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2EE2FE72") ,com.kingdee.eas.custom.salepayment.IAreaTarget.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IAreaTarget getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTarget)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2EE2FE72") ,com.kingdee.eas.custom.salepayment.IAreaTarget.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTarget getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTarget)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2EE2FE72"));
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTarget getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTarget)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2EE2FE72"));
    }
}