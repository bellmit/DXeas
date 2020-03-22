package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SSorgListFactory
{
    private SSorgListFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISSorgList getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISSorgList)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87FB5695") ,com.kingdee.eas.custom.lhsm.ISSorgList.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISSorgList getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISSorgList)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87FB5695") ,com.kingdee.eas.custom.lhsm.ISSorgList.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISSorgList getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISSorgList)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87FB5695"));
    }
    public static com.kingdee.eas.custom.lhsm.ISSorgList getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISSorgList)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87FB5695"));
    }
}