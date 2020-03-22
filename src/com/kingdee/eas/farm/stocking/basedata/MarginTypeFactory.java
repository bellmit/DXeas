package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginTypeFactory
{
    private MarginTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AEE5CC19") ,com.kingdee.eas.farm.stocking.basedata.IMarginType.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IMarginType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AEE5CC19") ,com.kingdee.eas.farm.stocking.basedata.IMarginType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AEE5CC19"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IMarginType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IMarginType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AEE5CC19"));
    }
}