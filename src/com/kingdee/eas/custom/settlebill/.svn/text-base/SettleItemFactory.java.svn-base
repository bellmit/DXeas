package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleItemFactory
{
    private SettleItemFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B6BF5AF") ,com.kingdee.eas.custom.settlebill.ISettleItem.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B6BF5AF") ,com.kingdee.eas.custom.settlebill.ISettleItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B6BF5AF"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B6BF5AF"));
    }
}