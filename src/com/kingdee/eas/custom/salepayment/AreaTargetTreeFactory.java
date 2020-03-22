package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaTargetTreeFactory
{
    private AreaTargetTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EFA25D30") ,com.kingdee.eas.custom.salepayment.IAreaTargetTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IAreaTargetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EFA25D30") ,com.kingdee.eas.custom.salepayment.IAreaTargetTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EFA25D30"));
    }
    public static com.kingdee.eas.custom.salepayment.IAreaTargetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaTargetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EFA25D30"));
    }
}