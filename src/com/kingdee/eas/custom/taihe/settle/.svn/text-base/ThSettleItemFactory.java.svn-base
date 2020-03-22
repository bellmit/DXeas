package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ThSettleItemFactory
{
    private ThSettleItemFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.IThSettleItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IThSettleItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3EAE355") ,com.kingdee.eas.custom.taihe.settle.IThSettleItem.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.IThSettleItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IThSettleItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3EAE355") ,com.kingdee.eas.custom.taihe.settle.IThSettleItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.IThSettleItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IThSettleItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3EAE355"));
    }
    public static com.kingdee.eas.custom.taihe.settle.IThSettleItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IThSettleItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3EAE355"));
    }
}