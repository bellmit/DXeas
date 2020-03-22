package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassDisrateFactory
{
    private CarcassDisrateFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1A7EFAFF") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrate.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1A7EFAFF") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrate.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1A7EFAFF"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1A7EFAFF"));
    }
}