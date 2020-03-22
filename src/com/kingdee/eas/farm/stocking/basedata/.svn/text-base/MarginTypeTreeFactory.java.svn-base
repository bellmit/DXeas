package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginTypeTreeFactory
{
    private MarginTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F0A7FF57") ,com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F0A7FF57") ,com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F0A7FF57"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F0A7FF57"));
    }
}